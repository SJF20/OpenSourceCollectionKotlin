package com.shijingfeng.background_service.work_manager;

import java.lang.System;

/**
 * Function: 检查更新 Worker
 * Date: 2020/5/23 17:45
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0003J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/shijingfeng/background_service/work_manager/CheckForUpdateWorker;", "Landroidx/work/Worker;", "context", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "getNewestAppInfoFromServer", "", "onStopped", "showAppUpdateNotification", "newestAppInfo", "Lcom/shijingfeng/background_service/entity/NewestAppInfoEntity;", "background_service_release"})
public final class CheckForUpdateWorker extends androidx.work.Worker {
    
    /**
     * 1. doWork()进程: 当前应用进程
     * 2. doWork()线程: 使用自定义线程池(没指定就是默认的)
     * 3. doWork()执行完后此 Worker 就会被销毁
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.work.ListenableWorker.Result doWork() {
        return null;
    }
    
    /**
     * Worker停止 (通常是遇见异常)
     */
    @java.lang.Override()
    public void onStopped() {
    }
    
    /**
     * 从服务器上获取最新 App 版本信息
     */
    @androidx.annotation.WorkerThread()
    private final void getNewestAppInfoFromServer() {
    }
    
    /**
     * 显示应用更新通知
     */
    private final void showAppUpdateNotification(com.shijingfeng.background_service.entity.NewestAppInfoEntity newestAppInfo) {
    }
    
    public CheckForUpdateWorker(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParameters) {
        super(null, null);
    }
}