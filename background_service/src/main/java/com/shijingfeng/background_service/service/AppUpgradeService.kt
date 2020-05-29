package com.shijingfeng.background_service.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.blankj.utilcode.util.AppUtils
import com.shijingfeng.background_service.R
import com.shijingfeng.background_service.constant.NEWEST_APP_INFO_STR
import com.shijingfeng.background_service.entity.NewestAppInfoEntity
import com.shijingfeng.background_service.manager.Downloader
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import java.io.File

/** 应用下载 更新间隔时间 (毫秒值)  */
private val APP_UPGRADE_UPDATE_INTERVAL_TIME = 500

/**
 * 开启 应用升级 服务
 */
fun startAppUpgradeService(
    bundle: Bundle = Bundle()
) {
    val intent = Intent(application, AppUpgradeService::class.java)

    intent.putExtras(bundle)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        application.startForegroundService(intent)
    } else {
        application.startService(intent)
    }
}

/**
 * Function: 应用升级 Service
 * Date: 2020/5/27 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class AppUpgradeService : Service() {

    /** 最新 App 版本信息 实体类 */
    private lateinit var mNewestAppInfo: NewestAppInfoEntity

    /** 下载器 */
    private var mDownloader: Downloader? = null
    /** 应用下载 RemoteViews */
    private var mAppDownloadRemoteViews: RemoteViews? = null

    /**
    返回值:
    START_STICKY：
    如果service进程被kill掉，保留service的状态为开始状态，但不保留递送的intent对象。
    随后系统会尝试重新创建service，由于服务状态为开始状态，
    所以创建服务后一定会调用onStartCommand(Intent,int,int)方法。
    如果在此期间没有任何启动命令被传 递到service，那么参数Intent将为null；
    START_NOT_STICKY：“非粘性的”。
    使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统不会自动重启该服务；
    START_REDELIVER_INTENT：重传Intent。
    使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统会自动重启该服务，并将Intent的值传入；
    START_STICKY_COMPATIBILITY：
    START_STICKY的兼容版本，但不保证服务被kill后一定能重启。
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val newestAppInfoStr = intent?.extras?.getString(NEWEST_APP_INFO_STR, EMPTY_OBJECT) ?: EMPTY_OBJECT

        mNewestAppInfo = deserialize(newestAppInfoStr, NewestAppInfoEntity::class.java)

        // 检查本地是否有下载完毕的应用包
        checkLocalApk()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): Nothing? = null

    /**
     * 检查本地是否有下载完毕的应用包
     */
    private fun checkLocalApk() {
        val apkFilePath = PERSONAL_APK_FILE_DIR + "wan_android.apk"
        val apkFile = File(apkFilePath)

        if (apkFile.exists()) {
            val apkAppInfo = AppUtils.getApkInfo(apkFile)

            if (apkAppInfo == null) {
                startDownloadApk()
                return
            }

            val appPackageName = packageName
            val newestAppVersionCode = mNewestAppInfo.buildVersionNo
            val apkPackageName = apkAppInfo.packageName
            val apkVersionCode = apkAppInfo.versionCode

            if (appPackageName == apkPackageName) {
                // 本地有 开源集合 apk 文件
                if (apkVersionCode == newestAppVersionCode) {
                    // 本地有最新版的 开源集合 apk 文件，更新之
                    AppUtils.installApp(apkFile)
                } else {
                    // 本地 apk 文件不是最新的
                    apkFile.deleteOnExit()
                    startDownloadApk()
                }
            } else {
                // 本地的 apk文件 不是 开源集合 apk 文件
                apkFile.deleteOnExit()
                startDownloadApk()
            }
        } else {
            // 本地不存在 apk 文件
            startDownloadApk()
        }
    }

    /**
     * 开始下载更新安装包
     */
    private fun startDownloadApk() {
        // 显示下载通知
        showDownloadNotification()
        // 开始下载
        mDownloader = Downloader.Builder()
            .setOnProgress { id, progress ->

            }
            .setOnSuccess { id, data ->

            }
            .setOnFailure { id, data, throwable ->

            }
            .build()
        mDownloader.execute(
            url = mNewestAppInfo.downloadURL
        )
    }

    /**
     * 显示下载通知
     */
    private fun showDownloadNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //添加通知渠道
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID_APP_UPDATE,
                NOTIFICATION_CHANNEL_NAME_APP_UPDATE,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

            notificationManager?.createNotificationChannel(notificationChannel)
        }

        mAppDownloadRemoteViews = RemoteViews(packageName, R.layout.layout_notification_app_update)

        val notificationCompatBuilder = NotificationCompat.Builder(
            applicationContext,
            NOTIFICATION_CHANNEL_ID_APP_UPDATE
        )   // 设置优先级
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            // 设置小图标
            .setSmallIcon(R.mipmap.ic_launcher_round)
            // 设置自定义视图
            .setCustomContentView(mAppDownloadRemoteViews)
            // 设置时间毫秒值
            .setWhen(System.currentTimeMillis())
            // 设置点击通知会取消  true:是  false:否
            .setAutoCancel(false)

        //开启前台服务 (Android8.0及以上版本 开启服务5秒后未开启前台通知会 ANR)
        startForeground(NOTIFICATION_ID_APP_UPDATE, notificationCompatBuilder.build());
    }

    override fun onDestroy() {
        super.onDestroy()
        mDownloader?.destory()
    }
}