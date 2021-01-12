/** 生成的 Java 类名 */
@file:JvmName("BaseHttpExceptionHandleUtil")
package com.shijingfeng.base.http.exception

import android.net.ParseException
import android.text.TextUtils
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonParseException
import com.shijingfeng.base.R
import com.shijingfeng.base.common.constant.NETWORK_EXCEPTION
import com.shijingfeng.base.common.constant.PARSE_EXCEPTION
import com.shijingfeng.base.common.constant.UNKNOWN_EXCEPTION
import com.shijingfeng.base.util.getStringById
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Function: HTTP异常 控制 工具类
 * Date: 2020/1/29 22:20
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 异常控制
 * @param e 异常
 * @return 转换后的异常
 */
fun handle(e: Throwable): E {
    val exception = when (e) {
        //服务器异常
        is ServerException -> E(
            errorCode = e.errorCode,
            errorMsg = e.errorMsg,
            error = e
        )
        //网络请求异常 (比如常见404 500之类的等)
        is retrofit2.HttpException -> E(
            errorCode = e.code(),
            errorMsg = getStringById(R.string.网络请求错误) + e.code(),
            error = e
        )
        //解析异常
        is JsonParseException, is JSONException, is ParseException -> E(
            errorCode = PARSE_EXCEPTION,
            errorMsg = getStringById(R.string.解析错误),
            error = e
        )
        //网络连接异常
        is ConnectException, is UnknownHostException, is SocketTimeoutException -> E(
            errorCode = NETWORK_EXCEPTION,
            errorMsg = getStringById(R.string.网络连接错误),
            error = e
        )
        //未知异常
        else -> E(
            errorCode = UNKNOWN_EXCEPTION,
            errorMsg = getStringById(R.string.未知错误),
            error = e
        )
    }
    if (!TextUtils.isEmpty(exception.errorMsg)) {
        ToastUtils.showShort(exception.errorMsg)
    } else {
        ToastUtils.showShort(getStringById(R.string.未知错误))
    }
    return exception
}