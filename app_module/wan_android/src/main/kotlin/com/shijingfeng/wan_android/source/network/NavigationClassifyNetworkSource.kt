package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.NavigationClassifyEntity
import com.shijingfeng.wan_android.source.network.api.ClassifyApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: NavigationClassifyNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getNavigationClassifyNetworkSourceInstance(): NavigationClassifyNetworkSource {
    if (sInstance == null) {
        synchronized(NavigationClassifyNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = NavigationClassifyNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 导航分类数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * Author: ShiJingFeng
 */
internal class NavigationClassifyNetworkSource : BaseNetworkSource() {

    private val mClassifyApi = RetrofitUtil.create(ClassifyApi::class.java)

    /**
     * 获取知识体系数据列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getNavigationClassifyList(onSuccess: onSuccess<List<NavigationClassifyEntity>?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mClassifyApi.getNavigationClassifyList(),
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