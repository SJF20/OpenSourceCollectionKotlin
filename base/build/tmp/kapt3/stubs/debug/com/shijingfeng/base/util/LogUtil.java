package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006\u001a\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"LOG_LIFECYCLE", "", "LOG_TENCENT_X5", "LOG_TEST", "LOG_WAN_ANDROID_SKIN", "sEnable", "", "d", "", "tag", "msg", "e", "enable", "i", "v", "w", "base_debug"})
public final class LogUtil {
    
    /**
     * Function: 日志工具类
     * Date: 2020/1/18 16:50
     * Description:
     * @author ShiJingFeng
     */
    private static boolean sEnable = false;
    
    /**
     * 测试相关日志
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOG_TEST = "log_test";
    
    /**
     * 腾讯X5相关日志
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOG_TENCENT_X5 = "log_tencent_x5";
    
    /**
     * 玩Android皮肤相关日志
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOG_WAN_ANDROID_SKIN = "log_wan_android_skin";
    
    /**
     * 生命周期函数相关日志
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOG_LIFECYCLE = "log_lifecycle";
    
    /**
     * 是否开启日志
     * @param enable true 开启  false 关闭
     */
    public static final void enable(boolean enable) {
    }
    
    /**
     * 日志级别：verbose
     * @param tag 日志标签
     * @param msg 日志内容
     */
    public static final void v(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    /**
     * 日志级别：info
     * @param tag 日志标签
     * @param msg 日志内容
     */
    public static final void i(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    /**
     * 日志级别：debug
     * @param tag 日志标签
     * @param msg 日志内容
     */
    public static final void d(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    /**
     * 日志级别：warn
     * @param tag 日志标签
     * @param msg 日志内容
     */
    public static final void w(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
    
    /**
     * 日志级别：error
     * @param tag 日志标签
     * @param msg 日志内容
     */
    public static final void e(@org.jetbrains.annotations.NotNull()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    java.lang.String msg) {
    }
}