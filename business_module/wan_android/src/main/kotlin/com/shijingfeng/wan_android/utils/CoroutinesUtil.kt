package com.shijingfeng.wan_android.utils

import com.shijingfeng.network.http.exception.E
import com.shijingfeng.network.http.exception.ServerException
import com.shijingfeng.wan_android.common.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.ResultEntity

/**
 * Function: 协程 工具类
 * Date: 2020/11/23 10:15
 * Description:
 * Author: ShiJingFeng
 */
internal fun <T> apiRequest(
    result: ResultEntity<T>,
    customHandleException: Boolean = false
) = try {
    if (result.code == SERVER_SUCCESS) {
        result.data
    } else {
        val exception = if (customHandleException) {
            E(error = ServerException(result.code, result.msg))
        } else {
            handle(ServerException(result.code, result.msg))
        }

        throw exception
    }
} catch (e: Exception) {
    val exception = if (customHandleException) {
        E(error = e)
    } else {
        handle(e)
    }

    throw exception
}