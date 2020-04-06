package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.PersonalCollectionArticleEntity
import com.shijingfeng.wan_android.entity.network.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: PersonalCollectionWebsiteNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getPersonalCollectionWebsiteNetworkSourceInstance(): PersonalCollectionWebsiteNetworkSource {
    if (sInstance == null) {
        synchronized(PersonalCollectionWebsiteNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = PersonalCollectionWebsiteNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 我的收藏 -> 网站收藏 网络源
 * Date: 2020/3/24 22:59
 * Description:
 * @author ShiJingFeng
 */
internal class PersonalCollectionWebsiteNetworkSource : BaseNetworkSource() {

    /** 收藏相关 Api */
    private var mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取 网站收藏列表
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getWebsiteCollectedList(onSuccess: onSuccess<List<PersonalCollectionWebsiteEntity>?>, onFailure: onFailure) {
        addDisposable(apiRequest(mCollectionApi.getWebsiteCollectedList(), onSuccess, onFailure))
    }

    /**
     * 编辑 网站
     * @param dataMap 请求参数集合 id，name，link
     * @param onSuccess 成功回调函数
     */
    fun updateWebsite(dataMap: Map<String, Any>, onSuccess: onSuccess<PersonalCollectionWebsiteEntity?>) {
        addDisposable(apiRequest(mCollectionApi.updateWebsite(dataMap), onSuccess))
    }

    /**
     * 删除 网站
     * @param id 网站 ID
     * @param onSuccess 成功回调函数
     */
    fun deleteWebsite(id: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.deleteWebsite(id), onSuccess))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}