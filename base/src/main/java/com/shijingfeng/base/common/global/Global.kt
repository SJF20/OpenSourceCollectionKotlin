package com.shijingfeng.base.common.global

import android.os.Handler
import android.os.Looper
import com.bumptech.glide.load.model.UnitModelLoader

/**
 * Function: 全局静态变量
 * Date: 2020/5/11 16:05
 * Description:
 * @author ShiJingFeng
 */

/** 主线程 Handler */
private val mainHandler = Handler(Looper.getMainLooper())

/** 获取 主线程 Handler */
fun getMainHandler() = mainHandler

/**
 * 运行在主线程
 * @param action 要执行的回调
 */
fun runOnUiThread(
    delay: Long = 0L,
    action: () -> Unit
) = mainHandler.postDelayed(action, delay)