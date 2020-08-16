package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * Function: 空 Fragment (用于 条件都不满足的情况下的 占位 Fragment, 为了保证不崩溃)
 * Date: 2020/4/17 17:21
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\n"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/EmptyFragment;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "Lcom/shijingfeng/wan_android/databinding/FragmentWanAndroidNullBinding;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "()V", "getLayoutId", "", "getVariableSparseArray", "", "getViewModel", "wan_android_debug"})
public final class EmptyFragment extends com.shijingfeng.wan_android.base.WanAndroidBaseFragment<com.shijingfeng.wan_android.databinding.FragmentWanAndroidNullBinding, com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<?>> {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void getViewModel() {
        return null;
    }
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected java.lang.Void getVariableSparseArray() {
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
    
    public EmptyFragment() {
        super();
    }
}