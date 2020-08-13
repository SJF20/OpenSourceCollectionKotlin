package com.shijingfeng.todo.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.todo.source.local.MainLocalSource
import com.shijingfeng.todo.source.network.MainNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: MainRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainRepositoryInstance(
    localSource: MainLocalSource? = null,
    networkSource: MainNetworkSource? = null
): MainRepository {
    if (sInstance == null) {
        synchronized(MainRepository::class.java) {
            if (sInstance == null) {
                sInstance = MainRepository(
                    localSource = localSource,
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 仓库
 * Date: 2020/5/17 16:33
 * Description:
 * @author ShiJingFeng
 */
internal class MainRepository(
    localSource: MainLocalSource? = null,
    networkSource: MainNetworkSource? = null
) : BaseRepository<MainLocalSource, MainNetworkSource>(
    mLocalSource = localSource,
    mNetworkSource = networkSource
) {

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}