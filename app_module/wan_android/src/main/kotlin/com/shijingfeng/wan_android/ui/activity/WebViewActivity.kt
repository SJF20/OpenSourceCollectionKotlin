package com.shijingfeng.wan_android.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.SparseArray
import android.util.SparseIntArray
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.webkit.JavascriptInterface
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.ConvertUtils
import com.kingja.loadsir.core.LoadSir
import com.shijingfeng.base.annotation.BindEventBus
import com.shijingfeng.base.arouter.ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_WEB_VIEW
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.event_bus.X5InitedEvent
import com.shijingfeng.base.util.getStatusBarHeight
import com.shijingfeng.base.util.serialize
import com.shijingfeng.base.util.shareText
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.common.entity.ViewOriginalImageItem
import com.shijingfeng.tencent_x5.util.setDefaultX5WebSettings
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.common.constant.IMAGE_CLICK_JS_ASSETS_FILE
import com.shijingfeng.wan_android.common.constant.SCROLL_TO_DOWN
import com.shijingfeng.wan_android.common.constant.SCROLL_TO_UP
import com.shijingfeng.wan_android.common.constant.TITLE_BAR_HEIGHT
import com.shijingfeng.wan_android.databinding.ActivityWanAndroidWebViewBinding
import com.shijingfeng.wan_android.view_model.WebViewViewModel
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
import com.tencent.smtt.export.external.interfaces.WebResourceError
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.ByteArrayOutputStream

/** TitleBar 隐藏 或 显示 所要滑动的距离 */
private val TITLE_BAR_VISIBILITY_SCROLL_DISTANCE = TITLE_BAR_HEIGHT * 3

/**
 * Function: WebView容器 Activity
 * Date: 2020/3/13 20:05
 * Description:
 * Author: ShiJingFeng
 */
@BindEventBus
@Route(path = ACTIVITY_WAN_ANDROID_WEB_VIEW)
internal class WebViewActivity : WanAndroidBaseActivity<ActivityWanAndroidWebViewBinding, WebViewViewModel>() {

    /** 第一次加载网页  */
    private var mFirstLoad = false

    /** 是否正在加载  */
    private var mLoading = false

    /** 标题栏是否可见  */
    private var mIsTitleBarVisible = false

    /** 动画是否加载完成  */
    private var mAnimLoadFinish = false

    /** WebView Y轴滑动方向 [SCROLL_TO_DOWN] */
    private var mYScrollDirection = 0

    /** WebView Y轴滑动距离  */
    private var mYScrollDistance = 0

    /** 更多 Dialog  */
    private var mMoreDialog: CommonDialog? = null
    /** 更多 Dialog Content View */
    private lateinit var mMoreDialogContentView: View

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_web_view

    /**
     * 获取ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(WebViewViewModel::class.java)

    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.webViewViewModel, mViewModel)
    }

    /**
     * 初始化参数
     */
    override fun initParam() {
        super.initParam()
        mDataBundle?.run {
            mViewModel?.mFromName = getString(FROM_ACTIVITY_NAME, "")
            mViewModel?.mUrl = getString(URL, "")
            mViewModel?.mTitle = getString(TITLE, "")
        }
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        mFirstLoad = true
        mIsTitleBarVisible = true
        mAnimLoadFinish = true

        mDataBinding.includeTitleBar.tvTitle.text = mViewModel?.mTitle
        mDataBinding.includeTitleBar.ivOperate.setImageResource(R.drawable.ic_wan_android_more)
        mDataBinding.includeTitleBar.ivOperate.visibility = VISIBLE

        mLoadService = LoadSir.getDefault().register(mDataBinding.wvContent) {
            if (mViewModel?.mLoadServiceStatus == LOAD_SERVICE_LOADING) {
                return@register
            }
            showCallback(LOAD_SERVICE_LOADING)
            mDataBinding.wvContent.loadUrl(mViewModel?.mUrl)
        }
        if (mViewModel == null || !mViewModel!!.mHasInitialized) {
            showCallback(LOAD_SERVICE_LOADING)
        }
        initX5WebView()
    }

    /**
     * 初始化 腾讯X5 WebView
     */
    private fun initX5WebView() {
        setDefaultX5WebSettings(mDataBinding.wvContent.settings)
        mDataBinding.wvContent.webViewClient = CustomWebViewClient()
        mDataBinding.wvContent.webChromeClient = CustomWebChromeClient()
        mDataBinding.wvContent.loadUrl(mViewModel?.mUrl)
        CookieSyncManager.createInstance(this)
        CookieSyncManager.getInstance().sync()
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        //返回 或 取消加载
        ClickUtils.applySingleDebouncing(mDataBinding.includeTitleBar.ivBack) {
            if (mLoading) {
                mDataBinding.wvContent.stopLoading()
            } else {
                finish()
            }
        }
        //显示 更多 Dialog
        ClickUtils.applySingleDebouncing(mDataBinding.includeTitleBar.ivOperate) { showMoreDialog() }
        //WebView滑动监听器
        mDataBinding.wvContent.setCustomOnScrollChangeListener { _, _, newScrollY, _, oldScrollY ->
            if (newScrollY > oldScrollY) {
                //触控点向上走，视图向下滚动，即手指向上滑动
                if (mYScrollDirection == SCROLL_TO_DOWN) {
                    //计算滑动距离
                    mYScrollDistance += (newScrollY - oldScrollY)
                    if (mYScrollDistance >= TITLE_BAR_VISIBILITY_SCROLL_DISTANCE && mIsTitleBarVisible) {
                        //隐藏标题栏
                        hideTitleBar()
                    }
                } else {
                    mYScrollDistance = newScrollY - oldScrollY
                    mYScrollDirection =
                        SCROLL_TO_DOWN
                }
            } else if (newScrollY < oldScrollY) {
                //触控点想下走，视图向上滚动，即手指向下滑动
                if (mYScrollDirection == SCROLL_TO_UP) {
                    //计算滑动距离
                    mYScrollDistance += (oldScrollY - newScrollY)
                    if (mYScrollDistance >= TITLE_BAR_VISIBILITY_SCROLL_DISTANCE && !mIsTitleBarVisible) {
                        //显示标题栏
                        showTitleBar()
                    }
                } else {
                    mYScrollDistance = oldScrollY - newScrollY
                    mYScrollDirection =
                        SCROLL_TO_UP
                }
            }
        }
        // JS交互接口
        initJavascriptInterfaces()
    }

    /**
     * 初始化 JavaScript Interface
     */
    private fun initJavascriptInterfaces() {
        //图片点击 js 接口
        mDataBinding.wvContent.addJavascriptInterface(ImageClickInterface(), "imgClick")
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onStart() {
        super.onStart()
        mDataBinding.wvContent.onResume()
        mDataBinding.wvContent.settings.javaScriptEnabled = true
        mDataBinding.wvContent.settings.javaScriptCanOpenWindowsAutomatically = true
    }

    override fun onStop() {
        mDataBinding.wvContent.onPause()
        mDataBinding.wvContent.settings.javaScriptEnabled = false
        mDataBinding.wvContent.settings.javaScriptCanOpenWindowsAutomatically = false
        super.onStop()
    }

    /**
     * 显示标题栏
     */
    private fun showTitleBar() {
        if (!mAnimLoadFinish) {
            return
        }
        mIsTitleBarVisible = true

        val animatorSet = AnimatorSet()
        val translationValueAnimator = ValueAnimator.ofInt(0,
            TITLE_BAR_HEIGHT
        )
        val scaleValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f)

        translationValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            val viewGroup = mDataBinding.includeTitleBar.flCommonTitleBar
            val layoutParams = viewGroup.layoutParams

            layoutParams.height = value
            viewGroup.layoutParams = layoutParams
        }
        scaleValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float

            mDataBinding.includeTitleBar.ivBack.run {
                scaleX = value
                scaleY = value
            }
            mDataBinding.includeTitleBar.tvTitle.run {
                scaleX = value
                scaleY = value
            }
            mDataBinding.includeTitleBar.ivOperate.run {
                scaleX = value
                scaleY = value
            }
        }
        animatorSet.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                mAnimLoadFinish = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                mAnimLoadFinish = true
            }

            override fun onAnimationCancel(animation: Animator?) {
                super.onAnimationCancel(animation)
                mAnimLoadFinish = true
            }

        })
        translationValueAnimator.duration = 400
        scaleValueAnimator.duration = 400
        animatorSet.run {
            playTogether(translationValueAnimator, scaleValueAnimator)
            duration = 400
            start()
        }
    }

    /**
     * 隐藏标题栏
     */
    private fun hideTitleBar() {
        if (!mAnimLoadFinish) {
            return
        }
        mIsTitleBarVisible = false

        val animatorSet = AnimatorSet()
        val translationValueAnimator = ValueAnimator.ofInt(TITLE_BAR_HEIGHT, 0)
        val scaleValueAnimator = ValueAnimator.ofFloat(1.0f, 0.0f)

        translationValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            val viewGroup = mDataBinding.includeTitleBar.flCommonTitleBar
            val layoutParams = viewGroup.layoutParams

            layoutParams.height = value
            viewGroup.layoutParams = layoutParams
        }
        scaleValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float

            mDataBinding.includeTitleBar.ivBack.run {
                scaleX = value
                scaleY = value
            }
            mDataBinding.includeTitleBar.tvTitle.run {
                scaleX = value
                scaleY = value
            }
            mDataBinding.includeTitleBar.ivOperate.run {
                scaleX = value
                scaleY = value
            }
        }
        animatorSet.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animation: Animator?) {
                super.onAnimationStart(animation)
                mAnimLoadFinish = false
            }

            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                mAnimLoadFinish = true
            }

            override fun onAnimationCancel(animation: Animator?) {
                super.onAnimationCancel(animation)
                mAnimLoadFinish = true
            }

        })
        translationValueAnimator.duration = 400
        scaleValueAnimator.duration = 400
        animatorSet.run {
            playTogether(translationValueAnimator, scaleValueAnimator)
            duration = 400
            start()
        }
    }

    /**
     * 显示 更多 Dialog
     */
    @SuppressLint("InflateParams")
    private fun showMoreDialog() {
        mMoreDialog?.run {
            if (!isShowing) {
                show()
            }
            return
        }

        mMoreDialogContentView = LayoutInflater.from(this).inflate(R.layout.layout_wan_android_webview_more, null)

        mMoreDialog = CommonDialog.Builder(this)
            .setContentView(mMoreDialogContentView)
            .setGravity(
                Gravity.TOP or Gravity.END,
                ConvertUtils.dp2px(5f),
                getStatusBarHeight()
            )
            .setCancelable(true)
            .show()

        //取消
        mMoreDialog?.setOnDismissListener {}
        //刷新
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_reload)
        ) {
            mMoreDialog?.hide()
            mDataBinding.wvContent.reload()
        }
        //分享
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_share)
        ) {
            mMoreDialog?.hide()
            shareText(this, mViewModel?.mTitle, mViewModel?.mUrl)
        }
        //收藏
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_collection)
        ) {
            mMoreDialog?.hide()
            mViewModel?.collectedWebsite(HashMap<String, Any>(2).apply {
                put("name", mViewModel?.mTitle ?: "")
                put("link", mViewModel?.mUrl ?: "")
            })
        }
        //在浏览器中打开
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_open_in_browser)
        ) {
            mMoreDialog?.hide()
            startActivity(Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(mDataBinding.wvContent.url)
                addCategory(Intent.CATEGORY_BROWSABLE)
            })
        }
    }

    /**
     * 在源网页中添加图片点击Js
     */
    private fun addImageClickJs() {
        var imageClickJs: String? = null

        application.assets.open(IMAGE_CLICK_JS_ASSETS_FILE).use { inputStream ->
            ByteArrayOutputStream().use { outputStream ->
                val byteArray = ByteArray(1024)
                var length: Int

                while (inputStream.read(byteArray).also { length = it } != -1) {
                    outputStream.write(byteArray, 0, length)
                }
                outputStream.flush()
                imageClickJs = outputStream.toString()
            }
        }
        if (!TextUtils.isEmpty(imageClickJs)) {
            mDataBinding.wvContent.evaluateJavascript(imageClickJs) {}
        }
    }

    /**
     * 切换屏幕方向
     */
    private fun switchScreenOrientation() {
        val currentOrientation = this.resources.configuration.orientation

        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            //设置为横屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            //设置为竖屏
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    /**
     * X5 内核初始化完毕 Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getX5InitedEvent(event: X5InitedEvent) {
        mDataBinding.wvContent.reload()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            // 返回
            KeyEvent.KEYCODE_BACK -> if (mMoreDialog != null && mMoreDialog!!.isShowing) {
                mMoreDialog?.hide()
                return true
            } else if (mDataBinding.wvContent.canGoBack()) {
                mDataBinding.wvContent.goBack()
                return true
            }
            // 前进
            KeyEvent.KEYCODE_FORWARD -> if (mDataBinding.wvContent.canGoForward()) {
                mDataBinding.wvContent.goForward()
                return true
            }
            else -> {}
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        mMoreDialog?.hide()
        mMoreDialog = null
        mDataBinding.wvContent.clearHistory()
        (mDataBinding.root as ViewGroup).removeView(mDataBinding.wvContent)
        mDataBinding.wvContent.destroy()
        super.onDestroy()
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
            mViewModel?.mUrl = request?.url?.toString() ?: ""
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
            mLoading = true
            mDataBinding.includeTitleBar.ivBack.setImageResource(R.drawable.ic_cancel)
            mDataBinding.pbProgress.visibility = VISIBLE
            if (mFirstLoad) {
                mFirstLoad = false
                showCallback(LOAD_SERVICE_LOADING)
            }
        }

        /**
         * 页面加载完成
         * @param view WebView
         * @param url mUrl
         */
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            mLoading = false
            mDataBinding.includeTitleBar.ivBack.setImageResource(R.drawable.ic_wan_android_back)
            mDataBinding.pbProgress.visibility = GONE
            showCallback(LOAD_SERVICE_SUCCESS)
            //在 HTML 标签加载完成之后开始加载图片内容
            mDataBinding.wvContent.settings.blockNetworkImage = false
            //添加图片可点击 js 接口
            addImageClickJs()
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
            val statusBarView = mDataBinding.root.findViewById<View>(R.id.status_bar_view)

            switchScreenOrientation()
            statusBarView?.setBackgroundResource(R.color.black)
            mDataBinding.frameVideo.visibility = VISIBLE
            mDataBinding.llWebView.visibility = GONE
            mDataBinding.frameVideo.addView(view, MATCH_PARENT, MATCH_PARENT)
        }

        /**
         * Web视频退出全屏时调用
         */
        override fun onHideCustomView() {
            super.onHideCustomView()
            val statusBarView = mDataBinding.root.findViewById<View>(R.id.status_bar_view)

            switchScreenOrientation()
            statusBarView?.setBackgroundResource(R.color.wan_android_theme_color)
            mDataBinding.frameVideo.visibility = GONE
            mDataBinding.llWebView.visibility = VISIBLE
            mDataBinding.frameVideo.removeAllViews()
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
            mDataBinding.pbProgress.progress = newProgress
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
            mViewModel?.mTitle = title ?: ""
            mDataBinding.includeTitleBar.tvTitle.text = title ?: ""
        }
    }

    /**
     * 图片操作 (Js 调用 原生 接口)
     */
    private inner class ImageClickInterface {

        /**
         * 图片点击回调
         * @param clickImageSrc 图片地址
         */
        @JavascriptInterface
        fun imageClick(clickImageSrc: String?, imageSrcArray: Array<String>?) {
            if (clickImageSrc.isNullOrEmpty()) {
                return
            }
            if (!clickImageSrc.startsWith(PROTOCOL_HTTP, true) && !clickImageSrc.startsWith(PROTOCOL_HTTPS, true)) {
                return
            }

            var clickedIndex = 0
            val dataList: List<ViewOriginalImageItem>

            if (imageSrcArray.isNullOrEmpty() || !imageSrcArray.contains(clickImageSrc)) {
                dataList = listOf(
                    ViewOriginalImageItem(imagePath = clickImageSrc)
                )
            } else {
                imageSrcArray.forEachIndexed { index, imageSrc ->
                    if (TextUtils.equals(clickImageSrc, imageSrc)) {
                        clickedIndex = index
                    }
                }
                dataList = imageSrcArray.map { imageSrc ->
                    ViewOriginalImageItem(imagePath = imageSrc)
                }.toList()
            }

            runOnUiThread {
                navigation(
                    activity = this@WebViewActivity,
                    path = ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE,
                    bundle = Bundle().apply {
                        putString(DATA, serialize(dataList))
                        putInt(CURRENT_POSITION, clickedIndex)
                    },
                    animSparseArray = SparseIntArray().apply {
                        put(KEY_ENTER_ANIM, R.anim.anim_activity_open_enter_view_original_image)
                        put(KEY_EXIT_ANIM, 0)
                    }
                )
            }
        }

    }

}