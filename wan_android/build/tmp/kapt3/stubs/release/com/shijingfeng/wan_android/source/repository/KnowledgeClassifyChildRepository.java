package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 知识体系 二级数据 仓库
 * Date: 2020/4/21 20:31
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J?\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\u0010Jp\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015`\u00102\'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u000bj\u0002`\u0019J\b\u0010\u001a\u001a\u00020\u0007H\u0016J?\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/KnowledgeClassifyChildRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/KnowledgeClassifyChildNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/KnowledgeClassifyChildNetworkSource;)V", "collected", "", "articleId", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "getKnowledgeClassifyChild", "page", "", "id", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildEntity;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollected", "wan_android_release"})
public final class KnowledgeClassifyChildRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.KnowledgeClassifyChildNetworkSource> {
    
    /**
     * 获取　知识体系 二级数据
     *
     * @param page       页码
     * @param id         ID
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getKnowledgeClassifyChild(int page, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.KnowledgeClassifyChildEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    public final void collected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调
     */
    public final void uncollected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public KnowledgeClassifyChildRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.KnowledgeClassifyChildNetworkSource networkSource) {
        super(null, null);
    }
    
    public KnowledgeClassifyChildRepository() {
        super(null, null);
    }
}