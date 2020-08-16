package com.shijingfeng.base.common.constant;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"NOTIFICATION_CHANNEL_ID_APP_UPDATE", "", "NOTIFICATION_CHANNEL_ID_APP_UPDATE_HINT", "NOTIFICATION_CHANNEL_NAME_APP_UPDATE", "NOTIFICATION_CHANNEL_NAME_APP_UPDATE_HINT", "NOTIFICATION_ID_APP_UPDATE", "", "NOTIFICATION_ID_APP_UPDATE_HINT", "base_debug"})
public final class NotificationConstant {
    
    /**
     * 通知渠道 ID: 应用更新提示
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_ID_APP_UPDATE_HINT = "app_update_hint";
    
    /**
     * 通知渠道 ID: 应用更新
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_ID_APP_UPDATE = "background_service";
    
    /**
     * 通知渠道名称: 应用更新提示
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_NAME_APP_UPDATE_HINT = "app_update_hint";
    
    /**
     * 通知渠道名称: 应用更新
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NOTIFICATION_CHANNEL_NAME_APP_UPDATE = "background_service";
    
    /**
     * 通知 ID: 应用更新提示
     */
    public static final int NOTIFICATION_ID_APP_UPDATE_HINT = 100;
    
    /**
     * 通知 ID: 应用更新
     */
    public static final int NOTIFICATION_ID_APP_UPDATE = 101;
}