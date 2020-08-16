package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: WebView容器 网络源
 * Date: 2020/2/12 10:26
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JK\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/WebViewNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mCollectionApi", "Lcom/shijingfeng/wan_android/source/network/api/CollectionApi;", "collectedWebsite", "", "dataMap", "", "", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onCleared", "wan_android_release"})
public final class WebViewNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 收藏 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.CollectionApi mCollectionApi = null;
    
    /**
     * 收藏
     * @param dataMap 请求携带数据 (name, link)
     * @param onSuccess 成功回调函数
     */
    public final void collectedWebsite(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> dataMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public WebViewNetworkSource() {
        super();
    }
}