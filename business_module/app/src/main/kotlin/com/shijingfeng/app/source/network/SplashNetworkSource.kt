package com.shijingfeng.app.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: SplashNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSplashNetworkSourceInstance(): SplashNetworkSource {
    if (sInstance == null) {
        synchronized(SplashNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = SplashNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 启动页 网络源
 * Date: 2020/5/23 15:51
 * Description:
 * Author: ShiJingFeng
 */
internal class SplashNetworkSource : BaseNetworkSource() {

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}