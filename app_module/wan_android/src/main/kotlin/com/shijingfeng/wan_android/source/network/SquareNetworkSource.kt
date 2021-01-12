package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.SquareEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.source.network.api.SquareApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: SquareNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getSquareNetworkSourceInstance(): SquareNetworkSource {
    if (sInstance == null) {
        synchronized(SquareNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = SquareNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 广场 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * Author: ShiJingFeng
 */
internal class SquareNetworkSource : BaseNetworkSource() {

    /** 广场 Api */
    private val mSquareApi = RetrofitUtil.create(SquareApi::class.java)
    /** 收藏 Api  */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取 广场 数据
     *
     * @param page       页码
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getSquareList(page: Int, onSuccess: onSuccess<SquareEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mSquareApi.getSquareList(page),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(
            single = mCollectionApi.collectedInSitesArticle(articleId),
            onSuccess = onSuccess
        ))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(
            single = mCollectionApi.uncollectedInArticleList(articleId),
            onSuccess = onSuccess
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