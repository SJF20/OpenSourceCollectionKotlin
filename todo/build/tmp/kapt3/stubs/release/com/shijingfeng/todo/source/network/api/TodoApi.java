package com.shijingfeng.todo.source.network.api;

import java.lang.System;

/**
 * Function: 待办事项 相关 Api
 * Date: 2020/5/20 21:38
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0016\b\u0003\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/todo/source/network/api/TodoApi;", "", "getTodoData", "Lio/reactivex/Single;", "Lcom/shijingfeng/todo/entity/ResultEntity;", "Lcom/shijingfeng/todo/entity/MainTodo;", "page", "", "postMap", "", "", "todo_release"})
public abstract interface TodoApi {
    
    /**
     * 获取 待办事项 数据
     *
     * @param page 页码
     * @param postMap 查询携带的参数
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/todo/v2/list/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.todo.entity.ResultEntity<com.shijingfeng.todo.entity.MainTodo>> getTodoData(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.QueryMap()
    java.util.Map<java.lang.String, ? extends java.lang.Object> postMap);
    
    /**
     * Function: 待办事项 相关 Api
     * Date: 2020/5/20 21:38
     * Description:
     * @author ShiJingFeng
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}