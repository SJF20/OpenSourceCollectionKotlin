package com.shijingfeng.view_original_image.base;

import java.lang.System;

/**
 * Function: common 模块 Activity 基类
 * Date: 2020/3/22 10:13
 * Description:
 * Author: ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/view_original_image/base/CommonBaseActivity;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/shijingfeng/view_original_image/base/CommonBaseViewModel;", "Lcom/shijingfeng/base/mvvm/activity/BaseMvvmActivity;", "()V", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "view_original_image_release"})
public abstract class CommonBaseActivity<V extends androidx.databinding.ViewDataBinding, VM extends com.shijingfeng.view_original_image.base.CommonBaseViewModel<?>> extends com.shijingfeng.base.mvvm.activity.BaseMvvmActivity<V, VM> {
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
    
    public CommonBaseActivity() {
        super();
    }
}