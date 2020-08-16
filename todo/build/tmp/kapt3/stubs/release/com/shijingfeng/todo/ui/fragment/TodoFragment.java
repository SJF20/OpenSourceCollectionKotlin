package com.shijingfeng.todo.ui.fragment;

import java.lang.System;

/**
 * Function: 首页 -> 待办 Fragment
 * Date: 2020/5/17 16:17
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/todo/fragment/TodoFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/shijingfeng/todo/ui/fragment/TodoFragment;", "Lcom/shijingfeng/todo/base/TodoBaseFragment;", "Lcom/shijingfeng/todo/databinding/FragmentTodoMainTodoBinding;", "Lcom/shijingfeng/todo/view_model/MainTodoViewModel;", "()V", "mMainTodoAdapter", "Lcom/shijingfeng/todo/entity/adapter/MainTodoAdapter;", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "initObserver", "todo_release"})
public final class TodoFragment extends com.shijingfeng.todo.base.TodoBaseFragment<com.shijingfeng.todo.databinding.FragmentTodoMainTodoBinding, com.shijingfeng.todo.view_model.MainTodoViewModel> {
    
    /**
     * 待办 分组 适配器
     */
    private com.shijingfeng.todo.entity.adapter.MainTodoAdapter mMainTodoAdapter;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取视图ID
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
    protected com.shijingfeng.todo.view_model.MainTodoViewModel getViewModel() {
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
     * 初始化 LiveData Observer
     */
    @java.lang.Override()
    protected void initObserver() {
    }
    
    public TodoFragment() {
        super();
    }
}