package com.shijingfeng.app

import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.entity.event.event_bus.X5InitedEvent
import com.shijingfeng.base.util.e
import com.shijingfeng.tencent_x5.global.isX5Inited
import com.tencent.smtt.sdk.QbSdk
import org.greenrobot.eventbus.EventBus

/**
 * Function: App 模块 Application
 * Date: 2020/2/2 22:29
 * Description:
 * @author ShiJingFeng
 */
internal class AppApplication : BaseApplication() {

    /** X5内核是否初始化成功  true:成功 false:失败  */
    private var mX5InitSuccess = false

    override fun onCreate() {
        super.onCreate()
        // 初始化腾讯X5
        initX5()
    }

    /**
     * 初始化腾讯X5
     */
    private fun initX5() {
        //搜集本地TBS内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        val cb = object : QbSdk.PreInitCallback {

            /**
             * x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
             * @param success true 内核加载成功  false 内核加载失败, 自动切换到系统内核
             */
            override fun onViewInitFinished(success: Boolean) {
                mX5InitSuccess = success
                if (success) {
                    e("测试", "腾讯X5内核加载成功")
                } else {
                    e("测试", "腾讯X5内核加载失败")
                }
            }

            /**
             * x5內核初始化完成回调
             */
            override fun onCoreInitFinished() {
                e("测试", "腾讯X5内核初始化完毕")
                isX5Inited = true
                EventBus.getDefault().post(X5InitedEvent(mX5InitSuccess))
            }

        }
        //x5内核初始化接口
        QbSdk.initX5Environment(this, cb)
    }

}