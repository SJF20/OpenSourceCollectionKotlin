package com.shijingfeng.base.base.activity;

import java.lang.System;

/**
 * Function: 通用的 Activity 基类
 * Date: 2020/3/21 10:48
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0004J\b\u00103\u001a\u000200H\u0002J\u0012\u00104\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0014J\b\u00107\u001a\u000200H\u0014J\b\u00108\u001a\u000200H\u0014J\b\u00109\u001a\u000200H\u0014J\b\u0010:\u001a\u000200H\u0004J\b\u0010;\u001a\u000200H\u0004J\u0010\u0010<\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0014J\u0012\u0010?\u001a\u0002002\b\u0010@\u001a\u0004\u0018\u00010\u000fH\u0004J\u0010\u0010A\u001a\u0002002\u0006\u0010=\u001a\u00020>H\u0014R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006B"}, d2 = {"Lcom/shijingfeng/base/base/activity/BaseNormalActivity;", "Lcom/shijingfeng/base/base/activity/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mCameraTempFilePath", "", "getMCameraTempFilePath", "()Ljava/lang/String;", "setMCameraTempFilePath", "(Ljava/lang/String;)V", "mCameraUri", "Landroid/net/Uri;", "getMCameraUri", "()Landroid/net/Uri;", "setMCameraUri", "(Landroid/net/Uri;)V", "mClipTempFilePath", "getMClipTempFilePath", "setMClipTempFilePath", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable$delegate", "Lkotlin/Lazy;", "mLoadService", "Lcom/kingja/loadsir/core/LoadService;", "getMLoadService", "()Lcom/kingja/loadsir/core/LoadService;", "setMLoadService", "(Lcom/kingja/loadsir/core/LoadService;)V", "mRxPermissions", "Lcom/tbruyelle/rxpermissions2/RxPermissions;", "getMRxPermissions", "()Lcom/tbruyelle/rxpermissions2/RxPermissions;", "setMRxPermissions", "(Lcom/tbruyelle/rxpermissions2/RxPermissions;)V", "mSmartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMSmartRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMSmartRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "addDisposable", "", "disposable", "Lio/reactivex/disposables/Disposable;", "clearDisposable", "init", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onDestroy", "onStart", "openCamera", "openPhoto", "showCallback", "status", "", "startImageClip", "data", "updateRefreshLoadMoreStatus", "base_release"})
public abstract class BaseNormalActivity extends com.shijingfeng.base.base.activity.BaseActivity implements kotlinx.coroutines.CoroutineScope {
    
    /**
     * Disposable容器
     */
    private final kotlin.Lazy mCompositeDisposable$delegate = null;
    
    /**
     * LoadSir
     */
    @org.jetbrains.annotations.Nullable()
    private com.kingja.loadsir.core.LoadService<?> mLoadService;
    
    /**
     * SmartRefresh
     */
    @org.jetbrains.annotations.Nullable()
    private com.scwang.smartrefresh.layout.SmartRefreshLayout mSmartRefreshLayout;
    
    /**
     * RxPermission (响应式权限申请框架)
     */
    @org.jetbrains.annotations.Nullable()
    private com.tbruyelle.rxpermissions2.RxPermissions mRxPermissions;
    
    /**
     * 相机Uri
     */
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri mCameraUri;
    
    /**
     * 相机图片缓存文件地址
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mCameraTempFilePath = "";
    
    /**
     * 裁剪图片缓存文件地址
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mClipTempFilePath = "";
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Disposable容器
     */
    private final io.reactivex.disposables.CompositeDisposable getMCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final com.kingja.loadsir.core.LoadService<?> getMLoadService() {
        return null;
    }
    
    protected final void setMLoadService(@org.jetbrains.annotations.Nullable()
    com.kingja.loadsir.core.LoadService<?> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final com.scwang.smartrefresh.layout.SmartRefreshLayout getMSmartRefreshLayout() {
        return null;
    }
    
    protected final void setMSmartRefreshLayout(@org.jetbrains.annotations.Nullable()
    com.scwang.smartrefresh.layout.SmartRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final com.tbruyelle.rxpermissions2.RxPermissions getMRxPermissions() {
        return null;
    }
    
    protected final void setMRxPermissions(@org.jetbrains.annotations.Nullable()
    com.tbruyelle.rxpermissions2.RxPermissions p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.net.Uri getMCameraUri() {
        return null;
    }
    
    protected final void setMCameraUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getMCameraTempFilePath() {
        return null;
    }
    
    protected final void setMCameraTempFilePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getMClipTempFilePath() {
        return null;
    }
    
    protected final void setMClipTempFilePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 初始化
     * @param savedInstanceState Activity重启 携带的Bundle数据
     */
    @java.lang.Override()
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Activity处于前台且完全可见
     */
    @java.lang.Override()
    protected void onStart() {
    }
    
    /**
     * 初始化数据
     */
    @java.lang.Override()
    protected void initData() {
    }
    
    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    protected void showCallback(@com.shijingfeng.base.annotation.define.LoadServiceStatus()
    int status) {
    }
    
    /**
     * 更新 下拉刷新，上拉加载 状态
     * @param status 下拉刷新 或 上拉加载 状态  默认: [REFRESH_SUCCESS]
     */
    protected void updateRefreshLoadMoreStatus(@com.shijingfeng.base.annotation.define.RefreshLoadMoreStatus()
    int status) {
    }
    
    /**
     * 打开相机
     */
    protected final void openCamera() {
    }
    
    /**
     * 打开相册
     */
    protected final void openPhoto() {
    }
    
    /**
     * 对图片进行裁剪
     *
     * @param data 原始图片URI
     */
    protected final void startImageClip(@org.jetbrains.annotations.Nullable()
    android.net.Uri data) {
    }
    
    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    protected final void addDisposable(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable disposable) {
    }
    
    /**
     * 清空Disposable
     */
    private final void clearDisposable() {
    }
    
    /**
     * Activity销毁回调
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public BaseNormalActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
}