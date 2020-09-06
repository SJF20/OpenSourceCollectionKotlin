package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.SquareEntity
import com.shijingfeng.wan_android.source.network.SquareNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: SquareRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSquareRepositoryInstance(
    networkSource: SquareNetworkSource? = null
): SquareRepository {
    if (sInstance == null) {
        synchronized(SquareRepository::class.java) {
            if (sInstance == null) {
                sInstance = SquareRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 广场 仓库
 * Date: 2020/5/7 15:34
 * Description:
 * @author ShiJingFeng
 */
internal class SquareRepository(
    networkSource: SquareNetworkSource? = null
) : BaseRepository<BaseLocalSource, SquareNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取 广场 数据
     *
     * @param page       页码
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getSquareList(page: Int, onSuccess: onSuccess<SquareEntity?>, onFailure: onFailure) {
        mNetworkSource?.getSquareList(page, onSuccess, onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.collected(articleId, onSuccess)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.uncollected(articleId, onSuccess)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}