package com.shijingfeng.base.mvp.presenter

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.mvp.model.BaseModel
import com.shijingfeng.base.mvp.model.IModel
import com.shijingfeng.base.mvp.view.IView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Function: MVP架构 Presenter层基类
 * Date: 2020/9/28 11:08
 * Description:
 * @author ShiJingFeng
 */
abstract class BasePresenter<V : IView, M : IModel> @JvmOverloads constructor(
    view: V,
) : DefaultLifecycleObserver {

    /** Disposable容器  */
    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    /** View */
    protected val mView = view
    /** Model */
    protected val mModel by lazy { createModel() }

    /** 是否已经初始化  true 已经初始化  false 没有初始化  */
    var mHasInitialized: Boolean = false

    /**
     * 初始化
     */
    open fun init() {
        mHasInitialized = true
    }

    /**
     * 创建 Model
     *
     * @return Model
     */
    protected abstract fun createModel(): M?

    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    protected fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }

    /**
     * 清空Disposable
     */
    private fun clearDisposable() {
        mCompositeDisposable.clear()
    }

    /**
     * 会在 Activity 或 Fragment 的 onCreate 方法完全执行完后执行
     */
    override fun onCreate(owner: LifecycleOwner) {
        if (owner !is BaseFragment && !mHasInitialized) {
            init()
        }
    }

    /**
     * 清除数据
     */
    open fun onCleared() {
        //取消所有异步任务
        clearDisposable()
        // 销毁 Model
        mModel?.run {
            if (this is BaseModel<*>) {
                onCleared()
            }
        }
    }

}