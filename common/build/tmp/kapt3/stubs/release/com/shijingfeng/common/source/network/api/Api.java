package com.shijingfeng.common.source.network.api;

import java.lang.System;

/**
 * Function: 通用 Retrofit Api
 * Date: 2020/1/23 20:52
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/shijingfeng/common/source/network/api/Api;", "", "downloadFile", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "url", "", "common_release"})
public abstract interface Api {
    
    /**
     * 下载文件
     * @param url 全限定URL地址
     * @return RxJava Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET()
    @retrofit2.http.Streaming()
    public abstract retrofit2.Call<okhttp3.ResponseBody> downloadFile(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Url()
    java.lang.String url);
}