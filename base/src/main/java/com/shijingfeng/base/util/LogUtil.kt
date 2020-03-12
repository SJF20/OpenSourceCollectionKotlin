@file:JvmName("LogUtil")
package com.shijingfeng.base.util

import android.util.Log

/**
 * Function: 日志工具类
 * Date: 2020/1/18 16:50
 * Description:
 * @author ShiJingFeng
 */

private var sEnable = false

/**
 * 是否开启日志
 * @param enable true 开启  false 关闭
 */
fun enable(enable: Boolean) {
    sEnable = enable
}

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
