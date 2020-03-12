package com.shijingfeng.base.listener

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * Function: SwipeRefreshLayout 刷新监听器
 * Date: 2020/1/22 20:21
 * Description:
 * @author ShiJingFeng
 */
@FunctionalInterface
interface OnSwipeRefreshListener {

    /**
     * 刷新回调
     * @param refreshLayout SwipeRefreshLayout
     */
    fun onRefresh(refreshLayout: SwipeRefreshLayout)

}