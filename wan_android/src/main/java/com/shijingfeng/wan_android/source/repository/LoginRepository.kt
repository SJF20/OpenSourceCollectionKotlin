package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.network.UserInfoEntity
import com.shijingfeng.wan_android.source.network.LoginNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: LoginRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getLoginRepositoryInstance(
    networkSource: LoginNetworkSource? = null
): LoginRepository {
    if (sInstance == null) {
        synchronized(LoginRepository::class.java) {
            if (sInstance == null) {
                sInstance = LoginRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance as LoginRepository
}

/**
 * Function: 登录Activity 数据管理类
 * Date: 2020/2/4 18:35
 * Description:
 * @author ShiJingFeng
 */
internal class LoginRepository(
    networkSource: LoginNetworkSource? = null
) : BaseRepository<BaseLocalSource, LoginNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 登录
     *
     * @param postMap  数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun login(postMap: Map<String, Any>, onSuccess: onSuccess<UserInfoEntity?>, onFailure: onFailure) {
        mNetworkSource?.login(postMap, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}