package com.shijingfeng.base.base.fragment;

import java.lang.System;

/**
 * Function: MVVM架构 Fragment 基类
 * Date: 2020/3/21 21:15
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\f\b\u0001\u0010\u0003*\u0006\u0012\u0002\b\u00030\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J#\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0002\u0010\u0014*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0017\u00a2\u0006\u0002\u0010\u0018J!\u0010\u0013\u001a\u00028\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH$J\u000f\u0010\u001f\u001a\u0004\u0018\u00018\u0001H$\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020!H\u0004J\b\u0010%\u001a\u00020!H\u0014J\b\u0010&\u001a\u00020!H\u0014J&\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010-\u001a\u00020!H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u000200H\u0014J\u0010\u00101\u001a\u00020!2\u0006\u0010/\u001a\u000200H\u0014R\u001c\u0010\u0007\u001a\u00028\u0000X\u0084.\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00018\u0001X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u00062"}, d2 = {"Lcom/shijingfeng/base/base/fragment/BaseMvvmFragment;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "Lcom/shijingfeng/base/base/fragment/BaseFragment;", "()V", "mDataBinding", "getMDataBinding", "()Landroidx/databinding/ViewDataBinding;", "setMDataBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "mViewModel", "getMViewModel", "()Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "setMViewModel", "(Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;)V", "Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "createViewModel", "T", "Landroidx/lifecycle/ViewModel;", "cls", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "init", "", "savedInstanceState", "Landroid/os/Bundle;", "initAAC", "initObserver", "initParam", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "showCallback", "status", "", "updateRefreshLoadMoreStatus", "base_release"})
public abstract class BaseMvvmFragment<V extends androidx.databinding.ViewDataBinding, VM extends com.shijingfeng.base.base.viewmodel.BaseViewModel<?>> extends com.shijingfeng.base.base.fragment.BaseFragment {
    
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
     * 创建 Fragment Root View
     * @param inflater LayoutInflater
     * @param container 父View容器
     * @param savedInstanceState Fragment View 重建 保存的Bundle数据
     * @return View
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
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
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    @java.lang.Override()
    protected void init(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * 初始化参数
     */
    @java.lang.Override()
    protected void initParam() {
    }
    
    /**
     * 初始化AAC组件
     */
    protected final void initAAC() {
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
     * @param <T> 泛型
     * @return ViewModel子类
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends androidx.lifecycle.ViewModel>T createViewModel(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> cls) {
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
     * Fragment View 销毁回调
     */
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    public BaseMvvmFragment() {
        super();
    }
}