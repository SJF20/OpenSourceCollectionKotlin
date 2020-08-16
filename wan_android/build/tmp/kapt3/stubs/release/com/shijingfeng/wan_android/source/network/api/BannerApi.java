package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 轮播图 Api
 * Date: 2020/2/12 10:28
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u0003H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/BannerApi;", "", "getHomeBannerList", "Lio/reactivex/Single;", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "", "Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerItem;", "wan_android_release"})
public abstract interface BannerApi {
    
    /**
     * 获取 首页 轮播图 数据
     * @return Single<ResultEntity>
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "banner/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeBannerItem>>> getHomeBannerList();
}