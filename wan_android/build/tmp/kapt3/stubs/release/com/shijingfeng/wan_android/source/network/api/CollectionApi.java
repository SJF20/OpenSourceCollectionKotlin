package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 收藏 API
 * Date: 2020/2/12 10:31
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J*\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\tH\'J*\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\tH\'J\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\r\u001a\u00020\u0006H\'J\u001e\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\'J\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\u00040\u0003H\'J\u001e\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J(\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u0006H\'J*\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\tH\'\u00a8\u0006\u0018"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/CollectionApi;", "", "collectedInSitesArticle", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "articleId", "", "collectedOutSitesArticle", "postMap", "", "collectedWebsite", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "deleteWebsite", "id", "getArticleCollectedList", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionArticleEntity;", "page", "", "getWebsiteCollectedList", "", "uncollectedInArticleList", "uncollectedInCollectedList", "originId", "updateWebsite", "wan_android_release"})
public abstract interface CollectionApi {
    
    /**
     * 获取文章收藏列表
     * @param page 页码 (从 [PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE] 开始)
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/collect/list/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.PersonalCollectionArticleEntity>> getArticleCollectedList(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * 收藏站内文章
     * @param articleId 文章ID
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/collect/{articleId}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.lang.Object>> collectedInSitesArticle(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "articleId")
    java.lang.String articleId);
    
    /**
     * 收藏站外文章
     * @param postMap 请求参数集合  title，author，link
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/collect/add/json")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.lang.Object>> collectedOutSitesArticle(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.Object> postMap);
    
    /**
     * 文章列表中的文章 取消收藏
     * @param articleId 文章ID
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/uncollect_originId/{articleId}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.lang.Object>> uncollectedInArticleList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "articleId")
    java.lang.String articleId);
    
    /**
     * 收藏列表中 取消收藏
     * @param articleId 文章ID
     * @param originId 列表页下发，无则为-1
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/uncollect/{articleId}/json")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.lang.Object>> uncollectedInCollectedList(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "articleId")
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "originId")
    java.lang.String originId);
    
    /**
     * 获取 网站收藏列表
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/collect/usertools/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.util.List<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity>>> getWebsiteCollectedList();
    
    /**
     * 收藏 网站
     * @param postMap 请求参数集合 name，link
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/collect/addtool/json")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity>> collectedWebsite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.Object> postMap);
    
    /**
     * 编辑 网站
     * @param postMap 请求参数集合 id，name，link
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/collect/updatetool/json")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity>> updateWebsite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.Object> postMap);
    
    /**
     * 删除 网站
     * @param id 网站 ID
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "lg/collect/deletetool/json")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.lang.Object>> deleteWebsite(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "id")
    java.lang.String id);
}