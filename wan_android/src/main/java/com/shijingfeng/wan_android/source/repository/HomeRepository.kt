package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.network.HomeDataEntity
import com.shijingfeng.wan_android.source.network.HomeNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: HomeRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getHomeRepositoryInstance(
    networkSource: HomeNetworkSource? = null
): HomeRepository {
    if (sInstance == null) {
        synchronized(HomeRepository::class.java) {
            if (sInstance == null) {
                sInstance = HomeRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 首页 仓库
 * Date: 2020/2/12 13:21
 * Description:
 * @author ShiJingFeng
 */
internal class HomeRepository(
    networkSource: HomeNetworkSource? = null
) : BaseRepository<BaseLocalSource, HomeNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取首页数据
     * @param page 页码 (从0开始，为了兼容以前的)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getHomeDataList(page: Int, onSuccess: onSuccess<HomeDataEntity?>, onFailure: onFailure) {
        mNetworkSource?.getHomeDataList(page, onSuccess = onSuccess, onFailure = onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        mNetworkSource?.collected(articleId, onSuccess, onFailure)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        mNetworkSource?.uncollected(articleId, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}