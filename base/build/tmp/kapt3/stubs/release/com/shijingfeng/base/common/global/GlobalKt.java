package com.shijingfeng.base.common.global;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\b\u001a\u00020\u0001\u001a\u001e\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"mainHandler", "Landroid/os/Handler;", "sophixHasInitialized", "", "getSophixHasInitialized", "()Z", "setSophixHasInitialized", "(Z)V", "getMainHandler", "runOnUiThread", "delay", "", "action", "Lkotlin/Function0;", "", "base_release"})
public final class GlobalKt {
    
    /**
     * 主线程 Handler
     */
    private static final android.os.Handler mainHandler = null;
    
    /**
     * 阿里 Sophix 热修复 是否已经初始化 (用于单模块调试时, 不需要初始化 Sophix, 调用 killProcessSafely 闪退问题)
     */
    private static boolean sophixHasInitialized = false;
    
    /**
     * 获取 主线程 Handler
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.os.Handler getMainHandler() {
        return null;
    }
    
    /**
     * 运行在主线程
     * @param action 要执行的回调
     */
    public static final boolean runOnUiThread(long delay, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> action) {
        return false;
    }
    
    public static final boolean getSophixHasInitialized() {
        return false;
    }
    
    public static final void setSophixHasInitialized(boolean p0) {
    }
}