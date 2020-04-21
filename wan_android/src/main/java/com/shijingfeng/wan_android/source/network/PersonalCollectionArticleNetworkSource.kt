package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.PersonalCollectionArticleEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.view_model.PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: PersonalCollectionArticleNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getPersonalCollectionArticleNetworkSourceInstance(): PersonalCollectionArticleNetworkSource {
    if (sInstance == null) {
        synchronized(PersonalCollectionArticleNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = PersonalCollectionArticleNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 我的收藏 -> 收藏文章列表 网络源
 * Date: 2020/3/24 22:59
 * Description:
 * @author ShiJingFeng
 */
internal class PersonalCollectionArticleNetworkSource : BaseNetworkSource() {

    /** 收藏相关 Api */
    private var mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取文章收藏列表
     * @param page      页码 (从 [PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getArticleCollectedList(page: Int, onSuccess: onSuccess<PersonalCollectionArticleEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(mCollectionApi.getArticleCollectedList(page), onSuccess, onFailure))
    }

    /**
     * 文章收藏列表 内 取消收藏
     * @param articleId 文章ID
     * @param originId  originId
     * @param onSuccess 成功回调函数
     */
    fun uncollectedInCollectedList(articleId: String, originId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.uncollectedInCollectedList(articleId,originId), onSuccess))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}