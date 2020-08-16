package com.shijingfeng.todo.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"TAB_LAYOUT_VISIBILITY", "", "TYPE_ALL", "", "TYPE_LIFE", "TYPE_STUDY", "TYPE_WORK", "VIEW_TODO_DETAIL", "todo_debug"})
public final class FlagConstant {
    
    /**
     * TabLayout可见性
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAB_LAYOUT_VISIBILITY = "tab_layout_visibility";
    
    /**
     * 查看 待办事项 详情
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String VIEW_TODO_DETAIL = "view_todo_detail";
    
    /**
     * 待办事项类型: 无分类 所有
     */
    public static final int TYPE_ALL = 0;
    
    /**
     * 待办事项类型: 工作
     */
    public static final int TYPE_WORK = 1;
    
    /**
     * 待办事项类型: 学习
     */
    public static final int TYPE_STUDY = 2;
    
    /**
     * 待办事项类型: 生活
     */
    public static final int TYPE_LIFE = 3;
}