package com.shijingfeng.wan_android.source.local;

import java.lang.System;

/**
 * Function: 主页 本地源
 * Date: 2020/5/17 14:59
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jl\u0010\u0006\u001a\u00020\u000725\b\u0002\u0010\b\u001a/\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u0001`\u000e2-\b\u0002\u0010\u000f\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tj\u0004\u0018\u0001`\u0012J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/shijingfeng/wan_android/source/local/MainLocalSource;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "()V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "logout", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_release"})
public final class MainLocalSource extends com.shijingfeng.base.base.source.BaseLocalSource {
    
    /**
     * 线程池
     */
    private final java.util.concurrent.ExecutorService mExecutorService = null;
    
    /**
     * 退出登录
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void logout(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public MainLocalSource() {
        super();
    }
}