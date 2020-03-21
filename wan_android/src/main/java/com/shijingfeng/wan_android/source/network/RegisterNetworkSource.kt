package com.shijingfeng.wan_android.source.network

import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.wan_android.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.network.UserInfoEntity
import com.shijingfeng.wan_android.source.network.api.UserApi
import com.shijingfeng.wan_android.utils.apiRequest
import com.shijingfeng.wan_android.utils.handle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/** 单例实例 */
@Volatile
private var sInstance: RegisterNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getRegisterNetworkSourceInstance(): RegisterNetworkSource {
    if (sInstance == null) {
        synchronized(RegisterNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = RegisterNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 注册页面 网络源
 * Date: 2020/2/5 12:53
 * Description:
 * @author ShiJingFeng
 */
class RegisterNetworkSource : BaseNetworkSource() {

    private val mUserApi: UserApi = RetrofitUtil.create(UserApi::class.java)

    /**
     * 注册
     * @param postMap 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun register(postMap: Map<String, Any>, onSuccess: OnSuccess<UserInfoEntity?>, onFailure: OnFailure) {
        addDisposable(apiRequest(mUserApi.register(postMap), onSuccess, onFailure))
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }
}