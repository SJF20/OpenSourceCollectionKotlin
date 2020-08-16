package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 广场 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J?\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0011Jh\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0015\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015`\u00112\'\u0010\u0016\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\b0\fj\u0002`\u0019J\b\u0010\u001a\u001a\u00020\bH\u0016J?\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/SquareNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mCollectionApi", "Lcom/shijingfeng/wan_android/source/network/api/CollectionApi;", "mSquareApi", "Lcom/shijingfeng/wan_android/source/network/api/SquareApi;", "collected", "", "articleId", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "getSquareList", "page", "", "Lcom/shijingfeng/wan_android/entity/SquareEntity;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollected", "wan_android_debug"})
public final class SquareNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 广场 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.SquareApi mSquareApi = null;
    
    /**
     * 收藏 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.CollectionApi mCollectionApi = null;
    
    /**
     * 获取 广场 数据
     *
     * @param page       页码
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getSquareList(int page, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.SquareEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
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
    
    public SquareNetworkSource() {
        super();
    }
}