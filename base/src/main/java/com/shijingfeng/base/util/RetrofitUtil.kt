package com.shijingfeng.base.util

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.shijingfeng.base.BuildConfig
import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.common.constant.BASE_URL_VALUE_WAN_ANDROID
import com.shijingfeng.base.http.cookie.CookieJarImpl
import com.shijingfeng.base.http.cookie.store.PersistentCookieStore
import com.shijingfeng.base.http.factory.CustomGsonConverterFactory
import com.shijingfeng.base.http.interceptor.CacheInterceptor
import com.shijingfeng.base.http.interceptor.ProgressInterceptor
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * Function: Retrofit工具类
 * Date: 2020/1/29 21:52
 * Description:
 * @author ShiJingFeng
 */
object RetrofitUtil {

    private val mRetrofit: Retrofit

    init {
        mRetrofit = initRetrofit()
    }

    /**
     * 创建 Retrofit 实例
     * @return Retrofit实例
     */
    private fun initRetrofit(): Retrofit {
        val sslParams: HttpsUtil.SSLParams = HttpsUtil.getSslSocketFactory()
        val okHttpClientBuilder = OkHttpClient().newBuilder()
            //读超时
            .readTimeout(20, TimeUnit.SECONDS)
            //连接超时
            .connectTimeout(20, TimeUnit.SECONDS)
            //错误重连
            .retryOnConnectionFailure(!BuildConfig.DEBUG)
            //设置CookieJar（存储到磁盘）
            .cookieJar(CookieJarImpl(PersistentCookieStore(BaseApplication.getApplication())))
            //添加SSL验证机制
            .sslSocketFactory(
                sslParams.sSLSocketFactory,
                sslParams.trustManager
            )
            // 这里你可以根据自己的机型设置同时连接的个数和时间，我这里8个，和每个保持时间为15s
            .connectionPool(ConnectionPool(8, 15, TimeUnit.SECONDS))
            //缓存拦截器
            .addInterceptor(CacheInterceptor())
            //数据拦截器
            .addNetworkInterceptor(HttpLoggingInterceptor(HttpLogger()).apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
//            .addInterceptor(new HeaderInterceptor(null))
            // 上传下载进度拦截器
            .addInterceptor(ProgressInterceptor())
        val okHttpClient = RetrofitUrlManager.getInstance()
            .with(okHttpClientBuilder)
            .build()
        return Retrofit.Builder()
            //默认 BaseUrl: 玩安卓域名 (只是占位用, 会被动态替换)
            .baseUrl(BASE_URL_VALUE_WAN_ANDROID)
            .client(okHttpClient)
            .addConverterFactory(CustomGsonConverterFactory.create(JsonUtil.getGson()))
            //添加对 RxJava2 的支持
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            //添加对 Kotlin协程 的支持
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    /**
     * 创建 Api 请求类
     * @param api  Api 请求原始反射类
     * @param <T> 泛型
     * @return Api 请求类
     */
    fun <T> create(api: Class<T>): T {
        return mRetrofit.create(api)
    }

}

/**
 * 自定义 OkHttp 拦截器 Logger
 */
class HttpLogger : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        d("网络拦截", message)
    }

}