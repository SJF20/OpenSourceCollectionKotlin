package com.shijingfeng.app.view_model

import android.view.View
import com.shijingfeng.app.base.AppBaseViewModel
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_MAIN
import com.shijingfeng.base.base.repository.BaseRepository

/**
 * Function: 主页 ViewModel
 * Date: 2020/3/16 13:39
 * Description:
 * Author: ShiJingFeng
 */
internal class MainViewModel : AppBaseViewModel<BaseRepository<*, *>>() {

    /** 跳转到 wan_android 模块 主页 */
    val mWanAndroidMainListener = View.OnClickListener {
        navigation(path = ACTIVITY_WAN_ANDROID_MAIN)
    }

    /** 跳转到 weather 模块 主页 */
    val mWeatherMainListener = View.OnClickListener {
        navigation(path = ACTIVITY_WEATHER_MAIN)
    }

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository(): Nothing? = null

}