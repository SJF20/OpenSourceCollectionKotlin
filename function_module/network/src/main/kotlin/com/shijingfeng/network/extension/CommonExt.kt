package com.shijingfeng.network.extension

import com.shijingfeng.network.http.exception.E

/**
 * Function: 通用 扩展函数
 * Date: 2020/12/31 15:31
 * Description:
 * @author ShiJingFeng
 */

/** 成功回调 */
typealias onSuccess<T> = (data: T) -> Unit

/** 失败回调 */
typealias onFailure = (e: E?) -> Unit