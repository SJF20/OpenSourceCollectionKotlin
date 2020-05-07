package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.network.ResultEntity
import com.shijingfeng.wan_android.entity.network.SquareEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Function: 广场相关 Api
 * Date: 2020/5/7 15:15
 * Description:
 * @author ShiJingFeng
 */
internal interface SquareApi {

    /**
     * 获取 广场 数据
     * @param page 页码
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("user_article/list/{page}/json")
    fun getSquareList(
        @Path("page") page: Int
    ): Single<ResultEntity<SquareEntity>>

}