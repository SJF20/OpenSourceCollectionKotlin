package com.shijingfeng.app.ui.activity

import android.util.SparseArray
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.app.BR
import com.shijingfeng.app.R
import com.shijingfeng.app.base.AppBaseActivity
import com.shijingfeng.app.databinding.ActivityAppSplashBinding
import com.shijingfeng.app.view_model.SplashViewModel
import com.shijingfeng.base.arouter.ACTIVITY_APP_SPLASH

/**
 * Function: 启动页
 * Date: 2020/3/16 13:28
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_APP_SPLASH)
class SplashActivity : AppBaseActivity<ActivityAppSplashBinding, SplashViewModel>(){

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
    override fun getViewModel() = createViewModel(SplashViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.splashViewModel, mViewModel)
    }

    /**
     * 是否自定义设置状态栏高度
     * @return true 自定义设置  false 默认设置
     */
    override fun isSetCustomStatusBarHeight() = true

}