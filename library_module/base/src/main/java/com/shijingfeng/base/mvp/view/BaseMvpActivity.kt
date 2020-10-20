package com.shijingfeng.base.mvp.view

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.shijingfeng.base.base.activity.BaseNormalActivity
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.base.mvp.presenter.IPresenter

/**
 * Function: MVP架构 View层 Activity基类
 * Date: 2020/9/28 10:26
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseMvpActivity<V : ViewBinding, P : IPresenter> : BaseNormalActivity() {

    /** ViewBinding */
    protected lateinit var mViewBinding: V
    /** Presenter */
    protected var mPresenter: P? = null

    /**
     * 初始化
     * @param savedInstanceState Activity重启 携带的Bundle数据
     */
    override fun init(savedInstanceState: Bundle?) {
        initViewBinding()
        initPresenter()
        initParam()
        initData()
        initAction()
    }

    /**
     * 初始化 ViewBinding
     */
    private fun initViewBinding() {
        createViewBinding()?.apply {
            mViewBinding = this
            setContentView(this.root)
        }
    }

    /**
     * 初始化 Presenter
     */
    private fun initPresenter() {
        createPresenter()?.run {
            mPresenter = this
            if (this is BasePresenter<*, *>) {
                //让 Presenter 拥有 Activity 的生命周期感应
                lifecycle.addObserver(this)
            }
        }
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    final override fun getLayoutId() = 0

    /**
     * 创建 ViewBinding
     */
    protected abstract fun createViewBinding(): V?

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    protected abstract fun createPresenter(): P?

    /**
     * Activity销毁回调
     */
    override fun onDestroy() {
        super.onDestroy()
        //销毁Lifecycle
        mPresenter?.run {
            if (this is BasePresenter<*, *>) {
                onCleared()
                lifecycle.removeObserver(this)
            }
        }
    }
}