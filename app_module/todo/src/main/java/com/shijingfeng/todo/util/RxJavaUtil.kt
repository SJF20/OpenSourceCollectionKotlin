/** 生成的 Java 类名 */
@file:JvmName("RxJavaUtil")
package com.shijingfeng.todo.util

import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.http.exception.E
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.http.exception.handle
import com.shijingfeng.todo.constant.SERVER_SUCCESS
import com.shijingfeng.todo.entity.network.ResultEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Function: RxJava 工具类
 * Date: 2020/3/19 12:15
 * Description:
 * @author ShiJingFeng
 */

/**
 * 网络请求
 * @param single 被观察的网络资源
 * @param customHandleException true 自定义控制异常  false 统一处理
 * @param onSuccess 成功函数回调
 * @param onFailure 失败函数回调
 */
internal fun <D, R : ResultEntity<D>> apiRequest(
    single: Single<R>,
    customHandleException: Boolean = false,
    onSuccess: onSuccess<D?>? = null,
    onFailure: onFailure? = null
): Disposable {
    return single
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ result ->
            if (result.code == SERVER_SUCCESS) {
                onSuccess?.invoke(result.data)
            } else {
                val exception = if (customHandleException) {
                    E(error = ServerException(result.code, result.msg))
                } else{
                    handle(ServerException(result.code, result.msg))
                }

                onFailure?.invoke(exception)
            }
        }, { throwable ->
            val exception = if (customHandleException) {
                E(error = throwable)
            } else {
                handle(throwable)
            }

            onFailure?.invoke(exception)
        })
}