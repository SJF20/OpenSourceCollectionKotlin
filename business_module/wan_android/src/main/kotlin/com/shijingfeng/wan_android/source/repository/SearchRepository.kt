package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem
import com.shijingfeng.wan_android.entity.SearchHotWordEntity
import com.shijingfeng.wan_android.entity.SearchListEntity
import com.shijingfeng.wan_android.source.local.SearchLocalSource
import com.shijingfeng.wan_android.source.network.SearchNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: SearchRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSearchRepositoryInstance(
    localSource: SearchLocalSource? = null,
    networkSource: SearchNetworkSource? = null
): SearchRepository {
    if (sInstance == null) {
        synchronized(SearchRepository::class.java) {
            if (sInstance == null) {
                sInstance = SearchRepository(
                    localSource = localSource,
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 搜索 仓库
 * Date: 20-5-3 下午9:09
 * Description:
 * Author: shijingfeng
 */
internal class SearchRepository(
    localSource: SearchLocalSource? = null,
    networkSource: SearchNetworkSource? = null
) : BaseRepository<SearchLocalSource, SearchNetworkSource>(
    mLocalSource = localSource,
    mNetworkSource = networkSource
)  {

    /**
     * 获取 搜索热词列表 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getSearchHotWordList(onSuccess: onSuccess<List<SearchHotWordEntity>?>, onFailure: onFailure) {
        mNetworkSource?.getSearchHotWordList(onSuccess, onFailure)
    }

    /**
     * 搜索
     * @param keyword 搜索关键词
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun search(keyword: String, onSuccess: onSuccess<SearchListEntity?>, onFailure: onFailure) {
        mNetworkSource?.search(keyword, onSuccess, onFailure)
    }

    /**
     * 获取 搜索历史列表 数据
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun getSearchHistoryList(onSuccess: onSuccess<List<SearchHistoryItem>?>, onFailure: onFailure) {
        mLocalSource?.getSearchHistoryList(onSuccess, onFailure)
    }

    /**
     * 更新 搜索历史列表 数据
     * @param searchHistoryList 搜索历史列表 (null 或 empty 代表清空数据)
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun updateSearchHistory(searchHistoryList: List<SearchHistoryItem>?, onSuccess: onSuccess<List<SearchHistoryItem>?>, onFailure: onFailure) {
        mLocalSource?.updateSearchHistoryList(searchHistoryList, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}