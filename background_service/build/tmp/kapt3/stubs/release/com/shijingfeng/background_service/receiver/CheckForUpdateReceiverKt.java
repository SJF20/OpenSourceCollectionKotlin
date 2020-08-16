package com.shijingfeng.background_service.receiver;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"mCheckForUpdateReceiver", "Lcom/shijingfeng/background_service/receiver/CheckForUpdateReceiver;", "registerCheckForUpdateReceiver", "", "unregisterCheckForUpdateReceiver", "background_service_release"})
public final class CheckForUpdateReceiverKt {
    
    /**
     * 检查更新 Broadcast Receiver (每个进程都有独立的内存, 所以 mCheckForUpdateReceiver 每个进程都有一份, 各不相同)
     */
    private static com.shijingfeng.background_service.receiver.CheckForUpdateReceiver mCheckForUpdateReceiver;
    
    /**
     * 注册 检查更新 Broadcast Receiver (在哪个进程中注册，onReceiver会执行在哪个进程, 可以同时在多个进程中注册)
     */
    public static final void registerCheckForUpdateReceiver() {
    }
    
    /**
     * 取消注册 检查更新 Broadcast Receiver
     */
    public static final void unregisterCheckForUpdateReceiver() {
    }
}