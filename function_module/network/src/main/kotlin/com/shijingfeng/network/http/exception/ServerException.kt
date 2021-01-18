package com.shijingfeng.network.http.exception

import kotlin.Exception

/**
 * Function: 服务器 异常
 * Date: 2020/1/22 20:34
 * Description:
 * @author ShiJingFeng
 */
class ServerException(

    /** 错误代码 */
    val errorCode: Int,
    /** 错误内容 */
    val errorMsg: String = "",
    /** 错误异常 */
    throwable: Throwable? = null

) : Exception(throwable)