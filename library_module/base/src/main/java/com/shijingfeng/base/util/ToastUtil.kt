@file:JvmName("ToastUtil")
package com.shijingfeng.base.util

import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.BuildConfig

/**
 * Function: 吐司 工具类
 * Date: 20-4-25 上午10:05
 * Description:
 * Author: shijingfeng
 */

/**
 * 显示 调试 长时间显示 吐司文本
 */
fun showDebugLongToast(text: String) {
    if (BuildConfig.DEBUG) {
        ToastUtils.showLong(text)
    }
}

/**
 * 显示 调试 短时间显示 吐司文本
 */
fun showDebugShortToast(text: String) {
    if (BuildConfig.DEBUG) {
        ToastUtils.showShort(text)
    }
}