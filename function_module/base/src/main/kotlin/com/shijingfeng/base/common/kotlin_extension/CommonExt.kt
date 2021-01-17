/** 生成的 Java 类名 */
@file:JvmName("CommonExtension")
package com.shijingfeng.base.common.kotlin_extension

import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

/**
 * Function: 通用 扩展类
 * Date: 2020/2/13 22:16
 * Description:
 * Author: ShiJingFeng
 */

/** 适配器事件监听回调 */
typealias onItemEvent = (view: View?, data: Any?, position: Int, flag: String) -> Unit

/** SwipeRefreshLayout 刷新回调 */
typealias onSwipeRefresh = (refreshLayout: SwipeRefreshLayout) -> Unit