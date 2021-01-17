package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.network.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.KnowledgeClassifyDetailChildEntity
import com.shijingfeng.wan_android.source.network.api.ClassifyApi
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: KnowledgeClassifyDetailChildNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getKnowledgeClassifyChildNetworkSourceInstance(): KnowledgeClassifyDetailChildNetworkSource {
    if (sInstance == null) {
        synchronized(KnowledgeClassifyDetailChildNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = KnowledgeClassifyDetailChildNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 知识体系 二级数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * Author: ShiJingFeng
 */
internal class KnowledgeClassifyDetailChildNetworkSource : BaseNetworkSource() {

    /** 分类相关 Api */
    private val mClassifyApi = RetrofitUtil.create(ClassifyApi::class.java)
    /** 收藏相关 Api */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取　知识体系 二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getKnowledgeClassifyDetailChild(page: Int, id: String, onSuccess: onSuccess<KnowledgeClassifyDetailChildEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mClassifyApi.getKnowledgeClassifyDetailChild(page, id),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(
            single = mCollectionApi.collectedInSitesArticle(articleId),
            onSuccess = onSuccess
        ))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(
            single = mCollectionApi.uncollectedInArticleList(articleId),
            onSuccess = onSuccess
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