package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003\"\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\n\u0010\u0003\"\u001b\u0010\f\u001a\u00020\u00018FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\r\u0010\u0003\u00a8\u0006\u000f"}, d2 = {"PERSONAL_EXTERNAL_APK_FILE_DIR", "", "getPERSONAL_EXTERNAL_APK_FILE_DIR", "()Ljava/lang/String;", "PERSONAL_EXTERNAL_APK_FILE_DIR$delegate", "Lkotlin/Lazy;", "PERSONAL_EXTERNAL_CACHE_DIR", "getPERSONAL_EXTERNAL_CACHE_DIR", "PERSONAL_EXTERNAL_CACHE_DIR$delegate", "PERSONAL_EXTERNAL_GLIDE_CACHE_DIR", "getPERSONAL_EXTERNAL_GLIDE_CACHE_DIR", "PERSONAL_EXTERNAL_GLIDE_CACHE_DIR$delegate", "PERSONAL_INTERNAL_FILE_DIR", "getPERSONAL_INTERNAL_FILE_DIR", "PERSONAL_INTERNAL_FILE_DIR$delegate", "base_debug"})
public final class StorageConstant {
    
    /**
     * 内部存储 -> 应用私有目录 -> file目录  /data/data/<application package>/files/
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy PERSONAL_INTERNAL_FILE_DIR$delegate = null;
    
    /**
     * 外部存储 -> 应用私有目录 -> cache目录  /storage/emulated/0/Android/data/<application package>/cache/
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy PERSONAL_EXTERNAL_CACHE_DIR$delegate = null;
    
    /**
     * 外部存储 -> 应用私有目录 -> files 内 apk 目录  /storage/emulated/0/Android/data/<application package>/files/apk/
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy PERSONAL_EXTERNAL_APK_FILE_DIR$delegate = null;
    
    /**
     * 外部存储 -> 应用私有目录 -> glide目录 /storage/emulated/0/Android/data/<application package>/cache/glide/
     * 如果外部存储不存在, 则是: /data/data/<application package>/cache/glide/
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy PERSONAL_EXTERNAL_GLIDE_CACHE_DIR$delegate = null;
    
    /**
     * 内部存储 -> 应用私有目录 -> file目录  /data/data/<application package>/files/
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPERSONAL_INTERNAL_FILE_DIR() {
        return null;
    }
    
    /**
     * 外部存储 -> 应用私有目录 -> cache目录  /storage/emulated/0/Android/data/<application package>/cache/
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPERSONAL_EXTERNAL_CACHE_DIR() {
        return null;
    }
    
    /**
     * 外部存储 -> 应用私有目录 -> files 内 apk 目录  /storage/emulated/0/Android/data/<application package>/files/apk/
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPERSONAL_EXTERNAL_APK_FILE_DIR() {
        return null;
    }
    
    /**
     * 外部存储 -> 应用私有目录 -> glide目录 /storage/emulated/0/Android/data/<application package>/cache/glide/
     * 如果外部存储不存在, 则是: /data/data/<application package>/cache/glide/
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPERSONAL_EXTERNAL_GLIDE_CACHE_DIR() {
        return null;
    }
}