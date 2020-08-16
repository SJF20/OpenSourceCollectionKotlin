package com.shijingfeng.wan_android.source.repository;

import java.lang.System;

/**
 * Function: 首页 仓库
 * Date: 2020/2/12 13:21
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J?\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0011Jp\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u00112\'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\b0\fj\u0002`\u001aJ\b\u0010\u001b\u001a\u00020\bH\u0016J?\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2/\u0010\u000b\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\fj\n\u0012\u0006\u0012\u0004\u0018\u00010\r`\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/shijingfeng/wan_android/source/repository/HomeRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/wan_android/source/local/HomeLocalSource;", "Lcom/shijingfeng/wan_android/source/network/HomeNetworkSource;", "localSource", "networkSource", "(Lcom/shijingfeng/wan_android/source/local/HomeLocalSource;Lcom/shijingfeng/wan_android/source/network/HomeNetworkSource;)V", "collected", "", "articleId", "", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "getHomeDataList", "pageOperateType", "", "page", "Lcom/shijingfeng/wan_android/entity/HomeDataEntity;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "uncollected", "wan_android_release"})
public final class HomeRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.wan_android.source.local.HomeLocalSource, com.shijingfeng.wan_android.source.network.HomeNetworkSource> {
    
    /**
     * 获取首页数据
     * @param pageOperateType 页面操作类型
     * @param page 页码 (从 [HOME_FIRST_PAGE] 开始，为了兼容以前的)
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getHomeDataList(@com.shijingfeng.base.annotation.define.PageOperateType()
    int pageOperateType, int page, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.wan_android.entity.HomeDataEntity, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    public final void collected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 取消收藏
     * @param articleId 文章ID
     * @param onSuccess 成功回调函数
     */
    public final void uncollected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public HomeRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.local.HomeLocalSource localSource, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.network.HomeNetworkSource networkSource) {
        super(null, null);
    }
    
    public HomeRepository() {
        super(null, null);
    }
}