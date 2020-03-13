package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.wan_android.entity.network.UserInfoEntity
import com.shijingfeng.wan_android.source.network.RegisterNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: RegisterRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getRegisterRepositoryInstance(
    networkSource: RegisterNetworkSource? = null
): RegisterRepository {
    if (sInstance == null) {
        synchronized(RegisterRepository::class.java) {
            if (sInstance == null) {
                sInstance = RegisterRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 注册页面 仓库
 * Date: 2020/2/5 15:48
 * Description:
 * @author ShiJingFeng
 */
class RegisterRepository(
    networkSource: RegisterNetworkSource? = null
) : BaseRepository<BaseLocalSource, RegisterNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 注册
     * @param postMap 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun register(postMap: Map<String, Any>, onSuccess: OnSuccess<UserInfoEntity?>, onFailure: OnFailure) {
        mNetworkSource?.register(postMap, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}