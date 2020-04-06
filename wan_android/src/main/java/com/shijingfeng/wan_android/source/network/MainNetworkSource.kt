package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.wan_android.source.network.api.CoinApi
import com.shijingfeng.wan_android.source.network.api.UserApi
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: MainNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getMainNetworkSourceInstance(): MainNetworkSource {
    if (sInstance == null) {
        synchronized(MainNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = MainNetworkSource()
            }
        }
    }
    return sInstance as MainNetworkSource
}

/**
 * Function: 主页 Activity 网络源
 * Date: 2020/2/10 16:25
 * Description:
 * @author ShiJingFeng
 */
internal class MainNetworkSource : BaseNetworkSource() {

    private val mCoinApi: CoinApi = RetrofitUtil.create(CoinApi::class.java)
    private val mUserApi: UserApi = RetrofitUtil.create(UserApi::class.java)

    /**
     * 获取 积分信息
     * @param onSuccess 成功回调接口
     */
    fun getCoinInfo(onSuccess: onSuccess<CoinInfoEntity?>) {
        addDisposable(apiRequest(mCoinApi.getCoinInfo(), onSuccess))
    }

    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun logout(onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        addDisposable(apiRequest(mUserApi.logout(), onSuccess, onFailure))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}