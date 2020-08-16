package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 注册页面 仓库
 * Date: 2020/2/5 15:48
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J`\u0010\u0006\u001a\u00020\u00072/\u0010\b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000e2\'\u0010\u000f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0012J\b\u0010\u0013\u001a\u00020\u0007H\u0016Jt\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162/\u0010\b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0019`\u000e2\'\u0010\u000f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/RegisterRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/wan_android/source/network/RegisterNetworkSource;", "networkSource", "(Lcom/shijingfeng/wan_android/source/network/RegisterNetworkSource;)V", "getCoinInfo", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/CoinInfoEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "register", "postMap", "", "", "", "Lcom/shijingfeng/wan_android/entity/UserInfoEntity;", "wan_android_debug"})
public final class RegisterRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.wan_android.source.network.RegisterNetworkSource> {
    
    /**
     * 注册
     *
     * @param postMap 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void register(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> postMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.UserInfoEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 获取 积分信息
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getCoinInfo(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.CoinInfoEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public RegisterRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.RegisterNetworkSource networkSource) {
        super(null, null);
    }
    
    public RegisterRepository() {
        super(null, null);
    }
}