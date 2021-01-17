/** 生成的 Java 类名 */
@file:JvmName("SwipeRefreshLayoutViewAdapter")
package com.shijingfeng.base.mvvm.databinding.view_adapter

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.shijingfeng.base.common.kotlin_extension.onSwipeRefresh

/**
 * Function: 下拉刷新 View适配器
 * Date: 2020/1/27 15:59
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 设置 下拉刷新 回调
 * @param swipeRefreshLayout SwipeRefreshLayout
 * @param onSwipeRefresh 刷新回调监听器
 */
@BindingAdapter(value = ["onSwipeRefreshListener"], requireAll = false)
fun setOnRefreshListener(
    swipeRefreshLayout: SwipeRefreshLayout,
    onSwipeRefresh: onSwipeRefresh?
) {
    if (onSwipeRefresh == null) {
        return
    }
    swipeRefreshLayout.setOnRefreshListener {
        onSwipeRefresh(swipeRefreshLayout)
    }
}