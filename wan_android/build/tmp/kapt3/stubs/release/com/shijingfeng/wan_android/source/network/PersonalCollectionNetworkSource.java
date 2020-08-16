package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 我的收藏 网络源
 * Date: 2020/3/22 19:15
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jh\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0013J\b\u0010\u0014\u001a\u00020\u0006H\u0016Jp\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0019`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/PersonalCollectionNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mCollectionApi", "Lcom/shijingfeng/wan_android/source/network/api/CollectionApi;", "getArticleCollectedList", "", "page", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionArticleEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollectedInCollectedList", "articleId", "", "originId", "", "wan_android_release"})
public final class PersonalCollectionNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 收藏相关 Api
     */
    private com.shijingfeng.wan_android.source.network.api.CollectionApi mCollectionApi;
    
    /**
     * 获取文章收藏列表
     * @param page      页码 (从 0 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getArticleCollectedList(int page, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.PersonalCollectionArticleEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 文章收藏列表 内 取消收藏
     * @param articleId 文章ID
     * @param originId  originId
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void uncollectedInCollectedList(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    java.lang.String originId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public PersonalCollectionNetworkSource() {
        super();
    }
}