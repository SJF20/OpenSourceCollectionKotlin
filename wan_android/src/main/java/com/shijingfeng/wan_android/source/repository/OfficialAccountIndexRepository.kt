package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.network.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.source.network.OfficialAccountIndexNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: OfficialAccountIndexRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getOfficialAccountIndexRepositoryInstance(
    networkSource: OfficialAccountIndexNetworkSource? = null
): OfficialAccountIndexRepository {
    if (sInstance == null) {
        synchronized(OfficialAccountIndexRepository::class.java) {
            if (sInstance == null) {
                sInstance = OfficialAccountIndexRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}


/**
 * Function: 公众号 索引数据 仓库
 * Date: 2020/4/30 16:31
 * Description:
 * @author ShiJingFeng
 */
internal class OfficialAccountIndexRepository(
    networkSource: OfficialAccountIndexNetworkSource? = null
) : BaseRepository<BaseLocalSource, OfficialAccountIndexNetworkSource>(
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