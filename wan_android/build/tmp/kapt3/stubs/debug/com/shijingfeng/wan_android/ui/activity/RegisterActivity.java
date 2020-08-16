package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 注册 Activity
 * Date: 2020/2/5 16:23
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/RegisterActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\n\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/RegisterActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidRegisterBinding;", "Lcom/shijingfeng/wan_android/view_model/RegisterViewModel;", "()V", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initData", "", "wan_android_debug"})
public final class RegisterActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidRegisterBinding, com.shijingfeng.wan_android.view_model.RegisterViewModel> {
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
     *
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.RegisterViewModel getViewModel() {
        return null;
    }
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
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
    
    public RegisterActivity() {
        super();
    }
}