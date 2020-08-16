package com.shijingfeng.base.base.fragment;

import java.lang.System;

/**
 * Function: Fragment 基类
 * Date: 2020/3/21 13:25
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010V\u001a\u00020?2\u0006\u0010W\u001a\u00020XH\u0004J\b\u0010Y\u001a\u00020?H\u0002J\b\u0010Z\u001a\u00020<H$J\n\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\b\u0010]\u001a\u00020<H\u0015J\u0014\u0010^\u001a\u00020?2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010 H\u0014J\b\u0010`\u001a\u00020?H\u0014J\b\u0010a\u001a\u00020?H\u0014J\b\u0010b\u001a\u00020?H\u0014J\b\u0010c\u001a\u00020?H\u0002J\b\u0010d\u001a\u00020&H\u0014J\b\u0010e\u001a\u00020&H\u0014J\b\u0010f\u001a\u00020&H\u0014J\b\u0010g\u001a\u00020&H\u0016J&\u0010h\u001a\u0004\u0018\u0001062\u0006\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010_\u001a\u0004\u0018\u00010 H\u0016J\b\u0010m\u001a\u00020?H\u0016J\b\u0010n\u001a\u00020?H\u0016J\u001a\u0010o\u001a\u00020&2\u0006\u0010p\u001a\u00020<2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\b\u0010s\u001a\u00020?H\u0016J\b\u0010t\u001a\u00020?H\u0016J\u0018\u0010u\u001a\u00020?2\u0006\u00109\u001a\u0002062\b\u0010_\u001a\u0004\u0018\u00010 J\b\u0010v\u001a\u00020?H\u0004J\b\u0010w\u001a\u00020?H\u0004Jt\u0010x\u001a\u00020?2l\u0010y\u001ah\u0012\u0015\u0012\u0013\u0018\u000106\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010:\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020?\u0018\u000105j\u0004\u0018\u0001`@J\u0010\u0010z\u001a\u00020?2\u0006\u0010{\u001a\u00020<H\u0014J+\u0010|\u001a\u00020?2\n\u0010}\u001a\u0006\u0012\u0002\b\u00030~2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010 2\t\b\u0002\u0010\u0080\u0001\u001a\u00020<H\u0004J\u0013\u0010\u0081\u0001\u001a\u00020?2\b\u0010;\u001a\u0004\u0018\u00010\u0011H\u0004J\u0011\u0010\u0082\u0001\u001a\u00020?2\u0006\u0010{\u001a\u00020<H\u0014R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R \u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0080\u0001\u00104\u001ah\u0012\u0015\u0012\u0013\u0018\u000106\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010:\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110<\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(=\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b7\u0012\b\b8\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020?\u0018\u000105j\u0004\u0018\u0001`@X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u000106X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010QX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/shijingfeng/base/base/fragment/BaseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/shijingfeng/base/interfaces/KeyDownMonitor;", "Lcom/shijingfeng/base/interfaces/BackPressMonitor;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "mCameraTempFilePath", "", "getMCameraTempFilePath", "()Ljava/lang/String;", "setMCameraTempFilePath", "(Ljava/lang/String;)V", "mCameraUri", "Landroid/net/Uri;", "getMCameraUri", "()Landroid/net/Uri;", "setMCameraUri", "(Landroid/net/Uri;)V", "mClipTempFilePath", "getMClipTempFilePath", "setMClipTempFilePath", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable$delegate", "Lkotlin/Lazy;", "mDataBundle", "Landroid/os/Bundle;", "getMDataBundle", "()Landroid/os/Bundle;", "setMDataBundle", "(Landroid/os/Bundle;)V", "mHasCreated", "", "getMHasCreated", "()Z", "setMHasCreated", "(Z)V", "mIsVisible", "getMIsVisible", "setMIsVisible", "mLoadService", "Lcom/kingja/loadsir/core/LoadService;", "getMLoadService", "()Lcom/kingja/loadsir/core/LoadService;", "setMLoadService", "(Lcom/kingja/loadsir/core/LoadService;)V", "mOnItemEvent", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "data", "", "position", "flag", "", "Lcom/shijingfeng/base/common/extension/onItemEvent;", "getMOnItemEvent", "()Lkotlin/jvm/functions/Function4;", "setMOnItemEvent", "(Lkotlin/jvm/functions/Function4;)V", "mRootView", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mRxPermissions", "Lcom/tbruyelle/rxpermissions2/RxPermissions;", "getMRxPermissions", "()Lcom/tbruyelle/rxpermissions2/RxPermissions;", "setMRxPermissions", "(Lcom/tbruyelle/rxpermissions2/RxPermissions;)V", "mSmartRefreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "getMSmartRefreshLayout", "()Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "setMSmartRefreshLayout", "(Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;)V", "addDisposable", "disposable", "Lio/reactivex/disposables/Disposable;", "clearDisposable", "getLayoutId", "getStatusBarBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getStatusBarBackgroundResource", "init", "savedInstanceState", "initAction", "initData", "initParam", "initStatusBar", "isEnableLazyLoad", "isSetCustomStatusBar", "isSetStatusBarContentDark", "onBackPressed", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDestroyView", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onViewCreated", "openCamera", "openPhoto", "setOnItemEventListener", "onItemEvent", "showCallback", "status", "startActivity", "cls", "Ljava/lang/Class;", "bundle", "requestCode", "startImageClip", "updateRefreshLoadMoreStatus", "base_debug"})
public abstract class BaseFragment extends androidx.fragment.app.Fragment implements com.shijingfeng.base.interfaces.KeyDownMonitor, com.shijingfeng.base.interfaces.BackPressMonitor, kotlinx.coroutines.CoroutineScope {
    
    /**
     * Disposable容器
     */
    private final kotlin.Lazy mCompositeDisposable$delegate = null;
    
    /**
     * Fragment Root View
     */
    @org.jetbrains.annotations.Nullable()
    private android.view.View mRootView;
    
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
     * 响应式权限请求框架
     */
    @org.jetbrains.annotations.Nullable()
    private com.tbruyelle.rxpermissions2.RxPermissions mRxPermissions;
    
    /**
     * 回调监听器
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> mOnItemEvent;
    
    /**
     * 跳转到 Fragment 携带的数据 或 Fragment重启保存的 Bundle 数据(未来会加上)
     */
    @org.jetbrains.annotations.Nullable()
    private android.os.Bundle mDataBundle;
    
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
    
    /**
     * Fragment View是否已创建完成   true 已创建完成  false 没有创建过 或 没有创建完成
     */
    private boolean mHasCreated = false;
    
    /**
     * 是否可见  true: 可见  false: 不可见
     */
    private boolean mIsVisible = false;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Disposable容器
     */
    private final io.reactivex.disposables.CompositeDisposable getMCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.view.View getMRootView() {
        return null;
    }
    
    protected final void setMRootView(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
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
    protected final kotlin.jvm.functions.Function4<android.view.View, java.lang.Object, java.lang.Integer, java.lang.String, kotlin.Unit> getMOnItemEvent() {
        return null;
    }
    
    protected final void setMOnItemEvent(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.os.Bundle getMDataBundle() {
        return null;
    }
    
    protected final void setMDataBundle(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
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
    
    protected final boolean getMHasCreated() {
        return false;
    }
    
    protected final void setMHasCreated(boolean p0) {
    }
    
    protected final boolean getMIsVisible() {
        return false;
    }
    
    protected final void setMIsVisible(boolean p0) {
    }
    
    /**
     * 创建 Fragment Root View
     * @param inflater LayoutInflater
     * @param container 父View容器
     * @param savedInstanceState Fragment View 重建 保存的Bundle数据
     * @return View
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    /**
     * Fragment View创建完毕回调函数
     * 禁止重载onViewCreated方法进行添加额外的初始化方法
     * 初始化请重载 [init]
     * @param view View
     * @param savedInstanceState 保存的Bundle数据
     */
    @java.lang.Override()
    public final void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 当 Fragment可见时，才执行onResume方法，否则不执行onResume方法 (参考setMaxLifecycle方法) (用于ViewPager懒加载)
     */
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     * @param savedInstanceState Fragment重启携带的 Bundle 数据
     */
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 获取视图ID
     * @return 视图ID
     */
    protected abstract int getLayoutId();
    
    /**
     * 初始化参数
     */
    protected void initParam() {
    }
    
    /**
     * 初始化数据
     */
    protected void initData() {
    }
    
    /**
     * 初始化事件
     */
    protected void initAction() {
    }
    
    /**
     * 初始化状态栏
     */
    private final void initStatusBar() {
    }
    
    /**
     * 是否开启懒加载 (用于ViewPager)
     * @return true 开启  false 关闭  默认关闭
     */
    protected boolean isEnableLazyLoad() {
        return false;
    }
    
    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    protected boolean isSetCustomStatusBar() {
        return false;
    }
    
    /**
     * 是否设置状态栏内容颜色为深色
     * @return true 深色  false 浅色
     */
    protected boolean isSetStatusBarContentDark() {
        return false;
    }
    
    /**
     * 获取 状态栏 背景Drawable (不支持换肤)
     * @return 背景 Drawable
     */
    @org.jetbrains.annotations.Nullable()
    protected android.graphics.drawable.Drawable getStatusBarBackgroundDrawable() {
        return null;
    }
    
    /**
     * 获取 状态栏 背景资源 (支持换肤)
     */
    @androidx.annotation.DrawableRes()
    protected int getStatusBarBackgroundResource() {
        return 0;
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
     * 跳转Activity页面
     * @param cls 要跳转到的页面反射Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    protected final void startActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> cls, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, int requestCode) {
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
     * 设置回调监听器
     * @param onItemEvent 回调监听器
     */
    public final void setOnItemEventListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onItemEvent) {
    }
    
    /**
     * 返回键点击 回调方法
     * @return true Fragment消费处理  false 交由Activity处理
     */
    @java.lang.Override()
    public boolean onBackPressed() {
        return false;
    }
    
    /**
     * 模拟按键 按下监听 回调方法
     * @param keyCode 模拟按键 代码
     * @param event 事件
     * @return  true Fragment消费处理   false 交由Activity处理
     */
    @java.lang.Override()
    public boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event) {
        return false;
    }
    
    /**
     * Fragment View 销毁回调
     */
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    /**
     * Fragment 销毁回调
     */
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
}