package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.network.CoinInfoEntity
import com.shijingfeng.wan_android.entity.network.CoinRankEntity
import com.shijingfeng.wan_android.entity.network.CoinRecordEntity
import com.shijingfeng.wan_android.entity.network.ResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * Function: 积分 Api
 * Date: 2020/2/10 16:22
 * Description:
 * @author ShiJingFeng
 */
interface CoinApi {

    /**
     * 获取个人积分
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/coin/userinfo/json")
    fun getCoinInfo(): Single<ResultEntity<CoinInfoEntity>>

    /**
     * 获取 积分记录 列表
     * @param page 页码
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/coin/list/{page}/json")
    fun getCoinRecordList(@Path("page") page: Int): Single<ResultEntity<CoinRecordEntity>>

    /**
     * 获取 积分排行榜 列表
     * @param page 页码
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("coin/rank/{page}/json")
    fun getCoinRankList(@Path("page") page: Int): Single<ResultEntity<CoinRankEntity>>

}