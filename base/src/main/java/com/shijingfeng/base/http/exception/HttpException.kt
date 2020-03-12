package com.shijingfeng.base.http.exception

import kotlin.Exception

/**
 * Function: 请求服务器错误 或 服务器返回错误 实体类
 * Date: 2020/1/22 20:25
 * Description:
 *
 * @author ShiJingFeng
 */
class HttpException(

    /** 错误代码 */
    val errorCode: Int,
    /** 错误内容 */
    var errorMsg: String = "",
    /** 错误异常 */
    throwable: Throwable? = null

) : Exception(throwable)