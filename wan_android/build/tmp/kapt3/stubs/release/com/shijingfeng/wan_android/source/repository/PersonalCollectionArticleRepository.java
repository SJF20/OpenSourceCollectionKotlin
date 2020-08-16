package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 我的收藏 -> 收藏文章列表 仓库
 * Date: 2020/3/24 22:58
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005Jh\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000bj\u0002`\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0016JG\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a`\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionArticleRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/PersonalCollectionArticleNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/PersonalCollectionArticleNetworkSource;)V", "getArticleCollectedList", "", "page", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionArticleEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollectedInCollectedList", "articleId", "", "originId", "", "wan_android_release"})
public final class PersonalCollectionArticleRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.PersonalCollectionArticleNetworkSource> {
    
    /**
     * 获取文章收藏列表
     * @param page      页码 (从 [PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getArticleCollectedList(int page, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.PersonalCollectionArticleEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 文章收藏列表 内 取消收藏
     *
     * @param articleId 文章ID
     * @param originId  originId
     * @param onSuccess 成功回调函数
     */
    public final void uncollectedInCollectedList(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    java.lang.String originId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public PersonalCollectionArticleRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.PersonalCollectionArticleNetworkSource networkSource) {
        super(null, null);
    }
    
    public PersonalCollectionArticleRepository() {
        super(null, null);
    }
}