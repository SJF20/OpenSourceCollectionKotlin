package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.source.network.WebViewNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: WebViewRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getWebViewRepositoryInstance(
    networkSource: WebViewNetworkSource? = null
): WebViewRepository {
    if (sInstance == null) {
        synchronized(WebViewRepository::class.java) {
            if (sInstance == null) {
                sInstance = WebViewRepository(
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: WebView容器 仓库
 * Date: 2020/3/24 11:41
 * Description:
 * @author ShiJingFeng
 */
internal class WebViewRepository(
    networkSource: WebViewNetworkSource? = null
) : BaseRepository<BaseLocalSource, WebViewNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 收藏
     * @param dataMap 请求携带数据 (name, link)
     * @param onSuccess 成功回调函数
     */
    fun collectedWebsite(dataMap: Map<String, Any>, onSuccess: onSuccess<PersonalCollectionWebsiteEntity?>) {
        mNetworkSource?.collectedWebsite(dataMap, onSuccess)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}