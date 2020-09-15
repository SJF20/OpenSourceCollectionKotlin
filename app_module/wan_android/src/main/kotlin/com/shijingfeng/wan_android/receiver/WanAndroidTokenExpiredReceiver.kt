package com.shijingfeng.wan_android.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_LOGIN
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.utils.localLogout

/** 玩Android Token失效 Broadcast Receiver */
private var mWanAndroidTokenExpiredReceiver: WanAndroidTokenExpiredReceiver? = null

/**
 * 注册 玩Android Token失效 Broadcast Receiver
 */
fun registerWanAndroidTokenExpiredReceiver() {
    if (mWanAndroidTokenExpiredReceiver == null) {
        mWanAndroidTokenExpiredReceiver = WanAndroidTokenExpiredReceiver()
        application.registerReceiver(mWanAndroidTokenExpiredReceiver, IntentFilter().apply {
            addAction(WanAndroidTokenExpiredReceiver::class.java.name)
        })
    }
}

/**
 * 取消注册 玩Android Token失效 Broadcast Receiver
 */
fun unregisterWanAndroidTokenExpiredReceiver() {
    if (mWanAndroidTokenExpiredReceiver != null) {
        application.unregisterReceiver(mWanAndroidTokenExpiredReceiver)
        mWanAndroidTokenExpiredReceiver = null
    }
}

/**
 * Function: 玩Android Token失效 BroadcastReceiver
 * Date: 2020/5/26 11:39
 * Description:
 * @author ShiJingFeng
 */
internal class WanAndroidTokenExpiredReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // 本地退出登录
        localLogout()
        ToastUtils.showShort(getStringById(R.string.玩AndroidToken失效请重新登录))
        // 跳转到登录页面
        navigation(
            path = ACTIVITY_WAN_ANDROID_LOGIN
        )
    }

}