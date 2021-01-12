package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.common.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.CoinInfoEntity
import com.shijingfeng.wan_android.entity.UserInfoEntity
import com.shijingfeng.wan_android.source.network.api.CoinApi
import com.shijingfeng.wan_android.source.network.api.UserApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.utils.handle
import kotlin.Exception

/** 单例实例 */
@Volatile
private var sInstance: LoginNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getLoginNetworkSourceInstance(): LoginNetworkSource {
    if (sInstance == null) {
        synchronized(LoginNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = LoginNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 登录Activity 网络数据操作实现类
 * Date: 2020/2/4 16:16
 * Description:
 * Author: ShiJingFeng
 */
internal class LoginNetworkSource : BaseNetworkSource() {

    /** 用户信息相关 Api */
    private val mUserApi = RetrofitUtil.create(UserApi::class.java)
    /** 积分信息相关 Api */
    private val mCoinApi = RetrofitUtil.create(CoinApi::class.java)

    /**
     * 登录
     * @param postMap 数据
     */
    suspend fun login(postMap: Map<String, Any>) = apiRequest(mUserApi.login(postMap))

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