package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.entity.OfficialAccountChildEntity
import com.shijingfeng.wan_android.source.network.OfficialAccountChildNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: OfficialAccountChildRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getOfficialAccountChildRepositoryInstance(
    networkSource: OfficialAccountChildNetworkSource? = null
): OfficialAccountChildRepository {
    if (sInstance == null) {
        synchronized(OfficialAccountChildRepository::class.java) {
            if (sInstance == null) {
                sInstance = OfficialAccountChildRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}


/**
 * Function: 公众号 二级数据 仓库
 * Date: 2020/4/30 16:31
 * Description:
 * Author: ShiJingFeng
 */
internal class OfficialAccountChildRepository(
    networkSource: OfficialAccountChildNetworkSource? = null
) : BaseRepository<BaseLocalSource, OfficialAccountChildNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 获取　公众号 二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getOfficialAccountChild(page: Int, id: String, onSuccess: onSuccess<OfficialAccountChildEntity?>, onFailure: onFailure) {
        mNetworkSource?.getOfficialAccountChild(page, id, onSuccess, onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.collected(articleId, onSuccess)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.uncollected(articleId, onSuccess)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}