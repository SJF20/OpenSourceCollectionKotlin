package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * Function: 项目 Fragment
 * Date: 2020/2/12 17:11
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/fragment/ProjectFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/ProjectFragment;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "Lcom/shijingfeng/wan_android/databinding/FragmentWanAndroidProjectBinding;", "Lcom/shijingfeng/wan_android/view_model/ProjectViewModel;", "()V", "mProjectFragmentPagerAdapter", "Lcom/shijingfeng/wan_android/ui/fragment/ProjectFragmentPagerAdapter;", "getLayoutId", "", "getTabView", "Landroid/widget/TextView;", "position", "projectIndex", "Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initData", "", "initObserver", "isEnableLazyLoad", "", "lazyInitAction", "lazyInitData", "scrollToTop", "startLazyInit", "wan_android_debug"})
public final class ProjectFragment extends com.shijingfeng.wan_android.base.WanAndroidBaseFragment<com.shijingfeng.wan_android.databinding.FragmentWanAndroidProjectBinding, com.shijingfeng.wan_android.view_model.ProjectViewModel> {
    
    /**
     * 项目 ViewPager Fragment 适配器
     */
    private com.shijingfeng.wan_android.ui.fragment.ProjectFragmentPagerAdapter mProjectFragmentPagerAdapter;
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
    protected com.shijingfeng.wan_android.view_model.ProjectViewModel getViewModel() {
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
     * 初始化 LiveData Observer
     */
    @java.lang.Override()
    protected void initObserver() {
    }
    
    /**
     * 开始 懒初始化数据
     */
    private final void startLazyInit() {
    }
    
    /**
     * 等获取完 索引数据 后初始化数据
     */
    private final void lazyInitData() {
    }
    
    /**
     * 等获取完 索引数据 后初始化事件
     */
    private final void lazyInitAction() {
    }
    
    /**
     * 获取要加载的 Tab CustomView
     * @param projectIndex 公众号 索引数据 Item
     * @param position 位置
     * @return View 要加载的View
     */
    private final android.widget.TextView getTabView(int position, com.shijingfeng.wan_android.entity.ProjectIndexEntity projectIndex) {
        return null;
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
    
    public ProjectFragment() {
        super();
    }
}