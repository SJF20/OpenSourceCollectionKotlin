package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 我的收藏 Activity
 * Date: 2020/3/22 20:56
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/PersonalCollectionActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bH\u0003J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/PersonalCollectionActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidPersonalCollectionBinding;", "Lcom/shijingfeng/wan_android/view_model/PersonalCollectionViewModel;", "()V", "mPersonalCollectionFragmentPagerAdapter", "Lcom/shijingfeng/wan_android/ui/activity/PersonalCollectionFragmentPagerAdapter;", "getLayoutId", "", "getTabView", "Landroid/view/View;", "position", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "wan_android_debug"})
public final class PersonalCollectionActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidPersonalCollectionBinding, com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel> {
    
    /**
     * 我的收藏 ViewPager Fragment 适配器
     */
    private com.shijingfeng.wan_android.ui.activity.PersonalCollectionFragmentPagerAdapter mPersonalCollectionFragmentPagerAdapter;
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
    protected com.shijingfeng.wan_android.view_model.PersonalCollectionViewModel getViewModel() {
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
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final android.view.View getTabView(int position) {
        return null;
    }
    
    public PersonalCollectionActivity() {
        super();
    }
}