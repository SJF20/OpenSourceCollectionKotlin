package com.shijingfeng.base.common.extension

import com.shijingfeng.base.http.exception.HttpException
import kotlinx.coroutines.Job
import kotlin.coroutines.coroutineContext

/**
 * Function: 通用 扩展类
 * Date: 2020/2/13 22:16
 * Description:
 * @author ShiJingFeng
 */

/** 成功回调 */
typealias OnSuccess<T> = (data: T) -> Unit

/** 失败回调 */
typealias OnFailure = (e: HttpException?) -> Unit

/**
 * 当前 协程 Job
 */
suspend inline fun Job.Key.currentJob() = coroutineContext[Job]