package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.network.ArticleCollectedListEntity
import com.shijingfeng.wan_android.source.network.ArticleCollectedListNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: ArticleCollectedListRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getArticleCollectedListRepositoryInstance(
    networkSource: ArticleCollectedListNetworkSource? = null
): ArticleCollectedListRepository {
    if (sInstance == null) {
        synchronized(ArticleCollectedListRepository::class.java) {
            if (sInstance == null) {
                sInstance = ArticleCollectedListRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 文章收藏列表 (入口: 首页侧边栏 我的收藏) 仓库
 * Date: 2020/3/22 19:30
 * Description:
 * @author ShiJingFeng
 */
internal class ArticleCollectedListRepository(
    networkSource: ArticleCollectedListNetworkSource? = null
) : BaseRepository<BaseLocalSource, ArticleCollectedListNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取文章收藏列表
     * @param page      页码 (从 0 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getArticleCollectedList(page: Int, onSuccess: onSuccess<ArticleCollectedListEntity?>, onFailure: onFailure) {
        mNetworkSource?.getArticleCollectedList(page, onSuccess, onFailure)
    }

    /**
     * 文章收藏列表 内 取消收藏
     *
     * @param articleId 文章ID
     * @param originId  originId
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun uncollectedInCollectedList(articleId: String, originId: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        mNetworkSource?.uncollectedInCollectedList(articleId, originId, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}