package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u001a\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"IV_BYTE_ARRAY", "", "KEY_BYTE_ARRAY", "TRANSFORMATION", "", "decrypt", "str", "encrypt", "base_debug"})
public final class SecurityUtil {
    
    /**
     * 仅支持16位密码
     */
    private static final byte[] KEY_BYTE_ARRAY = null;
    private static final java.lang.String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    
    /**
     * 16位向量
     */
    private static final byte[] IV_BYTE_ARRAY = null;
    
    /**
     * 加密数据
     * @param str 要加密的数据
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String encrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
    
    /**
     * 解密数据
     * @param str 要解密的数据
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String decrypt(@org.jetbrains.annotations.NotNull()
    java.lang.String str) {
        return null;
    }
}