package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 文章 API
 * Date: 2020/2/12 10:29
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\'J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00040\u0003H\'J(\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/ArticleApi;", "", "getHomeArticleList", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "Lcom/shijingfeng/wan_android/entity/HomeArticleEntity;", "page", "", "getHomeTopArticleList", "", "Lcom/shijingfeng/wan_android/entity/adapter/HomeTopArticleItem;", "getKnowledgeClassifyChildList", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildEntity;", "id", "", "wan_android_debug"})
public abstract interface ArticleApi {
    
    /**
     * 获取 首页置顶文章 列表
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "article/top/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem>>> getHomeTopArticleList();
    
    /**
     * 获取 首页文章 列表
     * @param page 页码 (从 [HOME_FIRST_PAGE] 开始，为了兼容旧版本)
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "article/list/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.HomeArticleEntity>> getHomeArticleList(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * 获取 知识体系 二级数据 列表
     * @param page 页码 (为了兼容以前的, 从0开始)
     * @param id 二级数据 ID
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "article/list/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildEntity>> getKnowledgeClassifyChildList(@retrofit2.http.Path(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "cid")
    java.lang.String id);
}