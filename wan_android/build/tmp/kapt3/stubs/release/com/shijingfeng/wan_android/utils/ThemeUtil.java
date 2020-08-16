package com.shijingfeng.wan_android.utils;

import java.lang.System;

/**
 * Function: 主题 工具类
 * Date: 2020/5/31 16:37
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/shijingfeng/wan_android/utils/ThemeUtil;", "", "()V", "curThemeColor", "", "getCurThemeColor", "()I", "setCurThemeColor", "(I)V", "curThemeName", "", "getCurThemeName", "()Ljava/lang/String;", "setCurThemeName", "(Ljava/lang/String;)V", "mCurThemeColor", "Ljava/lang/Integer;", "mCurThemeName", "wan_android_release"})
public final class ThemeUtil {
    
    /**
     * 当前主题颜色
     */
    @androidx.annotation.ColorInt()
    private static java.lang.Integer mCurThemeColor;
    
    /**
     * 当前主题名称
     */
    private static java.lang.String mCurThemeName;
    public static final com.shijingfeng.wan_android.utils.ThemeUtil INSTANCE = null;
    
    public final int getCurThemeColor() {
        return 0;
    }
    
    public final void setCurThemeColor(int curThemeColor) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurThemeName() {
        return null;
    }
    
    public final void setCurThemeName(@org.jetbrains.annotations.NotNull()
    java.lang.String curThemeName) {
    }
    
    private ThemeUtil() {
        super();
    }
}