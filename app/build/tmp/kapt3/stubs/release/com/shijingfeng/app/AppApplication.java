package com.shijingfeng.app;

import java.lang.System;

/**
 * Function: App 模块 Application
 * Date: 2020/2/2 22:29
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/app/AppApplication;", "Lcom/shijingfeng/base/base/application/BaseApplication;", "Landroidx/work/Configuration$Provider;", "()V", "mX5InitSuccess", "", "getWorkManagerConfiguration", "Landroidx/work/Configuration;", "initBmob", "", "initRealm", "initX5", "mainProcessInit", "app_release"})
public final class AppApplication extends com.shijingfeng.base.base.application.BaseApplication implements androidx.work.Configuration.Provider {
    
    /**
     * X5内核是否初始化成功  true:成功 false:失败
     */
    private boolean mX5InitSuccess = false;
    
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
    
    public AppApplication() {
        super();
    }
}