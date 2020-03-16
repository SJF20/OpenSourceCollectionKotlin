package com.shijingfeng.wan_android.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_SPLASH
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.databinding.ActivitySplashBinding
import com.shijingfeng.wan_android.view_model.SplashViewModel

/**
 * Function: 启动页 Activity
 * Date: 2020/2/4 21:19
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WAN_ANDROID_SPLASH)
class SplashActivity : WanAndroidBaseActivity<ActivitySplashBinding, SplashViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_splash

    /**
     * 获取ViewModel
     *
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(SplashViewModel::class.java, createCommonViewModelFactory())

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray(): Nothing? = null

    /**
     * 是否自定义设置状态栏高度
     *
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBarHeight() = true

}