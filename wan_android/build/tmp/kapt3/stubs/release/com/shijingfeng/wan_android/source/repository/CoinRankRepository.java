package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 积分排名 Repository
 * Date: 2020/3/12 22:33
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u0082\u0001\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2=\b\u0002\u0010\f\u001a7\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\rj\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u0001`\u00112-\b\u0002\u0010\u0012\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\rj\u0004\u0018\u0001`\u0015Jl\u0010\u0016\u001a\u00020\b25\b\u0002\u0010\f\u001a/\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\rj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u0001`\u00112-\b\u0002\u0010\u0012\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\rj\u0004\u0018\u0001`\u0015Jp\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2/\u0010\f\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c`\u00112\'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\rj\u0002`\u0015J\b\u0010\u001d\u001a\u00020\bH\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/CoinRankRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/wan_android/source/local/CoinRankLocalSource;", "Lcom/shijingfeng/wan_android/source/network/CoinRankNetworkSource;", "localSource", "networkSource", "(Lcom/shijingfeng/wan_android/source/local/CoinRankLocalSource;Lcom/shijingfeng/wan_android/source/network/CoinRankNetworkSource;)V", "addCoinRankList", "", "coinRankList", "", "Lcom/shijingfeng/wan_android/entity/CoinRankItem;", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "clear", "", "getCoinRankList", "type", "", "page", "Lcom/shijingfeng/wan_android/entity/CoinRankEntity;", "onCleared", "wan_android_release"})
public final class CoinRankRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.wan_android.source.local.CoinRankLocalSource, com.shijingfeng.wan_android.source.network.CoinRankNetworkSource> {
    
    /**
     * 获取 积分排行榜 列表
     *
     * @param page      页码 (从 [COIN_RANK_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getCoinRankList(@com.shijingfeng.base.annotation.define.PageOperateType()
    int type, int page, @org.jetbrains.annotations.NotNull()
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
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public CoinRankRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.local.CoinRankLocalSource localSource, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.CoinRankNetworkSource networkSource) {
        super(null, null);
    }
    
    public CoinRankRepository() {
        super(null, null);
    }
}