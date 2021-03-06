package com.shijingfeng.app.api

import com.shijingfeng.base.common.constant.PGYER_APP_KEY
import com.shijingfeng.app.entity.NewestAppInfoEntity
import com.shijingfeng.app.entity.ResultEntity
import com.shijingfeng.network.constant.BASE_URL_NAME_PGYER
import com.shijingfeng.network.constant.DOMAIN_HEADER
import retrofit2.Call
import retrofit2.http.*

/**
 * Function: App 操作相关 Api
 * Date: 2020/5/23 23:28
 * Description:
 * Author: ShiJingFeng
 */
internal interface AppApi {

    /**
     * 从服务器上获取最新应用版本信息
     *
     * @param
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_PGYER)
    @FormUrlEncoded
    @POST("apiv2/app/check?_api_key=08fe4e02f5d37b158c2d0b25e9614e73")
    fun getNewestAppInfoFromServer(
        @Query("buildVersion") versionName: String,
        @Field("appKey") appKey: String = PGYER_APP_KEY
    ): Call<ResultEntity<NewestAppInfoEntity?>>

}