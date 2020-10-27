package com.shijingfeng.weather.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_AMAP_CITY_SEARCH
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.weather.entity.CitySearchEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * Function: 城市搜索 Api
 * Date: 2020/10/27 14:57
 * Description:
 * @author ShiJingFeng
 */
internal interface CitySearchApi {

    /**
     * 城市搜索
     */
    @JvmSuppressWildcards //Java和Kotlin交互问题: 防止 Map<String, Any> 解析成 Map<String, ?>
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_AMAP_CITY_SEARCH)
    @GET("config/district")
    fun search(
        @QueryMap dataMap: Map<String, Any>
    ): Single<CitySearchEntity>

}