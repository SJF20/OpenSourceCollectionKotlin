package com.shijingfeng.base.http.request;

import java.lang.System;

/**
 * Function: 上传进度 请求体
 * Date: 2020/1/23 15:53
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/shijingfeng/base/http/request/ProgressRequestBody;", "Lokhttp3/RequestBody;", "mRequestBody", "mTag", "", "(Lokhttp3/RequestBody;Ljava/lang/String;)V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "readSink", "Lokio/Sink;", "sink", "Lokio/BufferedSink;", "writeTo", "", "base_release"})
public final class ProgressRequestBody extends okhttp3.RequestBody {
    private final okhttp3.RequestBody mRequestBody = null;
    private final java.lang.String mTag = null;
    
    @java.lang.Override()
    public void writeTo(@org.jetbrains.annotations.NotNull()
    okio.BufferedSink sink) {
    }
    
    /**
     * 写入，回调进度接口
     * @param sink Sink
     * @return Sink
     */
    private final okio.Sink readSink(okio.BufferedSink sink) {
        return null;
    }
    
    @java.lang.Override()
    public long contentLength() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public okhttp3.MediaType contentType() {
        return null;
    }
    
    public ProgressRequestBody(@org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody mRequestBody, @org.jetbrains.annotations.Nullable()
    java.lang.String mTag) {
        super();
    }
}