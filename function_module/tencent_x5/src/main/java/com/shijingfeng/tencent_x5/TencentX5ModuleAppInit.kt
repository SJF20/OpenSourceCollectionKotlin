package com.shijingfeng.tencent_x5

import android.app.Application
import androidx.annotation.Keep
import com.shijingfeng.apt_data.annotations.ModuleEventReceiver
import com.shijingfeng.apt_data.interfaces.ModuleEventListener
import com.shijingfeng.base.common.constant.DISPATCHER_DATA_KEY_APPLICATION
import com.shijingfeng.base.common.constant.DISPATCHER_GROUP_APPLICATION
import com.shijingfeng.base.entity.event.event_bus.X5InitedEvent
import com.shijingfeng.base.util.LOG_LIFECYCLE
import com.shijingfeng.base.util.LOG_TENCENT_X5
import com.shijingfeng.base.util.e
import com.shijingfeng.tencent_x5.global.isX5Inited
import com.tencent.smtt.sdk.QbSdk
import org.greenrobot.eventbus.EventBus

/**
 * Function: 模块 Application初始化
 * Date: 2020/5/25 22:12
 * Description:
 * Author: ShiJingFeng
 */
@Keep // TencentX5ModuleAppInit是通过反射调用，所以应防止被混淆
@ModuleEventReceiver(
    group = DISPATCHER_GROUP_APPLICATION
)
internal class TencentX5ModuleAppInit : ModuleEventListener {

    /** X5内核是否初始化成功  true:成功 false:失败  */
    private var mX5InitSuccess = false

    /**
     * 接收回调
     */
    override fun onReceive(data: Map<String, Any>): Boolean {
        e(LOG_LIFECYCLE, "tencent_x5 receiver onCreate")
        val application = data[DISPATCHER_DATA_KEY_APPLICATION] as Application

        // 初始化腾讯X5
        initX5(application)
        return super.onReceive(data)
    }

    /**
     * 初始化腾讯X5
     *
     * @param application Application
     */
    private fun initX5(application: Application) {
        //搜集本地TBS内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        val cb = object : QbSdk.PreInitCallback {

            /**
             * x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
             * @param success true 内核加载成功  false 内核加载失败, 自动切换到系统内核
             */
            override fun onViewInitFinished(success: Boolean) {
                mX5InitSuccess = success
                if (success) {
                    e(LOG_TENCENT_X5, "腾讯X5内核加载成功")
                } else {
                    e(LOG_TENCENT_X5, "腾讯X5内核加载失败")
                }
            }

            /**
             * x5內核初始化完成回调
             */
            override fun onCoreInitFinished() {
                e(LOG_TENCENT_X5, "腾讯X5内核初始化完毕")
                isX5Inited = true
                EventBus.getDefault().post(X5InitedEvent(mX5InitSuccess))
            }

        }

        //x5内核初始化接口
        QbSdk.initX5Environment(application, cb)
    }

}