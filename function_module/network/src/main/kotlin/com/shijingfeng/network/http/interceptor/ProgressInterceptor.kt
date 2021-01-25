package com.shijingfeng.network.http.interceptor

import com.shijingfeng.network.constant.HEADER_UPLOAD_PROGRESS_TAG
import com.shijingfeng.network.constant.HEADER_DOWNLOAD_PROGRESS_TAG
import com.shijingfeng.network.http.request.ProgressRequestBody
import com.shijingfeng.network.http.response.ProgressResponseBody
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Function: 进度拦截器
 * Date: 2020/1/23 15:47
 * Description:
 * @author ShiJingFeng
 */
internal class ProgressInterceptor : Interceptor {

    /**
     * 拦截回调
     * @param chain 拦截链
     * @return Response响应
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val uploadProgressTag = request.header(HEADER_UPLOAD_PROGRESS_TAG) ?: ""
        val downloadProgressTag = request.header(HEADER_DOWNLOAD_PROGRESS_TAG) ?: ""

        request.body?.let { requestBody ->
            //监听上传进度
            request = request.newBuilder()
                .removeHeader(HEADER_UPLOAD_PROGRESS_TAG)
                .post(ProgressRequestBody(
                    requestBody = requestBody,
                    tag = uploadProgressTag
                ))
                .build()
        }

        var response = chain.proceed(request)

        response.body?.let { responseBody ->
            //监听下载进度
            response = response.newBuilder()
                .body(ProgressResponseBody(
                    responseBody = responseBody,
                    tag = downloadProgressTag
                ))
                .build()
        }

        return response
    }
}