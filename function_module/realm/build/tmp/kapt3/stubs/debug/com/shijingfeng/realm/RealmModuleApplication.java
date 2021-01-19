package com.shijingfeng.realm;

import java.lang.System;

/**
 * Function: 模块 Application初始化
 * Date: 2020/5/25 22:12
 * Description:
 * Author: ShiJingFeng
 */
@com.shijingfeng.apt_data.annotations.ModuleEventReceiver(group = "application", priority = 0)
@androidx.annotation.Keep()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/realm/RealmModuleApplication;", "Lcom/shijingfeng/apt_data/interfaces/ModuleEventListener;", "()V", "initRealm", "", "application", "Landroid/app/Application;", "onReceive", "", "data", "", "", "", "realm_debug"})
public final class RealmModuleApplication implements com.shijingfeng.apt_data.interfaces.ModuleEventListener {
    
    /**
     * 接收回调
     */
    @java.lang.Override()
    public boolean onReceive(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> data) {
        return false;
    }
    
    /**
     * 初始化 Realm 数据库
     */
    private final void initRealm(android.app.Application application) {
    }
    
    public RealmModuleApplication() {
        super();
    }
}