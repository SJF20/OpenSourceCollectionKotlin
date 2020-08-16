package com.shijingfeng.wan_android.common.global;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\r\"\u0002H\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u0018\u001a)\u0010\u0019\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\r\"\u0002H\u0014\u00a2\u0006\u0002\u0010\u001a\u001a1\u0010\u001b\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u001c2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\r\"\u0002H\u00142\u0006\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u001d\u001a1\u0010\u001e\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u001f2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\r\"\u0002H\u00142\u0006\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\u0002\u0010!\u001a)\u0010\"\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020#2\u0012\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\r\"\u0002H\u0014\u00a2\u0006\u0002\u0010%\u001a)\u0010&\u001a\u00020\u0013\"\b\b\u0000\u0010\u0014*\u00020\u001f2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00140\r\"\u0002H\u0014\u00a2\u0006\u0002\u0010\'\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\u00020\u00078@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\"!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006("}, d2 = {"skinChangerManager", "Lcom/shijingfeng/skin_changer/manager/SkinChangerManager;", "getSkinChangerManager", "()Lcom/shijingfeng/skin_changer/manager/SkinChangerManager;", "setSkinChangerManager", "(Lcom/shijingfeng/skin_changer/manager/SkinChangerManager;)V", "themeColorList", "", "getThemeColorList", "()[I", "themeColorList$delegate", "Lkotlin/Lazy;", "themeColorNameList", "", "", "getThemeColorNameList", "()[Ljava/lang/String;", "themeColorNameList$delegate", "setThemeBackground", "", "T", "Landroid/view/View;", "views", "resName", "([Landroid/view/View;Ljava/lang/String;)V", "setThemeBackgroundTintList", "([Landroid/view/View;)V", "setThemeButtonDrawable", "Landroid/widget/CompoundButton;", "([Landroid/widget/CompoundButton;Ljava/lang/String;)V", "setThemeSrc", "Landroid/widget/ImageView;", "imageViews", "([Landroid/widget/ImageView;Ljava/lang/String;)V", "setThemeTextColor", "Landroid/widget/TextView;", "textViews", "([Landroid/widget/TextView;)V", "setThemeTint", "([Landroid/widget/ImageView;)V", "wan_android_debug"})
public final class ThemeColorGlobal {
    
    /**
     * 主题颜色 列表
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy themeColorList$delegate = null;
    
    /**
     * 主题颜色名称 列表
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy themeColorNameList$delegate = null;
    
    /**
     * 换肤框架实例 (每个模块都可以独立的更换主题)
     */
    @org.jetbrains.annotations.NotNull()
    public static com.shijingfeng.skin_changer.manager.SkinChangerManager skinChangerManager;
    
    /**
     * 主题颜色 列表
     */
    @org.jetbrains.annotations.NotNull()
    public static final int[] getThemeColorList() {
        return null;
    }
    
    /**
     * 主题颜色名称 列表
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String[] getThemeColorNameList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shijingfeng.skin_changer.manager.SkinChangerManager getSkinChangerManager() {
        return null;
    }
    
    public static final void setSkinChangerManager(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.skin_changer.manager.SkinChangerManager p0) {
    }
    
    /**
     * View 背景 批量设置 主题背景颜色
     *
     * @param views View数组
     * @param resName 资源ID 名称
     */
    public static final <T extends android.view.View>void setThemeBackground(@org.jetbrains.annotations.NotNull()
    T[] views, @org.jetbrains.annotations.NotNull()
    java.lang.String resName) {
    }
    
    /**
     * View 背景Tint 批量设置 主题背景颜色
     *
     * @param views View数组
     */
    public static final <T extends android.view.View>void setThemeBackgroundTintList(@org.jetbrains.annotations.NotNull()
    T... views) {
    }
    
    /**
     * TextView 文本 批量设置 主题文本颜色
     *
     * @param textViews TextView数组
     */
    public static final <T extends android.widget.TextView>void setThemeTextColor(@org.jetbrains.annotations.NotNull()
    T... textViews) {
    }
    
    /**
     * ImageView 批量设置 主题图片
     *
     * @param imageViews ImageView数组
     * @param resName 资源ID 名称
     */
    public static final <T extends android.widget.ImageView>void setThemeSrc(@org.jetbrains.annotations.NotNull()
    T[] imageViews, @org.jetbrains.annotations.NotNull()
    java.lang.String resName) {
    }
    
    /**
     * ImageView Tint 批量设置 主题Tint颜色
     *
     * @param imageViews ImageView数组
     */
    public static final <T extends android.widget.ImageView>void setThemeTint(@org.jetbrains.annotations.NotNull()
    T... imageViews) {
    }
    
    /**
     * View 批量设置 主题 ButtonDrawable
     *
     * @param views View数组
     * @param resName 资源ID 名称
     * @param resType 资源类型 (Drawable)
     */
    public static final <T extends android.widget.CompoundButton>void setThemeButtonDrawable(@org.jetbrains.annotations.NotNull()
    T[] views, @org.jetbrains.annotations.NotNull()
    java.lang.String resName) {
    }
}