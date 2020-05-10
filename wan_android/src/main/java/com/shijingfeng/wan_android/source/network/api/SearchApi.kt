package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.ResultEntity
import com.shijingfeng.wan_android.entity.SearchListEntity
import com.shijingfeng.wan_android.entity.SearchHotWordEntity
import io.reactivex.Single
import retrofit2.http.*

/**
 * Function: 搜索相关 Api
 * Date: 20-5-3 下午8:48
 * Description:
 * @author shijingfeng
 */
internal interface SearchApi {

    /**
     * 获取搜索热词列表
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("hotkey/json")
    fun getSearchHotWordList(): Single<ResultEntity<List<SearchHotWordEntity>>>

    /**
     * 获取 搜索 列表
     * @return RxJava Single
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @FormUrlEncoded
    @POST("article/query/{page}/json")
    fun getSearchList(
        @Path("page") page: Int,
        @Field("k") keyword: String
    ): Single<ResultEntity<SearchListEntity>>

}