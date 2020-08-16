package com.shijingfeng.wan_android.base;

import java.lang.System;

/**
 * Function: wan_android 模块 Activity 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/base/base/activity/BaseMvvmActivity;", "()V", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "isSetCustomStatusBar", "", "onDestroy", "wan_android_release"})
public abstract class WanAndroidBaseActivity<V extends androidx.databinding.ViewDataBinding, VM extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<?>> extends com.shijingfeng.base.base.activity.BaseMvvmActivity<V, VM> {
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
    
    /**
     * 是否自定义设置状态栏
     * @return true 自定义设置  false 默认设置
     */
    protected boolean isSetCustomStatusBar() {
        return false;
    }
    
    /**
     * Activity销毁回调
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public WanAndroidBaseActivity() {
        super();
    }
}