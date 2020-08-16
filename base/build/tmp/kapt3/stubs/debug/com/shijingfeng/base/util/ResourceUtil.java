package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\u001a\u0012\u0010\t\u001a\u00020\u00012\b\b\u0001\u0010\n\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0001\u001a\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0003\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0001\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0003\u001a\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u0019\u001a\u00020\u0001\u001a\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u0003\u001a\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u0003\u001a\u001a\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00032\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!\u001a\u001d\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010#2\b\b\u0001\u0010\u0019\u001a\u00020\u0001\u00a2\u0006\u0002\u0010$\u001a\u001b\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010&\u001a\u0010\u0010\'\u001a\u00020\u00032\b\b\u0001\u0010(\u001a\u00020\u0001\u001a\u000e\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"RESOURCE_NONE", "", "RESOURCE_TYPE_ARRAY", "", "RESOURCE_TYPE_COLOR", "RESOURCE_TYPE_DIMEN", "RESOURCE_TYPE_DRAWABLE", "RESOURCE_TYPE_MIPMAP", "RESOURCE_TYPE_STRING", "getColorById", "color", "getColorByIdName", "colorResName", "getDimensionById", "", "dimenId", "getDimensionByIdName", "dimenResName", "getDrawableById", "Landroid/graphics/drawable/Drawable;", "drawableId", "getDrawableByIdName", "drawableResName", "getIntArrayById", "", "arrayId", "getIntArrayByIdName", "arrayResName", "getMipmapByIdName", "mipmapResName", "getResId", "variableName", "cls", "Ljava/lang/Class;", "getStringArrayById", "", "(I)[Ljava/lang/String;", "getStringArrayByIdName", "(Ljava/lang/String;)[Ljava/lang/String;", "getStringById", "stringId", "getStringByIdName", "stringResName", "base_debug"})
public final class ResourceUtil {
    
    /**
     * 资源类型: Color(颜色)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_TYPE_COLOR = "color";
    
    /**
     * 资源类型: Drawable(图片)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_TYPE_DRAWABLE = "drawable";
    
    /**
     * 资源类型: Mipmap(图标)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_TYPE_MIPMAP = "mipmap";
    
    /**
     * 资源类型: String(字符串文本)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_TYPE_STRING = "string";
    
    /**
     * 资源名称: Dimen(尺寸)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_TYPE_DIMEN = "dimen";
    
    /**
     * 资源名称: Array(数组)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String RESOURCE_TYPE_ARRAY = "array";
    
    /**
     * 没有资源
     */
    public static final int RESOURCE_NONE = 0;
    
    /**
     * 通过发射获取资源ID
     * @param variableName 资源ID 名称
     * @param cls 资源ID 类型
     * @return 资源ID
     */
    public static final int getResId(@org.jetbrains.annotations.NotNull()
    java.lang.String variableName, @org.jetbrains.annotations.NotNull()
    java.lang.Class<?> cls) {
        return 0;
    }
    
    /**
     * 通过 资源ID 获取 ColorInt
     * @param color Color Id
     * @return ColorInt
     */
    @androidx.annotation.ColorInt()
    public static final int getColorById(@androidx.annotation.ColorRes()
    int color) {
        return 0;
    }
    
    /**
     * 通过 资源名称 获取 ColorInt
     * @param colorResName 资源名称
     */
    @androidx.annotation.ColorInt()
    public static final int getColorByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String colorResName) {
        return 0;
    }
    
    /**
     * 通过 资源ID 获取 Drawable
     * @param drawableId Drawable Id
     * @return Drawable
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.drawable.Drawable getDrawableById(@androidx.annotation.DrawableRes()
    int drawableId) {
        return null;
    }
    
    /**
     * 通过 资源名称 获取 Drawable
     * @param drawableResName 资源名称
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.drawable.Drawable getDrawableByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String drawableResName) {
        return null;
    }
    
    /**
     * 通过 资源名称 获取 Drawable (mipmap文件夹内)
     * @param mipmapResName 资源名称
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.drawable.Drawable getMipmapByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String mipmapResName) {
        return null;
    }
    
    /**
     * 通过 资源ID 获取 String字符串
     * @param stringId 字符串 Id
     * @return 字符串
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getStringById(@androidx.annotation.StringRes()
    int stringId) {
        return null;
    }
    
    /**
     * 通过 资源名称 获取 String字符串
     * @param stringResName
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getStringByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String stringResName) {
        return null;
    }
    
    /**
     * 通过 资源ID 获取 尺寸
     * @param dimenId 尺寸 Id
     * @return 尺寸
     */
    public static final float getDimensionById(@androidx.annotation.DimenRes()
    int dimenId) {
        return 0.0F;
    }
    
    /**
     * 通过 资源名称 获取 尺寸
     * @param dimenResName
     */
    public static final float getDimensionByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String dimenResName) {
        return 0.0F;
    }
    
    /**
     * 通过 资源ID 获取 字符串数组
     * @param arrayId 字符串数组资源 ID
     * @return 字符串数组资源
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String[] getStringArrayById(@androidx.annotation.ArrayRes()
    int arrayId) {
        return null;
    }
    
    /**
     * 通过 资源名称 获取 字符串数组
     * @param arrayResName 字符串数组 资源名称
     * @return 字符串数组资源
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.String[] getStringArrayByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String arrayResName) {
        return null;
    }
    
    /**
     * 通过 资源ID 获取 整数数组
     * @param arrayId 整数数组 ID
     * @return 整数数组
     */
    @org.jetbrains.annotations.Nullable()
    public static final int[] getIntArrayById(@androidx.annotation.ArrayRes()
    int arrayId) {
        return null;
    }
    
    /**
     * 通过 资源名称 获取 整数数组
     * @param arrayResName 整数数组 资源名称
     * @return 整数数组资源
     */
    @org.jetbrains.annotations.Nullable()
    public static final int[] getIntArrayByIdName(@org.jetbrains.annotations.NotNull()
    java.lang.String arrayResName) {
        return null;
    }
}