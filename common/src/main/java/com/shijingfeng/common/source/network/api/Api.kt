package com.shijingfeng.common.source.network.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * Function: 通用 Retrofit Api
 * Date: 2020/1/23 20:52
 * Description:
 * @author ShiJingFeng
 */
interface Api {

    /**
     * 下载文件
     * @param url 全限定URL地址
     * @return RxJava Single
     */
    @Streaming
    @GET
    fun downloadFile(@Url url: String): Call<ResponseBody?>

}