package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.KnowledgeClassifyChildEntity
import com.shijingfeng.wan_android.entity.network.OfficialAccountChildEntity
import com.shijingfeng.wan_android.entity.network.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.source.network.api.ClassifyApi
import com.shijingfeng.wan_android.source.network.api.CollectionApi
import com.shijingfeng.wan_android.source.network.api.OfficialAccountApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: OfficialAccountIndexNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getOfficialAccountIndexNetworkSourceInstance(): OfficialAccountIndexNetworkSource {
    if (sInstance == null) {
        synchronized(OfficialAccountIndexNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = OfficialAccountIndexNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 公众号 索引数据 Fragment
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class OfficialAccountIndexNetworkSource : BaseNetworkSource() {

    /** 公众号相关 Api */
    private val mOfficialAccountApi = RetrofitUtil.create(OfficialAccountApi::class.java)

    /**
     * 获取　公众号 索引数据
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun getOfficialAccountIndex(onSuccess: onSuccess<List<OfficialAccountIndexEntity>?>, onFailure: onFailure) {
        addDisposable(apiRequest(mOfficialAccountApi.getOfficialAccountIndex(), onSuccess, onFailure))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}