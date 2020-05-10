package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.SearchListEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.source.network.api.SearchApi
import com.shijingfeng.wan_android.utils.apiRequest

@Volatile
private var sInstance: SearchListNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSearchListNetworkSourceInstance(): SearchListNetworkSource {
    if (sInstance == null) {
        synchronized(SearchListNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = SearchListNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 搜索列表 网络源
 * Date: 20-5-3 下午8:46
 * Description:
 * @author shijingfeng
 */
internal class SearchListNetworkSource : BaseNetworkSource() {

    /** 搜索相关 Api */
    private val mSearchApi = RetrofitUtil.create(SearchApi::class.java)
    /** 收藏 Api  */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取 搜索列表 数据
     * @param page 页码
     * @param keyword 搜索关键词
     */
    fun getSearchList(page: Int, keyword: String, onSuccess: onSuccess<SearchListEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(mSearchApi.getSearchList(page, keyword), onSuccess, onFailure))
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.collectedInSitesArticle(articleId), onSuccess))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
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