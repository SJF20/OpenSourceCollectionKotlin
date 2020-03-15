/** 生成的 Java 类名 */
@file:JvmName("WanAndroidHttpExceptionHandleUtil")
package com.shijingfeng.wan_android.utils

import android.net.ParseException
import android.text.TextUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonParseException
import com.shijingfeng.base.common.constant.NETWORK_EXCEPTION
import com.shijingfeng.base.common.constant.PARSE_EXCEPTION
import com.shijingfeng.base.common.constant.UNKNOWN_EXCEPTION
import com.shijingfeng.base.http.exception.HttpException
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.wan_android.constant.SERVER_NEED_LOGIN
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Function: wan_android模块 HTTP异常 控制 工具类
 * Date: 2020/2/3 16:16
 * Description:
 * @author ShiJingFeng
 */

/**
 * 异常控制
 * @param e 异常
 * @return 转换后的异常
 */
fun handle(e: Throwable): HttpException {
    val exception: HttpException

    when(e) {
        //服务器异常
        is ServerException -> {
            exception = HttpException(e.errorCode, throwable = e)
            //服务器异常
            if (e.errorCode == SERVER_NEED_LOGIN) {
                exception.errorMsg = "需要登录"
            } else {
                exception.errorMsg = e.errorMsg
            }
        }
        //网络请求异常 (比如常见404 500之类的等)
        is retrofit2.HttpException -> {
            exception = HttpException(e.code(), "网络请求错误${e.code()}", e)
        }
        //解析异常
        is JsonParseException, is JSONException, is ParseException -> {
            exception = HttpException(PARSE_EXCEPTION, "解析错误", e)
        }
        //网络连接异常
        is ConnectException, is UnknownHostException, is SocketTimeoutException -> {
            exception = HttpException(NETWORK_EXCEPTION, "网络连接错误", e)
        }
        //未知异常
        else -> {
            exception = HttpException(UNKNOWN_EXCEPTION, "未知错误", e)
        }
    }
    if (!TextUtils.isEmpty(exception.errorMsg)) {
        ToastUtils.showShort(exception.errorMsg)
    } else {
        ToastUtils.showShort("未知错误")
    }
    return exception
}

