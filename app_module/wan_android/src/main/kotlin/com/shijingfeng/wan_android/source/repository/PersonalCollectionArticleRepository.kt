package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.PersonalCollectionArticleEntity
import com.shijingfeng.wan_android.source.network.PersonalCollectionArticleNetworkSource
import com.shijingfeng.wan_android.view_model.PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: PersonalCollectionArticleRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getPersonalCollectionArticleRepositoryInstance(
    networkSource: PersonalCollectionArticleNetworkSource? = null
): PersonalCollectionArticleRepository {
    if (sInstance == null) {
        synchronized(PersonalCollectionArticleRepository::class.java) {
            if (sInstance == null) {
                sInstance = PersonalCollectionArticleRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 我的收藏 -> 收藏文章列表 仓库
 * Date: 2020/3/24 22:58
 * Description:
 * Author: ShiJingFeng
 */
internal class PersonalCollectionArticleRepository(
    networkSource: PersonalCollectionArticleNetworkSource? = null
) : BaseRepository<BaseLocalSource, PersonalCollectionArticleNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取文章收藏列表
     * @param page      页码 (从 [PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getArticleCollectedList(page: Int, onSuccess: onSuccess<PersonalCollectionArticleEntity?>, onFailure: onFailure) {
        mNetworkSource?.getArticleCollectedList(page, onSuccess, onFailure)
    }

    /**
     * 文章收藏列表 内 取消收藏
     *
     * @param articleId 文章ID
     * @param originId  originId
     * @param onSuccess 成功回调函数
     */
    fun uncollectedInCollectedList(articleId: String, originId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.uncollectedInCollectedList(articleId, originId, onSuccess)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}