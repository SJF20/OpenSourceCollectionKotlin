package com.shijingfeng.todo.source.repository;

import java.lang.System;

/**
 * Function: 主页 -> 待办 仓库
 * Date: 2020/5/17 16:33
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J|\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2/\u0010\u000e\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0010`\u00142\'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00070\u000fj\u0002`\u0018J\b\u0010\u0019\u001a\u00020\u0007H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/todo/source/repository/MainTodoRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/todo/source/network/MainTodoNetworkSource;", "networkSource", "(Lcom/shijingfeng/todo/source/network/MainTodoNetworkSource;)V", "getTodoData", "", "page", "", "postMap", "", "", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/todo/entity/MainTodo;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "todo_release"})
public final class MainTodoRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.todo.source.network.MainTodoNetworkSource> {
    
    /**
     * 获取 待办事项 数据
     *
     * @param page 页码
     * @param postMap 查询携带的参数
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    public final void getTodoData(int page, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> postMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.todo.entity.MainTodo, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public MainTodoRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.todo.source.network.MainTodoNetworkSource networkSource) {
        super(null, null);
    }
    
    public MainTodoRepository() {
        super(null, null);
    }
}