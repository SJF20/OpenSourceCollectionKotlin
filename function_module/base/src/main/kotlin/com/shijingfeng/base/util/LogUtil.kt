@file:JvmName("LogUtil")
package com.shijingfeng.base.util

import android.util.Log
import com.shijingfeng.base.BuildConfig

/**
 * Function: 日志工具类
 * Date: 2020/1/18 16:50
 * Description:
 * Author: ShiJingFeng
 */

private var sEnable = BuildConfig.DEBUG

/** 测试相关日志 */
const val LOG_TEST = "log_test"
/** 腾讯X5相关日志 */
const val LOG_TENCENT_X5 = "log_tencent_x5"
/** 友盟相关日志 */
const val LOG_UMENG = "log_umeng"
/** 玩Android皮肤相关日志 */
const val LOG_WAN_ANDROID_SKIN = "log_wan_android_skin"
/** 生命周期函数相关日志 */
const val LOG_LIFECYCLE = "log_lifecycle"
/** 异常相关日志 */
const val LOG_EXCEPTION = "log_exception"

/**
 * 日志级别：verbose
 * @param tag 日志标签
 * @param msg 日志内容
 */
fun v(tag: String, msg: String) {
    if (sEnable) {
        Log.v(tag, msg)
    }
}

/**
 * 日志级别：info
 * @param tag 日志标签
 * @param msg 日志内容
 */
fun i(tag: String, msg: String) {
    if (sEnable) {
        Log.i(tag, msg)
    }
}

/**
 * 日志级别：debug
 * @param tag 日志标签
 * @param msg 日志内容
 */
fun d(tag: String, msg: String) {
    if (sEnable) {
        Log.d(tag, msg)
    }
}

/**
 * 日志级别：warn
 * @param tag 日志标签
 * @param msg 日志内容
 */
fun w(tag: String, msg: String) {
    if (sEnable) {
        Log.w(tag, msg)
    }
}

/**
 * 日志级别：error
 * @param tag 日志标签
 * @param msg 日志内容
 */
fun e(tag: String, msg: String) {
    if (sEnable) {
        Log.e(tag, msg)
    }
}