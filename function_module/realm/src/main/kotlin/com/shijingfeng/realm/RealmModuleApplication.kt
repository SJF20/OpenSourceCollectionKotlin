package com.shijingfeng.realm

import android.app.Application
import androidx.annotation.Keep
import com.shijingfeng.apt_data.annotations.ModuleEventReceiver
import com.shijingfeng.apt_data.constant.PRIORITY_HIGH
import com.shijingfeng.apt_data.constant.PRIORITY_MEDIUM
import com.shijingfeng.apt_data.interfaces.ModuleEventListener
import com.shijingfeng.base.common.constant.DISPATCHER_DATA_KEY_APPLICATION
import com.shijingfeng.base.common.constant.DISPATCHER_GROUP_APPLICATION
import com.shijingfeng.base.util.MODULE_EVENT_DISPATCHER
import com.shijingfeng.base.util.d
import com.shijingfeng.realm.BuildConfig.MODULE_NAME
import io.realm.Realm

/**
 * Function: 模块 Application初始化
 * Date: 2020/5/25 22:12
 * Description:
 * Author: ShiJingFeng
 */
@Keep // 因此类通过反射调用，所以应防止被混淆
@ModuleEventReceiver(
    group = DISPATCHER_GROUP_APPLICATION,
)
internal class RealmModuleApplication : ModuleEventListener {

    /**
     * 接收回调
     */
    override fun onReceive(data: Map<String, Any>): Boolean {
        d(MODULE_EVENT_DISPATCHER, "$MODULE_NAME ModuleApplication onCreate")
        val application = data[DISPATCHER_DATA_KEY_APPLICATION] as Application

        // 初始化 Realm 数据库
        initRealm(application)
        return super.onReceive(data)
    }

    /**
     * 初始化 Realm 数据库
     */
    private fun initRealm(application: Application) {
        // 初始化 Realm 数据库
        Realm.init(application)
    }

}