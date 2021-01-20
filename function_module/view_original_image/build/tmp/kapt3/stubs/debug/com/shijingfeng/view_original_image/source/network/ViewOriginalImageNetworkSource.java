package com.shijingfeng.view_original_image.source.network;

import java.lang.System;

/**
 * Function: 查看大图 网络源
 * Date: 2020/1/29 20:03
 * Description:
 * Author: ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jh\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2/\u0010\f\u001a+\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u00112\'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\rj\u0002`\u0015J\b\u0010\u0016\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/shijingfeng/view_original_image/source/network/ViewOriginalImageNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mApi", "Lcom/shijingfeng/view_original_image/source/network/api/Api;", "mDownloadImageCall", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "downloadImage", "", "imageUrl", "", "onSuccess", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/network/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/network/http/exception/E;", "e", "Lcom/shijingfeng/network/extension/onFailure;", "onCleared", "view_original_image_debug"})
public final class ViewOriginalImageNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    private final com.shijingfeng.view_original_image.source.network.api.Api mApi = null;
    private retrofit2.Call<okhttp3.ResponseBody> mDownloadImageCall;
    
    /**
     * 下载图片
     * @param imageUrl 图片地址
     */
    public final void downloadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super okhttp3.ResponseBody, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.network.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public ViewOriginalImageNetworkSource() {
        super();
    }
}