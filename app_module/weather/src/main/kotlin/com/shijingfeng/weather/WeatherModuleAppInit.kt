package com.shijingfeng.weather

import androidx.annotation.Keep
import com.shijingfeng.apt_data.annotations.ModuleEventReceiver
import com.shijingfeng.apt_data.interfaces.ModuleEventListener
import com.shijingfeng.base.common.constant.DISPATCHER_GROUP_APPLICATION
import com.shijingfeng.base.util.LOG_LIFECYCLE
import com.shijingfeng.base.util.e
import com.shijingfeng.weather.common.global.cityDataManager
import com.shijingfeng.weather.data_structure.CityDataManager

/**
 * Function: 模块 Application初始化 (类名不要变化(反射的缘故), 除非包括其他模块全局更改类名为同一个 并在 base模块中更改反射类名)
 * Date: 2020/5/25 22:12
 * Description:
 * @author ShiJingFeng
 */
@Keep // WeatherModuleAppInit是通过反射调用，所以应防止被混淆
@ModuleEventReceiver(
    group = DISPATCHER_GROUP_APPLICATION
)
internal class WeatherModuleAppInit : ModuleEventListener {

    /**
     * 接收回调
     */
    override fun onReceive(data: Map<String, Any>): Boolean {
        e(LOG_LIFECYCLE, "weather receiver onCreate")
        CityDataManager.init(onSuccess = {
            cityDataManager = it
        })
        return super.onReceive(data)
    }

}