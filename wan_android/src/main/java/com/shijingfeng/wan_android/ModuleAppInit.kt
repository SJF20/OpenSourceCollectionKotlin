package com.shijingfeng.wan_android

import android.app.AlarmManager
import android.app.AlarmManager.RTC
import android.app.AlarmManager.RTC_WAKEUP
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.BASE_URL_VALUE_WAN_ANDROID
import com.shijingfeng.base.common.constant.PENDING_CODE_TOKEN_EXPIRE
import com.shijingfeng.base.common.global.getMainHandler
import com.shijingfeng.base.http.cookie.store.PersistentCookieStore
import com.shijingfeng.base.interfaces.AppInit
import com.shijingfeng.wan_android.receiver.WanAndroidTokenExpiredReceiver
import com.shijingfeng.wan_android.receiver.registerWanAndroidTokenExpiredReceiver
import com.shijingfeng.wan_android.utils.UserUtil
import com.shijingfeng.wan_android.utils.checkTokenExpire
import com.shijingfeng.wan_android.utils.checkWanAndroidTokenExpire
import com.shijingfeng.wan_android.utils.localLogout
import okhttp3.Request

/**
 * Function: 模块 Application初始化 (类名不要变化(反射的缘故), 除非包括其他模块全局更改类名为同一个 并在 base模块中更改反射类名)
 * Date: 2020/5/25 22:12
 * Description:
 * @author ShiJingFeng
 */
internal class ModuleAppInit : AppInit {

    /**
     * 初始化 (对应 Application OnCreate())
     */
    override fun onCreate() {
        super.onCreate()
        // 检查 玩安卓 Token 是否过期
        checkTokenExpire()
    }

}