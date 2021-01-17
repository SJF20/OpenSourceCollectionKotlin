package com.shijingfeng.base.common.global

import android.os.Handler
import android.os.Looper
import androidx.annotation.AnyThread
import com.bumptech.glide.load.model.UnitModelLoader

/**
 * Function: 全局静态变量
 * Date: 2020/5/11 16:05
 * Description:
 * Author: ShiJingFeng
 */

/** 主线程 Handler */
private val MAIN_HANDLER = Handler(Looper.getMainLooper())

/**
 * 获取 主线程 Handler
 */
val mainHandler: Handler
    get() = MAIN_HANDLER

/**
 * 运行在主线程
 *
 * @param delay  延迟时间 (毫秒值)
 * @param action 要执行的回调
 */
@AnyThread
fun runOnUiThread(
    delay: Long = 0L,
    action: () -> Unit
) = MAIN_HANDLER.postDelayed(action, delay)

/** 阿里 Sophix 热修复 是否已经初始化 (用于单模块调试时, 不需要初始化 Sophix, 调用 killProcessSafely 闪退问题) */
var sSophixHasInitialized = false