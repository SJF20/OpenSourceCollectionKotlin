package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.constant.PAGE_OPERATE_TYPE_LOAD
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.CoinRankEntity
import com.shijingfeng.wan_android.entity.CoinRankItem
import com.shijingfeng.wan_android.source.local.CoinRankLocalSource
import com.shijingfeng.wan_android.source.network.CoinRankNetworkSource
import com.shijingfeng.wan_android.utils.handle
import com.shijingfeng.wan_android.view_model.COIN_RANK_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: CoinRankRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getCoinRankRepositoryInstance(
    localSource: CoinRankLocalSource? = null,
    networkSource: CoinRankNetworkSource? = null
): CoinRankRepository {
    if (sInstance == null) {
        synchronized(CoinRankRepository::class.java) {
            if (sInstance == null) {
                sInstance = CoinRankRepository(
                    localSource = localSource,
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 积分排名 Repository
 * Date: 2020/3/12 22:33
 * Description:
 * @author ShiJingFeng
 */
internal class CoinRankRepository(
    localSource: CoinRankLocalSource? = null,
    networkSource: CoinRankNetworkSource? = null
) : BaseRepository<CoinRankLocalSource, CoinRankNetworkSource>(
    mLocalSource = localSource,
    mNetworkSource = networkSource
) {

    /**
     * 获取 积分排行榜 列表
     *
     * @param page      页码 (从 [COIN_RANK_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinRankList(
        @PageOperateType type: Int,
        page: Int,
        onSuccess: onSuccess<CoinRankEntity?>,
        onFailure: onFailure
    ) {
        if (type == PAGE_OPERATE_TYPE_LOAD) {
            mNetworkSource?.getCoinRankList(
                page = page,
                customHandleException = true,
                onSuccess = onSuccess,
                onFailure = { e ->
                    mLocalSource?.getCoinRankList(onSuccess, onFailure = {
                        onFailure(handle(e))
                    })
                }
            )
        } else {
            mNetworkSource?.getCoinRankList(
                page = page,
                onSuccess = onSuccess,
                onFailure = onFailure
            )
        }
    }

    /**
     * 添加 积分排行榜 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun addCoinRankList(
        coinRankList: List<CoinRankItem>,
        onSuccess: onSuccess<List<CoinRankItem>>? = null,
        onFailure: onFailure? = null
    ) {
        mLocalSource?.addCoinRankList(coinRankList, onSuccess, onFailure)
    }

    /**
     * 清空
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun clear(
        onSuccess: onSuccess<Any?>? = null,
        onFailure: onFailure? = null
    ) {
        mLocalSource?.clear(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}