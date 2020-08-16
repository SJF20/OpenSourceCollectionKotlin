package com.shijingfeng.base.gson;

import java.lang.System;

/**
 * Function: Gson Int 类型 适配器
 * Date: 2020/5/16 22:14
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/base/gson/BooleanTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "", "()V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Boolean;", "write", "", "writer", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Boolean;)V", "base_debug"})
public final class BooleanTypeAdapter extends com.google.gson.TypeAdapter<java.lang.Boolean> {
    
    /**
     * Writes one JSON value (an array, object, string, number, boolean or null)
     * for `value`.
     *
     * @param value the Java object to write. May be null.
     */
    @java.lang.Override()
    public void write(@org.jetbrains.annotations.NotNull()
    com.google.gson.stream.JsonWriter writer, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean value) {
    }
    
    /**
     * Reads one JSON value (an array, object, string, number, boolean or null)
     * and converts it to a Java object. Returns the converted object.
     *
     * @return the converted Java object. May be null.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Boolean read(@org.jetbrains.annotations.NotNull()
    com.google.gson.stream.JsonReader reader) {
        return null;
    }
    
    public BooleanTypeAdapter() {
        super();
    }
}