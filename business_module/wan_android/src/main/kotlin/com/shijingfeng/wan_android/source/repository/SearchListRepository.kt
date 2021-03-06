package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.entity.SearchListEntity
import com.shijingfeng.wan_android.source.network.SearchListNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: SearchListRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSearchListRepositoryInstance(
    networkSource: SearchListNetworkSource? = null
): SearchListRepository {
    if (sInstance == null) {
        synchronized(SearchListRepository::class.java) {
            if (sInstance == null) {
                sInstance = SearchListRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 搜索列表 仓库
 * Date: 20-5-3 下午9:09
 * Description:
 * Author: shijingfeng
 */
internal class SearchListRepository(
    networkSource: SearchListNetworkSource? = null
) : BaseRepository<BaseLocalSource, SearchListNetworkSource>(
    mNetworkSource = networkSource
)  {

    /**
     * 获取 搜索列表 数据
     * @param page 页码
     * @param keyword 搜索关键词
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getSearchList(page: Int, keyword: String, onSuccess: onSuccess<SearchListEntity?>, onFailure: onFailure) {
        mNetworkSource?.getSearchList(page, keyword, onSuccess, onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.collected(articleId, onSuccess)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
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