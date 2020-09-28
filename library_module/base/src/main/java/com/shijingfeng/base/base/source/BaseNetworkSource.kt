package com.shijingfeng.base.base.source

import com.shijingfeng.base.util.cast
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Job

/**
 * Function: 网络资源 基类
 * Date: 2020/1/17 19:41
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseNetworkSource {

    /** Disposable 容器 */
    private val mCompositeDisposable by lazy { CompositeDisposable() }
    /** 协程任务容器 */
    private val mCoroutinesJobList by lazy { mutableListOf<Job>() }

    /**
     * 获取子类类型实例
     * @param <T> 泛型
     * @return 子类类型实例
     */
    fun <T : BaseNetworkSource> get() : T = cast(this)

    /**
     * 添加 Disposable
     * @param disposable Disposable
     */
    fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    /**
     * 添加 协程任务
     * @param job 协程任务
     */
    fun addCoroutinesJob(job: Job) {
        mCoroutinesJobList.add(job)
    }

    /**
     * 清空 Disposable
     */
    private fun clearDisposable() {
        mCompositeDisposable.clear()
    }

    /**
     * 清空 协程任务
     */
    private fun clearCoroutinesJob() {
        mCoroutinesJobList.forEach { job ->
            if (!job.isCancelled) {
                job.cancel()
            }
        }
        mCoroutinesJobList.clear()
    }

    /**
     * 清除数据
     */
    open fun onCleared() {
        //销毁异步任务，防止内存泄漏
        clearDisposable()
        //清空协程任务，防止内存泄漏
        clearCoroutinesJob()
    }

}