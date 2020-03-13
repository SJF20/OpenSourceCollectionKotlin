package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.wan_android.source.local.MainLocalSource
import com.shijingfeng.wan_android.source.network.MainNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: MainRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getMainRepositoryInstance(
    networkSource: MainNetworkSource? = null
): MainRepository {
    if (sInstance == null) {
        synchronized(MainRepository::class.java) {
            if (sInstance == null) {
                sInstance = MainRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 主页 仓库
 * Date: 2020/2/11 12:50
 * Description:
 * @author ShiJingFeng
 */
class MainRepository(
    networkSource: MainNetworkSource? = null
) : BaseRepository<MainLocalSource, MainNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取 积分信息
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getCoinInfo(onSuccess: OnSuccess<CoinInfoEntity?>, onFailure: OnFailure) {
        val coinInfo = mLocalSource?.getCoinInfo()

        if (coinInfo == null) {
            // 如果本地源没有获取到数据，则从网络源中获取数据
            mNetworkSource?.getCoinInfo(onSuccess, onFailure)
        } else {
            onSuccess(coinInfo)
        }
    }

    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun logout(onSuccess: OnSuccess<Any?>, onFailure: OnFailure) {
        mLocalSource?.logout()
        mNetworkSource?.logout(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}