package com.shijingfeng.background_service.receiver;

import java.lang.System;

/**
 * Function: 检查更新 Broadcast Receiver (在哪个进程中注册，onReceiver会执行在哪个进程, 可以同时在多个进程中注册)
 * Date: 2020/5/24 15:07
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/background_service/receiver/CheckForUpdateReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "background_service_release"})
public final class CheckForUpdateReceiver extends android.content.BroadcastReceiver {
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    public CheckForUpdateReceiver() {
        super();
    }
}