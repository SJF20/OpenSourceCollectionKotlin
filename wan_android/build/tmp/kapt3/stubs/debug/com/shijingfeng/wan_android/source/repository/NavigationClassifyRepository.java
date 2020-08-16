package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function:
 * Date: 2020/4/21 22:17
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005Jl\u0010\u0006\u001a\u00020\u00072;\u0010\b\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\tj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0013J\b\u0010\u0014\u001a\u00020\u0007H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/NavigationClassifyRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/NavigationClassifyNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/NavigationClassifyNetworkSource;)V", "getNavigationClassifyList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/shijingfeng/wan_android/entity/NavigationClassifyEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_debug"})
public final class NavigationClassifyRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.NavigationClassifyNetworkSource> {
    
    /**
     * 获取导航体系数据列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getNavigationClassifyList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.NavigationClassifyEntity>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public NavigationClassifyRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.NavigationClassifyNetworkSource networkSource) {
        super(null, null);
    }
    
    public NavigationClassifyRepository() {
        super(null, null);
    }
}