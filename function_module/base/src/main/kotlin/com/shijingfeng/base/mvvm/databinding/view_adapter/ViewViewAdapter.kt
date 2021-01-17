/** 生成的 Java 类名 */
@file:JvmName("ViewViewAdapter")
package com.shijingfeng.base.mvvm.databinding.view_adapter

import android.view.View
import androidx.annotation.IntRange
import androidx.databinding.BindingAdapter
import com.blankj.utilcode.util.ClickUtils

/**
 * Function: View View适配器
 * Date: 2020/1/27 16:02
 * Description:
 * Author: ShiJingFeng
 */

@BindingAdapter(
    value = ["onClick", "disEnableClickThrottle", "clickThrottleMs"],
    requireAll = false
)
fun onClick(
    view: View,
    listener: View.OnClickListener?,
    disEnableClickThrottle: Boolean = false,
    @IntRange(from = 0) clickThrottleMs: Int = 0
) {
    if (listener == null) {
        return
    }
    if (disEnableClickThrottle) {
        view.setOnClickListener(listener)
    } else {
        if (clickThrottleMs <= 0) {
            ClickUtils.applySingleDebouncing(view, listener)
        } else {
            ClickUtils.applySingleDebouncing(view, clickThrottleMs.toLong(), listener)
        }
    }
}