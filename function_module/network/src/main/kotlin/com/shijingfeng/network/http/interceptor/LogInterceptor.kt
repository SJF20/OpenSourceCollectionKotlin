package com.shijingfeng.network.http.interceptor

import com.shijingfeng.base.BuildConfig
import com.shijingfeng.base.util.d
import okhttp3.*
import okio.BufferedSource
import java.nio.charset.Charset

/**
 * Function: Log数据 OkHttp拦截器
 * Date: 2020/1/22 22:18
 * Description:
 * @author ShiJingFeng
 */
internal class LogInterceptor : Interceptor {

    /**
     * 拦截回调
     * @param chain 拦截链
     * @return Response响应
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()

        if (!BuildConfig.DEBUG) return chain.proceed(request)

        request.body?.let { requestBody ->
            when (requestBody) {
                //表单请求
                is FormBody -> {
                    val strBuilder = StringBuilder()

                    for (i in 0 until requestBody.size) {
                        val encodeName: String = requestBody.encodedName(i)
                        val encodeValue: String = requestBody.encodedValue(i)
                        val name: String = requestBody.name(i)
                        val value: String = requestBody.value(i)

//                        strBuilder.append(" encodeName: " + encodeName + "  encodeValue: " + encodeValue + "  name: " + name + "  value: " + value);
                        strBuilder.append("name: $name  value: $value\n")
                    }
                    d("网络拦截", "FormBody请求数据类型: ${requestBody.contentType()}")
                    d("网络拦截", "FormBody请求体内容: $strBuilder")
                }
                //文件上传请求
                is MultipartBody -> {

                }
            }
        }

        val response: Response = chain.proceed(request)
        response.body?.let { responseBody ->
            val bufferedSource = responseBody.source()

            bufferedSource.request(Long.MAX_VALUE)

            val buffer = bufferedSource.buffer
            val bufferClone = buffer.clone()
            val charSet = Charset.forName("UTF-8")

            d("网络拦截", "响应Body: ${bufferClone.readString(charSet)}")
        }
        return response
    }
}