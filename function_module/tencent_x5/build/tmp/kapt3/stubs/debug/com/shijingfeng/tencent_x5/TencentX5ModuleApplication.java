package com.shijingfeng.tencent_x5;

import java.lang.System;

/**
 * Function: 模块 Application初始化
 * Date: 2020/5/25 22:12
 * Description:
 * Author: ShiJingFeng
 */
@com.shijingfeng.module_event_dispatcher.data.annotations.ModuleEventReceiver(group = "application")
@androidx.annotation.Keep()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010\t\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/tencent_x5/TencentX5ModuleApplication;", "Lcom/shijingfeng/module_event_dispatcher/data/interfaces/ModuleEventListener;", "()V", "mX5InitSuccess", "", "initX5", "", "application", "Landroid/app/Application;", "onReceive", "data", "", "", "", "tencent_x5_debug"})
public final class TencentX5ModuleApplication implements com.shijingfeng.module_event_dispatcher.data.interfaces.ModuleEventListener {
    
    /**
     * X5内核是否初始化成功  true:成功 false:失败
     */
    private boolean mX5InitSuccess = false;
    
    /**
     * 接收回调
     */
    @java.lang.Override()
    public boolean onReceive(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> data) {
        return false;
    }
    
    /**
     * 初始化腾讯X5
     *
     * @param application Application
     */
    private final void initX5(android.app.Application application) {
    }
    
    public TencentX5ModuleApplication() {
        super();
    }
}