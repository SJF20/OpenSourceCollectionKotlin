package com.shijingfeng.weather.ui.activity

import android.text.Editable
import android.text.TextWatcher
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_SEARCH
import com.shijingfeng.base.util.TextWatcherAdapter
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.databinding.ActivityWeatherCitySearchBinding
import com.shijingfeng.weather.presenter.CitySearchPresenter

/**
 * Function:
 * Date: 2020/10/22 17:15
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_WEATHER_CITY_SEARCH)
internal class CitySearchActivity : WeatherBaseActivity<ActivityWeatherCitySearchBinding, CitySearchContract.Presenter>(), CitySearchContract.View {

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding() = ActivityWeatherCitySearchBinding.inflate(layoutInflater)

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = CitySearchPresenter(this)

    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    override fun isStatusBarContentDark() = true

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
        mViewBinding.etSearch.addTextChangedListener(object : TextWatcherAdapter {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }
}