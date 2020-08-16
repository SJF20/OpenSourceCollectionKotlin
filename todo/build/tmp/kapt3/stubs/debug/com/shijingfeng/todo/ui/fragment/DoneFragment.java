package com.shijingfeng.todo.ui.fragment;

import java.lang.System;

/**
 * Function: 首页 -> 已完成 Fragment
 * Date: 2020/5/17 16:19
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/todo/fragment/DoneFragment")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\b\u0010\n\u001a\u00020\u0003H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/todo/ui/fragment/DoneFragment;", "Lcom/shijingfeng/todo/base/TodoBaseFragment;", "Lcom/shijingfeng/todo/databinding/FragmentTodoMainDoneBinding;", "Lcom/shijingfeng/todo/view_model/MainDoneViewModel;", "()V", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "todo_debug"})
public final class DoneFragment extends com.shijingfeng.todo.base.TodoBaseFragment<com.shijingfeng.todo.databinding.FragmentTodoMainDoneBinding, com.shijingfeng.todo.view_model.MainDoneViewModel> {
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
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.shijingfeng.todo.view_model.MainDoneViewModel getViewModel() {
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
    
    public DoneFragment() {
        super();
    }
}