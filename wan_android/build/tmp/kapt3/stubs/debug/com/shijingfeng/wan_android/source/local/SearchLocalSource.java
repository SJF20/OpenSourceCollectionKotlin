package com.shijingfeng.wan_android.source.local;

import java.lang.System;

/**
 * Function: 搜索 本地源
 * Date: 20-5-3 下午8:46
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jl\u0010\u0006\u001a\u00020\u00072;\u0010\b\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\tj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0013J\b\u0010\u0014\u001a\u00020\u0007H\u0016J|\u0010\u0015\u001a\u00020\u00072\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2;\u0010\b\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\tj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n`\u000f2\'\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\tj\u0002`\u0013R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/shijingfeng/wan_android/source/local/SearchLocalSource;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "()V", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getSearchHistoryList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/shijingfeng/wan_android/entity/adapter/SearchHistoryItem;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "updateSearchHistoryList", "searchHistoryList", "wan_android_debug"})
public final class SearchLocalSource extends com.shijingfeng.base.base.source.BaseLocalSource {
    
    /**
     * 线程池
     */
    private java.util.concurrent.ExecutorService mExecutorService;
    
    /**
     * 获取 搜索历史列表 数据
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    public final void getSearchHistoryList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 更新 搜索历史列表 数据
     * @param searchHistoryList 搜索历史列表 (null 或 empty 代表清空数据)
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    public final void updateSearchHistoryList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem> searchHistoryList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public SearchLocalSource() {
        super();
    }
}