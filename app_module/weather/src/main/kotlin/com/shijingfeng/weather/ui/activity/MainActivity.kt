package com.shijingfeng.weather.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_MAIN
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.MainContract
import com.shijingfeng.weather.databinding.ActivityWeatherMainBinding
import com.shijingfeng.weather.presenter.MainPresenter

/**
 * Function: 首页 Activity
 * Date: 2020/9/29 10:42
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_MAIN)
internal class MainActivity : WeatherBaseActivity<ActivityWeatherMainBinding, MainContract.Presenter>(), MainContract.View {

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding() = ActivityWeatherMainBinding.inflate(layoutInflater)

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = MainPresenter(this)

}