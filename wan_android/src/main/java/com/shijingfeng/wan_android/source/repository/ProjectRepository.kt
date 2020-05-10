package com.shijingfeng.wan_android.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.wan_android.entity.ProjectIndexEntity
import com.shijingfeng.wan_android.source.network.ProjectNetworkSource

/** 单例实例 */
@Volatile
private var sInstance: ProjectRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getProjectRepositoryInstance(
    networkSource: ProjectNetworkSource? = null
): ProjectRepository {
    if (sInstance == null) {
        synchronized(ProjectRepository::class.java) {
            if (sInstance == null) {
                sInstance = ProjectRepository(networkSource = networkSource)
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 项目 仓库
 * Date: 20-4-29 下午9:53
 * Description:
 * @author shijingfeng
 */
internal class ProjectRepository(
    networkSource: ProjectNetworkSource? = null
) : BaseRepository<BaseLocalSource, ProjectNetworkSource>(
    mNetworkSource = networkSource
)  {

    /**
     * 获取 项目索引数据
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getProjectIndex(onSuccess: onSuccess<List<ProjectIndexEntity>?>, onFailure: onFailure) {
        mNetworkSource?.getProjectIndex(onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}