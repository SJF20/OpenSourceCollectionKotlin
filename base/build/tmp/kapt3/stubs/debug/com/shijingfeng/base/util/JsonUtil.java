package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\'\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b\u00a2\u0006\u0002\u0010\f\u001a!\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000f\u001a\b\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u0011\u001a\u00020\t\"\u0004\b\u0000\u0010\u00072\b\u0010\u0012\u001a\u0004\u0018\u0001H\u0007\u00a2\u0006\u0002\u0010\u0013\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0014"}, d2 = {"gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "deserialize", "T", "json", "", "clz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "initGson", "serialize", "any", "(Ljava/lang/Object;)Ljava/lang/String;", "base_debug"})
public final class JsonUtil {
    
    /**
     * Gson实例
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy gson$delegate = null;
    
    /**
     * Gson实例
     */
    @org.jetbrains.annotations.NotNull()
    public static final com.google.gson.Gson getGson() {
        return null;
    }
    
    /**
     * 初始化 Gson
     * @return 获得 Gson
     */
    private static final com.google.gson.Gson initGson() {
        return null;
    }
    
    /**
     * 将对象准换为json字符串
     * @param any 要序列化的对象
     * @param <T> 对象类型
     * @return Json序列化字符串
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>java.lang.String serialize(@org.jetbrains.annotations.Nullable()
    T any) {
        return null;
    }
    
    /**
     * 将json字符串转换为对象
     * @param json Json字符串
     * @param type 对象类型
     * @param <T> 对象泛型类型
     * @return 对象
     */
    public static final <T extends java.lang.Object>T deserialize(@org.jetbrains.annotations.NotNull()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    java.lang.reflect.Type type) {
        return null;
    }
    
    /**
     * 将json字符串转换为对象
     * @param json Json字符串
     * @param clz 对象类型
     * @param <T> 对象泛型类型
     * @return 对象
     */
    public static final <T extends java.lang.Object>T deserialize(@org.jetbrains.annotations.NotNull()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clz) {
        return null;
    }
}