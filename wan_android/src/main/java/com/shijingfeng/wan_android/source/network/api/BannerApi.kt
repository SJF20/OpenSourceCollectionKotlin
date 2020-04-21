package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.adapter.HomeBannerItem
import com.shijingfeng.wan_android.entity.network.ResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Function: 轮播图 Api
 * Date: 2020/2/12 10:28
 * Description:
 * @author ShiJingFeng
 */
internal interface BannerApi {

    /**
     * 获取 首页 轮播图 数据
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("banner/json")
    fun getHomeBannerList(): Single<ResultEntity<List<HomeBannerItem>>>

}