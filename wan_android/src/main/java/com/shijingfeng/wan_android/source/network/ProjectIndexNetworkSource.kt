package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildEntity
import com.shijingfeng.wan_android.entity.network.ProjectChildEntity
import com.shijingfeng.wan_android.entity.network.ProjectIndexEntity
import com.shijingfeng.wan_android.source.network.api.ClassifyApi
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.source.network.api.ProjectApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: ProjectIndexNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getProjectIndexNetworkSourceInstance(): ProjectIndexNetworkSource {
    if (sInstance == null) {
        synchronized(ProjectIndexNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = ProjectIndexNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 项目 索引数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class ProjectIndexNetworkSource : BaseNetworkSource() {

    /** 项目相关 Api */
    private val mProjectApi = RetrofitUtil.create(ProjectApi::class.java)

    /**
     * 获取 项目索引数据
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getProjectIndex(onSuccess: onSuccess<List<ProjectIndexEntity>?>, onFailure: onFailure) {
        addDisposable(apiRequest(mProjectApi.getProjectIndex(), onSuccess, onFailure))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}