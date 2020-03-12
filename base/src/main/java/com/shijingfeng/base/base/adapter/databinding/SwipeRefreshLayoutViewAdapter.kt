/** 生成的 Java 类名 */
@file:JvmName("SwipeRefreshLayoutViewAdapter")
package com.shijingfeng.base.base.adapter.databinding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.shijingfeng.base.listener.OnSwipeRefreshListener

/**
 * Function: 下拉刷新 View适配器
 * Date: 2020/1/27 15:59
 * Description:
 * @author ShiJingFeng
 */

/**
 * 设置 下拉刷新 回调
 * @param swipeRefreshLayout SwipeRefreshLayout
 * @param listener 回调监听器
 */
@BindingAdapter(value = ["onRefreshListener"], requireAll = false)
fun setOnRefreshListener(
    swipeRefreshLayout: SwipeRefreshLayout,
    listener: OnSwipeRefreshListener?
) {
    if (listener == null) {
        return
    }
    swipeRefreshLayout.setOnRefreshListener {
        listener.onRefresh(swipeRefreshLayout)
    }
}