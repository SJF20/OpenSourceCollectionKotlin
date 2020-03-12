package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.wan_android.entity.network.HomeDataEntity
import com.shijingfeng.wan_android.source.network.HomeNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: HomeRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getHomeRepositoryInstance(
    networkSource: HomeNetworkSource
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
class HomeRepository(
    networkSource: HomeNetworkSource
) : BaseRepository<BaseLocalSource, HomeNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取首页数据
     * @param page 页码 (从0开始，为了兼容以前的)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getHomeDataList(page: Int, onSuccess: OnSuccess<HomeDataEntity?>, onFailure: OnFailure) {
        mNetworkSource?.getHomeDataList(page, onSuccess = onSuccess, onFailure = onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun collected(articleId: String, onSuccess: OnSuccess<Any?>, onFailure: OnFailure) {
        mNetworkSource?.collected(articleId, onSuccess, onFailure)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun uncollected(articleId: String, onSuccess: OnSuccess<Any?>, onFailure: OnFailure) {
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