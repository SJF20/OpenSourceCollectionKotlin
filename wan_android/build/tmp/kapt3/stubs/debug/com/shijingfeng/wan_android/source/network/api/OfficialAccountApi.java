package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 公众号 相关 Api
 * Date: 2020/4/29 16:55
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH\'J\u001a\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00040\u0003H\'\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/OfficialAccountApi;", "", "getOfficialAccountChild", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "Lcom/shijingfeng/wan_android/entity/OfficialAccountChildEntity;", "page", "", "id", "", "getOfficialAccountIndex", "", "Lcom/shijingfeng/wan_android/entity/OfficialAccountIndexEntity;", "wan_android_debug"})
public abstract interface OfficialAccountApi {
    
    /**
     * 获取 公众号 索引数据
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "wxarticle/chapters/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity>>> getOfficialAccountIndex();
    
    /**
     * 获取 公众号 二级数据
     * @param page 页码
     * @param id 　公众号索引数据 ID
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "wxarticle/list/{id}/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.OfficialAccountChildEntity>> getOfficialAccountChild(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id);
}