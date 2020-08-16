package com.shijingfeng.todo.source.network;

import java.lang.System;

/**
 * Function: 主页 -> 待办 网络源
 * Date: 2020/5/20 21:34
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J|\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2/\u0010\r\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u00132\'\u0010\u0014\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00060\u000ej\u0002`\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/shijingfeng/todo/source/network/MainTodoNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mTodoApi", "Lcom/shijingfeng/todo/source/network/api/TodoApi;", "getTodoData", "", "page", "", "postMap", "", "", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/todo/entity/MainTodo;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "todo_release"})
public final class MainTodoNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 待办事项 相关 Api
     */
    private final com.shijingfeng.todo.source.network.api.TodoApi mTodoApi = null;
    
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
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public MainTodoNetworkSource() {
        super();
    }
}