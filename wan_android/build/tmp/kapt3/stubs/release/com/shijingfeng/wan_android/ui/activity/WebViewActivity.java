package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: WebView容器 Activity
 * Date: 2020/3/13 20:05
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/WebViewActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003*+,B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0014J\b\u0010\u001d\u001a\u00020\u0012H\u0014J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0012H\u0014J\b\u0010 \u001a\u00020\u0012H\u0002J\b\u0010!\u001a\u00020\u0012H\u0014J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0012H\u0015J\b\u0010&\u001a\u00020\u0012H\u0014J\b\u0010\'\u001a\u00020\u0012H\u0003J\b\u0010(\u001a\u00020\u0012H\u0002J\b\u0010)\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidWebViewBinding;", "Lcom/shijingfeng/wan_android/view_model/WebViewViewModel;", "()V", "mAnimLoadFinish", "", "mFirstLoad", "mIsTitleBarVisible", "mLoading", "mMoreDialog", "Lcom/shijingfeng/base/widget/dialog/CommonDialog;", "mMoreDialogContentView", "Landroid/view/View;", "mYScrollDirection", "", "mYScrollDistance", "addImageClickJs", "", "getLayoutId", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "getX5InitedEvent", "event", "Lcom/shijingfeng/base/entity/event/event_bus/X5InitedEvent;", "hideTitleBar", "initAction", "initData", "initJavascriptInterfaces", "initParam", "initX5WebView", "onDestroy", "onKeyDown", "keyCode", "Landroid/view/KeyEvent;", "onStart", "onStop", "showMoreDialog", "showTitleBar", "switchScreenOrientation", "CustomWebChromeClient", "CustomWebViewClient", "ImageClickInterface", "wan_android_release"})
@com.shijingfeng.base.annotation.BindEventBus()
public final class WebViewActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidWebViewBinding, com.shijingfeng.wan_android.view_model.WebViewViewModel> {
    
    /**
     * 第一次加载网页
     */
    private boolean mFirstLoad = false;
    
    /**
     * 是否正在加载
     */
    private boolean mLoading = false;
    
    /**
     * 标题栏是否可见
     */
    private boolean mIsTitleBarVisible = false;
    
    /**
     * 动画是否加载完成
     */
    private boolean mAnimLoadFinish = false;
    
    /**
     * WebView Y轴滑动方向 [com.shijingfeng.wan_android.constant.SCROLL_TO_DOWN]
     */
    private int mYScrollDirection = 0;
    
    /**
     * WebView Y轴滑动距离
     */
    private int mYScrollDistance = 0;
    
    /**
     * 更多 Dialog
     */
    private com.shijingfeng.base.widget.dialog.CommonDialog mMoreDialog;
    
    /**
     * 更多 Dialog Content View
     */
    private android.view.View mMoreDialogContentView;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    @java.lang.Override()
    protected int getLayoutId() {
        return 0;
    }
    
    /**
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.WebViewViewModel getViewModel() {
        return null;
    }
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.util.SparseArray<java.lang.Object> getVariableSparseArray() {
        return null;
    }
    
    /**
     * 初始化参数
     */
    @java.lang.Override()
    protected void initParam() {
    }
    
    /**
     * 初始化数据
     */
    @java.lang.Override()
    protected void initData() {
    }
    
    /**
     * 初始化 腾讯X5 WebView
     */
    private final void initX5WebView() {
    }
    
    /**
     * 初始化事件
     */
    @java.lang.Override()
    protected void initAction() {
    }
    
    /**
     * 初始化 JavaScript Interface
     */
    private final void initJavascriptInterfaces() {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    /**
     * 显示标题栏
     */
    private final void showTitleBar() {
    }
    
    /**
     * 隐藏标题栏
     */
    private final void hideTitleBar() {
    }
    
    /**
     * 显示 更多 Dialog
     */
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void showMoreDialog() {
    }
    
    /**
     * 在源网页中添加图片点击Js
     */
    private final void addImageClickJs() {
    }
    
    /**
     * 切换屏幕方向
     */
    private final void switchScreenOrientation() {
    }
    
    /**
     * X5 内核初始化完毕 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getX5InitedEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.entity.event.event_bus.X5InitedEvent event) {
    }
    
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public WebViewActivity() {
        super();
    }
    
    /**
     * 通用 WebClient
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J.\u0010\f\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity$CustomWebViewClient;", "Lcom/tencent/smtt/sdk/WebViewClient;", "(Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity;)V", "onPageFinished", "", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Lcom/tencent/smtt/export/external/interfaces/WebResourceRequest;", "error", "Lcom/tencent/smtt/export/external/interfaces/WebResourceError;", "webView", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "", "wan_android_release"})
    final class CustomWebViewClient extends com.tencent.smtt.sdk.WebViewClient {
        
        /**
         * 网页拦截
         * @param view WebView
         * @param request WebResourceRequest
         * @return true: 拦截，不往下执行， false: 不拦截，继续执行
         */
        @java.lang.Override()
        public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView view, @org.jetbrains.annotations.Nullable()
        com.tencent.smtt.export.external.interfaces.WebResourceRequest request) {
            return false;
        }
        
        /**
         * 页面加载开始
         * @param view WebView
         * @param url mUrl
         * @param favicon Bitmap
         */
        @java.lang.Override()
        public void onPageStarted(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView view, @org.jetbrains.annotations.Nullable()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        android.graphics.Bitmap favicon) {
        }
        
        /**
         * 页面加载完成
         * @param view WebView
         * @param url mUrl
         */
        @java.lang.Override()
        public void onPageFinished(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView view, @org.jetbrains.annotations.Nullable()
        java.lang.String url) {
        }
        
        /**
         * 向主机应用程序报告Web资源加载错误。这些错误通常表明无法连接到服务器。(6.0之后)
         * @param view WebView
         * @param request WebResourceRequest
         * @param error WebResourceError
         */
        @java.lang.Override()
        public void onReceivedError(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView view, @org.jetbrains.annotations.Nullable()
        com.tencent.smtt.export.external.interfaces.WebResourceRequest request, @org.jetbrains.annotations.Nullable()
        com.tencent.smtt.export.external.interfaces.WebResourceError error) {
        }
        
        /**
         * 向主机应用程序报告Web资源加载错误。这些错误通常表明无法连接到服务器。(6.0之前)
         * @param webView WebView
         * @param errorCode 错误代码号
         * @param description 错误描述
         * @param failingUrl 失败URL
         */
        @java.lang.Override()
        public void onReceivedError(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView webView, int errorCode, @org.jetbrains.annotations.Nullable()
        java.lang.String description, @org.jetbrains.annotations.Nullable()
        java.lang.String failingUrl) {
        }
        
        public CustomWebViewClient() {
            super();
        }
    }
    
    /**
     * 通用 WebChromeClient
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J6\u0010\u0013\u001a\u00020\u00142\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0018\u0010\u0015\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity$CustomWebChromeClient;", "Lcom/tencent/smtt/sdk/WebChromeClient;", "(Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity;)V", "getVideoLoadingProgressView", "Landroid/view/View;", "onHideCustomView", "", "onProgressChanged", "view", "Lcom/tencent/smtt/sdk/WebView;", "newProgress", "", "onReceivedTitle", "webView", "title", "", "onShowCustomView", "customViewCallback", "Lcom/tencent/smtt/export/external/interfaces/IX5WebChromeClient$CustomViewCallback;", "onShowFileChooser", "", "valueCallback", "Lcom/tencent/smtt/sdk/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Lcom/tencent/smtt/sdk/WebChromeClient$FileChooserParams;", "wan_android_release"})
    final class CustomWebChromeClient extends com.tencent.smtt.sdk.WebChromeClient {
        
        /**
         * 获取 Web视频进度 View
         * @return Web视频进度 View
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.view.View getVideoLoadingProgressView() {
            return null;
        }
        
        /**
         * Web视频全屏时调用
         * @param view View
         * @param customViewCallback CustomViewCallback
         */
        @java.lang.Override()
        public void onShowCustomView(@org.jetbrains.annotations.Nullable()
        android.view.View view, @org.jetbrains.annotations.Nullable()
        com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback customViewCallback) {
        }
        
        /**
         * Web视频退出全屏时调用
         */
        @java.lang.Override()
        public void onHideCustomView() {
        }
        
        /**
         * WebView调用本地文件选择器
         * @param webView WebView
         * @param valueCallback ValueCallback
         * @param fileChooserParams FileChooserParams
         * @return true: 消费事件  false: 不消费事件
         */
        @java.lang.Override()
        public boolean onShowFileChooser(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView webView, @org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.ValueCallback<android.net.Uri[]> valueCallback, @org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebChromeClient.FileChooserParams fileChooserParams) {
            return false;
        }
        
        /**
         * 页面加载进度
         * @param view WebView
         * @param newProgress 加载进度
         */
        @java.lang.Override()
        public void onProgressChanged(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView view, int newProgress) {
        }
        
        /**
         * 标题接收回调
         * @param webView WebView
         * @param title 标题
         */
        @java.lang.Override()
        public void onReceivedTitle(@org.jetbrains.annotations.Nullable()
        com.tencent.smtt.sdk.WebView webView, @org.jetbrains.annotations.Nullable()
        java.lang.String title) {
        }
        
        public CustomWebChromeClient() {
            super();
        }
    }
    
    /**
     * 图片操作 (Js 调用 原生 接口)
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\'\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity$ImageClickInterface;", "", "(Lcom/shijingfeng/wan_android/ui/activity/WebViewActivity;)V", "imageClick", "", "clickImageSrc", "", "imageSrcArray", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "wan_android_release"})
    final class ImageClickInterface {
        
        /**
         * 图片点击回调
         * @param clickImageSrc 图片地址
         */
        @android.webkit.JavascriptInterface()
        public final void imageClick(@org.jetbrains.annotations.Nullable()
        java.lang.String clickImageSrc, @org.jetbrains.annotations.Nullable()
        java.lang.String[] imageSrcArray) {
        }
        
        public ImageClickInterface() {
            super();
        }
    }
}