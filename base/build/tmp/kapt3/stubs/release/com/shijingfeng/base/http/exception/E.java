package com.shijingfeng.base.http.exception;

import java.lang.System;

/**
 * Function: 请求服务器错误 或 服务器返回错误 实体类
 * Date: 2020/1/22 20:25
 * Description:
 *
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/shijingfeng/base/http/exception/E;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "errorMsg", "", "error", "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "base_release"})
public class E extends java.lang.Exception {
    
    /**
     * 错误代码
     */
    private final int errorCode = 0;
    
    /**
     * 错误内容
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String errorMsg;
    
    /**
     * 错误异常
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Throwable error = null;
    
    /**
     * 错误代码
     */
    public final int getErrorCode() {
        return 0;
    }
    
    /**
     * 错误内容
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getErrorMsg() {
        return null;
    }
    
    /**
     * 错误内容
     */
    public final void setErrorMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 错误异常
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Throwable getError() {
        return null;
    }
    
    public E(int errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.String errorMsg, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable error) {
        super();
    }
    
    public E() {
        super();
    }
}