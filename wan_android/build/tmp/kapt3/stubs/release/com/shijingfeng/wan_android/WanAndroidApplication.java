package com.shijingfeng.wan_android;

import java.lang.System;

/**
 * Function: 玩Android Application (只有设置为 application 单独调试时，才会调用)
 * Date: 2020/2/3 14:15
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/shijingfeng/wan_android/WanAndroidApplication;", "Lcom/shijingfeng/base/base/application/BaseApplication;", "Landroidx/work/Configuration$Provider;", "()V", "mX5InitSuccess", "", "attachBaseContext", "", "base", "Landroid/content/Context;", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "initBmob", "initRealm", "initX5", "mainProcessInit", "wan_android_release"})
public final class WanAndroidApplication extends com.shijingfeng.base.base.application.BaseApplication implements androidx.work.Configuration.Provider {
    
    /**
     * X5内核是否初始化成功  true:成功 false:失败
     */
    private boolean mX5InitSuccess = false;
    
    /**
     * 绑定Context, 先于 onCreate 执行
     */
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context base) {
    }
    
    /**
     * 主进程初始化
     */
    @java.lang.Override()
    protected void mainProcessInit() {
    }
    
    /**
     * 初始化 Bmob 后端
     */
    private final void initBmob() {
    }
    
    /**
     * 初始化腾讯X5
     */
    private final void initX5() {
    }
    
    /**
     * 初始化 Realm 数据库
     */
    private final void initRealm() {
    }
    
    /**
     * 获取 WorkManager 初始化配置
     *
     * @return WorkManager 初始化配置
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.work.Configuration getWorkManagerConfiguration() {
        return null;
    }
    
    public WanAndroidApplication() {
        super();
    }
}