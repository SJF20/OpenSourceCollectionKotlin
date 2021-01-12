package com.shijingfeng.base.coroutines.exception_catcher

import com.shijingfeng.base.util.LOG_EXCEPTION
import com.shijingfeng.base.util.e
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

/**
 * Function: 全局协程异常捕获器
 * Date: 2020/12/8 14:15
 * Description:
 * Author: ShiJingFeng
 */
class GlobalExceptionCatcher : CoroutineExceptionHandler {

    override val key: CoroutineContext.Key<*> = CoroutineExceptionHandler

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        e(LOG_EXCEPTION, "全局协程异常捕获器: context: $context  exception: $exception")
    }
}