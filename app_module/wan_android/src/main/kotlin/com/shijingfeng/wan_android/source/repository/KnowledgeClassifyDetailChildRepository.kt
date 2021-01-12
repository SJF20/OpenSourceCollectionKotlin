package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.KnowledgeClassifyDetailChildEntity
import com.shijingfeng.wan_android.source.network.KnowledgeClassifyDetailChildNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: KnowledgeClassifyDetailChildRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getKnowledgeClassifyChildRepositoryInstance(
    networkSource: KnowledgeClassifyDetailChildNetworkSource? = null
): KnowledgeClassifyDetailChildRepository {
    if (sInstance == null) {
        synchronized(KnowledgeClassifyDetailChildRepository::class.java) {
            if (sInstance == null) {
                sInstance = KnowledgeClassifyDetailChildRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 知识体系 二级数据 仓库
 * Date: 2020/4/21 20:31
 * Description:
 * Author: ShiJingFeng
 */
internal class KnowledgeClassifyDetailChildRepository(
    networkSource: KnowledgeClassifyDetailChildNetworkSource? = null
) : BaseRepository<BaseLocalSource, KnowledgeClassifyDetailChildNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取　知识体系 二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getKnowledgeClassifyDetailChild(page: Int, id: String, onSuccess: onSuccess<KnowledgeClassifyDetailChildEntity?>, onFailure: onFailure) {
        mNetworkSource?.getKnowledgeClassifyDetailChild(page, id, onSuccess, onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.collected(articleId, onSuccess)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.uncollected(articleId, onSuccess)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}