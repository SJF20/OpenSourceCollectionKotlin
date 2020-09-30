package com.shijingfeng.app.ui.activity

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.SparseArray
import android.view.WindowManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.BarUtils
import com.shijingfeng.app.BR
import com.shijingfeng.app.R
import com.shijingfeng.app.base.AppBaseActivity
import com.shijingfeng.app.databinding.ActivityAppSplashBinding
import com.shijingfeng.app.source.local.getSplashLocalSourceInstance
import com.shijingfeng.app.source.network.getSplashNetworkSourceInstance
import com.shijingfeng.app.source.repository.getSplashRepositoryInstance
import com.shijingfeng.app.view_model.SplashViewModel
import com.shijingfeng.base.arouter.ACTIVITY_APP_SPLASH
import com.shijingfeng.base.common.constant.NO_LAYOUT
import com.shijingfeng.base.mvvm.viewmodel.factory.createCommonViewModelFactory

/**
 * Function: 启动页 Activity
 * Date: 2020/3/16 13:28
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_APP_SPLASH)
internal class SplashActivity : AppBaseActivity<ActivityAppSplashBinding, SplashViewModel>(){

    /**
     * 在 onCreate 方法执行前
     */
    override fun onCreateBefore(savedInstanceState: Bundle?) {
        super.onCreateBefore(savedInstanceState)
        setTheme(R.style.AppSplashTheme)
    }

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = NO_LAYOUT

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel(): SplashViewModel? {
        val repository = getSplashRepositoryInstance(
            localSource = getSplashLocalSourceInstance(),
            networkSource = getSplashNetworkSourceInstance()
        )
        val factory = createCommonViewModelFactory(
            repository = repository
        )

        return createViewModel(SplashViewModel::class.java, factory)
    }

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.splashViewModel, mViewModel)
    }

    /**
     * 获取 Activity 背景
     */
    override fun getActivityBackground(): Drawable? = null

}