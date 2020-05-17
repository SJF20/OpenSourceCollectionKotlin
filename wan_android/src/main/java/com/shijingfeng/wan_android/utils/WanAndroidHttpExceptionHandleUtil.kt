/** 生成的 Java 类名 */
@file:JvmName("WanAndroidHttpExceptionHandleUtil")
package com.shijingfeng.wan_android.utils

import android.net.ParseException
import android.text.TextUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonParseException
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_LOGIN
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.NETWORK_EXCEPTION
import com.shijingfeng.base.common.constant.PARSE_EXCEPTION
import com.shijingfeng.base.common.constant.UNKNOWN_EXCEPTION
import com.shijingfeng.base.http.exception.E
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
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
internal fun handle(e: Throwable?): E {
    val throwable = if (e is E) e.error else e
    val exception: E

    when(throwable) {
        //服务器异常
        is ServerException -> {
            exception = E(throwable.errorCode, error = throwable)
            //服务器异常
            if (throwable.errorCode == SERVER_NEED_LOGIN) {
                exception.errorMsg = getStringById(R.string.需要登录)
                ToastUtils.showShort(exception.errorMsg)
                //需要登录, 跳转到登录页面
                navigation(
                    path = ACTIVITY_WAN_ANDROID_LOGIN
                )
                return exception
            } else {
                exception.errorMsg = throwable.errorMsg
            }
        }
        //网络请求异常 (比如常见404 500之类的等)
        is retrofit2.HttpException -> {
            exception = E(throwable.code(), getStringById(R.string.网络请求错误) + throwable.code(), throwable)
        }
        //解析异常
        is JsonParseException, is JSONException, is ParseException -> {
            exception = E(PARSE_EXCEPTION, getStringById(R.string.解析错误), throwable)
        }
        //网络连接异常
        is ConnectException, is UnknownHostException, is SocketTimeoutException -> {
            exception = E(NETWORK_EXCEPTION, getStringById(R.string.网络连接错误), throwable)
        }
        //未知异常
        else -> {
            exception = E(UNKNOWN_EXCEPTION, getStringById(R.string.未知错误), throwable)
        }
    }
    if (!TextUtils.isEmpty(exception.errorMsg)) {
        ToastUtils.showShort(exception.errorMsg)
    } else {
        ToastUtils.showShort(getStringById(R.string.未知错误))
    }
    return exception
}

