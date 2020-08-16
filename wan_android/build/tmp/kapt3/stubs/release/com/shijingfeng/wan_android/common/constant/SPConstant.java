package com.shijingfeng.wan_android.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"COIN_INFO", "", "FIRST_USE", "LOGIN", "SEARCH_HISTORY_LIST", "SP_WAN_ANDROID_APP_NAME", "THEME_COLOR", "THEME_NAME", "USER_INFO", "wan_android_release"})
public final class SPConstant {
    
    /**
     * SP 玩安卓 App Name
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SP_WAN_ANDROID_APP_NAME = "wan_android";
    
    /**
     * SP key: 当前是否已登录, value(boolean)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LOGIN = "login";
    
    /**
     * SP key: 用户信息, value(String: 序列化后加密字符串)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String USER_INFO = "login_info";
    
    /**
     * SP key: 第一次使用App, value(boolean)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FIRST_USE = "first_use";
    
    /**
     * SP key: 当前主题颜色, value(String) RGB字符串 例如: "#FFFFFF"
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String THEME_COLOR = "theme_color";
    
    /**
     * SP key: 当前主题名称, value(String) 字符串 例如: red_accent
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String THEME_NAME = "theme_name";
    
    /**
     * SP key: 积分信息, value(String: 序列化后加密字符串)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COIN_INFO = "coin_info";
    
    /**
     * SP key: 搜索历史列表, value(String: 序列化字符串)
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String SEARCH_HISTORY_LIST = "search_history_list";
}