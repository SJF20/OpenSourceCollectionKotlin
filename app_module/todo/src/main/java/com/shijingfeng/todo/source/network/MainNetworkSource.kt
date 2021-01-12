package com.shijingfeng.todo.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: MainNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainNetworkSourceInstance(): MainNetworkSource {
    if (sInstance == null) {
        synchronized(MainNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = MainNetworkSource()
            }
        }
    }
    return sInstance as MainNetworkSource
}

/**
 * Function: 主页 网络源
 * Date: 2020/5/17 16:36
 * Description:
 * Author: ShiJingFeng
 */
internal class MainNetworkSource : BaseNetworkSource() {

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}