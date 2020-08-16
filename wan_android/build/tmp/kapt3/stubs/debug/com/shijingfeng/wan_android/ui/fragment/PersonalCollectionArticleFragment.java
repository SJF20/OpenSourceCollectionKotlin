package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * Function: 我的收藏 -> 收藏文章列表 Fragment
 * Date: 2020/3/24 22:53
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/fragment/PersonalCollectionArticleFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0014J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0011\u001a\u00020\bH\u0014J\b\u0010\u0012\u001a\u00020\bH\u0014J\b\u0010\u0013\u001a\u00020\bH\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/PersonalCollectionArticleFragment;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "Lcom/shijingfeng/wan_android/databinding/FragmentWanAndroidPersonalCollectionArticleBinding;", "Lcom/shijingfeng/wan_android/view_model/PersonalCollectionArticleViewModel;", "()V", "mPersonalCollectionArticleAdapter", "Lcom/shijingfeng/wan_android/adapter/PersonalCollectionArticleAdapter;", "getArticleCollectionEvent", "", "event", "Lcom/shijingfeng/wan_android/entity/event/ArticleCollectionEvent;", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "initData", "initObserver", "isEnableLazyLoad", "", "scrollToTop", "setToTopButtonVisibility", "visibility", "wan_android_debug"})
@com.shijingfeng.base.annotation.BindEventBus()
public final class PersonalCollectionArticleFragment extends com.shijingfeng.wan_android.base.WanAndroidBaseFragment<com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionArticleBinding, com.shijingfeng.wan_android.view_model.PersonalCollectionArticleViewModel> {
    
    /**
     * 文章收藏列表 适配器
     */
    private com.shijingfeng.wan_android.adapter.PersonalCollectionArticleAdapter mPersonalCollectionArticleAdapter;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取视图ID
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
    protected com.shijingfeng.wan_android.view_model.PersonalCollectionArticleViewModel getViewModel() {
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
     * 设置 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private final void setToTopButtonVisibility(int visibility) {
    }
    
    /**
     * 是否开启懒加载 (用于ViewPager)
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
     * 获取 收藏状态改变 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getArticleCollectionEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent event) {
    }
    
    public PersonalCollectionArticleFragment() {
        super();
    }
}