package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.wan_android.source.network.api.CoinApi
import com.shijingfeng.wan_android.source.network.api.UserApi
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.utils.handle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/** 单例实例 */
@Volatile
private var sInstance: MainNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getMainNetworkSourceInstance(): MainNetworkSource {
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
class MainNetworkSource : BaseNetworkSource() {

    private val mCoinApi: CoinApi = RetrofitUtil.create(CoinApi::class.java)
    private val mUserApi: UserApi = RetrofitUtil.create(UserApi::class.java)

    /**
     * 获取 积分信息
     * @param onSuccess 成功回调接口
     * @param onFailure 失败回调接口
     */
    fun getCoinInfo(onSuccess: OnSuccess<CoinInfoEntity?>, onFailure: OnFailure) {
        addDisposable(apiRequest(mCoinApi.getCoinInfo(), onSuccess, onFailure))
    }

    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun logout(onSuccess: OnSuccess<Any?>, onFailure: OnFailure) {
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