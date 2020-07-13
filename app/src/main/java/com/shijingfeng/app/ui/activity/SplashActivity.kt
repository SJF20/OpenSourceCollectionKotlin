package com.shijingfeng.app.ui.activity

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.app.BR
import com.shijingfeng.app.R
import com.shijingfeng.app.base.AppBaseActivity
import com.shijingfeng.app.databinding.ActivityAppSplashBinding
import com.shijingfeng.app.source.local.getSplashLocalSourceInstance
import com.shijingfeng.app.source.network.getSplashNetworkSourceInstance
import com.shijingfeng.app.source.repository.getSplashRepositoryInstance
import com.shijingfeng.app.view_model.SplashViewModel
import com.shijingfeng.base.arouter.ACTIVITY_APP_SPLASH
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory

/**
 * Function: 启动页 Activity
 * Date: 2020/3/16 13:28
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_APP_SPLASH)
internal class SplashActivity : AppBaseActivity<ActivityAppSplashBinding, SplashViewModel>(){

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_app_splash

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

}