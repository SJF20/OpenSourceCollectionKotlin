package com.shijingfeng.todo.entity.adapter;

import java.lang.System;

/**
 * Function: 主页 -> 待办 实体类
 * Date: 2020/5/21 15:02
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/shijingfeng/todo/entity/adapter/MainTodoItem;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "date", "", "todoItemList", "", "Lcom/shijingfeng/todo/entity/MainTodoGroupItem;", "(JLjava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getIdentity", "()J", "getTodoItemList", "()Ljava/util/List;", "setTodoItemList", "(Ljava/util/List;)V", "getId", "todo_debug"})
public final class MainTodoItem extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 唯一ID
     */
    private final long identity = 0L;
    
    /**
     * 日期
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String date;
    
    /**
     * 分组下的列表
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.shijingfeng.todo.entity.MainTodoGroupItem> todoItemList;
    
    /**
     * 获取ID
     * @return ID
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getId() {
        return null;
    }
    
    /**
     * 唯一ID
     */
    public final long getIdentity() {
        return 0L;
    }
    
    /**
     * 日期
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDate() {
        return null;
    }
    
    /**
     * 日期
     */
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 分组下的列表
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.todo.entity.MainTodoGroupItem> getTodoItemList() {
        return null;
    }
    
    /**
     * 分组下的列表
     */
    public final void setTodoItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.todo.entity.MainTodoGroupItem> p0) {
    }
    
    public MainTodoItem(long identity, @org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.todo.entity.MainTodoGroupItem> todoItemList) {
        super();
    }
    
    public MainTodoItem() {
        super();
    }
}