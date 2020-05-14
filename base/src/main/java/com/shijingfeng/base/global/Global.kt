package com.shijingfeng.base.global

import android.os.Handler
import android.os.Looper

/**
 * Function: 全局静态变量
 * Date: 2020/5/11 16:05
 * Description:
 * @author ShiJingFeng
 */

/** 主线程 Handler */
private val mainHandler = Handler(Looper.getMainLooper())

/**
 * 运行在主线程
 * @param action 要执行的回调
 */
fun runOnUiThread(action: () -> Unit) {
    if (Thread.currentThread() !== Looper.getMainLooper().thread) {
        mainHandler.post(action)
    } else {
        action()
    }
}