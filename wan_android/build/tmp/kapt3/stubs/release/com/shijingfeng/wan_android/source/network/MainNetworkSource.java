package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 主页 Activity 网络源
 * Date: 2020/2/10 16:25
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J`\u0010\u0005\u001a\u00020\u00062/\u0010\u0007\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\r2\'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\bj\u0002`\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/MainNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mUserApi", "Lcom/shijingfeng/wan_android/source/network/api/UserApi;", "logout", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_release"})
public final class MainNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    private final com.shijingfeng.wan_android.source.network.api.UserApi mUserApi = null;
    
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
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public MainNetworkSource() {
        super();
    }
}