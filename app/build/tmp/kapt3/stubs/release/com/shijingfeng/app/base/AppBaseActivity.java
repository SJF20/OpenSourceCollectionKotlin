package com.shijingfeng.app.base;

import java.lang.System;

/**
 * Function: app 模块 Activity 基类
 * Date: 2020/2/2 22:30
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/app/base/AppBaseActivity;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/shijingfeng/app/base/AppBaseViewModel;", "Lcom/shijingfeng/base/base/activity/BaseMvvmActivity;", "()V", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "app_release"})
public abstract class AppBaseActivity<V extends androidx.databinding.ViewDataBinding, VM extends com.shijingfeng.app.base.AppBaseViewModel<?>> extends com.shijingfeng.base.base.activity.BaseMvvmActivity<V, VM> {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 初始化
     */
    @java.lang.Override()
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 初始化数据
     */
    @java.lang.Override()
    protected void initData() {
    }
    
    public AppBaseActivity() {
        super();
    }
}