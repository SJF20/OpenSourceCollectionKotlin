package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * Function: 我的收藏 -> 收藏网站列表 Fragment
 * Date: 2020/3/26 20:57
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/fragment/PersonalCollectionWebsiteFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0015H\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/PersonalCollectionWebsiteFragment;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "Lcom/shijingfeng/wan_android/databinding/FragmentWanAndroidPersonalCollectionWebsiteBinding;", "Lcom/shijingfeng/wan_android/view_model/PersonalCollectionWebsiteViewModel;", "()V", "mCurrentPosition", "", "mEditContentView", "Landroid/view/View;", "mEditDialog", "Lcom/shijingfeng/base/widget/dialog/CommonDialog;", "mPersonalCollectionWebsite", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "mPersonalCollectionWebsiteAdapter", "Lcom/shijingfeng/wan_android/adapter/PersonalCollectionWebsiteAdapter;", "getLayoutId", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "getWebsiteCollectionEvent", "", "event", "Lcom/shijingfeng/wan_android/entity/event/WebsiteCollectionEvent;", "initAction", "initData", "initObserver", "isEnableLazyLoad", "", "onDestroy", "scrollToBottom", "scrollToTop", "setToTopButtonVisibility", "visibility", "showEditDialog", "wan_android_release"})
@com.shijingfeng.base.annotation.BindEventBus()
public final class PersonalCollectionWebsiteFragment extends com.shijingfeng.wan_android.base.WanAndroidBaseFragment<com.shijingfeng.wan_android.databinding.FragmentWanAndroidPersonalCollectionWebsiteBinding, com.shijingfeng.wan_android.view_model.PersonalCollectionWebsiteViewModel> {
    
    /**
     * 网站收藏列表 适配器
     */
    private com.shijingfeng.wan_android.adapter.PersonalCollectionWebsiteAdapter mPersonalCollectionWebsiteAdapter;
    
    /**
     * 网站编辑 Dialog
     */
    private com.shijingfeng.base.widget.dialog.CommonDialog mEditDialog;
    
    /**
     * 网站编辑 ContentView
     */
    private android.view.View mEditContentView;
    
    /**
     * 当前 网站编辑 实体类
     */
    private com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity mPersonalCollectionWebsite;
    
    /**
     * 当前操作的 position
     */
    private int mCurrentPosition = -1;
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
    protected com.shijingfeng.wan_android.view_model.PersonalCollectionWebsiteViewModel getViewModel() {
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
     * 显示 网站编辑 Dialog
     */
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void showEditDialog() {
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
     * 滑动到底部
     */
    private final void scrollToBottom() {
    }
    
    /**
     * 获取 收藏状态改变 Event
     */
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void getWebsiteCollectionEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.event.WebsiteCollectionEvent event) {
    }
    
    /**
     * Fragment 销毁回调
     */
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public PersonalCollectionWebsiteFragment() {
        super();
    }
}