package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 搜索 仓库
 * Date: 20-5-3 下午9:09
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006Jl\u0010\u0007\u001a\u00020\b2;\u0010\t\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\nj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0014Jl\u0010\u0015\u001a\u00020\b2;\u0010\t\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\nj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000b`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0014J\b\u0010\u0017\u001a\u00020\bH\u0016Jh\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2/\u0010\t\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u001b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0014J|\u0010\u001c\u001a\u00020\b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2;\u0010\t\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\b0\nj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\nj\u0002`\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/SearchRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/wan_android/source/local/SearchLocalSource;", "Lcom/shijingfeng/wan_android/source/network/SearchNetworkSource;", "localSource", "networkSource", "(Lcom/shijingfeng/wan_android/source/local/SearchLocalSource;Lcom/shijingfeng/wan_android/source/network/SearchNetworkSource;)V", "getSearchHistoryList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/shijingfeng/wan_android/entity/adapter/SearchHistoryItem;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "getSearchHotWordList", "Lcom/shijingfeng/wan_android/entity/SearchHotWordEntity;", "onCleared", "search", "keyword", "", "Lcom/shijingfeng/wan_android/entity/SearchListEntity;", "updateSearchHistory", "searchHistoryList", "wan_android_debug"})
public final class SearchRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.wan_android.source.local.SearchLocalSource, com.shijingfeng.wan_android.source.network.SearchNetworkSource> {
    
    /**
     * 获取 搜索热词列表 数据
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getSearchHotWordList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.SearchHotWordEntity>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 搜索
     * @param keyword 搜索关键词
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.SearchListEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
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
    public final void updateSearchHistory(@org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem> searchHistoryList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public SearchRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.local.SearchLocalSource localSource, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.SearchNetworkSource networkSource) {
        super(null, null);
    }
    
    public SearchRepository() {
        super(null, null);
    }
}