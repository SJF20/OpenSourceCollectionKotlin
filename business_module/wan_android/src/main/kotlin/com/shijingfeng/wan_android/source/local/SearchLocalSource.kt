package com.shijingfeng.wan_android.source.local

import com.blankj.utilcode.util.SPUtils
import com.google.gson.reflect.TypeToken
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.constant.EMPTY_ARRAY
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.network.http.exception.E
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.common.constant.SEARCH_HISTORY_LIST
import com.shijingfeng.wan_android.common.constant.SP_WAN_ANDROID_APP_NAME
import com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem
import java.util.concurrent.Executors

@Volatile
private var sInstance: SearchLocalSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSearchLocalSourceInstance(): SearchLocalSource {
    if (sInstance == null) {
        synchronized(SearchLocalSource::class.java) {
            if (sInstance == null) {
                sInstance = SearchLocalSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 搜索 本地源
 * Date: 20-5-3 下午8:46
 * Description:
 * Author: shijingfeng
 */
internal class SearchLocalSource : BaseLocalSource() {

    /** 线程池 */
    private var mExecutorService = Executors.newCachedThreadPool()

    /**
     * 获取 搜索历史列表 数据
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun getSearchHistoryList(onSuccess: onSuccess<List<SearchHistoryItem>?>, onFailure: onFailure) {
        mExecutorService?.execute {
            try {
                val searchHistoryListStr = SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).getString(
                    SEARCH_HISTORY_LIST, EMPTY_ARRAY)
                val searchHistoryList = deserialize<List<SearchHistoryItem>>(searchHistoryListStr, object : TypeToken<List<SearchHistoryItem>>() {}.type)

                runOnUiThread {
                    onSuccess(searchHistoryList)
                }
            } catch (e: java.lang.Exception) {
                runOnUiThread {
                    onFailure(
                        E(
                            errorCode = -1,
                            errorMsg = e.message ?: "",
                            error = e
                        )
                    )
                }
            }
        }
    }

    /**
     * 更新 搜索历史列表 数据
     * @param searchHistoryList 搜索历史列表 (null 或 empty 代表清空数据)
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun updateSearchHistoryList(searchHistoryList: List<SearchHistoryItem>?, onSuccess: onSuccess<List<SearchHistoryItem>?>, onFailure: onFailure) {
        mExecutorService?.execute {
            try {
                if (searchHistoryList.isNullOrEmpty()) {
                    SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).remove(SEARCH_HISTORY_LIST, true)
                } else {
                    SPUtils.getInstance(SP_WAN_ANDROID_APP_NAME).put(SEARCH_HISTORY_LIST, serialize(searchHistoryList), true)
                }
                runOnUiThread {
                    onSuccess(searchHistoryList)
                }
            } catch (e: java.lang.Exception) {
                runOnUiThread {
                    onFailure(
                        E(
                            errorCode = -1,
                            errorMsg = e.message ?: "",
                            error = e
                        )
                    )
                }
            }
        }
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        mExecutorService.shutdownNow()
        sInstance = null
    }

}