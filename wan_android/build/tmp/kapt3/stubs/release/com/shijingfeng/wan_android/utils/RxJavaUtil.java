package com.shijingfeng.wan_android.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u009c\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b25\b\u0002\u0010\t\u001a/\u0012\u0015\u0012\u0013\u0018\u0001H\u0002\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u0001`\u000f2-\b\u0002\u0010\u0010\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u0013H\u0000\u00a8\u0006\u0014"}, d2 = {"apiRequest", "Lio/reactivex/disposables/Disposable;", "D", "R", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "single", "Lio/reactivex/Single;", "customHandleException", "", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "wan_android_release"})
public final class RxJavaUtil {
    
    /**
     * 网络请求
     * @param single 被观察的网络资源
     * @param customHandleException true 自定义控制异常  false 统一处理
     * @param onSuccess 成功函数回调
     * @param onFailure 失败函数回调
     */
    @org.jetbrains.annotations.NotNull()
    public static final <D extends java.lang.Object, R extends com.shijingfeng.wan_android.entity.ResultEntity<D>>io.reactivex.disposables.Disposable apiRequest(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<R> single, boolean customHandleException, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super D, kotlin.Unit> onSuccess, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
        return null;
    }
}