package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 知识体系 详细数据 Activity
 * Date: 20-4-25 下午4:05
 * Description:
 * @author shijingfeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/KnowledgeClassifyDetailActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0013H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/KnowledgeClassifyDetailActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidKnowledgeClassifyDetailBinding;", "Lcom/shijingfeng/wan_android/view_model/KnowledgeClassifyDetailViewModel;", "()V", "mKnowledgeClassifyDetailFragmentPagerAdapter", "Lcom/shijingfeng/wan_android/ui/activity/KnowledgeClassifyDetailFragmentPagerAdapter;", "getLayoutId", "", "getTabView", "Landroid/widget/TextView;", "position", "children", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildren;", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "initParam", "wan_android_release"})
public final class KnowledgeClassifyDetailActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidKnowledgeClassifyDetailBinding, com.shijingfeng.wan_android.view_model.KnowledgeClassifyDetailViewModel> {
    
    /**
     * 知识体系 ViewPager Fragment 适配器
     */
    private com.shijingfeng.wan_android.ui.activity.KnowledgeClassifyDetailFragmentPagerAdapter mKnowledgeClassifyDetailFragmentPagerAdapter;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.KnowledgeClassifyDetailViewModel getViewModel() {
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
     *
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
     * 获取要加载的 Tab CustomView
     * @param children 知识体系 二级 Item
     * @param position 位置
     * @return View 要加载的View
     */
    private final android.widget.TextView getTabView(int position, com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren children) {
        return null;
    }
    
    public KnowledgeClassifyDetailActivity() {
        super();
    }
}