package com.shijingfeng.wan_android.source.network

import android.util.Log
import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.util.JsonUtil
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.base.util.e
import com.shijingfeng.wan_android.constant.SERVER_SUCCESS
import com.shijingfeng.wan_android.entity.network.UserInfoEntity
import com.shijingfeng.wan_android.source.network.api.UserApi
import com.shijingfeng.wan_android.utils.handle
import kotlinx.coroutines.*
import java.lang.Exception

/** 单例实例 */
@Volatile
private var sInstance: LoginNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getLoginNetworkSourceInstance(): LoginNetworkSource {
    if (sInstance == null) {
        synchronized(LoginNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = LoginNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 登录Activity 网络数据操作实现类
 * Date: 2020/2/4 16:16
 * Description:
 * @author ShiJingFeng
 */
class LoginNetworkSource : BaseNetworkSource() {

    private val mUserApi: UserApi = RetrofitUtil.create(UserApi::class.java)

    /**
     * 登录
     * @param postMap 数据
     * @param listener 回调监听
     */
    fun login(postMap: Map<String, Any>, onSuccess: OnSuccess<UserInfoEntity?>, onFailure: OnFailure) {
        addCoroutinesJob(
            GlobalScope.launch(Dispatchers.Main) {
                try {
                    val result = mUserApi.login(postMap)

                    if (result.code == SERVER_SUCCESS) {
                        onSuccess(result.data)
                    } else {
                        onFailure(handle(ServerException(result.code, result.msg)))
                    }
                } catch (e: Exception) {
                    e("测试", "错误: msg: ${e.message}, cause: ${e.cause}")
                    onFailure(handle(e))
                }
            }
        )
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}