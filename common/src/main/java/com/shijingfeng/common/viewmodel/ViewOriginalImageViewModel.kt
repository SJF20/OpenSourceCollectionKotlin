package com.shijingfeng.common.viewmodel

import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.common.source.repository.ViewOriginalImageRepository
import com.shijingfeng.base.widget.dialog.LoadingDialog
import com.shijingfeng.common.base.CommonBaseViewModel
import okhttp3.ResponseBody

/**
 * Function: 查看原图 ViewModel
 * Date: 2020/1/29 9:41
 * Description:
 * @author ShiJingFeng
 */
internal class ViewOriginalImageViewModel(
    repository: ViewOriginalImageRepository? = null
) : CommonBaseViewModel<ViewOriginalImageRepository>(repository) {

    /** 保存图片 LiveEvent */
    val mSaveImageLiveEvent: SingleLiveEvent<ResponseBody?> = SingleLiveEvent()

    /**
     * 下载图片
     */
    fun downloadImage(imageUrl: String) {
        showLoadingDialog("保存中...")

        mRepository?.downloadImage(imageUrl, onSuccess = { responseBody ->
            mSaveImageLiveEvent.postValue(responseBody)
        }, onFailure = {
            LoadingDialog.getInstance().hide()
        })
    }

}