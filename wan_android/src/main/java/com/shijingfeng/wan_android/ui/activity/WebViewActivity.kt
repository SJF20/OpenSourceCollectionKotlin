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
import com.shijingfeng.base.arouter.ARouterUtil.navigation
import com.shijingfeng.base.base.application.isX5Inited
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.entity.event.X5InitedEvent
import com.shijingfeng.base.util.getStatusBarHeight
import com.shijingfeng.base.util.serialize
import com.shijingfeng.base.util.setDefaultX5WebSettings
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.common.entity.ViewOriginalImageItem
import com.shijingfeng.wan_android.BR
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.base.WanAndroidBaseActivity
import com.shijingfeng.wan_android.constant.SCROLL_TO_DOWN
import com.shijingfeng.wan_android.constant.SCROLL_TO_UP
import com.shijingfeng.wan_android.constant.TITLE_BAR_HEIGHT
import com.shijingfeng.wan_android.databinding.ActivityWebViewBinding
import com.shijingfeng.wan_android.view_model.WebViewViewModel
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
import com.tencent.smtt.export.external.interfaces.WebResourceError
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.*
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.layout_title_bar.view.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.ByteArrayOutputStream


/**
 * Function: WebView容器 Activity
 * Date: 2020/3/13 20:05
 * Description:
 * @author ShiJingFeng
 */
@BindEventBus
@Route(path = ACTIVITY_WAN_ANDROID_WEB_VIEW)
class WebViewActivity : WanAndroidBaseActivity<ActivityWebViewBinding, WebViewViewModel>() {

    /** 第一次加载网页  */
    private var mFirstLoad = false

    /** 是否正在加载  */
    private var mLoading = false

    /** 标题栏是否可见  */
    private var mIsTitleBarVisible = false

    /** 动画是否加载完成  */
    private var mAnimLoadFinish = false

    /** WebView Y轴滑动方向 [com.shijingfeng.wan_android.constant.SCROLL_TO_DOWN] */
    private var mYScrollDirection = 0

    /** WebView Y轴滑动距离  */
    private var mYScrollDistance = 0

    /** 更多 Dialog  */
    private var mMoreDialog: CommonDialog? = null

    /** 上一个页面的全限定名称  */
    private var mFromName = ""

    /** 加载的URL  */
    private var mUrl = ""

    /** 标题  */
    private var mTitle = ""

    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    override fun getLayoutId() = R.layout.activity_web_view

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
        mViewModel?.mBundle?.run {
            mFromName = getString(FROM_ACTIVITY_NAME, "")
            mUrl = getString(URL, "")
            mTitle = getString(TITLE, "")
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

        include_title_bar.tv_title.text = mTitle
        include_title_bar.iv_operate.setImageResource(R.drawable.ic_more)
        include_title_bar.iv_operate.visibility = VISIBLE

        mLoadService = LoadSir.getDefault().register(wv_content) {
            mLoadService?.showCallback(LoadingCallback::class.java)
            wv_content.loadUrl(mUrl)
        }
        if (mViewModel == null || !mViewModel!!.mHasInited) {
            mLoadService?.showCallback(LoadingCallback::class.java)
        }
        //如果内核没有初始化完成，则不初始化 腾讯X5 WebView
        mViewModel?.let { viewModel ->
            if (!viewModel.mHasX5WebViewInited && isX5Inited) {
                initX5WebView()
            }
        }
    }

    /**
     * 初始化 腾讯X5 WebView
     */
    private fun initX5WebView() {
        mViewModel?.mHasX5WebViewInited = true
        setDefaultX5WebSettings(wv_content.settings)
        wv_content.webViewClient = CustomWebViewClient()
        wv_content.webChromeClient = CustomWebChromeClient()
        wv_content.loadUrl(mUrl)
        CookieSyncManager.createInstance(this)
        CookieSyncManager.getInstance().sync()
    }

    /**
     * 初始化事件
     */
    override fun initAction() {
        super.initAction()
        //返回 或 取消加载
        ClickUtils.applySingleDebouncing(include_title_bar.iv_back) {
            if (mLoading) {
                wv_content.stopLoading()
            } else {
                finish()
            }
        }
        //显示 更多 Dialog
        ClickUtils.applySingleDebouncing(include_title_bar.iv_operate) { showMoreDialog() }
        //WebView滑动监听器
        wv_content.setCustomOnScrollChangeListener { _, _, newScrollY, _, oldScrollY ->
            if (newScrollY > oldScrollY) {
                //触控点向上走，视图向下滚动，即手指向上滑动
                if (mYScrollDirection == SCROLL_TO_DOWN) {
                    //计算滑动距离
                    mYScrollDistance += (newScrollY - oldScrollY)
                    if (mYScrollDistance >= TITLE_BAR_HEIGHT && mIsTitleBarVisible) {
                        //隐藏标题栏
                        hideTitleBar()
                    }
                } else {
                    mYScrollDistance = 0
                    mYScrollDirection = SCROLL_TO_DOWN;
                }
            } else {
                //触控点想下走，视图向上滚动，即手指向下滑动
                if (mYScrollDirection == SCROLL_TO_UP) {
                    //计算滑动距离
                    mYScrollDistance += (oldScrollY - newScrollY)
                    if (mYScrollDistance >= TITLE_BAR_HEIGHT && !mIsTitleBarVisible) {
                        //显示标题栏
                        showTitleBar()
                    }
                } else {
                    mYScrollDistance = 0;
                    mYScrollDirection = SCROLL_TO_UP;
                }
            }
        }
        initJavascriptInterfaces()
    }

    /**
     * 初始化 JavaScript Interface
     */
    private fun initJavascriptInterfaces() {
        //图片点击 js 接口
        wv_content.addJavascriptInterface(JsCallAndroidInterface(), "imgClick")
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onStart() {
        super.onStart()
        wv_content.onResume()
        wv_content.settings.javaScriptEnabled = true
        wv_content.settings.javaScriptCanOpenWindowsAutomatically = true
    }

    override fun onStop() {
        wv_content.onPause()
        wv_content.settings.javaScriptEnabled = false
        wv_content.settings.javaScriptCanOpenWindowsAutomatically = false
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
        val translationValueAnimator = ValueAnimator.ofInt(0, TITLE_BAR_HEIGHT)
        val scaleValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f)

        translationValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Int
            val viewGroup = include_title_bar
            val layoutParams = viewGroup.layoutParams

            layoutParams.height = value
            viewGroup.layoutParams = layoutParams
        }
        scaleValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float

            include_title_bar.iv_back.run {
                scaleX = value
                scaleY = value
            }
            include_title_bar.tv_title.run {
                scaleX = value
                scaleY = value
            }
            include_title_bar.iv_operate.run {
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
            val viewGroup = include_title_bar
            val layoutParams = viewGroup.layoutParams

            layoutParams.height = value
            viewGroup.layoutParams = layoutParams
        }
        scaleValueAnimator.addUpdateListener { animation ->
            val value = animation.animatedValue as Float

            include_title_bar.iv_back.run {
                scaleX = value
                scaleY = value
            }
            include_title_bar.tv_title.run {
                scaleX = value
                scaleY = value
            }
            include_title_bar.iv_operate.run {
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

        val view = LayoutInflater.from(this).inflate(R.layout.layout_webview_more, null)

        mMoreDialog = CommonDialog.Builder(this)
            .setContentView(view)
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
            view.findViewById<TextView>(R.id.tv_reload)
        ) {
            mMoreDialog?.hide()
            wv_content.reload()
        }
        //分享
        ClickUtils.applySingleDebouncing(
            view.findViewById<TextView>(R.id.tv_share)
        ) {
            mMoreDialog?.hide()
        }
        //收藏
        ClickUtils.applySingleDebouncing(
            view.findViewById<TextView>(R.id.tv_collection)
        ) {
            mMoreDialog?.hide()
        }
        //在浏览器中打开
        ClickUtils.applySingleDebouncing(
            view.findViewById<TextView>(R.id.tv_open_in_browser)
        ) {
            mMoreDialog?.hide()
            startActivity(Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(wv_content.url)
                addCategory(Intent.CATEGORY_BROWSABLE)
            })
        }
    }

    /**
     * 在源网页中添加图片点击Js
     */
    private fun addImageClickJs() {
        var imageClickJs: String? = null

        application.assets.open("js/image_click.js").use { inputStream ->
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
            wv_content.evaluateJavascript(imageClickJs) {}
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
        val success = event.success

        mViewModel?.run {
            if (!mHasX5WebViewInited) {
                initX5WebView()
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            // 返回
            KeyEvent.KEYCODE_BACK -> if (mMoreDialog != null && mMoreDialog!!.isShowing) {
                mMoreDialog?.hide()
                return true
            } else if (wv_content.canGoBack()) {
                wv_content.goBack()
                return true
            }
            // 前进
            KeyEvent.KEYCODE_FORWARD -> if (wv_content.canGoForward()) {
                wv_content.goForward()
                return true
            }
            else -> {}
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onDestroy() {
        wv_content?.clearHistory()
        (mDataBinding.root as ViewGroup).removeView(wv_content)
        wv_content?.destroy()
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
            mUrl = request?.url?.toString() ?: ""
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
            include_title_bar.iv_back.setImageResource(R.drawable.ic_cancel)
            pb_progress.visibility = VISIBLE
            if (mFirstLoad) {
                mFirstLoad = false
                mLoadService?.showCallback(LoadingCallback::class.java)
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
            include_title_bar.iv_back.setImageResource(R.drawable.ic_back)
            pb_progress.visibility = GONE
            mLoadService?.showSuccess()
            //在 HTML 标签加载完成之后开始加载图片内容
            wv_content?.settings?.blockNetworkImage = false
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
            frame_video.visibility = VISIBLE
            ll_web_view.visibility = GONE
            frame_video.addView(view, MATCH_PARENT, MATCH_PARENT)
        }

        /**
         * Web视频退出全屏时调用
         */
        override fun onHideCustomView() {
            super.onHideCustomView()
            val statusBarView = mDataBinding.root.findViewById<View>(R.id.status_bar_view)

            switchScreenOrientation()
            statusBarView?.setBackgroundResource(R.color.wan_android_theme_color)
            frame_video.visibility = GONE
            ll_web_view.visibility = VISIBLE
            frame_video.removeAllViews()
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
            pb_progress.progress = newProgress
        }

        override fun onReceivedTitle(
            webView: WebView?,
            title: String?
        ) {
            super.onReceivedTitle(webView, title)
            if (!TextUtils.isEmpty(title)) {
                include_title_bar.tv_title.text = title
            }
        }
    }

    /**
     * 图片点击 (HTML调用 原生)
     */
    private inner class JsCallAndroidInterface {

        @JavascriptInterface
        fun imageClick(data: String?) {
            runOnUiThread {
                val dataList: List<ViewOriginalImageItem> = listOf(
                    ViewOriginalImageItem(
                        data ?: ""
                    )
                )

                navigation(
                    activity = this@WebViewActivity,
                    path = ACTIVITY_COMMON_VIEW_ORIGINAL_IMAGE,
                    bundle = Bundle().apply {
                        putString(DATA, serialize(dataList))
                        putInt(CURRENT_POSITION, 0)
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