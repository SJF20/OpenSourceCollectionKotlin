package com.shijingfeng.base.util;

import java.lang.System;

/**
 * Function: Retrofit工具类
 * Date: 2020/1/29 21:52
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/base/util/RetrofitUtil;", "", "()V", "mRetrofit", "Lretrofit2/Retrofit;", "create", "T", "api", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "initRetrofit", "base_release"})
public final class RetrofitUtil {
    private static final retrofit2.Retrofit mRetrofit = null;
    public static final com.shijingfeng.base.util.RetrofitUtil INSTANCE = null;
    
    /**
     * 创建 Retrofit 实例
     * @return Retrofit实例
     */
    private final retrofit2.Retrofit initRetrofit() {
        return null;
    }
    
    /**
     * 创建 Api 请求类
     * @param api  Api 请求原始反射类
     * @param <T> 泛型
     * @return Api 请求类
     */
    public final <T extends java.lang.Object>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> api) {
        return null;
    }
    
    private RetrofitUtil() {
        super();
    }
}