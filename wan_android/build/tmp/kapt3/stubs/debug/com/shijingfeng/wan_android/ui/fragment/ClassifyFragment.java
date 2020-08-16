package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * Function: 分类 Fragment
 * Date: 2020/2/12 16:52
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/fragment/ClassifyFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0014J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014J\b\u0010\u0014\u001a\u00020\u0003H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0016H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/ClassifyFragment;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "Lcom/shijingfeng/wan_android/databinding/FragmentWanAndroidClassifyBinding;", "Lcom/shijingfeng/wan_android/view_model/ClassifyViewModel;", "()V", "mClassifyFragmentPagerAdapter", "Lcom/shijingfeng/wan_android/ui/fragment/ClassifyFragmentPagerAdapter;", "mCurPosition", "", "getMCurPosition", "()I", "setMCurPosition", "(I)V", "getLayoutId", "getTabView", "Landroid/view/View;", "position", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "isEnableLazyLoad", "", "scrollToTop", "wan_android_debug"})
public final class ClassifyFragment extends com.shijingfeng.wan_android.base.WanAndroidBaseFragment<com.shijingfeng.wan_android.databinding.FragmentWanAndroidClassifyBinding, com.shijingfeng.wan_android.view_model.ClassifyViewModel> {
    
    /**
     * 分类 ViewPager Fragment 适配器
     */
    private com.shijingfeng.wan_android.ui.fragment.ClassifyFragmentPagerAdapter mClassifyFragmentPagerAdapter;
    
    /**
     * 当前 ViewPager 下标
     */
    private int mCurPosition = 0;
    private java.util.HashMap _$_findViewCache;
    
    public final int getMCurPosition() {
        return 0;
    }
    
    public final void setMCurPosition(int p0) {
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
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.ClassifyViewModel getViewModel() {
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
     * 获取要加载的 Tab CustomView
     * @param position 位置
     * @return View 要加载的View
     */
    private final android.view.View getTabView(int position) {
        return null;
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
    
    public ClassifyFragment() {
        super();
    }
}