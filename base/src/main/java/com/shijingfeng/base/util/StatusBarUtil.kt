@file:JvmName("StatusBarUtil")
package com.shijingfeng.base.util

import android.annotation.TargetApi
import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.annotation.ColorRes
import com.shijingfeng.base.base.application.application

/**
 * Function: 状态栏工具类
 * Date: 2020/1/18 16:29
 * Description:
 * @author ShiJingFeng
 */

/**
 * 设置 状态栏背景 颜色
 * @param color 颜色资源
 */
fun setStatusBarColor(activity: Activity, @ColorRes color: Int) {
    activity.window?.run {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            statusBarColor = getColorById(color)
        }
    }
}

/**
 * 设置 状态栏内容 颜色
 * @param dark 深色 或 浅色   true: 深色  false: 浅色
 */
@TargetApi(23)
fun setStatusBarContentColor(activity: Activity, dark: Boolean) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        with(activity.window.decorView) {
            if (dark) {
                if (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR != systemUiVisibility) {
                    systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                }
            } else {
                if (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE != systemUiVisibility) {
                    systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                }
            }
        }
    }
}

/**
 * 获取状态栏高度
 * @return 高度
 */
fun getStatusBarHeight(): Int {
    var result = 0
    val resourceId = application.resources.getIdentifier("status_bar_height", "dimen", "android")

    if (resourceId > 0) {
        result = application.resources.getDimensionPixelSize(resourceId)
    }
    return result
}
