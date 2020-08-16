package com.shijingfeng.todo.view_model;

import java.lang.System;

/**
 * Function: 主页 ViewModel
 * Date: 2020/3/18 23:01
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/todo/view_model/MainViewModel;", "Lcom/shijingfeng/todo/base/TodoBaseViewModel;", "Lcom/shijingfeng/todo/source/repository/MainRepository;", "()V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mCurPosition", "", "getMCurPosition", "()I", "setMCurPosition", "(I)V", "todo_debug"})
public final class MainViewModel extends com.shijingfeng.todo.base.TodoBaseViewModel<com.shijingfeng.todo.source.repository.MainRepository> {
    
    /**
     * 当前 ViewPager 下标
     */
    private int mCurPosition = 0;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    public final int getMCurPosition() {
        return 0;
    }
    
    public final void setMCurPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    public MainViewModel() {
        super(null);
    }
}