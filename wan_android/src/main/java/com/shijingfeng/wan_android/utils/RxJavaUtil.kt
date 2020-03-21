/** 生成的 Java 类名 */
@file:JvmName("RxJavaUtil")

package com.shijingfeng.wan_android.utils

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.http.exception.handle
import com.shijingfeng.wan_android.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.network.ResultEntity
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
 * @param onSuccess 成功函数回调
 * @param onFailure 失败函数回调
 */
fun <D, R : ResultEntity<D>> apiRequest(single: Single<R>, onSuccess: OnSuccess<D?>? = null, onFailure: OnFailure? = null): Disposable {
    return single
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ result ->
            if (result.code == SERVER_SUCCESS) {
                onSuccess?.invoke(result.data)
            } else {
                onFailure?.invoke(handle(ServerException(result.code, result.msg)))
            }
        }, { throwable ->
            onFailure?.invoke(handle(throwable))
        })
}