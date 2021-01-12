package com.shijingfeng.app.source.local

import com.shijingfeng.base.base.source.BaseLocalSource

/** 单例实例 */
@Volatile
private var sInstance: SplashLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSplashLocalSourceInstance(): SplashLocalSource {
    if (sInstance == null) {
        synchronized(SplashLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = SplashLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 启动页 本地源
 * Date: 2020/5/23 15:52
 * Description:
 * Author: ShiJingFeng
 */
internal class SplashLocalSource : BaseLocalSource() {

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}