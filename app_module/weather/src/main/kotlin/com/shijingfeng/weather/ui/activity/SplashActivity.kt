package com.shijingfeng.weather.ui.activity

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_SPLASH
import com.shijingfeng.weather.R
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.SplashContract
import com.shijingfeng.weather.presenter.SplashPresenter

/**
 * Function: 启动页 Activity
 * Date: 2020/9/27 16:23
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_SPLASH)
internal class SplashActivity : WeatherBaseActivity<ViewBinding, SplashContract.Presenter>(), SplashContract.View {

    /**
     * 在 onCreate 方法执行前
     */
    override fun onCreateBefore(savedInstanceState: Bundle?) {
        super.onCreateBefore(savedInstanceState)
        setTheme(R.style.WeatherSplashTheme)
    }

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding(): Nothing? = null

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = SplashPresenter(this)

    /**
     * 获取 Activity 背景
     */
    override fun getActivityBackground(): Nothing? = null

}