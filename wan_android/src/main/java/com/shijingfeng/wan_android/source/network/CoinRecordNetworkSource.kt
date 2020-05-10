package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.CoinRecordEntity
import com.shijingfeng.wan_android.source.network.api.CoinApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.view_model.COIN_RECORD_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: CoinRecordNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getCoinRecordNetworkSourceInstance(): CoinRecordNetworkSource {
    if (sInstance == null) {
        synchronized(CoinRecordNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = CoinRecordNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 积分排行榜 网络源
 * Date: 2020/3/12 22:25
 * Description:
 * @author ShiJingFeng
 */
internal class CoinRecordNetworkSource : BaseNetworkSource() {

    private val mCoinApi = RetrofitUtil.create(CoinApi::class.java)

    /**
     * 获取 积分记录 列表
     *
     * @param page     页码 (从 [COIN_RECORD_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinRecordList(page: Int, onSuccess: onSuccess<CoinRecordEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(mCoinApi.getCoinRecordList(page), onSuccess, onFailure))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}