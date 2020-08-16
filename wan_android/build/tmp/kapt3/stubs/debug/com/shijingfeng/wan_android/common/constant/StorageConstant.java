package com.shijingfeng.wan_android.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u001b\u0010\u0002\u001a\u00020\u00018@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u001b\u0010\b\u001a\u00020\u00018@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\t\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"IMAGE_CLICK_JS_ASSETS_FILE", "", "PERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR", "getPERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR", "()Ljava/lang/String;", "PERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR$delegate", "Lkotlin/Lazy;", "WAN_ANDROID_SKIN_ASSETS_FILE", "WAN_ANDROID_SKIN_FILE", "getWAN_ANDROID_SKIN_FILE", "WAN_ANDROID_SKIN_FILE$delegate", "wan_android_debug"})
public final class StorageConstant {
    
    /**
     * 内部存储 -> 应用私有目录 -> skin目录  /data/data/<application package>/files/skin/
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy PERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR$delegate = null;
    
    /**
     * 玩Android 本地皮肤文件
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy WAN_ANDROID_SKIN_FILE$delegate = null;
    
    /**
     * assets目录内 玩Android皮肤文件
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WAN_ANDROID_SKIN_ASSETS_FILE = "wan_android_skin.skin";
    
    /**
     * assets目录内 图片点击 js文件
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_CLICK_JS_ASSETS_FILE = "js/image_click.js";
    
    /**
     * 内部存储 -> 应用私有目录 -> skin目录  /data/data/<application package>/files/skin/
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getPERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR() {
        return null;
    }
    
    /**
     * 玩Android 本地皮肤文件
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getWAN_ANDROID_SKIN_FILE() {
        return null;
    }
}