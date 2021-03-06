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
import com.shijingfeng.tencent_x5.entity.event.X5InitedEvent
import com.shijingfeng.base.util.getStatusBarHeight
import com.shijingfeng.base.util.serialize
import com.shijingfeng.base.util.shareText
import com.shijingfeng.base.widget.dialog.CommonDialog
import com.shijingfeng.view_original_image.entity.ViewOriginalImageItem
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

/** TitleBar ?????? ??? ?????? ????????????????????? */
private val TITLE_BAR_VISIBILITY_SCROLL_DISTANCE = TITLE_BAR_HEIGHT * 3

/**
 * Function: WebView?????? Activity
 * Date: 2020/3/13 20:05
 * Description:
 * Author: ShiJingFeng
 */
@BindEventBus
@Route(path = ACTIVITY_WAN_ANDROID_WEB_VIEW)
internal class WebViewActivity : WanAndroidBaseActivity<ActivityWanAndroidWebViewBinding, WebViewViewModel>() {

    /** ?????????????????????  */
    private var mFirstLoad = false

    /** ??????????????????  */
    private var mLoading = false

    /** ?????????????????????  */
    private var mIsTitleBarVisible = false

    /** ????????????????????????  */
    private var mAnimLoadFinish = false

    /** WebView Y??????????????? [SCROLL_TO_DOWN] */
    private var mYScrollDirection = 0

    /** WebView Y???????????????  */
    private var mYScrollDistance = 0

    /** ?????? Dialog  */
    private var mMoreDialog: CommonDialog? = null
    /** ?????? Dialog Content View */
    private lateinit var mMoreDialogContentView: View

    /**
     * ????????????ID
     *
     * @return ??????ID
     */
    override fun getLayoutId() = R.layout.activity_wan_android_web_view

    /**
     * ??????ViewModel
     * @return ViewModel
     */
    override fun getViewModel() = createViewModel(WebViewViewModel::class.java)

    /**
     * ????????? DataBinding ??????ID ??? ??????????????? Map
     * @return DataBinding ??????SparseArray
     */
    override fun getVariableSparseArray() = SparseArray<Any>().apply {
        put(BR.webViewViewModel, mViewModel)
    }

    /**
     * ???????????????
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
     * ???????????????
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
     * ????????? ??????X5 WebView
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
     * ???????????????
     */
    override fun initAction() {
        super.initAction()
        //?????? ??? ????????????
        ClickUtils.applySingleDebouncing(mDataBinding.includeTitleBar.ivBack) {
            if (mLoading) {
                mDataBinding.wvContent.stopLoading()
            } else {
                finish()
            }
        }
        //?????? ?????? Dialog
        ClickUtils.applySingleDebouncing(mDataBinding.includeTitleBar.ivOperate) { showMoreDialog() }
        //WebView???????????????
        mDataBinding.wvContent.setCustomOnScrollChangeListener { _, _, newScrollY, _, oldScrollY ->
            if (newScrollY > oldScrollY) {
                //???????????????????????????????????????????????????????????????
                if (mYScrollDirection == SCROLL_TO_DOWN) {
                    //??????????????????
                    mYScrollDistance += (newScrollY - oldScrollY)
                    if (mYScrollDistance >= TITLE_BAR_VISIBILITY_SCROLL_DISTANCE && mIsTitleBarVisible) {
                        //???????????????
                        hideTitleBar()
                    }
                } else {
                    mYScrollDistance = newScrollY - oldScrollY
                    mYScrollDirection =
                        SCROLL_TO_DOWN
                }
            } else if (newScrollY < oldScrollY) {
                //???????????????????????????????????????????????????????????????
                if (mYScrollDirection == SCROLL_TO_UP) {
                    //??????????????????
                    mYScrollDistance += (oldScrollY - newScrollY)
                    if (mYScrollDistance >= TITLE_BAR_VISIBILITY_SCROLL_DISTANCE && !mIsTitleBarVisible) {
                        //???????????????
                        showTitleBar()
                    }
                } else {
                    mYScrollDistance = oldScrollY - newScrollY
                    mYScrollDirection =
                        SCROLL_TO_UP
                }
            }
        }
        // JS????????????
        initJavascriptInterfaces()
    }

    /**
     * ????????? JavaScript Interface
     */
    private fun initJavascriptInterfaces() {
        //???????????? js ??????
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
     * ???????????????
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
     * ???????????????
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
     * ?????? ?????? Dialog
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

        //??????
        mMoreDialog?.setOnDismissListener {}
        //??????
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_reload)
        ) {
            mMoreDialog?.hide()
            mDataBinding.wvContent.reload()
        }
        //??????
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_share)
        ) {
            mMoreDialog?.hide()
            shareText(this, mViewModel?.mTitle, mViewModel?.mUrl)
        }
        //??????
        ClickUtils.applySingleDebouncing(
            mMoreDialogContentView.findViewById<TextView>(R.id.tv_collection)
        ) {
            mMoreDialog?.hide()
            mViewModel?.collectedWebsite(HashMap<String, Any>(2).apply {
                put("name", mViewModel?.mTitle ?: "")
                put("link", mViewModel?.mUrl ?: "")
            })
        }
        //?????????????????????
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
     * ?????????????????????????????????Js
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
     * ??????????????????
     */
    private fun switchScreenOrientation() {
        val currentOrientation = this.resources.configuration.orientation

        if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
            //???????????????
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        } else if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            //???????????????
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    /**
     * X5 ????????????????????? Event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun getX5InitedEvent(event: X5InitedEvent) {
        mDataBinding.wvContent.reload()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            // ??????
            KeyEvent.KEYCODE_BACK -> if (mMoreDialog != null && mMoreDialog!!.isShowing) {
                mMoreDialog?.hide()
                return true
            } else if (mDataBinding.wvContent.canGoBack()) {
                mDataBinding.wvContent.goBack()
                return true
            }
            // ??????
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
     * ?????? WebClient
     */
    private inner class CustomWebViewClient : WebViewClient() {

        /**
         * ????????????
         * @param view WebView
         * @param request WebResourceRequest
         * @return true: ??????????????????????????? false: ????????????????????????
         */
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean {
            mViewModel?.mUrl = request?.url?.toString() ?: ""
            return false
        }

        /**
         * ??????????????????
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
         * ??????????????????
         * @param view WebView
         * @param url mUrl
         */
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            mLoading = false
            mDataBinding.includeTitleBar.ivBack.setImageResource(R.drawable.ic_wan_android_back)
            mDataBinding.pbProgress.visibility = GONE
            showCallback(LOAD_SERVICE_SUCCESS)
            //??? HTML ????????????????????????????????????????????????
            mDataBinding.wvContent.settings.blockNetworkImage = false
            //????????????????????? js ??????
            addImageClickJs()
        }

        /**
         * ???????????????????????????Web????????????????????????????????????????????????????????????????????????(6.0??????)
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
         * ???????????????????????????Web????????????????????????????????????????????????????????????????????????(6.0??????)
         * @param webView WebView
         * @param errorCode ???????????????
         * @param description ????????????
         * @param failingUrl ??????URL
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
     * ?????? WebChromeClient
     */
    private inner class CustomWebChromeClient : WebChromeClient() {

        /**
         * ?????? Web???????????? View
         * @return Web???????????? View
         */
        override fun getVideoLoadingProgressView(): View {
            return super.getVideoLoadingProgressView()
        }

        /**
         * Web?????????????????????
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
         * Web???????????????????????????
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
         * WebView???????????????????????????
         * @param webView WebView
         * @param valueCallback ValueCallback
         * @param fileChooserParams FileChooserParams
         * @return true: ????????????  false: ???????????????
         */
        override fun onShowFileChooser(
            webView: WebView?,
            valueCallback: ValueCallback<Array<Uri?>?>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams)
        }

        /**
         * ??????????????????
         * @param view WebView
         * @param newProgress ????????????
         */
        override fun onProgressChanged(
            view: WebView?,
            newProgress: Int
        ) {
            super.onProgressChanged(view, newProgress)
            mDataBinding.pbProgress.progress = newProgress
        }

        /**
         * ??????????????????
         * @param webView WebView
         * @param title ??????
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
     * ???????????? (Js ?????? ?????? ??????)
     */
    private inner class ImageClickInterface {

        /**
         * ??????????????????
         * @param clickImageSrc ????????????
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