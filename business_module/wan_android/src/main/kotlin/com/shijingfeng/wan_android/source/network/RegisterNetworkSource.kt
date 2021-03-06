package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.network.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.CoinInfoEntity
import com.shijingfeng.wan_android.entity.UserInfoEntity
import com.shijingfeng.wan_android.source.network.api.CoinApi
import com.shijingfeng.wan_android.source.network.api.UserApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: RegisterNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getRegisterNetworkSourceInstance(): RegisterNetworkSource {
    if (sInstance == null) {
        synchronized(RegisterNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = RegisterNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 注册页面 网络源
 * Date: 2020/2/5 12:53
 * Description:
 * Author: ShiJingFeng
 */
internal class RegisterNetworkSource : BaseNetworkSource() {

    /** 用户信息相关 Api */
    private val mUserApi = RetrofitUtil.create(UserApi::class.java)
    /** 积分信息相关 Api */
    private val mCoinApi = RetrofitUtil.create(CoinApi::class.java)

    /**
     * 注册
     * @param postMap 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun register(postMap: Map<String, Any>, onSuccess: onSuccess<UserInfoEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mUserApi.register(postMap),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 获取 积分信息
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinInfo(onSuccess: onSuccess<CoinInfoEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mCoinApi.getCoinInfo(),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}