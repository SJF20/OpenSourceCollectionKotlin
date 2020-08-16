package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 搜索相关 Api
 * Date: 20-5-3 下午8:48
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H\'J(\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/SearchApi;", "", "getSearchHotWordList", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "", "Lcom/shijingfeng/wan_android/entity/SearchHotWordEntity;", "getSearchList", "Lcom/shijingfeng/wan_android/entity/SearchListEntity;", "page", "", "keyword", "", "wan_android_release"})
public abstract interface SearchApi {
    
    /**
     * 获取搜索热词列表
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "hotkey/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.util.List<com.shijingfeng.wan_android.entity.SearchHotWordEntity>>> getSearchHotWordList();
    
    /**
     * 获取 搜索 列表
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "article/query/{page}/json")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.SearchListEntity>> getSearchList(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "k")
    java.lang.String keyword);
}