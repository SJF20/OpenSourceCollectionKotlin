package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.source.network.OfficialAccountNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: OfficialAccountRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getOfficialAccountRepositoryInstance(
    networkSource: OfficialAccountNetworkSource? = null
): OfficialAccountRepository {
    if (sInstance == null) {
        synchronized(OfficialAccountRepository::class.java) {
            if (sInstance == null) {
                sInstance = OfficialAccountRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}


/**
 * Function: 公众号 仓库
 * Date: 2020/4/30 16:31
 * Description:
 * @author ShiJingFeng
 */
internal class OfficialAccountRepository(
    networkSource: OfficialAccountNetworkSource? = null
) : BaseRepository<BaseLocalSource, OfficialAccountNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取　公众号 索引数据
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getOfficialAccountIndex(onSuccess: onSuccess<List<OfficialAccountIndexEntity>?>, onFailure: onFailure) {
        mNetworkSource?.getOfficialAccountIndex(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}