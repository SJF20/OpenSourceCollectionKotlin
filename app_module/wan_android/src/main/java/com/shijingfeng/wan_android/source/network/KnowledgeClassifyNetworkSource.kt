package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity
import com.shijingfeng.wan_android.source.network.api.ClassifyApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: KnowledgeClassifyNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getKnowledgeClassifyNetworkSourceInstance(): KnowledgeClassifyNetworkSource {
    if (sInstance == null) {
        synchronized(KnowledgeClassifyNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = KnowledgeClassifyNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 知识体系 一级数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class KnowledgeClassifyNetworkSource : BaseNetworkSource() {

    private val mClassifyApi = RetrofitUtil.create(ClassifyApi::class.java)

    /**
     * 获取　知识体系　一级数据　列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getKnowledgeClassifyList(onSuccess: onSuccess<List<KnowledgeClassifyEntity>?>, onFailure: onFailure) {
        addDisposable(apiRequest(
            single = mClassifyApi.getKnowledgeClassifyList(),
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