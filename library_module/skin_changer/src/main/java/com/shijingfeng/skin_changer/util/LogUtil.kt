/** 生成的 Java 类名 */
@file:JvmName("LogUtil")
package com.shijingfeng.skin_changer.util

import android.util.Log
import com.shijingfeng.skin_changer.BuildConfig

/**
 * Function: 日志工具类
 * Date: 2020/7/20 15:52
 * Description:
 * @author ShiJingFeng
 */

/** SkinChanger 日志 */
internal const val LOG_SKIN_CHANGER = "log_skin_changer"

private val enable = BuildConfig.DEBUG

/**
 * 日志级别：verbose
 * @param tag 日志标签
 * @param msg 日志内容
 */
internal fun v(tag: String, msg: String) {
    if (enable) {
        Log.v(tag, msg)
    }
}

/**
 * 日志级别：info
 * @param tag 日志标签
 * @param msg 日志内容
 */
internal fun i(tag: String, msg: String) {
    if (enable) {
        Log.i(tag, msg)
    }
}

/**
 * 日志级别：debug
 * @param tag 日志标签
 * @param msg 日志内容
 */
internal fun d(tag: String, msg: String) {
    if (enable) {
        Log.d(tag, msg)
    }
}

/**
 * 日志级别：warn
 * @param tag 日志标签
 * @param msg 日志内容
 */
internal fun w(tag: String, msg: String) {
    if (enable) {
        Log.w(tag, msg)
    }
}

/**
 * 日志级别：error
 * @param tag 日志标签
 * @param msg 日志内容
 */
internal fun e(tag: String, msg: String) {
    if (enable) {
        Log.e(tag, msg)
    }
}