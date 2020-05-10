package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.ProjectChildEntity
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.source.network.api.ProjectApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: ProjectChildNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getProjectChildNetworkSourceInstance(): ProjectChildNetworkSource {
    if (sInstance == null) {
        synchronized(ProjectChildNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = ProjectChildNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 项目 二级数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class ProjectChildNetworkSource : BaseNetworkSource() {

    /** 项目相关 Api */
    private val mProjectApi = RetrofitUtil.create(ProjectApi::class.java)
    /** 收藏相关 Api */
    private val mCollectionApi = RetrofitUtil.create(CollectionApi::class.java)

    /**
     * 获取 项目二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getProjectChild(page: Int, id: String, onSuccess: onSuccess<ProjectChildEntity?>, onFailure: onFailure) {
        addDisposable(apiRequest(mProjectApi.getProjectChild(page, id), onSuccess, onFailure))
    }

    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun collected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.collectedInSitesArticle(articleId), onSuccess))
    }

    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    fun uncollected(articleId: String, onSuccess: onSuccess<Any?>) {
        addDisposable(apiRequest(mCollectionApi.uncollectedInArticleList(articleId), onSuccess))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}