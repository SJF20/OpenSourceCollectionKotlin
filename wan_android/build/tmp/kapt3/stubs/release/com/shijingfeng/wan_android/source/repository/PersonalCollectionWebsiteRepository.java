package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 我的收藏 -> 网站收藏 仓库
 * Date: 2020/3/25 23:22
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005Jl\u0010\u0006\u001a\u00020\u00072;\u0010\b\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\tj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0013J\b\u0010\u0014\u001a\u00020\u0007H\u0016J?\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172/\u0010\b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u000fJt\u0010\u0019\u001a\u00020\u00072\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u001b2/\u0010\b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionWebsiteRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/PersonalCollectionWebsiteNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/PersonalCollectionWebsiteNetworkSource;)V", "getWebsiteCollectedList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollectedWebsite", "id", "", "", "updateWebsite", "dataMap", "", "wan_android_release"})
public final class PersonalCollectionWebsiteRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.PersonalCollectionWebsiteNetworkSource> {
    
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
     * 取消收藏 网站
     * @param id 网站 ID
     * @param onSuccess 成功回调函数
     */
    public final void uncollectedWebsite(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public PersonalCollectionWebsiteRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.PersonalCollectionWebsiteNetworkSource networkSource) {
        super(null, null);
    }
    
    public PersonalCollectionWebsiteRepository() {
        super(null, null);
    }
}