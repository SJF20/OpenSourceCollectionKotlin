package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.OfficialAccountChildEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.source.network.api.OfficialAccountApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: OfficialAccountChildNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getOfficialAccountChildNetworkSourceInstance(): OfficialAccountChildNetworkSource {
    if (sInstance == null) {
        synchronized(OfficialAccountChildNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = OfficialAccountChildNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 公众号 二级数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class OfficialAccountChildNetworkSource : BaseNetworkSource() {

    /** 公众号相关 Api */
    private val mOfficialAccountApi = RetrofitUtil.create(OfficialAccountApi::class.java)
    /** 收藏相关 Api */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取　公众号 二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getOfficialAccountChild(page: Int, id: String, onSuccess: onSuccess<OfficialAccountChildEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mOfficialAccountApi.getOfficialAccountChild(page, id),
            onSuccess = onSuccess,
            onFailure = onFailure
        ))
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
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
     * @param onSuccess 成功回调
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