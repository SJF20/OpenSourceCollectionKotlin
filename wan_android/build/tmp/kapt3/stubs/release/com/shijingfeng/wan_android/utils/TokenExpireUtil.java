package com.shijingfeng.wan_android.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\b\u0010\u0007\u001a\u00020\bH\u0000\u001a\b\u0010\t\u001a\u00020\u0004H\u0002\u001a\b\u0010\n\u001a\u00020\bH\u0000\u001a\b\u0010\u000b\u001a\u00020\bH\u0000\"\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"mExpireDateTime", "", "Ljava/lang/Long;", "mIsTokenExpireAlarmStarted", "", "mTokenExpirePendingIntent", "Landroid/app/PendingIntent;", "checkTokenExpire", "", "isTokenExpired", "startTokenExpireAlarm", "stopTokenExpireAlarm", "wan_android_release"})
public final class TokenExpireUtil {
    
    /**
     * 玩Android Token 失效时间
     */
    private static java.lang.Long mExpireDateTime;
    
    /**
     * 检查 玩Android Token 是否过期 PendingIntent
     */
    private static android.app.PendingIntent mTokenExpirePendingIntent;
    
    /**
     * 检查 玩Android Token 是否过期 定时器 是否已开启  true:已开启  false:未开启
     */
    private static boolean mIsTokenExpireAlarmStarted = false;
    
    /**
     * 检查 玩安卓 Token 是否过期
     */
    public static final void checkTokenExpire() {
    }
    
    /**
     * 玩Android Token 是否过期  true: 已过期  false: 未过期
     */
    private static final boolean isTokenExpired() {
        return false;
    }
    
    /**
     * 开启 检查 玩Android Token 是否过期 定时器
     */
    public static final void startTokenExpireAlarm() {
    }
    
    /**
     * 停止 检查 玩Android Token 是否过期 定时器
     */
    public static final void stopTokenExpireAlarm() {
    }
}