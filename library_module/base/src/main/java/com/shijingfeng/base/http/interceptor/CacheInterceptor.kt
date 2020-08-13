package com.shijingfeng.base.http.interceptor

import com.blankj.utilcode.util.NetworkUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Function: 缓存控制 OkHttp拦截器
 * Date: 2020/1/22 22:02
 * Description:
 * @author ShiJingFeng
 */
internal class CacheInterceptor : Interceptor {

    /**
     * 拦截回调
     * @param chain 拦截链
     * @return Response响应
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if (NetworkUtils.isAvailable()) {
            //网络可用
            val response = chain.proceed(request)
            //缓存可用60秒
            val maxAge = 60

            return response.newBuilder()
                //HTTP1.1已废弃
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                //缓存使用者无限制，且生命周期60秒
                .header("Cache-Control", "public, max-age=$maxAge")
                .build()
        } else {
            //网络不可用
            // 读取缓存信息
            request = request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build()
            val response = chain.proceed(request)
            //设置缓存为3天以内
            val maxStale = 60 * 60 * 24 * 3

            return response.newBuilder()
                //HTTP1.1已废弃
                .removeHeader("Pragma")
                .removeHeader("Cache-Control")
                //只使用缓存，使用3天以内的缓存
                .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                .build()
        }
    }

}