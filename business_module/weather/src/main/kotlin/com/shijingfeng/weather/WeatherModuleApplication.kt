package com.shijingfeng.weather

import androidx.annotation.Keep
import com.shijingfeng.module_event_dispatcher.data.annotations.ModuleEventReceiver
import com.shijingfeng.module_event_dispatcher.data.interfaces.ModuleEventListener
import com.shijingfeng.base.common.constant.DISPATCHER_GROUP_APPLICATION
import com.shijingfeng.base.util.MODULE_EVENT_DISPATCHER
import com.shijingfeng.base.util.d
import com.shijingfeng.weather.BuildConfig.MODULE_NAME
import com.shijingfeng.weather.common.global.cityDataManager
import com.shijingfeng.weather.data_structure.CityDataManager

/**
 * Function: 模块 Application初始化
 * Date: 2020/5/25 22:12
 * Description:
 * Author: ShiJingFeng
 */
@Keep // 因此类通过反射调用，所以应防止被混淆
@ModuleEventReceiver(
    group = DISPATCHER_GROUP_APPLICATION
)
internal class WeatherModuleApplication : ModuleEventListener {

    /**
     * 接收回调
     */
    override fun onReceive(data: Map<String, Any>): Boolean {
        d(MODULE_EVENT_DISPATCHER, "$MODULE_NAME ModuleApplication onCreate")
        CityDataManager.init(onSuccess = {
            cityDataManager = it
        })
        return super.onReceive(data)
    }

}