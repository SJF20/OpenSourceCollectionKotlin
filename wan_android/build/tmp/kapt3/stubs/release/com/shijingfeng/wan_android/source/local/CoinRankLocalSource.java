package com.shijingfeng.wan_android.source.local;

import java.lang.System;

/**
 * Function: 积分排行榜 本地源
 * Date: 2020/5/11 14:53
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0082\u0001\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2=\b\u0002\u0010\u000b\u001a7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u0001`\u00102-\b\u0002\u0010\u0011\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u0014Jl\u0010\u0015\u001a\u00020\u000725\b\u0002\u0010\u000b\u001a/\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u0001`\u00102-\b\u0002\u0010\u0011\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fj\u0004\u0018\u0001`\u0014J`\u0010\u0017\u001a\u00020\u00072/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\fj\u0002`\u0014J\b\u0010\u0019\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/wan_android/source/local/CoinRankLocalSource;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "()V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "addCoinRankList", "", "coinRankList", "", "Lcom/shijingfeng/wan_android/entity/CoinRankItem;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "clear", "", "getCoinRankList", "Lcom/shijingfeng/wan_android/entity/CoinRankEntity;", "onCleared", "wan_android_release"})
public final class CoinRankLocalSource extends com.shijingfeng.base.base.source.BaseLocalSource {
    
    /**
     * 线程池
     */
    private final java.util.concurrent.ExecutorService mExecutorService = null;
    
    /**
     * 获取 积分排行榜 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getCoinRankList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.CoinRankEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 添加 积分排行榜 列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void addCoinRankList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> coinRankList, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清空
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void clear(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public CoinRankLocalSource() {
        super();
    }
}