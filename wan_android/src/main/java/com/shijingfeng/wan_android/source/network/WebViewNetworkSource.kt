package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.base.util.e
import com.shijingfeng.wan_android.entity.network.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: WebViewNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getWebViewNetworkSourceInstance(): WebViewNetworkSource {
    if (sInstance == null) {
        synchronized(WebViewNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = WebViewNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: WebView容器 网络源
 * Date: 2020/2/12 10:26
 * Description:
 * @author ShiJingFeng
 */
internal class WebViewNetworkSource : BaseNetworkSource() {

    /** 收藏 Api  */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 收藏
     * @param dataMap 请求携带数据 (name, link)
     * @param onSuccess 成功回调函数
     */
    fun collectedWebsite(dataMap: Map<String, Any>, onSuccess: onSuccess<PersonalCollectionWebsiteEntity?>) {
        addDisposable(apiRequest(mCollectionApi.collectedWebsite(dataMap), onSuccess))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}