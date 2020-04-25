package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.source.network.KnowledgeClassifyNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: KnowledgeClassifyRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getKnowledgeClassifyRepositoryInstance(
    networkSource: KnowledgeClassifyNetworkSource? = null
): KnowledgeClassifyRepository {
    if (sInstance == null) {
        synchronized(KnowledgeClassifyRepository::class.java) {
            if (sInstance == null) {
                sInstance = KnowledgeClassifyRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 知识体系 一级数据 仓库
 * Date: 2020/4/21 20:31
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyRepository(
    networkSource: KnowledgeClassifyNetworkSource? = null
) : BaseRepository<BaseLocalSource, KnowledgeClassifyNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取 知识体系 一级数据 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getKnowledgeClassifyList(onSuccess: onSuccess<List<KnowledgeClassifyEntity>?>, onFailure: onFailure) {
        mNetworkSource?.getKnowledgeClassifyList(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}