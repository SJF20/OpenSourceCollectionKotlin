package com.shijingfeng.app.source.repository

import com.shijingfeng.app.source.local.SplashLocalSource
import com.shijingfeng.app.source.network.SplashNetworkSource
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess

/** 单例实例 */
@Volatile
private var sInstance: SplashRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSplashRepositoryInstance(
    localSource: SplashLocalSource? = null,
    networkSource: SplashNetworkSource? = null
): SplashRepository {
    if (sInstance == null) {
        synchronized(SplashRepository::class.java) {
            if (sInstance == null) {
                sInstance = SplashRepository(
                    localSource = localSource,
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 启动页 仓库
 * Date: 2020/5/23 15:50
 * Description:
 * Author: ShiJingFeng
 */
internal class SplashRepository(
    localSource: SplashLocalSource? = null,
    networkSource: SplashNetworkSource? = null
) : BaseRepository<SplashLocalSource, SplashNetworkSource>(
    mLocalSource = localSource,
    mNetworkSource = networkSource
) {

    /**
     * 检查版本更新
     *
     * @param onSuccess 成功回调监听器
     * @param onFailure 失败回调监听器
     */
    fun checkForUpdate(
        onSuccess: onSuccess<Any?>,
        onFailure: onFailure
    ) {

    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}