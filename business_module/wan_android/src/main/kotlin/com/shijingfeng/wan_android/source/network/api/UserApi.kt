package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.network.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.network.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.ResultEntity
import com.shijingfeng.wan_android.entity.UserInfoEntity
import io.reactivex.Single
import retrofit2.http.*

/**
 * Function: 用户 Api
 * Date: 2020/2/4 16:17
 * Description:
 * Author: ShiJingFeng
 */
internal interface UserApi {

    /**
     * 登录 (使用协程)
     * @param postMap 数据
     * @return Single
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@FieldMap postMap: Map<String, Any>): ResultEntity<UserInfoEntity>

    /**
     * 退出登录
     * @return Single
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("user/logout/json")
    fun logout(): Single<ResultEntity<Any>>

    /**
     * 注册
     * @param postMap 数据
     * @return Single
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("user/register")
    fun register(@FieldMap postMap: Map<String, Any>): Single<ResultEntity<UserInfoEntity>>

}