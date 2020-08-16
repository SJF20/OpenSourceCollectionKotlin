package com.shijingfeng.base.base.application;

import java.lang.System;

/**
 * Function:  Application基类
 * Date: 2020/1/18 16:38
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0014J\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/base/base/application/BaseApplication;", "Landroid/app/Application;", "()V", "initARouter", "", "initLoadSir", "initRetrofitUrlManager", "initUtils", "mainProcessInit", "onCreate", "registerGlobalReceiver", "startAppInit", "Companion", "base_release"})
public abstract class BaseApplication extends android.app.Application {
    public static final com.shijingfeng.base.base.application.BaseApplication.Companion Companion = null;
    
    /**
     * 注意 多进程 会创建多个Application对象，则 onCreate() 会执行多次
     * 多进程中 变量在相应的进程内存中
     */
    @java.lang.Override()
    public final void onCreate() {
    }
    
    /**
     * 主进程初始化
     */
    protected void mainProcessInit() {
    }
    
    /**
     * 开始 其他 module App 初始化
     */
    private final void startAppInit() {
    }
    
    /**
     * 注册全局广播 (注意如果可以在 Activity 或 Service 中注册(可以取消注册), 那么就不要注册全局广播)
     */
    private final void registerGlobalReceiver() {
    }
    
    /**
     * 初始化 ARouter 路由框架
     */
    private final void initARouter() {
    }
    
    /**
     * 初始化万能工具类
     */
    private final void initUtils() {
    }
    
    /**
     * 初始化 LoadSir
     */
    private final void initLoadSir() {
    }
    
    /**
     * 初始化 RetrofitUrlManager
     */
    private final void initRetrofitUrlManager() {
    }
    
    public BaseApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/shijingfeng/base/base/application/BaseApplication$Companion;", "", "()V", "base_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}