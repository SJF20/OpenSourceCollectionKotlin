package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 主页 仓库
 * Date: 2020/2/11 12:50
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J`\u0010\u0007\u001a\u00020\b2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0013J\b\u0010\u0014\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/MainRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/wan_android/source/local/MainLocalSource;", "Lcom/shijingfeng/wan_android/source/network/MainNetworkSource;", "localSource", "networkSource", "(Lcom/shijingfeng/wan_android/source/local/MainLocalSource;Lcom/shijingfeng/wan_android/source/network/MainNetworkSource;)V", "logout", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_release"})
public final class MainRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.wan_android.source.local.MainLocalSource, com.shijingfeng.wan_android.source.network.MainNetworkSource> {
    
    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void logout(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public MainRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.local.MainLocalSource localSource, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.MainNetworkSource networkSource) {
        super(null, null);
    }
    
    public MainRepository() {
        super(null, null);
    }
}