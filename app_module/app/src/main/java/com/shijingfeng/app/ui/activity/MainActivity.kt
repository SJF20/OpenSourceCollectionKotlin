package com.shijingfeng.app.ui.activity

import android.graphics.Bitmap
import android.net.Uri
import android.util.SparseArray
import android.view.KeyEvent
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.app.BR
import com.shijingfeng.app.R
import com.shijingfeng.app.base.AppBaseActivity
import com.shijingfeng.app.databinding.ActivityAppMainBinding
import com.shijingfeng.app.view_model.MainViewModel
import com.shijingfeng.apt_api.manager.getActivityReceiverList
import com.shijingfeng.apt_api.manager.getApplicationReceiverList
import com.shijingfeng.base.arouter.ACTIVITY_APP_MAIN
import com.shijingfeng.base.util.LOG_TEST
import com.shijingfeng.base.util.e
import com.shijingfeng.tencent_x5.util.setDefaultX5WebSettings
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
import com.tencent.smtt.export.external.interfaces.WebResourceError
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.*
import kotlinx.android.synthetic.main.activity_app_main.*
import kotlinx.coroutines.launch

/**
 * Function: 主页
 * Date: 2020/3/16 13:28
 * Description:
 * @author ShiJingFeng
 */
@Route(path = ACTIVITY_APP_MAIN)
internal class MainActivity : AppBaseActivity<ActivityAppMainBinding, MainViewModel>() {

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_app_main

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(MainViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.mainViewModel, mViewModel)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
//        Handler().postDelayed({
//            initX5WebView()
//        }, 500)
    }

    /**
     * 初始化 腾讯X5 WebView
     */
    private fun initX5WebView() {
        setDefaultX5WebSettings(wv_content.settings)
        wv_content.webViewClient = CustomWebViewClient()
        wv_content.webChromeClient = CustomWebChromeClient()
        wv_content.loadUrl("http://debugtbs.qq.com")
        CookieSyncManager.createInstance(this)
        CookieSyncManager.getInstance().sync()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                val size = ActivityUtils.getActivityList().size

                if (size <= 1) {
                    mViewModel?.doubleDownExitApp()
                } else {
                    finish()
                }
                return true
            }
            else -> {}
        }
        return super.onKeyDown(keyCode, event)
    }

    /**
     * 通用 WebClient
     */
    private inner class CustomWebViewClient : WebViewClient() {

        /**
         * 网页拦截
         * @param view WebView
         * @param request WebResourceRequest
         * @return true: 拦截，不往下执行， false: 不拦截，继续执行
         */
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            return false
        }

        /**
         * 页面加载开始
         * @param view WebView
         * @param url mUrl
         * @param favicon Bitmap
         */
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        /**
         * 页面加载完成
         * @param view WebView
         * @param url mUrl
         */
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }

        /**
         * 向主机应用程序报告Web资源加载错误。这些错误通常表明无法连接到服务器。(6.0之后)
         * @param view WebView
         * @param request WebResourceRequest
         * @param error WebResourceError
         */
        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
        }

        /**
         * 向主机应用程序报告Web资源加载错误。这些错误通常表明无法连接到服务器。(6.0之前)
         * @param webView WebView
         * @param errorCode 错误代码号
         * @param description 错误描述
         * @param failingUrl 失败URL
         */
        override fun onReceivedError(
            webView: WebView?,
            errorCode: Int,
            description: String?,
            failingUrl: String?
        ) {
            super.onReceivedError(webView, errorCode, description, failingUrl)
        }
    }

    /**
     * 通用 WebChromeClient
     */
    private inner class CustomWebChromeClient : WebChromeClient() {

        /**
         * 获取 Web视频进度 View
         * @return Web视频进度 View
         */
        override fun getVideoLoadingProgressView(): View {
            return super.getVideoLoadingProgressView()
        }

        /**
         * Web视频全屏时调用
         * @param view View
         * @param customViewCallback CustomViewCallback
         */
        override fun onShowCustomView(
            view: View?,
            customViewCallback: IX5WebChromeClient.CustomViewCallback?
        ) {
            super.onShowCustomView(view, customViewCallback)
        }

        /**
         * Web视频退出全屏时调用
         */
        override fun onHideCustomView() {
            super.onHideCustomView()
        }

        /**
         * WebView调用本地文件选择器
         * @param webView WebView
         * @param valueCallback ValueCallback
         * @param fileChooserParams FileChooserParams
         * @return true: 消费事件  false: 不消费事件
         */
        override fun onShowFileChooser(
            webView: WebView?,
            valueCallback: ValueCallback<Array<Uri?>?>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams)
        }

        /**
         * 页面加载进度
         * @param view WebView
         * @param newProgress 加载进度
         */
        override fun onProgressChanged(
            view: WebView?,
            newProgress: Int
        ) {
            super.onProgressChanged(view, newProgress)
        }

        /**
         * 标题接收回调
         * @param webView WebView
         * @param title 标题
         */
        override fun onReceivedTitle(
            webView: WebView?,
            title: String?
        ) {
            super.onReceivedTitle(webView, title)
        }
    }

}
