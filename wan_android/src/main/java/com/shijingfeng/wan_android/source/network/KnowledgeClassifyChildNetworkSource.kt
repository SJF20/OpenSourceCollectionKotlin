package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.KnowledgeClassifyChildEntity
import com.shijingfeng.wan_android.source.network.api.ClassifyApi
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: KnowledgeClassifyChildNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getKnowledgeClassifyChildNetworkSourceInstance(): KnowledgeClassifyChildNetworkSource {
    if (sInstance == null) {
        synchronized(KnowledgeClassifyChildNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = KnowledgeClassifyChildNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 知识体系 二级数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyChildNetworkSource : BaseNetworkSource() {

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
    fun getKnowledgeClassifyChild(page: Int, id: String, onSuccess: onSuccess<KnowledgeClassifyChildEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(mClassifyApi.getKnowledgeClassifyChild(page, id), onSuccess, onFailure))
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.collectedInSitesArticle(articleId), onSuccess))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.uncollectedInArticleList(articleId), onSuccess))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}