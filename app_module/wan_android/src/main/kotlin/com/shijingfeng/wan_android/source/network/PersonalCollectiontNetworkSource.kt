package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.PersonalCollectionArticleEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: PersonalCollectionNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getPersonalCollectionNetworkSourceInstance(): PersonalCollectionNetworkSource {
    if (sInstance == null) {
        synchronized(PersonalCollectionNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = PersonalCollectionNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 我的收藏 网络源
 * Date: 2020/3/22 19:15
 * Description:
 * Author: ShiJingFeng
 */
internal class PersonalCollectionNetworkSource : BaseNetworkSource() {

    /** 收藏相关 Api */
    private var mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取文章收藏列表
     * @param page      页码 (从 0 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getArticleCollectedList(page: Int, onSuccess: onSuccess<PersonalCollectionArticleEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mCollectionApi.getArticleCollectedList(page),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 文章收藏列表 内 取消收藏
     * @param articleId 文章ID
     * @param originId  originId
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun uncollectedInCollectedList(articleId: String, originId: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mCollectionApi.uncollectedInCollectedList(articleId,originId),
            onSuccess = onSuccess,
            onFailure = onFailure
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