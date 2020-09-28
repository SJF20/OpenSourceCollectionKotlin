package com.shijingfeng.base.mvp.model

import com.shijingfeng.base.mvp.presenter.IPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Job

/**
 * Function: MVP架构 Model层基类
 * Date: 2020/9/28 17:35
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseModel<P : IPresenter>(
    val presenter: P
) {

    /** Presenter */
    protected var mPresenter: P? = presenter

    /** Disposable 容器 */
    private val mCompositeDisposable by lazy { CompositeDisposable() }
    /** 协程任务容器 */
    private val mCoroutinesJobList by lazy { mutableListOf<Job>() }

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
    fun clearDisposable() {
        mCompositeDisposable.clear()
    }

    /**
     * 清空 协程任务
     */
    fun clearCoroutinesJob() {
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