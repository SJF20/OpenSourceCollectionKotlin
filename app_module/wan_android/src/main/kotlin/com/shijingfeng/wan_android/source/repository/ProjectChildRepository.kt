package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.ProjectChildEntity
import com.shijingfeng.wan_android.source.network.ProjectChildNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: ProjectChildRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getProjectChildRepositoryInstance(
    networkSource: ProjectChildNetworkSource? = null
): ProjectChildRepository {
    if (sInstance == null) {
        synchronized(ProjectChildRepository::class.java) {
            if (sInstance == null) {
                sInstance = ProjectChildRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 项目 二级数据 仓库
 * Date: 20-4-29 下午9:53
 * Description:
 * Author: shijingfeng
 */
internal class ProjectChildRepository(
    networkSource: ProjectChildNetworkSource? = null
) : BaseRepository<BaseLocalSource, ProjectChildNetworkSource>(
    mNetworkSource = networkSource
)  {

    /**
     * 获取 项目二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getProjectChild(page: Int, id: String, onSuccess: onSuccess<ProjectChildEntity?>, onFailure: onFailure) {
        mNetworkSource?.getProjectChild(page, id, onSuccess, onFailure)
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