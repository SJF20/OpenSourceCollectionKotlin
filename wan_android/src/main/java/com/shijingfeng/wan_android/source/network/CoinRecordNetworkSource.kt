package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.CoinRecordEntity
import com.shijingfeng.wan_android.source.network.api.CoinApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: CoinRecordNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getCoinRecordNetworkSourceInstance(): CoinRecordNetworkSource {
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
class CoinRecordNetworkSource : BaseNetworkSource() {

    private val mCoinApi = RetrofitUtil.create(CoinApi::class.java)

    /**
     * 获取 积分记录 列表
     *
     * @param page     页码 (从1开始)
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