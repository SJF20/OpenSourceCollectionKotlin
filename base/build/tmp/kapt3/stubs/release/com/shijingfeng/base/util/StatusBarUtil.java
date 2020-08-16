package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"getStatusBarHeight", "", "setStatusBarColor", "", "activity", "Landroid/app/Activity;", "color", "setStatusBarContentColor", "dark", "", "base_release"})
public final class StatusBarUtil {
    
    /**
     * 设置 状态栏背景 颜色
     * @param color 颜色资源
     */
    public static final void setStatusBarColor(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.ColorRes()
    int color) {
    }
    
    /**
     * 设置 状态栏内容 颜色
     * @param dark 深色 或 浅色   true: 深色  false: 浅色
     */
    @android.annotation.TargetApi(value = 23)
    public static final void setStatusBarContentColor(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, boolean dark) {
    }
    
    /**
     * 获取状态栏高度
     * @return 高度
     */
    public static final int getStatusBarHeight() {
        return 0;
    }
}