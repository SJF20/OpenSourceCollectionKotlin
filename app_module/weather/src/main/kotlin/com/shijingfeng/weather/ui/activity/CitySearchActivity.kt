package com.shijingfeng.weather.ui.activity

import android.text.InputFilter
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_SEARCH
import com.shijingfeng.base.util.TextWatcherAdapter
import com.shijingfeng.base.util.e
import com.shijingfeng.base.util.getProhibitSystemEmojiInputFilter
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.weather.R
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.databinding.ActivityWeatherCitySearchBinding
import com.shijingfeng.weather.presenter.CitySearchPresenter

/**
 * Function: 城市搜索 页面
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
        initHotCity()
    }

    /**
     * 初始化热门城市
     */
    private fun initHotCity() {
        mViewBinding.flHotCity.run {
            addView(TextView(this@CitySearchActivity).apply {
                text = getStringById(R.string.北京市)
            })
        }
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        mViewBinding.etSearch.filters = arrayOf(
            // 过滤表情
            getProhibitSystemEmojiInputFilter()
        )
        mViewBinding.etSearch.addTextChangedListener(object : TextWatcherAdapter {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val length = mViewBinding.etSearch.length()

                if (length == 0) {
                    // 显示热门城市
                    mViewBinding.rvCityList.visibility = GONE
                    mViewBinding.nsvHotCity.visibility = VISIBLE
                } else {
                    // 显示搜索列表
                    mViewBinding.nsvHotCity.visibility = GONE
                    mViewBinding.rvCityList.visibility = VISIBLE
                }
            }
        })
    }
}