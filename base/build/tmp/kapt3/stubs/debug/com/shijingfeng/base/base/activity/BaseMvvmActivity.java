package com.shijingfeng.base.base.activity;

import java.lang.System;

/**
 * Function: MVVM架构 Activity 基类
 * Date: 2020/3/21 10:56
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0013\u001a\u00028\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015\u00a2\u0006\u0002\u0010\u0016J!\u0010\u0013\u001a\u00028\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH$J\u000f\u0010\u001d\u001a\u0004\u0018\u00018\u0001H$\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001fH\u0004J\b\u0010#\u001a\u00020\u001fH\u0014J\b\u0010$\u001a\u00020\u001fH\u0014J\b\u0010%\u001a\u00020\u001fH\u0014J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(H\u0014J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010\'\u001a\u00020(H\u0014R\u001c\u0010\u0007\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00018\u0001X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006*"}, d2 = {"Lcom/shijingfeng/base/base/activity/BaseMvvmActivity;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "Lcom/shijingfeng/base/base/activity/BaseNormalActivity;", "()V", "mDataBinding", "getMDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setMDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "mViewModel", "getMViewModel", "()Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "setMViewModel", "(Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;)V", "Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "createViewModel", "cls", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initAAC", "initObserver", "initParam", "onDestroy", "showCallback", "status", "", "updateRefreshLoadMoreStatus", "base_debug"})
public abstract class BaseMvvmActivity<V extends androidx.databinding.ViewDataBinding, VM extends com.shijingfeng.base.base.viewmodel.BaseViewModel<?>> extends com.shijingfeng.base.base.activity.BaseNormalActivity {
    
    /**
     * DataBinding
     */
    @org.jetbrains.annotations.NotNull()
    protected V mDataBinding;
    
    /**
     * ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    private VM mViewModel;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    protected final V getMDataBinding() {
        return null;
    }
    
    protected final void setMDataBinding(@org.jetbrains.annotations.NotNull()
    V p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final VM getMViewModel() {
        return null;
    }
    
    protected final void setMViewModel(@org.jetbrains.annotations.Nullable()
    VM p0) {
    }
    
    /**
     * 初始化
     */
    @java.lang.Override()
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    protected abstract VM getViewModel();
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    @org.jetbrains.annotations.Nullable()
    protected abstract android.util.SparseArray<java.lang.Object> getVariableSparseArray();
    
    /**
     * 初始化AAC组件
     */
    protected final void initAAC() {
    }
    
    /**
     * 初始化参数
     */
    @java.lang.Override()
    protected void initParam() {
    }
    
    /**
     * 初始化 LiveData Observer
     */
    protected void initObserver() {
    }
    
    /**
     * LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SUCCESS]
     */
    @java.lang.Override()
    protected void showCallback(int status) {
    }
    
    /**
     * 更新 下拉刷新，上拉加载 状态
     * @param status 下拉刷新 或 上拉加载 状态  默认: [REFRESH_SUCCESS]
     */
    @java.lang.Override()
    protected void updateRefreshLoadMoreStatus(int status) {
    }
    
    /**
     * 创建ViewModel
     *
     * @param cls Activity Class
     * @return ViewModel子类
     */
    @org.jetbrains.annotations.NotNull()
    public final VM createViewModel(@org.jetbrains.annotations.NotNull()
    java.lang.Class<VM> cls) {
        return null;
    }
    
    /**
     * 工厂模式创建ViewModel
     *
     * @param cls Activity Class
     * @param factory 工厂
     * @return ViewModel子类
     */
    @org.jetbrains.annotations.NotNull()
    public final VM createViewModel(@org.jetbrains.annotations.NotNull()
    java.lang.Class<VM> cls, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.ViewModelProvider.Factory factory) {
        return null;
    }
    
    /**
     * Activity 销毁回调
     */
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public BaseMvvmActivity() {
        super();
    }
}