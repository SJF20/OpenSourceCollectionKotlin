package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * Function: 项目 二级数据 Fragment
 * Date: 20-4-29 下午10:29
 * Description:
 * @author shijingfeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/fragment/ProjectChildFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0010H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0015\u001a\u00020\bH\u0014J\b\u0010\u0016\u001a\u00020\bH\u0014J\b\u0010\u0017\u001a\u00020\bH\u0014J\b\u0010\u0018\u001a\u00020\bH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/ProjectChildFragment;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "Lcom/shijingfeng/wan_android/databinding/FragmentWanAndroidProjectChildBinding;", "Lcom/shijingfeng/wan_android/view_model/ProjectChildViewModel;", "()V", "mProjectChildAdapter", "Lcom/shijingfeng/wan_android/adapter/ProjectChildAdapter;", "getCollectionEvent", "", "event", "Lcom/shijingfeng/wan_android/entity/event/ArticleCollectionEvent;", "getLayoutId", "", "getThemeEvent", "Lcom/shijingfeng/wan_android/entity/event/ThemeEvent;", "getUserInfoEvent", "Lcom/shijingfeng/wan_android/entity/event/UserInfoEvent;", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "initData", "initObserver", "initParam", "isEnableLazyLoad", "", "onResume", "scrollToTop", "wan_android_debug"})
@com.shijingfeng.base.annotation.BindEventBus()
public final class ProjectChildFragment extends com.shijingfeng.wan_android.base.WanAndroidBaseFragment<com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectChildBinding, com.shijingfeng.wan_android.view_model.ProjectChildViewModel> {
    
    /**
     * 项目 二级数据 列表适配器
     */
    private com.shijingfeng.wan_android.adapter.ProjectChildAdapter mProjectChildAdapter;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.ProjectChildViewModel getViewModel() {
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
     * 获取视图ID
     * @return 视图ID
     */
    @java.lang.Override()
    protected int getLayoutId() {
        return 0;
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
     * 初始化事件
     */
    @java.lang.Override()
    protected void initAction() {
    }
    
    /**
     * 初始化 LiveData Observer
     */
    @java.lang.Override()
    protected void initObserver() {
    }
    
    /**
     * 页面可见
     */
    @java.lang.Override()
    public void onResume() {
    }
    
    /**
     * 是否开启懒加载 (用于ViewPager)
     *
     * @return true 开启  false 关闭  默认关闭
     */
    @java.lang.Override()
    protected boolean isEnableLazyLoad() {
        return false;
    }
    
    /**
     * 滑动到顶部
     */
    @java.lang.Override()
    public void scrollToTop() {
    }
    
    /**
     * 获取 用户信息 改变 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getUserInfoEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.UserInfoEvent event) {
    }
    
    /**
     * 更新 收藏
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getCollectionEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent event) {
    }
    
    /**
     * 获取 主题更新 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getThemeEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.ThemeEvent event) {
    }
    
    public ProjectChildFragment() {
        super();
    }
}