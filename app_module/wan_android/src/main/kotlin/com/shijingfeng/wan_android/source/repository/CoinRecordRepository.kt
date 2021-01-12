package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.CoinRecordEntity
import com.shijingfeng.wan_android.source.network.CoinRecordNetworkSource
import com.shijingfeng.wan_android.view_model.COIN_RECORD_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: CoinRecordRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getCoinRecordRepositoryInstance(
    networkSource: CoinRecordNetworkSource? = null
): CoinRecordRepository {
    if (sInstance == null) {
        synchronized(CoinRecordRepository::class.java) {
            if (sInstance == null) {
                sInstance = CoinRecordRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 积分记录 Repository
 * Date: 2020/3/16 21:47
 * Description:
 * Author: ShiJingFeng
 */
internal class CoinRecordRepository(
    networkSource: CoinRecordNetworkSource? = null
) : BaseRepository<BaseLocalSource, CoinRecordNetworkSource>(
    mNetworkSource = networkSource
) {
    /**
     * 获取 积分排行榜 列表
     *
     * @param page     页码 (从 [COIN_RECORD_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinRecordList(page: Int, onSuccess: onSuccess<CoinRecordEntity?>, onFailure: onFailure) {
        mNetworkSource?.getCoinRecordList(page, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}