package com.shijingfeng.view_original_image.source.repository;

import java.lang.System;

/**
 * Function: 查看大图 仓库
 * Date: 2020/1/29 13:20
 * Description:
 * Author: ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005Jh\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2/\u0010\n\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\u00102\'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000bj\u0002`\u0014J\b\u0010\u0015\u001a\u00020\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/view_original_image/source/repository/ViewOriginalImageRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "Lcom/shijingfeng/view_original_image/source/network/ViewOriginalImageNetworkSource;", "networkSource", "(Lcom/shijingfeng/view_original_image/source/network/ViewOriginalImageNetworkSource;)V", "downloadImage", "", "imageUrl", "", "onSuccess", "Lkotlin/Function1;", "Lokhttp3/ResponseBody;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/network/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/network/http/exception/E;", "e", "Lcom/shijingfeng/network/extension/onFailure;", "onCleared", "view_original_image_debug"})
public final class ViewOriginalImageRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.base.base.source.BaseLocalSource, com.shijingfeng.view_original_image.source.network.ViewOriginalImageNetworkSource> {
    
    /**
     * 下载图片
     * @param imageUrl 图片地址
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void downloadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super okhttp3.ResponseBody, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.network.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public ViewOriginalImageRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.view_original_image.source.network.ViewOriginalImageNetworkSource networkSource) {
        super(null, null);
    }
    
    public ViewOriginalImageRepository() {
        super(null, null);
    }
}