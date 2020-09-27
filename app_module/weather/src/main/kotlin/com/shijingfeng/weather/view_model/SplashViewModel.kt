package com.shijingfeng.weather.view_model

import android.os.Bundle
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_MAIN
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.weather.base.WeatherBaseViewModel

/**
 * Function: 启动页 ViewModel
 * Date: 2020/9/27 16:25
 * Description:
 * @author ShiJingFeng
 */
internal class SplashViewModel(
    repository: BaseRepository<*, *>? = null
) : WeatherBaseViewModel<BaseRepository<*, *>>(
    repository = repository
) {

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        runOnUiThread(1500) {
            //跳转到首页
            navigation(
                path = ACTIVITY_WEATHER_MAIN,
                bundle = Bundle().apply {
                    putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
                }
            )
        }
    }

}