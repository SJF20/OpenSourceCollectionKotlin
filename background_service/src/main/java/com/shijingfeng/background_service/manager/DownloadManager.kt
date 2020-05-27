package com.shijingfeng.background_service.manager

import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Function: 下载管理器
 * Date: 2020/5/27 21:40
 * Description:
 * @author ShiJingFeng
 */
class DownloadManager<T, S>(
    /** 下载线程执行器 */
    private var executorService: ExecutorService = Executors.newCachedThreadPool(),
    /** 下载进度 回调函数 [0, 100] */
    private var onProgress: ((id: String?, progress: Int) -> Unit)? = null,
    /** 下载大小进度 回调函数 [0, totalSize] */
    private var onSize: ((id: String?, curSize: Long, totalSize: Long) -> Unit)? = null,
    /** 下载成功 回调函数 */
    private var onSuccess: ((id: String?, data: T?) -> Unit)? = null,
    /** 下载失败 回调函数 */
    private var onFailure: ((id: String?, data: S?, throwable: Throwable?) -> Unit)? = null,
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
        filePath: String
    ) {
        val future = executorService.submit<String> {
            
            ""
        }
        mFutureMap[id] = future
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
    fun setExecutorService(executorService: ExecutorService): DownloadManager<T, S> {
        this.executorService = executorService
        return this
    }

    /**
     * 设置 下载进度 回调函数 [0, 100]
     * @param onProgress 下载进度 回调函数 [0, 100]
     */
    fun setOnProgress(onProgress: (id: String?, progress: Int) -> Unit): DownloadManager<T, S> {
        this.onProgress = onProgress
        return this
    }

    /**
     * 设置 下载大小进度 回调函数 [0, totalSize]
     * @param onSize 下载大小进度 回调函数 [0, totalSize]
     */
    fun setOnSize(onSize: (id: String?, curSize: Long, totalSize: Long) -> Unit): DownloadManager<T, S> {
        this.onSize = onSize
        return this
    }

    /**
     * 设置 下载成功 回调函数
     * @param onSuccess 下载成功 回调函数
     */
    fun setOnSuccess(onSuccess: (id: String?, data: T?) -> Unit): DownloadManager<T, S> {
        this.onSuccess = onSuccess
        return this
    }

    /**
     * 设置 下载失败 回调函数
     * @param onFailure 下载失败 回调函数
     */
    fun setOnFailure(onFailure: (id: String?, data: S?, throwable: Throwable?) -> Unit): DownloadManager<T, S> {
        this.onFailure = onFailure
        return this
    }

    /**
     * 设置 下载取消 回调函数
     * @param onCancel 下载取消 回调函数 isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况
     */
    fun setOnCancel(onCancel: (id: String?, isCanceled: Boolean) -> Unit): DownloadManager<T, S> {
        this.onCancel = onCancel
        return this
    }

}