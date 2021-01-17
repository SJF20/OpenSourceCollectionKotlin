package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.entity.NavigationClassifyEntity
import com.shijingfeng.wan_android.source.network.NavigationClassifyNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: NavigationClassifyRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getNavigationClassifyRepositoryInstance(
    networkSource: NavigationClassifyNetworkSource? = null
): NavigationClassifyRepository {
    if (sInstance == null) {
        synchronized(NavigationClassifyRepository::class.java) {
            if (sInstance == null) {
                sInstance = NavigationClassifyRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function:
 * Date: 2020/4/21 22:17
 * Description:
 * Author: ShiJingFeng
 */
internal class NavigationClassifyRepository(
    networkSource: NavigationClassifyNetworkSource? = null
) : BaseRepository<BaseLocalSource, NavigationClassifyNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取导航体系数据列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getNavigationClassifyList(onSuccess: onSuccess<List<NavigationClassifyEntity>?>, onFailure: onFailure) {
        mNetworkSource?.getNavigationClassifyList(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}