package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 积分排行榜 网络源
 * Date: 2020/3/12 22:25
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jr\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u00112\'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00060\fj\u0002`\u0015J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/CoinRankNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mCoinApi", "Lcom/shijingfeng/wan_android/source/network/api/CoinApi;", "getCoinRankList", "", "page", "", "customHandleException", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/CoinRankEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_debug"})
public final class CoinRankNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    private final com.shijingfeng.wan_android.source.network.api.CoinApi mCoinApi = null;
    
    /**
     * 获取 积分排行榜 列表
     *
     * @param page     页码 (从 [COIN_RANK_FIRST_PAGE] 开始)
     * @param customHandleException true 自定义控制异常  false 统一处理
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getCoinRankList(int page, boolean customHandleException, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.CoinRankEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public CoinRankNetworkSource() {
        super();
    }
}