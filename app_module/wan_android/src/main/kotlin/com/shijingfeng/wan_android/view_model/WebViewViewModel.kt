package com.shijingfeng.wan_android.view_model

import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.common.constant.ADD
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.entity.event.WebsiteCollectionEvent
import com.shijingfeng.wan_android.source.network.getWebViewNetworkSourceInstance
import com.shijingfeng.wan_android.source.repository.WebViewRepository
import com.shijingfeng.wan_android.source.repository.getWebViewRepositoryInstance
import com.shijingfeng.wan_android.ui.activity.WebViewActivity
import org.greenrobot.eventbus.EventBus

/**
 * Function: 通用 WebView ViewModel
 * Date: 2020/3/13 20:02
 * Description:
 * Author: ShiJingFeng
 */
internal class WebViewViewModel : WanAndroidBaseViewModel<WebViewRepository>() {

    /** 上一个页面的全限定名称  */
    var mFromName = ""
    /** 加载的URL  */
    var mUrl = ""
    /** 标题  */
    var mTitle = ""

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository() = getWebViewRepositoryInstance(
        networkSource = getWebViewNetworkSourceInstance()
    )

    /**
     * 收藏
     * @param dataMap 请求携带数据 (name, link)
     */
    fun collectedWebsite(dataMap: Map<String, Any>) {
        mRepository?.collectedWebsite(dataMap, onSuccess = { personalCollectionWebsite ->
            // 收藏该网站 广播出去
            EventBus.getDefault().post(WebsiteCollectionEvent(
                fromName = WebViewActivity::class.java.name,
                type = ADD,
                personalCollectionWebsite = personalCollectionWebsite
            ))
            ToastUtils.showShort(getStringById(R.string.收藏成功))
        })
    }

}