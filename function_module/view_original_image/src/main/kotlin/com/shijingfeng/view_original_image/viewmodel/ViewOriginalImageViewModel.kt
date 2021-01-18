package com.shijingfeng.view_original_image.viewmodel

import com.shijingfeng.base.mvvm.livedata.SingleLiveEvent
import com.shijingfeng.view_original_image.source.repository.ViewOriginalImageRepository
import com.shijingfeng.view_original_image.base.CommonBaseViewModel
import com.shijingfeng.view_original_image.entity.ViewOriginalImageItem
import com.shijingfeng.view_original_image.source.network.getViewOriginalImageNetworkSourceInstance
import com.shijingfeng.view_original_image.source.repository.getViewOriginalImageRepositoryInstance
import okhttp3.ResponseBody

/**
 * Function: 查看原图 ViewModel
 * Date: 2020/1/29 9:41
 * Description:
 * Author: ShiJingFeng
 */
internal class ViewOriginalImageViewModel : CommonBaseViewModel<ViewOriginalImageRepository>() {

    /** 上一个页面的全限定名称 */
    lateinit var mFromName: String
    /** 图片数据列表 */
    lateinit var mDataList: List<ViewOriginalImageItem>
    /** 首先展示的图片 在 图片数据列表的 位置 */
    var mCurrentPosition = 0

    /** 保存图片 LiveEvent */
    val mSaveImageLiveEvent = SingleLiveEvent<ResponseBody?>()

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getViewOriginalImageRepositoryInstance(
        networkSource = getViewOriginalImageNetworkSourceInstance()
    )

    /**
     * 下载图片
     */
    fun downloadImage(imageUrl: String) {
        showLoadingView()

        mRepository?.downloadImage(imageUrl, onSuccess = { responseBody ->
            mSaveImageLiveEvent.value = responseBody
        }, onFailure = {
            hideLoadingView()
        })
    }

}