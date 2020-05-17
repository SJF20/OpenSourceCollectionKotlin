package com.shijingfeng.wan_android.source.local

import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import java.util.concurrent.Executors

/** 单例实例 */
@Volatile
private var sInstance: MainLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainLocalSourceInstance(): MainLocalSource {
    if (sInstance == null) {
        synchronized(MainLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = MainLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 本地源
 * Date: 2020/5/17 14:59
 * Description:
 * @author ShiJingFeng
 */
internal class MainLocalSource : BaseLocalSource() {

    /** 线程池 */
    private val mExecutorService = Executors.newCachedThreadPool()

    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun logout(
        onSuccess: onSuccess<Any?>? = null,
        onFailure: onFailure? = null
    ) {
//        // TODO 此处用来删除 和用户相关的 数据库数据
//        getRealmInstance().executeTransactionAsync({ realm ->
//
//        }, {
//            // 成功回调
//            onSuccess?.invoke(null)
//        }, { throwable ->
//            // 失败回调
//            onFailure?.invoke(E(error = throwable))
//        })
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
        // 关闭线程池
        mExecutorService.shutdown()
    }
}