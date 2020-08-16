package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"BASE_URL_NAME_PGYER", "", "BASE_URL_NAME_WAN_ANDROID", "BASE_URL_VALUE_PGYER", "BASE_URL_VALUE_WAN_ANDROID", "DOMAIN_HEADER", "base_debug"})
public final class NetworkConstant {
    
    /**
     * BaseUrl动态替换 Header Name
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DOMAIN_HEADER = "Domain-Name:";
    
    /**
     * 玩安卓 BaseUrl Name
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_NAME_WAN_ANDROID = "wan_android";
    
    /**
     * 玩安卓 BaseUrl Value
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_VALUE_WAN_ANDROID = "https://www.wanandroid.com/";
    
    /**
     * 蒲公英 (用于检测版本更新 和 下载应用) BaseUrl Name
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_NAME_PGYER = "payer";
    
    /**
     * 蒲公英 (用于检测版本更新 和 下载应用) BaseUrl Value
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_URL_VALUE_PGYER = "https://www.pgyer.com/";
}