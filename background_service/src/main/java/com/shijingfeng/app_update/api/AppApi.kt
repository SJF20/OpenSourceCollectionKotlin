package com.shijingfeng.app_update.api

import com.shijingfeng.base.common.constant.BASE_URL_NAME_PGYER
import com.shijingfeng.base.common.constant.DOMAIN_HEADER
import com.shijingfeng.app_update.constant.PGYER_APP_KEY
import com.shijingfeng.app_update.entity.NewestAppVersionEntity
import com.shijingfeng.app_update.entity.ResultEntity
import retrofit2.Call
import retrofit2.http.*

/**
 * Function: App 操作相关 Api
 * Date: 2020/5/23 23:28
 * Description:
 * @author ShiJingFeng
 */
internal interface AppApi {

    /**
     * 从服务器上获取最新应用版本
     *
     * @param
     */
    @Headers(DOMAIN_HEADER + BASE_URL_NAME_PGYER)
    @FormUrlEncoded
    @POST("apiv2/app/check?_api_key=08fe4e02f5d37b158c2d0b25e9614e73")
    fun getNewestAppVersionFromServer(
        @Query("buildVersion") versionName: String,
        @Field("appKey") appKey: String = PGYER_APP_KEY
    ): Call<ResultEntity<NewestAppVersionEntity?>>

}