package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 项目相关 Api
 * Date: 20-4-29 下午8:40
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\'J\u001a\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00040\u0003H\'\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/ProjectApi;", "", "getProjectChild", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "Lcom/shijingfeng/wan_android/entity/ProjectChildEntity;", "page", "", "id", "", "getProjectIndex", "", "Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;", "wan_android_debug"})
public abstract interface ProjectApi {
    
    /**
     * 获取 项目索引数据
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "project/tree/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexEntity>>> getProjectIndex();
    
    /**
     * 获取 项目二级数据
     * @param page 页码
     * @param id 　项目索引数据 ID
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "project/list/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.ProjectChildEntity>> getProjectChild(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "cid")
    java.lang.String id);
}