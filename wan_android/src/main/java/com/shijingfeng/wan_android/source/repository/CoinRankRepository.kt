package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.CoinRankEntity
import com.shijingfeng.wan_android.source.network.CoinRankNetworkSource
import com.shijingfeng.wan_android.view_model.COIN_RANK_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: CoinRankRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getCoinRankRepositoryInstance(
    networkSource: CoinRankNetworkSource? = null
): CoinRankRepository {
    if (sInstance == null) {
        synchronized(CoinRankRepository::class.java) {
            if (sInstance == null) {
                sInstance = CoinRankRepository(networkSource = networkSource)
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
    networkSource: CoinRankNetworkSource? = null
) : BaseRepository<BaseLocalSource, CoinRankNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取 积分排行榜 列表
     *
     * @param page      页码 (从 [COIN_RANK_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinRankList(page: Int, onSuccess: onSuccess<CoinRankEntity?>, onFailure: onFailure) {
        mNetworkSource?.getCoinRankList(page, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}