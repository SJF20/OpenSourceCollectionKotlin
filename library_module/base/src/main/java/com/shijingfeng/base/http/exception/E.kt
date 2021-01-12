package com.shijingfeng.base.http.exception

import com.shijingfeng.base.common.constant.UNKNOWN_EXCEPTION
import kotlin.Exception

/**
 * Function: 请求服务器错误 或 服务器返回错误 实体类
 * Date: 2020/1/22 20:25
 * Description:
 *
 * Author: ShiJingFeng
 */
open class E(

    /** 用于区分属于哪个公司的接口产生的异常 */
    val flag: String = "",
    /** 错误代码 */
    val errorCode: Int = UNKNOWN_EXCEPTION,
    /** 错误内容 */
    var errorMsg: String = "",
    /** 错误异常 */
    val error: Throwable? = null

) : Exception(error)