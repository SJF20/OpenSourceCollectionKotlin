/** 生成的 Java 类名 */
@file:JvmName("CoroutinesUtil")
package com.shijingfeng.base.util

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlin.coroutines.coroutineContext

/**
 * Function: 协程相关 工具类
 * Date: 2020/11/25 15:33
 * Description:
 * @author ShiJingFeng
 */

/**
 * 当前 协程
 */
suspend inline fun currentCoroutine() = coroutineContext[Job.Key]

/**
 * 当前协程名称
 */
suspend inline fun currentCoroutineName() = coroutineContext[CoroutineName.Key]?.name ?: currentCoroutine()