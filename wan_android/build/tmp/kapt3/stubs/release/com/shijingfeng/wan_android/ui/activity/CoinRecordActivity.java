package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 积分记录 Activity
 * Date: 2020/3/16 21:54
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/CoinRecordActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/CoinRecordActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidCoinRecordBinding;", "Lcom/shijingfeng/wan_android/view_model/CoinRecordViewModel;", "()V", "mCoinRecordAdapter", "Lcom/shijingfeng/wan_android/adapter/CoinRecordAdapter;", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "initObserver", "scrollToTop", "setToTopButtonVisibility", "visibility", "wan_android_release"})
public final class CoinRecordActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidCoinRecordBinding, com.shijingfeng.wan_android.view_model.CoinRecordViewModel> {
    
    /**
     * 积分记录列表适配器
     */
    private com.shijingfeng.wan_android.adapter.CoinRecordAdapter mCoinRecordAdapter;
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
    protected com.shijingfeng.wan_android.view_model.CoinRecordViewModel getViewModel() {
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
     * 滑动到顶部
     */
    private final void scrollToTop() {
    }
    
    public CoinRecordActivity() {
        super();
    }
}