/** 生成的 Java 类名 */
@file:JvmName("ToastUtil")
package com.shijingfeng.skin_changer.util

import android.widget.Toast
import com.shijingfeng.skin_changer.BuildConfig
import com.shijingfeng.skin_changer.global.appContext

/**
 * Function: Toast工具类
 * Date: 2020/7/20 15:54
 * Description:
 * @author ShiJingFeng
 */

/**
 * Debug模式下 弹出短时间Toast
 */
internal fun showShortToast(message: String) {
    if (BuildConfig.DEBUG) {
        Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
    }
}

/**
 * Debug模式下 弹出长时间Toast
 */
internal fun showLongToast(message: String) {
    if (BuildConfig.DEBUG) {
        Toast.makeText(appContext, message, Toast.LENGTH_LONG).show()
    }
}