/** 生成的 Java 类名 */
@file:JvmName("TokenExpireUtil")
package com.shijingfeng.wan_android.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.BASE_URL_VALUE_WAN_ANDROID
import com.shijingfeng.base.common.constant.PENDING_CODE_TOKEN_EXPIRE
import com.shijingfeng.base.common.global.getMainHandler
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.http.cookie.store.PersistentCookieStore
import com.shijingfeng.wan_android.receiver.WanAndroidTokenExpiredReceiver
import com.shijingfeng.wan_android.receiver.registerWanAndroidTokenExpiredReceiver
import com.shijingfeng.wan_android.receiver.unregisterWanAndroidTokenExpiredReceiver
import okhttp3.Request

/**
 * Function: 玩安卓 Token 过期检查 工具类
 * Date: 2020/5/26 13:48
 * Description:
 * @author ShiJingFeng
 */

/** 玩Android Token 失效时间 */
private var mExpireDateTime: Long? = null
/** 检查 玩Android Token 是否过期 PendingIntent */
private var mTokenExpirePendingIntent: PendingIntent? = null

/** 检查 玩Android Token 是否过期 定时器 是否已开启  true:已开启  false:未开启 */
private var mIsTokenExpireAlarmStarted = false

/**
 * 检查 玩安卓 Token 是否过期
 */
internal fun checkTokenExpire() {
    if (UserUtil.isLogin()) {
        mExpireDateTime = null
        if (isTokenExpired()) {
            // 玩安卓 Token已过期，本地退出登录
            localLogout()
        } else {
            // 开启 检查 玩Android Token 是否过期 定时器
            startTokenExpireAlarm()
        }
    }
}

/**
 * 玩Android Token 是否过期  true: 已过期  false: 未过期
 */
private fun isTokenExpired(): Boolean {
    val request = Request.Builder()
        .url(BASE_URL_VALUE_WAN_ANDROID + "user/login")
        .build()
    val cookieList = PersistentCookieStore(application).getCookieList(request.url)

    cookieList?.forEach { cookie ->
        val cookieName = cookie.name

        if (cookie.expiresAt < System.currentTimeMillis()) {
            return true
        } else if (cookieName == "loginUserName"
            || cookieName == "loginUserName_wanandroid_com"
            || cookieName == "token_pass"
            || cookieName == "token_pass_wanandroid_com"
        ) {
            if (mExpireDateTime == null) {
                mExpireDateTime = cookie.expiresAt
            }
        }
    }
    return false
}

/**
 * 开启 检查 玩Android Token 是否过期 定时器
 */
internal fun startTokenExpireAlarm() {
    val expireDateTime = mExpireDateTime ?: return
    val alarmManager = application.getSystemService(Context.ALARM_SERVICE) as AlarmManager?

    // AlarmManager在应用被杀死的情况下会终止执行, 可以考虑使用 WorkManager(执行周期最低为 15分钟, 用于防止恶意保活)
    // RTC: 对应System.currentTimeMillis()（系统当前时间）  ELAPSED_REALTIME: 对应SystemClock.elapsedRealtime()（系统运行时间）
    // RTC 或 ELAPSED_REALTIME 以 WAKEUP 结尾的类型能够唤醒设备，其他的类型不能唤醒设备，直到设备被唤醒才能出发警报提醒
    // 关于 AlarmManager详情请看: https://www.jianshu.com/p/8a2ce9d02640
    alarmManager?.run {
        mIsTokenExpireAlarmStarted = true

        // 注册 玩Android Token失效 Broadcast Receiver
        registerWanAndroidTokenExpiredReceiver()

        mTokenExpirePendingIntent = PendingIntent.getBroadcast(
            application,
            PENDING_CODE_TOKEN_EXPIRE,
            Intent().apply {
                action = WanAndroidTokenExpiredReceiver::class.java.name
            },
            FLAG_UPDATE_CURRENT
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Android 6.0 及以上版本 引入低功耗模式, 使用精确时间应使用 setExactAndAllowWhileIdle()
            setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, expireDateTime, mTokenExpirePendingIntent)
        } else {
            // Android 4.4 及以上版本 为了省电, 合并相似时间的Alarm进行批量执行, 使用精确时间应使用 setExact()
            setExact(AlarmManager.RTC_WAKEUP, expireDateTime, mTokenExpirePendingIntent)
        }
    }
}

/**
 * 停止 检查 玩Android Token 是否过期 定时器
 */
internal fun stopTokenExpireAlarm() {
    mIsTokenExpireAlarmStarted ?: return
    val tokenExpirePendingIntent = mTokenExpirePendingIntent ?: return
    val alarmManager = application.getSystemService(Context.ALARM_SERVICE) as AlarmManager?

    mIsTokenExpireAlarmStarted = false

    // 取消注册 玩Android Token失效 Broadcast Receiver
    unregisterWanAndroidTokenExpiredReceiver()

    alarmManager?.cancel(tokenExpirePendingIntent)
}