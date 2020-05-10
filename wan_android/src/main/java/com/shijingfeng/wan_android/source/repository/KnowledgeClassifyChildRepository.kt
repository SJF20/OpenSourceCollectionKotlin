package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.KnowledgeClassifyChildEntity
import com.shijingfeng.wan_android.source.network.KnowledgeClassifyChildNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: KnowledgeClassifyChildRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getKnowledgeClassifyChildRepositoryInstance(
    networkSource: KnowledgeClassifyChildNetworkSource? = null
): KnowledgeClassifyChildRepository {
    if (sInstance == null) {
        synchronized(KnowledgeClassifyChildRepository::class.java) {
            if (sInstance == null) {
                sInstance = KnowledgeClassifyChildRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 知识体系 二级数据 仓库
 * Date: 2020/4/21 20:31
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyChildRepository(
    networkSource: KnowledgeClassifyChildNetworkSource? = null
) : BaseRepository<BaseLocalSource, KnowledgeClassifyChildNetworkSource>(
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
    fun getKnowledgeClassifyChild(page: Int, id: String, onSuccess: onSuccess<KnowledgeClassifyChildEntity?>, onFailure: onFailure) {
        mNetworkSource?.getKnowledgeClassifyChild(page, id, onSuccess, onFailure)
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