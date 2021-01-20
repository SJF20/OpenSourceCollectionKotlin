package com.shijingfeng.network

import androidx.annotation.Keep
import com.shijingfeng.module_event_dispatcher.data.annotations.ModuleEventReceiver
import com.shijingfeng.module_event_dispatcher.data.interfaces.ModuleEventListener
import com.shijingfeng.base.common.constant.DISPATCHER_GROUP_APPLICATION
import com.shijingfeng.base.util.MODULE_EVENT_DISPATCHER
import com.shijingfeng.base.util.d
import com.shijingfeng.network.BuildConfig.MODULE_NAME
import com.shijingfeng.network.constant.*
import me.jessyan.retrofiturlmanager.RetrofitUrlManager

/**
 * Function: 模块 Application初始化
 * Date: 2020/12/31 15:50
 * Description:
 * @author ShiJingFeng
 */
@Keep // 因此类通过反射调用, 故需混淆
@ModuleEventReceiver(
    group = DISPATCHER_GROUP_APPLICATION
)
internal class NetworkModuleApplication : ModuleEventListener {

    /**
     * 事件回调
     *
     * @return false: 阻止事件向后面的接收器分发
     */
    override fun onReceive(data: Map<String, Any>): Boolean {
        d(MODULE_EVENT_DISPATCHER, "$MODULE_NAME ModuleApplication onCreate")
        // 初始化 RetrofitUrlManager
        initRetrofitUrlManager()
        return super.onReceive(data)
    }

    /**
     * 初始化 RetrofitUrlManager
     */
    private fun initRetrofitUrlManager() {
        RetrofitUrlManager.getInstance().run {
            // 设置是否开启Debug调试  true:开启  false:关闭
            setDebug(true)
            //将每个 BaseUrl 进行初始化,运行时可以随时改变 DOMAIN_NAME 对应的值,从而达到切换 BaseUrl 的效果
            // 玩安卓 BaseUrl
            putDomain(BASE_URL_NAME_WAN_ANDROID, BASE_URL_VALUE_WAN_ANDROID)
            // Weather BaseUrl
            putDomain(BASE_URL_NAME_WEATHER, BASE_URL_VALUE_WEATHER)
            // 蒲公英 (用于检测版本更新 和 下载应用) BaseUrl
            putDomain(BASE_URL_NAME_PGYER, BASE_URL_VALUE_PGYER)
            // 高德行政区域查询 BaseUrl Value
            putDomain(BASE_URL_NAME_AMAP_CITY_SEARCH, BASE_URL_VALUE_AMAP_CITY_SEARCH)
        }
    }

}