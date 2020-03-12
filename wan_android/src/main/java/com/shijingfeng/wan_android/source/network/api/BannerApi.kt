package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.network.HomeBannerEntity
import com.shijingfeng.wan_android.entity.network.ResultEntity
import io.reactivex.Single
import io.reactivex.SingleSource
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Function: 轮播图 Api
 * Date: 2020/2/12 10:28
 * Description:
 * @author ShiJingFeng
 */
interface BannerApi {

    /**
     * 获取 首页 轮播图 数据
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("banner/json")
    fun getHomeBannerData(): Single<ResultEntity<List<HomeBannerEntity>>>

}