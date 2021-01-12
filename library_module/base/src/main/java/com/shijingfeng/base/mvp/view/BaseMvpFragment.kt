package com.shijingfeng.base.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.base.mvp.presenter.IPresenter

/**
 * Function: MVP架构 View层 Fragment基类
 * Date: 2020/9/28 11:00
 * Description:
 * Author: ShiJingFeng
 */
abstract class BaseMvpFragment<V : ViewBinding, P : IPresenter> : BaseFragment() {

    /** ViewBinding */
    protected lateinit var mViewBinding: V
    /** Presenter */
    protected var mPresenter: P? = null

    /**
     * 创建 Fragment Root View
     * @param inflater LayoutInflater
     * @param container 父View容器
     * @param savedInstanceState Fragment View 重建 保存的Bundle数据
     * @return View
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = createViewBinding()
        mRootView = mViewBinding.root
        return mRootView
    }

    /**
     * 初始化
     * @param savedInstanceState Activity重启 携带的Bundle数据
     */
    override fun init(savedInstanceState: Bundle?) {
        initPresenter()
        initParam()
        initData()
        initAction()
        mPresenter?.run {
            if (this is BasePresenter<*, *>) {
                if (!mHasInitialized) {
                    init()
                }
            }
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
    protected abstract fun createViewBinding(): V

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