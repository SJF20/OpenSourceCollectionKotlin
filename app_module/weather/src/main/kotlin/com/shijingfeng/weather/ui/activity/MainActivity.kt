package com.shijingfeng.weather.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_MANAGE
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_MAIN
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.MainContract
import com.shijingfeng.weather.databinding.ActivityWeatherMainBinding
import com.shijingfeng.weather.presenter.MainPresenter

/**
 * Function: 首页 Activity
 * Date: 2020/9/29 10:42
 * Description:
 * Author: ShiJingFeng
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

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 跳转到 地址管理 页面
        ClickUtils.applySingleDebouncing(mViewBinding.ivAddArea) {
            navigation(
                activity = this,
                path = ACTIVITY_WEATHER_CITY_MANAGE
            )
        }
        // 跳转到 更多信息 页面
        ClickUtils.applySingleDebouncing(mViewBinding.ivMore) {

        }
    }

}