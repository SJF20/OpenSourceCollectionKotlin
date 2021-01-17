package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.annotation.define.PageOperateType
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.PAGE_OPERATE_TYPE_LOAD
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.wan_android.entity.HomeDataEntity
import com.shijingfeng.wan_android.source.local.HomeLocalSource
import com.shijingfeng.wan_android.source.network.HomeNetworkSource
import com.shijingfeng.wan_android.view_model.HOME_FIRST_PAGE

/** 单例实例 */
@Volatile
private var sInstance: HomeRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getHomeRepositoryInstance(
    localSource: HomeLocalSource? = null,
    networkSource: HomeNetworkSource? = null
): HomeRepository {
    if (sInstance == null) {
        synchronized(HomeRepository::class.java) {
            if (sInstance == null) {
                sInstance = HomeRepository(
                    localSource = localSource,
                    networkSource = networkSource
                )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 首页 仓库
 * Date: 2020/2/12 13:21
 * Description:
 * Author: ShiJingFeng
 */
internal class HomeRepository(
    localSource: HomeLocalSource? = null,
    networkSource: HomeNetworkSource? = null
) : BaseRepository<HomeLocalSource, HomeNetworkSource>(
    mLocalSource = localSource,
    mNetworkSource = networkSource
) {

    /**
     * 获取首页数据
     * @param pageOperateType 页面操作类型
     * @param page 页码 (从 [HOME_FIRST_PAGE] 开始，为了兼容以前的)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getHomeDataList(
        @PageOperateType pageOperateType: Int,
        page: Int,
        onSuccess: onSuccess<HomeDataEntity?>,
        onFailure: onFailure
    ) {
//        when (pageOperateType) {
//            // 页面操作类型：加载数据
//            PAGE_OPERATE_TYPE_LOAD -> {
//                mNetworkSource?.getHomeDataList(page, onSuccess, onFailure = { exception ->
//                    mLocalSource?.getHomeDataList(onSuccess, onFailure = {
//                        onFailure(exception)
//                    })
//                })
//            }
//            else -> {
//                mNetworkSource?.getHomeDataList(page, onSuccess, onFailure)
//            }
//        }
        mNetworkSource?.getHomeDataList(page, onSuccess, onFailure)
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        mNetworkSource?.collected(articleId, onSuccess)
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
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