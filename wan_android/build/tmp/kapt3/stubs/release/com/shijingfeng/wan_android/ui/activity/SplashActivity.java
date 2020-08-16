package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 启动页 Activity
 * Date: 2020/2/4 21:19
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/SplashActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0014\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/SplashActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidSplashBinding;", "Lcom/shijingfeng/wan_android/view_model/SplashViewModel;", "()V", "getLayoutId", "", "getVariableSparseArray", "", "getViewModel", "initData", "", "isSetCustomStatusBar", "", "wan_android_release"})
public final class SplashActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidSplashBinding, com.shijingfeng.wan_android.view_model.SplashViewModel> {
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
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.SplashViewModel getViewModel() {
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
     * 初始化数据
     */
    @java.lang.Override()
    protected void initData() {
    }
    
    /**
     * 是否自定义设置状态栏
     *
     * @return true 自定义设置  false 默认设置
     */
    @java.lang.Override()
    protected boolean isSetCustomStatusBar() {
        return false;
    }
    
    public SplashActivity() {
        super();
    }
}