package com.shijingfeng.wan_android.base;

import java.lang.System;

/**
 * Function: wan_android 模块 Fragment 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/base/base/fragment/BaseMvvmFragment;", "()V", "getStatusBarBackgroundResource", "", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "scrollToTop", "wan_android_debug"})
public abstract class WanAndroidBaseFragment<V extends androidx.databinding.ViewDataBinding, VM extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<?>> extends com.shijingfeng.base.base.fragment.BaseMvvmFragment<V, VM> {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    @java.lang.Override()
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 获取 状态栏 背景资源 (支持换肤)
     */
    @java.lang.Override()
    protected int getStatusBarBackgroundResource() {
        return 0;
    }
    
    /**
     * 滑动到顶部
     */
    public void scrollToTop() {
    }
    
    public WanAndroidBaseFragment() {
        super();
    }
}