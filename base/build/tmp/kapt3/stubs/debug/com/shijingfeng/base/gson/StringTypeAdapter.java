package com.shijingfeng.base.gson;

import java.lang.System;

/**
 * Function: Gson String 类型 适配器
 * Date: 2020/5/16 22:00
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/base/gson/StringTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "base_debug"})
public final class StringTypeAdapter extends com.google.gson.TypeAdapter<java.lang.String> {
    
    /**
     * 序列化
     */
    @java.lang.Override()
    public void write(@org.jetbrains.annotations.NotNull()
    com.google.gson.stream.JsonWriter writer, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    /**
     * 反序列化
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String read(@org.jetbrains.annotations.NotNull()
    com.google.gson.stream.JsonReader reader) {
        return null;
    }
    
    public StringTypeAdapter() {
        super();
    }
}