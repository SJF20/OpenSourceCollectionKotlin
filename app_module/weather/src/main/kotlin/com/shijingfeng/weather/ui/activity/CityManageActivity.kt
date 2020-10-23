package com.shijingfeng.weather.ui.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_MANAGE
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_CITY_SEARCH
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.weather.R
import com.shijingfeng.weather.base.WeatherBaseActivity
import com.shijingfeng.weather.contract.CityManageContract
import com.shijingfeng.weather.databinding.ActivityWeatherCityManageBinding
import com.shijingfeng.weather.presenter.CityManagePresenter
import kotlinx.android.synthetic.main.layout_weather_title_bar.view.*

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
        mViewBinding.includeTitleBar.tvTitle.text = getStringById(R.string.城市管理)
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        // 关闭当前页面
        ClickUtils.applySingleDebouncing(mViewBinding.includeTitleBar.ivBack) { finish() }
        // 跳转到 搜索地址 页面
        ClickUtils.applySingleDebouncing(mViewBinding.llSearch) {
            navigation(
                activity = this,
                path = ACTIVITY_WEATHER_CITY_SEARCH
            )
        }
    }
}