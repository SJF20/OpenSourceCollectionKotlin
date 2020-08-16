package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 我的收藏 -> 网站收藏 网络源
 * Date: 2020/3/24 22:59
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J?\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u000fJl\u0010\u0010\u001a\u00020\u00062;\u0010\t\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011`\u000f2\'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016Jt\u0010\u0018\u001a\u00020\u00062\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u001a2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012`\u000f2\'\u0010\u0013\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00060\nj\u0002`\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/PersonalCollectionWebsiteNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mCollectionApi", "Lcom/shijingfeng/wan_android/source/network/api/CollectionApi;", "deleteWebsite", "", "id", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "getWebsiteCollectedList", "", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "updateWebsite", "dataMap", "", "wan_android_release"})
public final class PersonalCollectionWebsiteNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 收藏相关 Api
     */
    private com.shijingfeng.wan_android.source.network.api.CollectionApi mCollectionApi;
    
    /**
     * 获取 网站收藏列表
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getWebsiteCollectedList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 编辑 网站
     * @param dataMap 请求参数集合 id，name，link
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void updateWebsite(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> dataMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 删除 网站
     * @param id 网站 ID
     * @param onSuccess 成功回调函数
     */
    public final void deleteWebsite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public PersonalCollectionWebsiteNetworkSource() {
        super();
    }
}