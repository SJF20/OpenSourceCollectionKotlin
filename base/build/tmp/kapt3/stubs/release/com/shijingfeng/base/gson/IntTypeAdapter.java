package com.shijingfeng.base.gson;

import java.lang.System;

/**
 * Function: Gson Int 类型 适配器
 * Date: 2020/5/16 22:05
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/base/gson/IntTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Integer;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Integer;)V", "base_release"})
public final class IntTypeAdapter extends com.google.gson.TypeAdapter<java.lang.Integer> {
    
    /**
     * 序列化
     */
    @java.lang.Override()
    public void write(@org.jetbrains.annotations.Nullable()
    com.google.gson.stream.JsonWriter writer, @org.jetbrains.annotations.Nullable()
    java.lang.Integer value) {
    }
    
    /**
     * 反序列化
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Integer read(@org.jetbrains.annotations.NotNull()
    com.google.gson.stream.JsonReader reader) {
        return null;
    }
    
    public IntTypeAdapter() {
        super();
    }
}