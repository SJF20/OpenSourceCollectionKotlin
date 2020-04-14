package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.source.network.MainNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: MainRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainRepositoryInstance(
    networkSource: MainNetworkSource? = null
): MainRepository {
    if (sInstance == null) {
        synchronized(MainRepository::class.java) {
            if (sInstance == null) {
                sInstance = MainRepository(
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 仓库
 * Date: 2020/2/11 12:50
 * Description:
 * @author ShiJingFeng
 */
internal class MainRepository(
    networkSource: MainNetworkSource? = null
) : BaseRepository<BaseLocalSource, MainNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun logout(onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        mNetworkSource?.logout(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}