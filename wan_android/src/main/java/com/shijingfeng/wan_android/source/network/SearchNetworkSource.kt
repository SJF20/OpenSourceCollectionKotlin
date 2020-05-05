package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.SearchHotWordEntity
import com.shijingfeng.wan_android.entity.network.SearchListEntity
import com.shijingfeng.wan_android.source.network.api.SearchApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.view_model.SEARCH_LIST_FIRST_PAGE

@Volatile
private var sInstance: SearchNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSearchNetworkSourceInstance(): SearchNetworkSource {
    if (sInstance == null) {
        synchronized(SearchNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = SearchNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 搜索 网络源
 * Date: 20-5-3 下午8:46
 * Description:
 * @author shijingfeng
 */
internal class SearchNetworkSource : BaseNetworkSource() {

    /** 搜索相关 Api */
    private val mSearchApi = RetrofitUtil.create(SearchApi::class.java)

    /**
     * 获取 搜索热词列表 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getSearchHotWordList(onSuccess: onSuccess<List<SearchHotWordEntity>?>, onFailure: onFailure) {
        apiRequest(mSearchApi.getSearchHotWordList(), onSuccess, onFailure)
    }

    /**
     * 搜索
     * @param keyword 搜索关键词
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun search(keyword: String, onSuccess: onSuccess<SearchListEntity?>, onFailure: onFailure) {
        apiRequest(mSearchApi.getSearchList(SEARCH_LIST_FIRST_PAGE, keyword), onSuccess, onFailure)
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}