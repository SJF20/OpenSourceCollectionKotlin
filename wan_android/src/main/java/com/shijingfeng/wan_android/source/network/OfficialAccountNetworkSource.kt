package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.entity.network.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.source.network.api.OfficialAccountApi
import com.shijingfeng.wan_android.utils.apiRequest

/** 单例实例 */
@Volatile
private var sInstance: OfficialAccountNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getOfficialAccountNetworkSourceInstance(): OfficialAccountNetworkSource {
    if (sInstance == null) {
        synchronized(OfficialAccountNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = OfficialAccountNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 公众号 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class OfficialAccountNetworkSource : BaseNetworkSource() {

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