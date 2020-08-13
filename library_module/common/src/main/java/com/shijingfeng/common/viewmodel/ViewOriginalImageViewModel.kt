package com.shijingfeng.common.viewmodel

import com.google.gson.reflect.TypeToken
import com.shijingfeng.base.common.constant.CURRENT_POSITION
import com.shijingfeng.base.common.constant.DATA
import com.shijingfeng.base.common.constant.EMPTY_ARRAY
import com.shijingfeng.base.common.constant.FROM_ACTIVITY_NAME
import com.shijingfeng.base.livedata.SingleLiveEvent
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.common.source.repository.ViewOriginalImageRepository
import com.shijingfeng.base.widget.dialog.LoadingDialog
import com.shijingfeng.common.R
import com.shijingfeng.common.base.CommonBaseViewModel
import com.shijingfeng.common.entity.ViewOriginalImageItem
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

    /** 上一个页面的全限定名称 */
    lateinit var mFromName: String
    /** 图片数据列表 */
    lateinit var mDataList: List<ViewOriginalImageItem>
    /** 首先展示的图片 在 图片数据列表的 位置 */
    var mCurrentPosition = 0

    /** 保存图片 LiveEvent */
    val mSaveImageLiveEvent: SingleLiveEvent<ResponseBody?> = SingleLiveEvent()

    /**
     * 下载图片
     */
    fun downloadImage(imageUrl: String) {
        showLoadingDialog(getStringById(R.string.保存中))

        mRepository?.downloadImage(imageUrl, onSuccess = { responseBody ->
            mSaveImageLiveEvent.postValue(responseBody)
        }, onFailure = {
            LoadingDialog.getInstance().hide()
        })
    }

}