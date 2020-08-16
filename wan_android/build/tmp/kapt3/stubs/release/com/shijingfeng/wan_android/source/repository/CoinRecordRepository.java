package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 积分记录 Repository
 * Date: 2020/3/16 21:47
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005Jh\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000bj\u0002`\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/CoinRecordRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/CoinRecordNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/CoinRecordNetworkSource;)V", "getCoinRecordList", "", "page", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/CoinRecordEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_release"})
public final class CoinRecordRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.CoinRecordNetworkSource> {
    
    /**
     * 获取 积分排行榜 列表
     *
     * @param page     页码 (从 [COIN_RECORD_FIRST_PAGE] 开始)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getCoinRecordList(int page, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.CoinRecordEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public CoinRecordRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.CoinRecordNetworkSource networkSource) {
        super(null, null);
    }
    
    public CoinRecordRepository() {
        super(null, null);
    }
}