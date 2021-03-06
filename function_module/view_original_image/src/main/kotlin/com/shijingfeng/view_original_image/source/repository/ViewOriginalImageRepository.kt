package com.shijingfeng.view_original_image.source.repository

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.base.source.BaseLocalSource
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.view_original_image.source.network.ViewOriginalImageNetworkSource
import okhttp3.ResponseBody

/** 实例 */
@Volatile
private var sInstance: ViewOriginalImageRepository? = null

/**
 * DCL双检 获取实例
 * @return 实例
 */
internal fun getViewOriginalImageRepositoryInstance(
    networkSource: ViewOriginalImageNetworkSource? = null
): ViewOriginalImageRepository {
    if (sInstance == null) {
        synchronized(ViewOriginalImageRepository::class.java) {
            if (sInstance == null) {
                sInstance =
                    ViewOriginalImageRepository(
                        networkSource
                    )
            }
        }
    }
    return sInstance!!
}

/**
 * Function: 查看大图 仓库
 * Date: 2020/1/29 13:20
 * Description:
 * Author: ShiJingFeng
 */
internal class ViewOriginalImageRepository(
    networkSource: ViewOriginalImageNetworkSource? = null
) : BaseRepository<BaseLocalSource, ViewOriginalImageNetworkSource>(
    mNetworkSource = networkSource
) {

    /**
     * 下载图片
     * @param imageUrl 图片地址
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    fun downloadImage(imageUrl: String, onSuccess: onSuccess<ResponseBody?>, onFailure: onFailure) {
        mNetworkSource?.downloadImage(imageUrl, onSuccess, onFailure)
    }

    /**
     * 销毁回调
     */
    override fun onCleared() {
        super.onCleared()
        sInstance = null
    }

}