package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: WebView容器 仓库
 * Date: 2020/3/24 11:41
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005JK\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2/\u0010\f\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u0012J\b\u0010\u0013\u001a\u00020\u0007H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/WebViewRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/WebViewNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/WebViewNetworkSource;)V", "collectedWebsite", "", "dataMap", "", "", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onCleared", "wan_android_debug"})
public final class WebViewRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.WebViewNetworkSource> {
    
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
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public WebViewRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.WebViewNetworkSource networkSource) {
        super(null, null);
    }
    
    public WebViewRepository() {
        super(null, null);
    }
}