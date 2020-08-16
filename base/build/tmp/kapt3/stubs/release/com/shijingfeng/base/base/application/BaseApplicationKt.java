package com.shijingfeng.base.base.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"appInitClassNameList", "", "", "[Ljava/lang/String;", "appInitInstanceList", "", "Lcom/shijingfeng/base/interfaces/AppInit;", "application", "Lcom/shijingfeng/base/base/application/BaseApplication;", "getApplication", "()Lcom/shijingfeng/base/base/application/BaseApplication;", "setApplication", "(Lcom/shijingfeng/base/base/application/BaseApplication;)V", "base_release"})
public final class BaseApplicationKt {
    
    /**
     * 应用初始化类 全限定类名 列表
     */
    private static final java.lang.String[] appInitClassNameList = {"com.shijingfeng.app.ModuleAppInit", "com.shijingfeng.wan_android.ModuleAppInit", "com.shijingfeng.todo.ModuleAppInit", "com.shijingfeng.tencent_x5.ModuleAppInit", "com.shijingfeng.background_service.ModuleAppInit", "com.shijingfeng.common.ModuleAppInit"};
    
    /**
     * 应用初始化类 列表
     */
    private static final java.util.List<com.shijingfeng.base.interfaces.AppInit> appInitInstanceList = null;
    
    /**
     * Application实例
     */
    @org.jetbrains.annotations.NotNull()
    public static com.shijingfeng.base.base.application.BaseApplication application;
    
    @org.jetbrains.annotations.NotNull()
    public static final com.shijingfeng.base.base.application.BaseApplication getApplication() {
        return null;
    }
    
    public static final void setApplication(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.application.BaseApplication p0) {
    }
}