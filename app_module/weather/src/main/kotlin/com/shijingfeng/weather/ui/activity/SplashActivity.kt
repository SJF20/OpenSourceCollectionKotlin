package com.shijingfeng.weather.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_SPLASH
import com.shijingfeng.base.base.viewmodel.factory.createCommonViewModelFactory
import com.shijingfeng.weather.R
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.databinding.ActivityWeatherSplashBinding
import com.shijingfeng.weather.view_model.SplashViewModel

/**
 * Function: 启动页 Activity
 * Date: 2020/9/27 16:23
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_SPLASH)
internal class SplashActivity : WeatherBaseActivity<ActivityWeatherSplashBinding, SplashViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_weather_splash

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(SplashViewModel::class.java, createCommonViewModelFactory())

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray(): Nothing? = null

}