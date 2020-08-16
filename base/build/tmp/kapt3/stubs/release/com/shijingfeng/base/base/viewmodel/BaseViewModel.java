package com.shijingfeng.base.base.viewmodel;

import java.lang.System;

/**
 * Function: ViewModel基类
 * Date: 2020/1/17 19:15
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u00020\u00032\u00020\u0004:\u0001^B\u0011\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u000207H\u0002J\u0006\u0010;\u001a\u000207J\u0012\u0010<\u001a\u0002072\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>J\u0006\u0010?\u001a\u000207J\u0006\u0010@\u001a\u00020\bJ\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c0\"J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0\"J\u0006\u0010C\u001a\u000207J\b\u0010D\u001a\u000207H\u0016J<\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\'2\b\b\u0002\u0010I\u001a\u00020\u001c2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KJ\b\u0010L\u001a\u000207H\u0014J\u0010\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020OH\u0016J\b\u0010P\u001a\u000207H\u0002J\u001a\u0010Q\u001a\u0002072\u0006\u0010R\u001a\u00020\u001c2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010TJ\u000e\u0010U\u001a\u0002072\u0006\u0010V\u001a\u00020\u001cJ\u0012\u0010W\u001a\u0002072\n\b\u0002\u0010X\u001a\u0004\u0018\u00010GJ(\u0010Y\u001a\u0002072\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030[2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\'2\b\b\u0002\u0010I\u001a\u00020\u001cJ\b\u0010\\\u001a\u000207H\u0002J\u000e\u0010]\u001a\u0002072\u0006\u0010V\u001a\u00020\u001cR\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R!\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010\f\u001a\u0004\b0\u0010$R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u00105\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0006\u00a8\u0006_"}, d2 = {"Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "R", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "mRepository", "(Lcom/shijingfeng/base/base/repository/BaseRepository;)V", "mCommonEventManager", "Lcom/shijingfeng/base/base/viewmodel/BaseViewModel$CommonEventManager;", "getMCommonEventManager", "()Lcom/shijingfeng/base/base/viewmodel/BaseViewModel$CommonEventManager;", "mCommonEventManager$delegate", "Lkotlin/Lazy;", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable$delegate", "mExitApp", "", "getMExitApp", "()Z", "setMExitApp", "(Z)V", "mHasInited", "getMHasInited", "setMHasInited", "mLoadServiceStatus", "", "getMLoadServiceStatus", "()I", "setMLoadServiceStatus", "(I)V", "mLoadServiceStatusEvent", "Landroidx/lifecycle/MutableLiveData;", "getMLoadServiceStatusEvent", "()Landroidx/lifecycle/MutableLiveData;", "mLoadServiceStatusEvent$delegate", "mParamBundle", "Landroid/os/Bundle;", "getMParamBundle", "()Landroid/os/Bundle;", "setMParamBundle", "(Landroid/os/Bundle;)V", "mRefreshLoadMoreStatus", "getMRefreshLoadMoreStatus", "setMRefreshLoadMoreStatus", "mRefreshLoadMoreStatusEvent", "getMRefreshLoadMoreStatusEvent", "mRefreshLoadMoreStatusEvent$delegate", "getMRepository", "()Lcom/shijingfeng/base/base/repository/BaseRepository;", "setMRepository", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "addDisposable", "", "disposable", "Lio/reactivex/disposables/Disposable;", "clearDisposable", "doubleDownExitApp", "finish", "animSparseArray", "Landroid/util/SparseIntArray;", "finishNoAnim", "getCommonEventManager", "getLoadServiceStatusEvent", "getRefreshLoadMoreStatusEvent", "hideLoadingDialog", "init", "navigation", "path", "", "bundle", "requestCode", "callback", "Lcom/alibaba/android/arouter/facade/callback/NavigationCallback;", "onCleared", "onCreate", "owner", "Landroidx/lifecycle/LifecycleOwner;", "registerEventBus", "setResult", "resultCode", "data", "Landroid/content/Intent;", "showCallback", "status", "showLoadingDialog", "hint", "startActivity", "cls", "Ljava/lang/Class;", "unregisterEventBus", "updateRefreshLoadMoreStatus", "CommonEventManager", "base_release"})
public abstract class BaseViewModel<R extends com.shijingfeng.base.base.repository.BaseRepository<?, ?>> extends androidx.lifecycle.ViewModel implements androidx.lifecycle.DefaultLifecycleObserver {
    
    /**
     * 常用的 LiveData Event 管理器
     */
    private final kotlin.Lazy mCommonEventManager$delegate = null;
    
    /**
     * LoadService 状态 LiveData Event
     */
    private final kotlin.Lazy mLoadServiceStatusEvent$delegate = null;
    
    /**
     * 刷新 或 上拉加载 状态 LiveData Event
     */
    private final kotlin.Lazy mRefreshLoadMoreStatusEvent$delegate = null;
    
    /**
     * Disposable容器
     */
    private final kotlin.Lazy mCompositeDisposable$delegate = null;
    
    /**
     * 页面跳转携带的数据Bundle (注意: 和 Activity 或 Fragment 的 mDataBundle 做区分, mDataBundle随着 Activity重启 或 Fragment重启 会改变)
     */
    @org.jetbrains.annotations.Nullable()
    private android.os.Bundle mParamBundle;
    
    /**
     * LoadSir 状态
     */
    @com.shijingfeng.base.annotation.define.LoadServiceStatus()
    private int mLoadServiceStatus = 0;
    
    /**
     * 下拉刷新 或 上拉加载 状态
     */
    @com.shijingfeng.base.annotation.define.RefreshLoadMoreStatus()
    private int mRefreshLoadMoreStatus = 0;
    
    /**
     * 连续双击退出应用
     */
    private boolean mExitApp = false;
    
    /**
     * 是否已经初始化  true 已经初始化  false 没有初始化
     */
    private boolean mHasInited = false;
    @org.jetbrains.annotations.Nullable()
    private R mRepository;
    
    /**
     * 常用的 LiveData Event 管理器
     */
    private final com.shijingfeng.base.base.viewmodel.BaseViewModel.CommonEventManager getMCommonEventManager() {
        return null;
    }
    
    /**
     * LoadService 状态 LiveData Event
     */
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> getMLoadServiceStatusEvent() {
        return null;
    }
    
    /**
     * 刷新 或 上拉加载 状态 LiveData Event
     */
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> getMRefreshLoadMoreStatusEvent() {
        return null;
    }
    
    /**
     * Disposable容器
     */
    private final io.reactivex.disposables.CompositeDisposable getMCompositeDisposable() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.Bundle getMParamBundle() {
        return null;
    }
    
    public final void setMParamBundle(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    public final int getMLoadServiceStatus() {
        return 0;
    }
    
    public final void setMLoadServiceStatus(int p0) {
    }
    
    public final int getMRefreshLoadMoreStatus() {
        return 0;
    }
    
    public final void setMRefreshLoadMoreStatus(int p0) {
    }
    
    protected final boolean getMExitApp() {
        return false;
    }
    
    protected final void setMExitApp(boolean p0) {
    }
    
    public final boolean getMHasInited() {
        return false;
    }
    
    public final void setMHasInited(boolean p0) {
    }
    
    /**
     * 注册EventBus
     */
    private final void registerEventBus() {
    }
    
    /**
     * 解注册EventBus
     */
    private final void unregisterEventBus() {
    }
    
    /**
     * 获取 常用的 LiveData Event 管理器
     * @return U常用的 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.base.viewmodel.BaseViewModel.CommonEventManager getCommonEventManager() {
        return null;
    }
    
    /**
     * 获取 LoadService 状态 SingleLiveEvent
     * @return LoadService 状态 SingleLiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getLoadServiceStatusEvent() {
        return null;
    }
    
    /**
     * 获取 刷新 或 上拉加载 状态 SingleLiveEvent
     * @return 刷新 或 上拉加载 状态 SingleLiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getRefreshLoadMoreStatusEvent() {
        return null;
    }
    
    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    public final void showCallback(@com.shijingfeng.base.annotation.define.LoadServiceStatus()
    int status) {
    }
    
    /**
     * 更新 下拉刷新，上拉加载 状态
     * @param status 下拉刷新 或 上拉加载 状态 {@link com.zjn.transport.constant.StatusConstant#REFRESH_SUCCESS}
     */
    public final void updateRefreshLoadMoreStatus(@com.shijingfeng.base.annotation.define.RefreshLoadMoreStatus()
    int status) {
    }
    
    /**
     * 显示加载中Dialog
     * @param hint 提示文本  null: 默认提示 (提交中...)
     */
    public final void showLoadingDialog(@org.jetbrains.annotations.Nullable()
    java.lang.String hint) {
    }
    
    /**
     * 隐藏加载中Dialog
     */
    public final void hideLoadingDialog() {
    }
    
    /**
     * 通过Class跳转界面
     * @param cls 要跳转到的页面的Class
     * @param bundle 携带的数据
     * @param requestCode 请求码
     */
    public final void startActivity(@org.jetbrains.annotations.NotNull()
    java.lang.Class<?> cls, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, int requestCode) {
    }
    
    /**
     * 跳到指定路径页面
     * @param path 路径
     * @param bundle 携带的数据
     * @param requestCode 请求码
     * @param animSparseArray Activity切换动画, Key: KEY_ENTER_ANIM, KEY_EXIT_ANIM
     * @param callback 跳转回调
     */
    public final void navigation(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, int requestCode, @org.jetbrains.annotations.Nullable()
    android.util.SparseIntArray animSparseArray, @org.jetbrains.annotations.Nullable()
    com.alibaba.android.arouter.facade.callback.NavigationCallback callback) {
    }
    
    /**
     * 销毁Activity (系统动画 或 全局动画(style中设置))
     * @param animSparseArray key: KEY_ENTER_ANIM(进入动画), KEY_EXIT_ANIM(退出动画)
     */
    public final void finish(@org.jetbrains.annotations.Nullable()
    android.util.SparseIntArray animSparseArray) {
    }
    
    /**
     * 销毁Activity (没有动画)
     */
    public final void finishNoAnim() {
    }
    
    /**
     * 设置返回响应
     * @param resultCode 返回响应码
     * @param data 返回响应数据
     */
    public final void setResult(int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    /**
     * 添加Disposable
     * @param disposable Disposable
     */
    public final void addDisposable(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable disposable) {
    }
    
    /**
     * 清空Disposable
     */
    private final void clearDisposable() {
    }
    
    /**
     * 指定间隔时间内 按下两次返回键退出App
     */
    public final void doubleDownExitApp() {
    }
    
    /**
     * ViewModel销毁回调
     */
    @java.lang.Override()
    protected void onCleared() {
    }
    
    /**
     * 初始化
     */
    public void init() {
    }
    
    /**
     * 会在 Activity 的 onCreate 方法完全执行完后执行
     */
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final R getMRepository() {
        return null;
    }
    
    protected final void setMRepository(@org.jetbrains.annotations.Nullable()
    R p0) {
    }
    
    public BaseViewModel(@org.jetbrains.annotations.Nullable()
    R mRepository) {
        super();
    }
    
    public BaseViewModel() {
        super();
    }
    
    /**
     * 常用的 LiveData Event 管理器
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004J\u000e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004J\u0014\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004J\u0014\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004J\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0004J\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u0004R)\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R#\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R)\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R)\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R#\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0018\u0010\u0007R)\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001b\u0010\u0007\u00a8\u0006#"}, d2 = {"Lcom/shijingfeng/base/base/viewmodel/BaseViewModel$CommonEventManager;", "", "()V", "mFinishEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Landroid/util/SparseArray;", "getMFinishEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mFinishEvent$delegate", "Lkotlin/Lazy;", "mFinishNoAnimEvent", "getMFinishNoAnimEvent", "mFinishNoAnimEvent$delegate", "mHideLoadingDialogEvent", "getMHideLoadingDialogEvent", "mHideLoadingDialogEvent$delegate", "mNavigationEvent", "getMNavigationEvent", "mNavigationEvent$delegate", "mSetResultEvent", "getMSetResultEvent", "mSetResultEvent$delegate", "mShowLoadingDialogEvent", "", "getMShowLoadingDialogEvent", "mShowLoadingDialogEvent$delegate", "mStartActivityEvent", "getMStartActivityEvent", "mStartActivityEvent$delegate", "getFinishEvent", "getHideLoadingDialogEvent", "getNavigationEvent", "getSetResultEvent", "getShowLoadingDialogEvent", "getStartActivityEvent", "base_release"})
    public static final class CommonEventManager {
        
        /**
         * 显示加载中 Dialog
         */
        private final kotlin.Lazy mShowLoadingDialogEvent$delegate = null;
        
        /**
         * 隐藏加载中 Dialog
         */
        private final kotlin.Lazy mHideLoadingDialogEvent$delegate = null;
        
        /**
         * 跳转 Activity
         */
        private final kotlin.Lazy mStartActivityEvent$delegate = null;
        
        /**
         * 页面跳转
         */
        private final kotlin.Lazy mNavigationEvent$delegate = null;
        
        /**
         * 关闭 Activity
         */
        private final kotlin.Lazy mFinishEvent$delegate = null;
        
        /**
         * 关闭 Activity (没有动画)
         */
        private final kotlin.Lazy mFinishNoAnimEvent$delegate = null;
        
        /**
         * Activity setResult设置返回响应
         */
        private final kotlin.Lazy mSetResultEvent$delegate = null;
        
        /**
         * 显示加载中 Dialog
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.String> getMShowLoadingDialogEvent() {
            return null;
        }
        
        /**
         * 隐藏加载中 Dialog
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Object> getMHideLoadingDialogEvent() {
            return null;
        }
        
        /**
         * 跳转 Activity
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMStartActivityEvent() {
            return null;
        }
        
        /**
         * 页面跳转
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMNavigationEvent() {
            return null;
        }
        
        /**
         * 关闭 Activity
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMFinishEvent() {
            return null;
        }
        
        /**
         * 关闭 Activity (没有动画)
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Object> getMFinishNoAnimEvent() {
            return null;
        }
        
        /**
         * Activity setResult设置返回响应
         */
        private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMSetResultEvent() {
            return null;
        }
        
        /**
         * 获取 显示加载中Dialog SingleLiveEvent
         * @return 显示加载中Dialog SingleLiveEvent
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.String> getShowLoadingDialogEvent() {
            return null;
        }
        
        /**
         * 获取 隐藏加载中Dialog SingleLiveEvent
         * @return 隐藏加载中Dialog SingleLiveEvent
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Object> getHideLoadingDialogEvent() {
            return null;
        }
        
        /**
         * 获取 跳转 Activity SingleLiveEvent
         * @return 跳转 Activity SingleLiveEvent
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getStartActivityEvent() {
            return null;
        }
        
        /**
         * 获取 跳转页面 SingleLiveEvent
         * @return 跳转页面 SingleLiveEvent
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getNavigationEvent() {
            return null;
        }
        
        /**
         * 获取 关闭销毁Activity SingleLiveEvent
         * @return 关闭销毁Activity SingleLiveEvent
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getFinishEvent() {
            return null;
        }
        
        /**
         * 获取 Activity setResult设置返回响应 SingleLiveEvent
         * @return Activity setResult设置返回响应 SingleLiveEvent
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getSetResultEvent() {
            return null;
        }
        
        public CommonEventManager() {
            super();
        }
    }
}