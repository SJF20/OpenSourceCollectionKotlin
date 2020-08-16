package com.shijingfeng.base.gson;

import java.lang.System;

/**
 * Function: Gson 类型处理 Factory (用于空处理，类型纠正)
 * Date: 2020/5/16 22:09
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/shijingfeng/base/gson/TypeHandleAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "base_debug"})
public final class TypeHandleAdapterFactory implements com.google.gson.TypeAdapterFactory {
    
    /**
     * 创建 TypeAdapter
     * @param gson Gson
     * @param type TypeToken
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public <T extends java.lang.Object>com.google.gson.TypeAdapter<T> create(@org.jetbrains.annotations.Nullable()
    com.google.gson.Gson gson, @org.jetbrains.annotations.Nullable()
    com.google.gson.reflect.TypeToken<T> typeToken) {
        return null;
    }
    
    public TypeHandleAdapterFactory() {
        super();
    }
}