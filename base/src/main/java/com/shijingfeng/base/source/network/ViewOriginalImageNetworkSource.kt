package com.shijingfeng.base.source.network

import android.os.Handler
import android.os.Looper
import com.shijingfeng.base.base.source.BaseNetworkSource
import com.shijingfeng.base.common.extension.OnFailure
import com.shijingfeng.base.common.extension.OnSuccess
import com.shijingfeng.base.http.exception.handle
import com.shijingfeng.base.source.network.api.Api
import com.shijingfeng.base.util.RetrofitUtil
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** 实例 */
@Volatile
private var sInstance: ViewOriginalImageNetworkSource? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
fun getViewOriginalImageNetworkSourceInstance(): ViewOriginalImageNetworkSource {
    if (sInstance == null) {
        synchronized(ViewOriginalImageNetworkSource::class.java) {
            if (sInstance == null) {
                sInstance = ViewOriginalImageNetworkSource()
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 查看大图 网络源
 * Date: 2020/1/29 20:03
 * Description:
 * @author ShiJingFeng
 */
class ViewOriginalImageNetworkSource : BaseNetworkSource() {

    private val mApi: Api = RetrofitUtil.create(Api::class.java)
    private var mDownloadImageCall: Call<ResponseBody?>? = null

    /**
     * 下载图片
     * @param imageUrl 图片地址
     */
    fun downloadImage(imageUrl: String, onSuccess: OnSuccess<ResponseBody?>, onFailure: OnFailure) {
        mDownloadImageCall = mApi.downloadFile(imageUrl)
        mDownloadImageCall
            ?.enqueue(object : Callback<ResponseBody?> {

                /**
                 * 响应成功回调
                 */
                override fun onResponse(
                    call: Call<ResponseBody?>,
                    response: Response<ResponseBody?>
                ) {
                    onSuccess(response.body())
                }

                /**
                 * 响应失败回调
                 */
                override fun onFailure(
                    call: Call<ResponseBody?>,
                    throwable: Throwable
                ) {
                    Handler(Looper.getMainLooper()).post {
                        onFailure(handle(throwable))
                    }
                }

            })
    }

    /**
     * 清除数据
     */
    override fun onCleared() {
        super.onCleared()
        mDownloadImageCall?.cancel()
        mDownloadImageCall = null
        sInstance = null
    }
}