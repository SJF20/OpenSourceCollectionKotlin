package com.shijingfeng.base.http.interceptor;

import java.lang.System;

/**
 * Function: Header OkHttp拦截器
 * Date: 2020/1/22 22:11
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/shijingfeng/base/http/interceptor/HeaderInterceptor;", "Lokhttp3/Interceptor;", "mHeaderMap", "", "", "(Ljava/util/Map;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "base_debug"})
public final class HeaderInterceptor implements okhttp3.Interceptor {
    private final java.util.Map<java.lang.String, java.lang.String> mHeaderMap = null;
    
    /**
     * 拦截回调
     * @param chain 拦截链
     * @return Response响应
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    public HeaderInterceptor(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> mHeaderMap) {
        super();
    }
}