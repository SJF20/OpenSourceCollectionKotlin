package com.shijingfeng.wan_android.viewmodel

import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel

/**
 * Function: 通用 WebView ViewModel
 * Date: 2020/3/13 20:02
 * Description:
 * @author ShiJingFeng
 */
class WebViewViewModel : WanAndroidBaseViewModel<BaseRepository<*, *>>() {

    /** 腾讯X5 WebView是否已经初始化  */
    var mHasX5WebViewInited = false

}