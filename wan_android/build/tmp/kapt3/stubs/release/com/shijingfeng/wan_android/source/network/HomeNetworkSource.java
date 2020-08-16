package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 首页 网络源
 * Date: 2020/2/12 10:26
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J?\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2/\u0010\r\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0013Jj\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162/\u0010\r\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u0017`\u00132\'\u0010\u0018\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\n0\u000ej\u0002`\u001bH\u0007J\b\u0010\u001c\u001a\u00020\nH\u0016J?\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2/\u0010\r\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f`\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/HomeNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mArticleApi", "Lcom/shijingfeng/wan_android/source/network/api/ArticleApi;", "mBannerApi", "Lcom/shijingfeng/wan_android/source/network/api/BannerApi;", "mCollectionApi", "Lcom/shijingfeng/wan_android/source/network/api/CollectionApi;", "collected", "", "articleId", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "getHomeDataList", "page", "", "Lcom/shijingfeng/wan_android/entity/HomeDataEntity;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollected", "wan_android_release"})
public final class HomeNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 轮播图 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.BannerApi mBannerApi = null;
    
    /**
     * 文章 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.ArticleApi mArticleApi = null;
    
    /**
     * 收藏 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.CollectionApi mCollectionApi = null;
    
    /**
     * 获取首页数据
     * @param page 页码 (从 [HOME_FIRST_PAGE] 开始，为了兼容以前的)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    @android.annotation.SuppressLint(value = {"CheckResult"})
    public final void getHomeDataList(int page, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.HomeDataEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    public final void collected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    public final void uncollected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public HomeNetworkSource() {
        super();
    }
}