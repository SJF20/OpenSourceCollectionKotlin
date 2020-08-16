package com.shijingfeng.background_service.entity;

import java.lang.System;

/**
 * Function: 请求服务器返回的结果
 * Date: 2020/2/4 16:08
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00018\u0000H\u00c6\u0003\u00a2\u0006\u0002\u0010\fJ4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000H\u00c6\u0001\u00a2\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/background_service/entity/ResultEntity;", "T", "", "code", "", "msg", "", "data", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getMsg", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/shijingfeng/background_service/entity/ResultEntity;", "equals", "", "other", "hashCode", "toString", "background_service_release"})
public final class ResultEntity<T extends java.lang.Object> {
    
    /**
     * 错误码 或 成功码
     */
    @com.google.gson.annotations.SerializedName(value = "code")
    private final int code = 0;
    
    /**
     * 错误信息
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "message")
    private final java.lang.String msg = null;
    
    /**
     * 数据
     */
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.SerializedName(value = "data")
    private final T data = null;
    
    /**
     * 错误码 或 成功码
     */
    public final int getCode() {
        return 0;
    }
    
    /**
     * 错误信息
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMsg() {
        return null;
    }
    
    /**
     * 数据
     */
    @org.jetbrains.annotations.Nullable()
    public final T getData() {
        return null;
    }
    
    public ResultEntity(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, @org.jetbrains.annotations.Nullable()
    T data) {
        super();
    }
    
    public ResultEntity() {
        super();
    }
    
    /**
     * 错误码 或 成功码
     */
    public final int component1() {
        return 0;
    }
    
    /**
     * 错误信息
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 数据
     */
    @org.jetbrains.annotations.Nullable()
    public final T component3() {
        return null;
    }
    
    /**
     * Function: 请求服务器返回的结果
     * Date: 2020/2/4 16:08
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.background_service.entity.ResultEntity<T> copy(int code, @org.jetbrains.annotations.NotNull()
    java.lang.String msg, @org.jetbrains.annotations.Nullable()
    T data) {
        return null;
    }
    
    /**
     * Function: 请求服务器返回的结果
     * Date: 2020/2/4 16:08
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 请求服务器返回的结果
     * Date: 2020/2/4 16:08
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 请求服务器返回的结果
     * Date: 2020/2/4 16:08
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}