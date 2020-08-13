package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.OfficialAccountChildEntity
import com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity
import com.shijingfeng.wan_android.entity.ResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Function: 公众号 相关 Api
 * Date: 2020/4/29 16:55
 * Description:
 * @author ShiJingFeng
 */
internal interface OfficialAccountApi {

    /**
     * 获取 公众号 索引数据
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("wxarticle/chapters/json")
    fun getOfficialAccountIndex(): Single<ResultEntity<List<OfficialAccountIndexEntity>>>

    /**
     * 获取 公众号 二级数据
     * @param page 页码
     * @param id 　公众号索引数据 ID
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("wxarticle/list/{id}/{page}/json")
    fun getOfficialAccountChild(
        @Path("page") page: Int,
        @Path("id") id: String
    ): Single<ResultEntity<OfficialAccountChildEntity>>


}