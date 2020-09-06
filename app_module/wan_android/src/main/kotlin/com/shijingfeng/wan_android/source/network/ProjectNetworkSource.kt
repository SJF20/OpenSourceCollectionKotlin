package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.ProjectIndexEntity
import com.shijingfeng.wan_android.source.network.api.ProjectApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: ProjectNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getProjectNetworkSourceInstance(): ProjectNetworkSource {
    if (sInstance == null) {
        synchronized(ProjectNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = ProjectNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 项目 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class ProjectNetworkSource : BaseNetworkSource() {

    /** 项目相关 Api */
    private val mProjectApi = RetrofitUtil.create(ProjectApi::class.java)

    /**
     * 获取 项目 索引数据
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getProjectIndex(onSuccess: onSuccess<List<ProjectIndexEntity>?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mProjectApi.getProjectIndex(),
            onSuccess = onSuccess,
            onFailure = onFailure
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