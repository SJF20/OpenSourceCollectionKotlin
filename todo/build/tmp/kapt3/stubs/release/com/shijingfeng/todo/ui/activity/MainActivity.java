package com.shijingfeng.todo.ui.activity;

import java.lang.System;

/**
 * Function: 主页 Activity
 * Date: 2020/3/18 23:00
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/todo/activity/MainActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0003J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/shijingfeng/todo/ui/activity/MainActivity;", "Lcom/shijingfeng/todo/base/TodoBaseActivity;", "Lcom/shijingfeng/todo/databinding/ActivityTodoMainBinding;", "Lcom/shijingfeng/todo/view_model/MainViewModel;", "()V", "mMainFragmentPagerAdapter", "Lcom/shijingfeng/todo/ui/activity/MainFragmentPagerAdapter;", "mTypeSwitchDialog", "Lcom/shijingfeng/base/widget/dialog/CommonDialog;", "getLayoutId", "", "getTabView", "Landroid/view/View;", "position", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "setTabLayoutVisibility", "visibility", "showTypeSwitchDialog", "todo_release"})
public final class MainActivity extends com.shijingfeng.todo.base.TodoBaseActivity<com.shijingfeng.todo.databinding.ActivityTodoMainBinding, com.shijingfeng.todo.view_model.MainViewModel> {
    
    /**
     * 主页 ViewPager Fragment 适配器
     */
    private com.shijingfeng.todo.ui.activity.MainFragmentPagerAdapter mMainFragmentPagerAdapter;
    
    /**
     * 类型切换 Dialog
     */
    private com.shijingfeng.base.widget.dialog.CommonDialog mTypeSwitchDialog;
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
    protected com.shijingfeng.todo.view_model.MainViewModel getViewModel() {
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
     * 设置 TabLayout 和 置顶按钮 的可见性
     * @param visibility 可见性
     */
    private final void setTabLayoutVisibility(int visibility) {
    }
    
    /**
     * 根据 下标 生成 TabLayout Tab View
     * @param position
     */
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final android.view.View getTabView(int position) {
        return null;
    }
    
    /**
     * 显示 类型切换 Dialog
     */
    @android.annotation.SuppressLint(value = {"InflateParams"})
    private final void showTypeSwitchDialog() {
    }
    
    public MainActivity() {
        super();
    }
}