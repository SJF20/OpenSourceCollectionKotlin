package com.shijingfeng.base.http.exception

import android.net.ParseException
import android.text.TextUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.gson.JsonParseException
import com.shijingfeng.base.common.constant.NETWORK_EXCEPTION
import com.shijingfeng.base.common.constant.PARSE_EXCEPTION
import com.shijingfeng.base.common.constant.UNKNOWN_EXCEPTION
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Function: HTTP异常 控制 工具类
 * Date: 2020/1/29 22:20
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

    if (e is ServerException) {
        //服务器异常
        exception = HttpException(e.errorCode, e.errorMsg, e)
    } else if (e is retrofit2.HttpException) {
        //网络请求异常 (比如常见404 500之类的等)
        exception = HttpException(e.code(), "网络请求错误${e.code()}", e)
    } else if (e is JsonParseException || e is JSONException || e is ParseException) {
        //解析异常
        exception = HttpException(PARSE_EXCEPTION, "解析错误", e)
    } else if (e is ConnectException || e is UnknownHostException || e is SocketTimeoutException) {
        //网络连接异常
        exception =
            HttpException(NETWORK_EXCEPTION, "网络连接错误", e)
    } else {
        //未知异常
        exception = HttpException(UNKNOWN_EXCEPTION, "未知错误", e)
    }
    if (!TextUtils.isEmpty(exception.errorMsg)) {
        ToastUtils.showShort(exception.errorMsg)
    } else {
        ToastUtils.showShort("未知错误")
    }
    return exception
}