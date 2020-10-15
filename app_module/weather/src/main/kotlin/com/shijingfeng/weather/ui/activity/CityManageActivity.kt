package com.shijingfeng.weather.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_MANAGE
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.CityManageContract
import com.shijingfeng.weather.databinding.ActivityWeatherCityManageBinding
import com.shijingfeng.weather.presenter.CityManagePresenter

/**
 * Function: 城市管理 Activity
 * Date: 2020/10/12 11:08
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_CITY_MANAGE)
internal class CityManageActivity : WeatherBaseActivity<ActivityWeatherCityManageBinding, CityManageContract.Presenter>(), CityManageContract.View {

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding() = ActivityWeatherCityManageBinding.inflate(layoutInflater)

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = CityManagePresenter(this)

}