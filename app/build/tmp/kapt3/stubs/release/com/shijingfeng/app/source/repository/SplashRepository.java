package com.shijingfeng.app.source.repository;

import java.lang.System;

/**
 * Function: 启动页 仓库
 * Date: 2020/5/23 15:50
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J`\u0010\u0007\u001a\u00020\b2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0013J\b\u0010\u0014\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/shijingfeng/app/source/repository/SplashRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/app/source/local/SplashLocalSource;", "Lcom/shijingfeng/app/source/network/SplashNetworkSource;", "localSource", "networkSource", "(Lcom/shijingfeng/app/source/local/SplashLocalSource;Lcom/shijingfeng/app/source/network/SplashNetworkSource;)V", "checkForUpdate", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "app_release"})
public final class SplashRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.app.source.local.SplashLocalSource, com.shijingfeng.app.source.network.SplashNetworkSource> {
    
    /**
     * 检查版本更新
     *
     * @param onSuccess 成功回调监听器
     * @param onFailure 失败回调监听器
     */
    public final void checkForUpdate(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public SplashRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.app.source.local.SplashLocalSource localSource, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.app.source.network.SplashNetworkSource networkSource) {
        super(null, null);
    }
    
    public SplashRepository() {
        super(null, null);
    }
}