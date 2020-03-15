/** 生成的 Java 类名 */
@file:JvmName("WindowUtil")
package com.shijingfeng.base.util

import android.app.Activity
import android.view.WindowManager

/**
 * Function: Window 工具类
 * Date: 2020/1/18 22:12
 * Description:
 * @author ShiJingFeng
 */

/**
 * 设置窗口外部背景透明度
 */
fun setWindowOutsideBackground(activity: Activity, bgAlpha: Float) {
    activity.window?.run {
        addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        val params = attributes

        params.alpha = bgAlpha

        attributes = params
    }
}