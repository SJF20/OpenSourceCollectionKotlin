package com.shijingfeng.wan_android.source.local

import android.os.Handler
import android.os.Looper
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ThreadUtils
import com.google.gson.reflect.TypeToken
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.constant.EMPTY_ARRAY
import com.shijingfeng.base.common.constant.EMPTY_OBJECT
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.http.exception.HttpException
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.serialize
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.constant.SEARCH_HISTORY_LIST
import com.shijingfeng.wan_android.constant.SP_APP_NAME
import com.shijingfeng.wan_android.entity.network.SearchHotWordEntity
import com.shijingfeng.wan_android.entity.network.SearchListEntity
import com.shijingfeng.wan_android.source.network.api.SearchApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.view_model.SEARCH_LIST_FIRST_PAGE
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

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
 * @author shijingfeng
 */
internal class SearchLocalSource : BaseLocalSource() {

    private val mHandler = Handler(Looper.getMainLooper())

    /**
     * 获取 搜索历史列表 数据
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun getSearchHistoryList(onSuccess: onSuccess<List<String>?>, onFailure: onFailure) {
        Executors.newSingleThreadExecutor().execute {
            try {
                val searchHistoryListStr = SPUtils.getInstance(SP_APP_NAME).getString(SEARCH_HISTORY_LIST, EMPTY_ARRAY)
                val searchHistoryList = deserialize<List<String>>(searchHistoryListStr, object : TypeToken<List<String>>() {}.type)

                mHandler.post {
                    onSuccess(searchHistoryList)
                }
            } catch (e: Exception) {
                mHandler.post {
                    onFailure(HttpException(
                        errorCode = -1,
                        errorMsg = e.message ?: "",
                        throwable = e
                    ))
                }
            }
        }
    }

    /**
     * 添加 某条搜索历史 Item
     * @param name 搜索关键词
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun addSearchHistoryItem(name: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        Executors.newSingleThreadExecutor().execute {
            try {
                val searchHistoryListStr = SPUtils.getInstance(SP_APP_NAME).getString(SEARCH_HISTORY_LIST, EMPTY_ARRAY)
                val searchHistoryList = deserialize<MutableList<String>>(searchHistoryListStr, object : TypeToken<MutableList<String>>() {}.type)

                if (searchHistoryList.isNullOrEmpty()) {
                    searchHistoryList.add(name)
                } else {
                    searchHistoryList.add(0, name)
                }
                SPUtils.getInstance(SP_APP_NAME).put(SEARCH_HISTORY_LIST, serialize(searchHistoryList), true)
                mHandler.post {
                    onSuccess(null)
                }
            } catch (e: Exception) {
                mHandler.post {
                    onFailure(HttpException(
                        errorCode = -1,
                        errorMsg = e.message ?: "",
                        throwable = e
                    ))
                }
            }
        }
    }

    /**
     * 清空 搜索历史列表 数据
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun clearSearchHistoryList(onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        Executors.newSingleThreadExecutor().execute {
            try {
                SPUtils.getInstance(SP_APP_NAME).remove(SEARCH_HISTORY_LIST, true)
                mHandler.post {
                    onSuccess(null)
                }
            } catch (e: Exception) {
                mHandler.post {
                    onFailure(HttpException(
                        errorCode = -1,
                        errorMsg = e.message ?: "",
                        throwable = e
                    ))
                }
            }
        }
    }

    /**
     * 删除 某条搜索历史 Item
     * @param name 搜索关键词
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    fun removeSearchHistoryItem(name: String, onSuccess: onSuccess<Any?>, onFailure: onFailure) {
        Executors.newSingleThreadExecutor().execute {
            try {
                val searchHistoryListStr = SPUtils.getInstance(SP_APP_NAME).getString(SEARCH_HISTORY_LIST, EMPTY_ARRAY)
                val searchHistoryList = deserialize<MutableList<String>>(searchHistoryListStr, object : TypeToken<MutableList<String>>() {}.type)

                searchHistoryList.remove(name)
                SPUtils.getInstance(SP_APP_NAME).put(SEARCH_HISTORY_LIST, serialize(searchHistoryList), true)
                mHandler.post {
                    onSuccess(null)
                }
            } catch (e: Exception) {
                mHandler.post {
                    onFailure(HttpException(
                        errorCode = -1,
                        errorMsg = e.message ?: "",
                        throwable = e
                    ))
                }
            }
        }
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}