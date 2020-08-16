package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 主页 ViewModel
 * Date: 2020/2/10 16:19
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\"\u001a\u00020#R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0011\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\b\u00a8\u0006$"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/MainViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/MainRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/MainRepository;)V", "mAboutClickListener", "Landroid/view/View$OnClickListener;", "getMAboutClickListener", "()Landroid/view/View$OnClickListener;", "mCoinRecordClickListener", "getMCoinRecordClickListener", "mCollectionClickListener", "getMCollectionClickListener", "mCurPosition", "", "getMCurPosition", "()I", "setMCurPosition", "(I)V", "mHeaderClickListener", "getMHeaderClickListener", "mLogoutClickListener", "getMLogoutClickListener", "mRankClickListener", "getMRankClickListener", "mSettingClickListener", "getMSettingClickListener", "mShowLogoutDialogEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "", "getMShowLogoutDialogEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mTodoClickListener", "getMTodoClickListener", "logout", "", "wan_android_debug"})
public final class MainViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.MainRepository> {
    
    /**
     * 当前 TabLayout 和 ViewPager 下标
     */
    private int mCurPosition = 0;
    
    /**
     * 显示 退出登录确认对话框 Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Object> mShowLogoutDialogEvent = null;
    
    /**
     * 侧边栏 Header 点击事件
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mHeaderClickListener = null;
    
    /**
     * 跳转到 积分排行榜页面
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mRankClickListener = null;
    
    /**
     * 跳转到 积分记录页面
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mCoinRecordClickListener = null;
    
    /**
     * 跳转到 我的收藏页面
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mCollectionClickListener = null;
    
    /**
     * 跳转到 待办事项页面
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mTodoClickListener = null;
    
    /**
     * 跳转到 系统设置页面
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mSettingClickListener = null;
    
    /**
     * 跳转到 关于我们页面
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mAboutClickListener = null;
    
    /**
     * 注销登录
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mLogoutClickListener = null;
    
    public final int getMCurPosition() {
        return 0;
    }
    
    public final void setMCurPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Object> getMShowLogoutDialogEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMHeaderClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMRankClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMCoinRecordClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMCollectionClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMTodoClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMSettingClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMAboutClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMLogoutClickListener() {
        return null;
    }
    
    /**
     * 退出登录
     */
    public final void logout() {
    }
    
    public MainViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.MainRepository repository) {
        super(null);
    }
    
    public MainViewModel() {
        super(null);
    }
}