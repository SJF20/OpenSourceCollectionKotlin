/** 生成的 Java 类名 */
@file:JvmName("CommonExtension")
package com.shijingfeng.base.common.extension

import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.shijingfeng.base.http.exception.E
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.coroutineContext

/**
 * Function: 通用 扩展类
 * Date: 2020/2/13 22:16
 * Description:
 * @author ShiJingFeng
 */

/** 成功回调 */
typealias onSuccess<T> = (data: T) -> Unit

/** 失败回调 */
typealias onFailure = (e: E?) -> Unit

/** 适配器事件监听回调 */
typealias onItemEvent = (view: View?, data: Any?, position: Int, flag: String) -> Unit

/** SwipeRefreshLayout 刷新回调 */
typealias onSwipeRefresh = (refreshLayout: SwipeRefreshLayout) -> Unit

/**
 * 当前 协程
 */
suspend inline fun currentCoroutine() = coroutineContext[Job.Key]

/**
 * 当前协程名称
 */
suspend inline fun currentCoroutineName() = coroutineContext[CoroutineName.Key]?.name ?: currentCoroutine()