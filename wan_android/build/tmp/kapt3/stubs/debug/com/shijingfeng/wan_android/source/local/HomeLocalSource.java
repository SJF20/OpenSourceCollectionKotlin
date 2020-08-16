package com.shijingfeng.wan_android.source.local;

import java.lang.System;

/**
 * Function: 首页 本地源
 * Date: 2020/5/10 20:38
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J`\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\t0\u000bj\u0002`\u0014J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/wan_android/source/local/HomeLocalSource;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "()V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "mWanAndroidDatabase", "Lcom/shijingfeng/wan_android/database/room/WanAndroidDatabase;", "getHomeDataList", "", "onSuccess", "Lkotlin/Function1;", "Lcom/shijingfeng/wan_android/entity/HomeDataEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_debug"})
public final class HomeLocalSource extends com.shijingfeng.base.base.source.BaseLocalSource {
    private final java.util.concurrent.ExecutorService mExecutorService = null;
    private com.shijingfeng.wan_android.database.room.WanAndroidDatabase mWanAndroidDatabase;
    
    /**
     * 获取首页数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getHomeDataList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.HomeDataEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public HomeLocalSource() {
        super();
    }
}