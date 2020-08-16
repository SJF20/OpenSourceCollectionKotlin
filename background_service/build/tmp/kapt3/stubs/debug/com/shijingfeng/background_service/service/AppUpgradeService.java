package com.shijingfeng.background_service.service;

import java.lang.System;

/**
 * Function: 应用升级 Service
 * Date: 2020/5/27 20:32
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/shijingfeng/background_service/service/AppUpgradeService;", "Landroid/app/Service;", "()V", "mAppDownloadNotification", "Landroid/app/Notification;", "mAppDownloadRemoteViews", "Landroid/widget/RemoteViews;", "mDownloader", "Lcom/shijingfeng/background_service/manager/Downloader;", "mNewestAppInfo", "Lcom/shijingfeng/background_service/entity/NewestAppInfoEntity;", "mNotificationManager", "Landroid/app/NotificationManager;", "mPreTimestamp", "", "checkLocalApk", "", "installApp", "onBind", "", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onStartCommand", "", "flags", "startId", "showDownloadNotification", "startDownloadApk", "background_service_debug"})
public final class AppUpgradeService extends android.app.Service {
    
    /**
     * 最新 App 版本信息 实体类
     */
    private com.shijingfeng.background_service.entity.NewestAppInfoEntity mNewestAppInfo;
    
    /**
     * 下载器
     */
    private com.shijingfeng.background_service.manager.Downloader mDownloader;
    
    /**
     * 通知管理器
     */
    private android.app.NotificationManager mNotificationManager;
    
    /**
     * 应用下载 通知
     */
    private android.app.Notification mAppDownloadNotification;
    
    /**
     * 应用下载 RemoteViews
     */
    private android.widget.RemoteViews mAppDownloadRemoteViews;
    
    /**
     * 用于防止频繁跨进程更新导致卡顿
     */
    private long mPreTimestamp = 0L;
    
    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * 返回值:
     * START_STICKY：
     * 如果service进程被kill掉，保留service的状态为开始状态，但不保留递送的intent对象。
     * 随后系统会尝试重新创建service，由于服务状态为开始状态，
     * 所以创建服务后一定会调用onStartCommand(Intent,int,int)方法。
     * 如果在此期间没有任何启动命令被传 递到service，那么参数Intent将为null；
     * START_NOT_STICKY：“非粘性的”。
     * 使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统不会自动重启该服务；
     * START_REDELIVER_INTENT：重传Intent。
     * 使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统会自动重启该服务，并将Intent的值传入；
     * START_STICKY_COMPATIBILITY：
     * START_STICKY的兼容版本，但不保证服务被kill后一定能重启。
     */
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Void onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    /**
     * 检查本地是否有下载完毕的应用包
     */
    private final void checkLocalApk() {
    }
    
    /**
     * 安装新版应用
     */
    private final void installApp() {
    }
    
    /**
     * 开始下载更新安装包
     */
    private final void startDownloadApk() {
    }
    
    /**
     * 显示下载通知
     */
    private final void showDownloadNotification() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public AppUpgradeService() {
        super();
    }
}