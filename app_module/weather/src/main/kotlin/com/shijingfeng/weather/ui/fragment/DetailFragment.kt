package com.shijingfeng.weather.ui.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.FRAGMENT_WEATHER_DETAIL
import com.shijingfeng.weather.base.WeatherBaseFragment
import com.shijingfeng.weather.contract.DetailContract
import com.shijingfeng.weather.databinding.FragmentWeatherDetailBinding
import com.shijingfeng.weather.presenter.DetailPresenter

/**
 * Function: 天气详情 Fragment
 * Date: 2020/10/9 11:39
 * Description:
 * Author: ShiJingFeng
 */
@Route(path = FRAGMENT_WEATHER_DETAIL)
internal class DetailFragment : WeatherBaseFragment<FragmentWeatherDetailBinding, DetailContract.Presenter>(), DetailContract.View {

    /**
     * 创建 ViewBinding
     */
    override fun createViewBinding() = FragmentWeatherDetailBinding.inflate(layoutInflater)

    /**
     * 创建 Presenter
     *
     * @return Presenter
     */
    override fun createPresenter() = DetailPresenter(this)

}