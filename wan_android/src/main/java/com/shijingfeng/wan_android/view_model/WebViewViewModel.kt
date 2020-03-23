package com.shijingfeng.wan_android.view_model

import com.kingja.loadsir.callback.Callback
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.DATA_OPERATE_TYPE_LOAD
import com.shijingfeng.base.common.constant.LOADING
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel

/**
 * Function: 通用 WebView ViewModel
 * Date: 2020/3/13 20:02
 * Description:
 * @author ShiJingFeng
 */
internal class WebViewViewModel : WanAndroidBaseViewModel<BaseRepository<*, *>>() {

    /** 腾讯X5 WebView是否已经初始化  */
    var mHasX5WebViewInited = false

}