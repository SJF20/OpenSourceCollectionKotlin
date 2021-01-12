package com.shijingfeng.wan_android.source.network.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.wan_android.entity.CoinInfoEntity
import com.shijingfeng.wan_android.entity.CoinRankEntity
import com.shijingfeng.wan_android.entity.CoinRecordEntity
import com.shijingfeng.wan_android.entity.ResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import com.shijingfeng.wan_android.view_model.COIN_RANK_FIRST_PAGE
import com.shijingfeng.wan_android.view_model.COIN_RECORD_FIRST_PAGE

/**
 * Function: 积分 Api
 * Date: 2020/2/10 16:22
 * Description:
 * Author: ShiJingFeng
 */
internal interface CoinApi {

    /**
     * 获取个人积分
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/coin/userinfo/json")
    fun getCoinInfo(): Single<ResultEntity<CoinInfoEntity>>

    /**
     * 获取 积分记录 列表
     * @param page 页码 从 [COIN_RECORD_FIRST_PAGE] 开始
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("lg/coin/list/{page}/json")
    fun getCoinRecordList(@Path("page") page: Int): Single<ResultEntity<CoinRecordEntity>>

    /**
     * 获取 积分排行榜 列表
     * @param page 页码 从 [COIN_RANK_FIRST_PAGE] 开始
     * @return Single<ResultEntity>
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_WAN_ANDROID)
    @GET("coin/rank/{page}/json")
    fun getCoinRankList(@Path("page") page: Int): Single<ResultEntity<CoinRankEntity>>

}