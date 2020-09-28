package com.shijingfeng.weather.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_SPLASH
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.SplashContract
import com.shijingfeng.weather.databinding.ActivityWeatherSplashBinding
import com.shijingfeng.weather.presenter.SplashPresenter

/**
 * Function: 启动页 Activity
 * Date: 2020/9/27 16:23
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_SPLASH)
internal class SplashActivity : WeatherBaseActivity<ActivityWeatherSplashBinding, SplashContract.Presenter>(), SplashContract.View {

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding() = ActivityWeatherSplashBinding.inflate(layoutInflater)

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = SplashPresenter(this)

}