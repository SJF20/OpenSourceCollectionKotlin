package com.shijingfeng.base.mvp.presenter

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.mvp.view.IView

/**
 * Function: MVP架构 Presenter层基类
 * Date: 2020/9/28 11:08
 * Description:
 * @author ShiJingFeng
 */
abstract class BasePresenter<V : IView>(
    view: V
) : DefaultLifecycleObserver {

    /** View */
    protected var mView: V? = view

    /** 是否已经初始化  true 已经初始化  false 没有初始化  */
    var mHasInitialized: Boolean = false

    /**
     * 初始化
     */
    open fun init() {
        mHasInitialized = true
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
     * 会在 Activity 或 Fragment 的 onDestroy 方法中调用
     */
    override fun onDestroy(owner: LifecycleOwner) {
        // 销毁 View层引用, 防止内存泄漏
        mView = null
        super.onDestroy(owner)
    }
}