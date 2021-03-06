package com.shijingfeng.app.manager

import com.shijingfeng.app.R
import com.shijingfeng.base.util.getStringById
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedInputStream
import java.io.Closeable
import java.io.File
import java.io.FileOutputStream
import java.util.*
import java.util.concurrent.*


/**
 * Function: 下载管理器
 * Date: 2020/5/27 21:40
 * Description:
 * Author: ShiJingFeng
 */
class Downloader private constructor(
    /** 构建器 */
    private val builder: Builder
) {

    /** Future Map */
    private val mFutureMap = mutableMapOf<String, Future<String>>()

    /**
     * 执行下载任务
     *
     * @param id 本次下载任务的唯一ID
     * @param url 要下载的url
     * @param filePath 下载到的本地地址 (推荐使用应用程序私有目录，否则需要请求外部存储权限)
     * Android Q(10.0)严格限制外部存储，需要通过 MediaStore 或 SAF 或 使用兼容模式(以后会废弃)
     */
    fun execute(
        id: String = UUID.randomUUID().toString().replace("-", ""),
        url: String,
        filePath: String,
        // 文件已存在, 是否覆盖原文件  true:覆盖  false:不覆盖
        replace: Boolean = false
    ) {
        // 注意只能使用 Callable 而不能使用 Runnable (虽然也返回 Future 但调用 cancel 无效)
        val future = builder.executorService.submit(object : Callable<String> {

            override fun call(): String {
                val file = File(filePath)

                if (file.exists()) {
                    if (replace) {
                        file.deleteOnExit()
                    } else {
                        builder.onFailure?.invoke(
                            id,
                            getStringById(R.string.文件已存在),
                            SecurityException(getStringById(R.string.文件已存在))
                        )
                        return url
                    }
                }
                // 如果父目录不存在，则创建父目录
                file.parentFile?.run {
                    if (!exists()) {
                        mkdirs()
                    }
                }
                // 创建文件
                file.createNewFile()

                var bufferedInputStream: BufferedInputStream? = null
                var fileOutputStream: FileOutputStream? = null
                //完整文件 总字节数
                var contentLength = 0L
                //当前下载的字节数
                var sumLength = 0L

                try {
                    //后台下载
                    val client = OkHttpClient.Builder()
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .readTimeout(15, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
                        .build()
                    val request = Request.Builder()
                        .url(url)
                        .get()
                        .build()
                    val response = client.newCall(request).execute()
                    val responseBody = response.body

                    if (responseBody != null) {
                        contentLength = responseBody.contentLength()
                        bufferedInputStream = BufferedInputStream(responseBody.byteStream())
                        fileOutputStream = FileOutputStream(file)

                        val bytes = ByteArray(1024)
                        var length: Int

                        length = bufferedInputStream.read(bytes)

                        while (length != -1) {
                            fileOutputStream.write(bytes, 0, length)
                            sumLength += length
                            val currentLength: Long = sumLength

                            //通知监听器 下载进度
                            builder.onSize?.invoke(id, currentLength, contentLength)
                            builder.onProgress?.invoke(id, (sumLength * 100L / contentLength).toInt())

                            length = bufferedInputStream.read(bytes)
                        }
                    } else {
                        builder.onFailure?.invoke(
                            id,
                            getStringById(R.string.下载失败),
                            IllegalAccessException(getStringById(R.string.没有数据))
                        )
                    }
                } catch (e: Exception) {
                    builder.onFailure?.invoke(id, getStringById(R.string.下载失败), e)
                    throw e
                } finally {
                    releaseResource(bufferedInputStream, fileOutputStream)
                }
                if (contentLength == sumLength) {
                    builder.onSuccess?.invoke(id, filePath)
                }
                return url
            }
        })
        mFutureMap[id] = future
    }

    /**
     * 释放流资源
     * @param closeables
     */
    private fun releaseResource(vararg closeables: Closeable?) {
        try {
            for (closeable in closeables) {
                closeable?.close()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * 取消下载任务
     */
    fun cancel(
        id: String,
        mayInterruptIfRunning: Boolean = true
    ) {
        val future = mFutureMap[id]

        future?.run {
            val canceled = future.cancel(mayInterruptIfRunning)

            mFutureMap.remove(id)
            // canceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况
            builder.onCancel?.invoke(id, canceled)
        }
    }

    /**
     * 注意一定要在 onDestroy 中调用 destroy 否则会导致内存泄漏
     */
    fun destory() {
        builder.executorService.shutdownNow()
    }

    /**
     * 构建器
     */
    class Builder {

        /** 下载线程执行器 */
        var executorService: ExecutorService = Executors.newCachedThreadPool()

        /** 下载进度 回调函数 [0, 100] */
        var onProgress: ((id: String?, progress: Int) -> Unit)? = null

        /** 下载大小进度 回调函数 [0, totalSize] */
        var onSize: ((id: String?, curSize: Long, totalSize: Long) -> Unit)? = null

        /** 下载成功 回调函数 */
        var onSuccess: ((id: String?, filePath: String?) -> Unit)? = null

        /** 下载失败 回调函数 */
        var onFailure: ((id: String?, msg: String?, throwable: Throwable?) -> Unit)? = null

        /** 下载取消 回调函数  isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况 */
        var onCancel: ((id: String?, isCanceled: Boolean) -> Unit)? = null

        /**
         * 设置 下载线程执行器
         * @param executorService 下载线程执行器
         */
        fun setExecutorService(executorService: ExecutorService): Builder {
            this.executorService = executorService
            return this
        }

        /**
         * 设置 下载进度 回调函数 [0, 100]
         * @param onProgress 下载进度 回调函数 [0, 100]
         */
        fun setOnProgress(onProgress: (id: String?, progress: Int) -> Unit): Builder {
            this.onProgress = onProgress
            return this
        }

        /**
         * 设置 下载大小进度 回调函数 [0, totalSize]
         * @param onSize 下载大小进度 回调函数 [0, totalSize]
         */
        fun setOnSize(onSize: (id: String?, curSize: Long, totalSize: Long) -> Unit): Builder {
            this.onSize = onSize
            return this
        }

        /**
         * 设置 下载成功 回调函数
         * @param onSuccess 下载成功 回调函数
         */
        fun setOnSuccess(onSuccess: (id: String?, data: String?) -> Unit): Builder {
            this.onSuccess = onSuccess
            return this
        }

        /**
         * 设置 下载失败 回调函数
         * @param onFailure 下载失败 回调函数
         */
        fun setOnFailure(onFailure: (id: String?, data: String?, throwable: Throwable?) -> Unit): Builder {
            this.onFailure = onFailure
            return this
        }

        /**
         * 设置 下载取消 回调函数
         * @param onCancel 下载取消 回调函数 isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况
         */
        fun setOnCancel(onCancel: (id: String?, isCanceled: Boolean) -> Unit): Builder {
            this.onCancel = onCancel
            return this
        }

        /**
         * 构建 DownloadManager
         */
        fun build() = Downloader(this)

    }

}