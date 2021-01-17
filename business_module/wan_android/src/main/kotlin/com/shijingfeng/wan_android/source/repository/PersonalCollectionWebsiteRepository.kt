package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity
import com.shijingfeng.wan_android.source.network.PersonalCollectionWebsiteNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: PersonalCollectionWebsiteRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getPersonalCollectionWebsiteRepositoryInstance(
    networkSource: PersonalCollectionWebsiteNetworkSource? = null
): PersonalCollectionWebsiteRepository {
    if (sInstance == null) {
        synchronized(PersonalCollectionWebsiteRepository::class.java) {
            if (sInstance == null) {
                sInstance = PersonalCollectionWebsiteRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 我的收藏 -> 网站收藏 仓库
 * Date: 2020/3/25 23:22
 * Description:
 * Author: ShiJingFeng
 */
internal class PersonalCollectionWebsiteRepository(
    networkSource: PersonalCollectionWebsiteNetworkSource? = null
) : BaseRepository<BaseLocalSource, PersonalCollectionWebsiteNetworkSource>(
    mNetworkSource = networkSource
)  {

    /**
     * 获取 网站收藏列表
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getWebsiteCollectedList(onSuccess: onSuccess<List<PersonalCollectionWebsiteEntity>?>, onFailure: onFailure) {
        mNetworkSource?.getWebsiteCollectedList(onSuccess, onFailure)
    }

    /**
     * 编辑 网站
     * @param dataMap 请求参数集合 id，name，link
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun updateWebsite(dataMap: Map<String, Any>, onSuccess: onSuccess<PersonalCollectionWebsiteEntity?>, onFailure: onFailure) {
        mNetworkSource?.updateWebsite(dataMap, onSuccess, onFailure)
    }

    /**
     * 取消收藏 网站
     * @param id 网站 ID
     * @param onSuccess 成功回调函数
     */
    fun uncollectedWebsite(id: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.deleteWebsite(id, onSuccess)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}