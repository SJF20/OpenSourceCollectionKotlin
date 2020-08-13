package com.shijingfeng.base.http.interceptor

import com.shijingfeng.base.http.request.ProgressRequestBody
import com.shijingfeng.base.http.response.ProgressResponseBody
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
        
        request.body?.let { requestBody ->
            //监听上传进度
            request = request.newBuilder()
                .post(ProgressRequestBody(requestBody))
                .build()
        }

        var response = chain.proceed(request)

        response.body?.let { responseBody ->
            //监听下载进度
            response = response.newBuilder()
                .body(ProgressResponseBody(responseBody))
                .build()
        }

        return response
    }
}