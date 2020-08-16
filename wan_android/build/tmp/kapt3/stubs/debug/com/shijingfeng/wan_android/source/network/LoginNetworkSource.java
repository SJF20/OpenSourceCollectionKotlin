package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 登录Activity 网络数据操作实现类
 * Date: 2020/2/4 16:16
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J`\u0010\u0007\u001a\u00020\b2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0013Jt\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00162/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0019`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0013J\b\u0010\u001a\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/LoginNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mCoinApi", "Lcom/shijingfeng/wan_android/source/network/api/CoinApi;", "mUserApi", "Lcom/shijingfeng/wan_android/source/network/api/UserApi;", "getCoinInfo", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/CoinInfoEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "login", "postMap", "", "", "", "Lcom/shijingfeng/wan_android/entity/UserInfoEntity;", "onCleared", "wan_android_debug"})
public final class LoginNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    
    /**
     * 用户信息相关 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.UserApi mUserApi = null;
    
    /**
     * 积分信息相关 Api
     */
    private final com.shijingfeng.wan_android.source.network.api.CoinApi mCoinApi = null;
    
    /**
     * 登录
     * @param postMap 数据
     * @param onSuccess 成功回调监听
     * @param onFailure 失败回调监听
     */
    public final void login(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> postMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.UserInfoEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 获取 积分信息
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getCoinInfo(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.CoinInfoEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public LoginNetworkSource() {
        super();
    }
}