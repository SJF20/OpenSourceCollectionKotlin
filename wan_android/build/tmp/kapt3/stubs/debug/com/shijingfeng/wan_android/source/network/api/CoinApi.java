package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 积分 Api
 * Date: 2020/2/10 16:22
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u001e\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\'J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\'\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/CoinApi;", "", "getCoinInfo", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "Lcom/shijingfeng/wan_android/entity/CoinInfoEntity;", "getCoinRankList", "Lcom/shijingfeng/wan_android/entity/CoinRankEntity;", "page", "", "getCoinRecordList", "Lcom/shijingfeng/wan_android/entity/CoinRecordEntity;", "wan_android_debug"})
public abstract interface CoinApi {
    
    /**
     * 获取个人积分
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/coin/userinfo/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.CoinInfoEntity>> getCoinInfo();
    
    /**
     * 获取 积分记录 列表
     * @param page 页码 从 [COIN_RECORD_FIRST_PAGE] 开始
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "lg/coin/list/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.CoinRecordEntity>> getCoinRecordList(@retrofit2.http.Path(value = "page")
    int page);
    
    /**
     * 获取 积分排行榜 列表
     * @param page 页码 从 [COIN_RANK_FIRST_PAGE] 开始
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "coin/rank/{page}/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.CoinRankEntity>> getCoinRankList(@retrofit2.http.Path(value = "page")
    int page);
}