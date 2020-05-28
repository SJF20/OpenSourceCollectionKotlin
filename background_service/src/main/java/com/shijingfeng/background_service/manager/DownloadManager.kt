package com.shijingfeng.background_service.manager

import android.os.Handler
import android.os.Looper
import com.shijingfeng.background_service.R
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
 * @author ShiJingFeng
 */
class DownloadManager(
    /** 下载线程执行器 */
    private var executorService: ExecutorService = Executors.newCachedThreadPool(),
    /** 下载进度 回调函数 [0, 100] */
    private var onProgress: ((id: String?, progress: Int) -> Unit)? = null,
    /** 下载大小进度 回调函数 [0, totalSize] */
    private var onSize: ((id: String?, curSize: Long, totalSize: Long) -> Unit)? = null,
    /** 下载成功 回调函数 */
    private var onSuccess: ((id: String?, data: String?) -> Unit)? = null,
    /** 下载失败 回调函数 */
    private var onFailure: ((id: String?, data: String?, throwable: Throwable?) -> Unit)? = null,
    /** 下载取消 回调函数  isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况 */
    private var onCancel: ((id: String?, isCanceled: Boolean) -> Unit)? = null
) {

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
        val future = executorService.submit(object : Callable<String> {

            override fun call(): String {
                val file = File(filePath)

                if (file.exists()) {
                    if (replace) {
                        file.deleteOnExit()
                    } else {
                        onFailure?.invoke(
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
                val contentLength: Long
                //当前下载的字节数
                var sumLength: Long = 0

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

                        while ((length = bufferedInputStream.read(bytes)) != -1) {
                            fileOutputStream.write(bytes, 0, length)
                            sumLength += length
                            val currentLength: Long = sumLength

                            //通知监听器 下载进度
                            onSize?.invoke(id, currentLength, contentLength)
                        }
                    } else {
                        onFailure?.invoke(id, getStringById(R.string.下载失败), e)
                    }
                } catch (e: Exception) {
                    onFailure?.invoke(id, getStringById(R.string.下载失败), e)
                    throw e
                } finally {
                    releaseResource(bufferedInputStream, fileOutputStream)
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
            onCancel?.invoke(id, canceled)
        }
    }

    /**
     * 注意一定要在 onDestroy 中调用 destroy 否则会导致内存泄漏
     */
    fun destory() {
        executorService.shutdownNow()
    }

    /**
     * 设置 下载线程执行器
     * @param executorService 下载线程执行器
     */
    fun setExecutorService(executorService: ExecutorService): DownloadManager {
        this.executorService = executorService
        return this
    }

    /**
     * 设置 下载进度 回调函数 [0, 100]
     * @param onProgress 下载进度 回调函数 [0, 100]
     */
    fun setOnProgress(onProgress: (id: String?, progress: Int) -> Unit): DownloadManager {
        this.onProgress = onProgress
        return this
    }

    /**
     * 设置 下载大小进度 回调函数 [0, totalSize]
     * @param onSize 下载大小进度 回调函数 [0, totalSize]
     */
    fun setOnSize(onSize: (id: String?, curSize: Long, totalSize: Long) -> Unit): DownloadManager {
        this.onSize = onSize
        return this
    }

    /**
     * 设置 下载成功 回调函数
     * @param onSuccess 下载成功 回调函数
     */
    fun setOnSuccess(onSuccess: (id: String?, data: String?) -> Unit): DownloadManager {
        this.onSuccess = onSuccess
        return this
    }

    /**
     * 设置 下载失败 回调函数
     * @param onFailure 下载失败 回调函数
     */
    fun setOnFailure(onFailure: (id: String?, data: String?, throwable: Throwable?) -> Unit): DownloadManager {
        this.onFailure = onFailure
        return this
    }

    /**
     * 设置 下载取消 回调函数
     * @param onCancel 下载取消 回调函数 isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况
     */
    fun setOnCancel(onCancel: (id: String?, isCanceled: Boolean) -> Unit): DownloadManager {
        this.onCancel = onCancel
        return this
    }

}