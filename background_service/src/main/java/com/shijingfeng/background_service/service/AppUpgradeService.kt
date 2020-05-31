package com.shijingfeng.background_service.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.background_service.R
import com.shijingfeng.background_service.constant.CANCEL_APP_DOWNLOAD
import com.shijingfeng.background_service.constant.NEWEST_APP_INFO_STR
import com.shijingfeng.background_service.constant.RECEIVER_FLAG
import com.shijingfeng.background_service.entity.NewestAppInfoEntity
import com.shijingfeng.background_service.manager.Downloader
import com.shijingfeng.background_service.receiver.AppUpgradeReceiver
import com.shijingfeng.background_service.receiver.registerAppUpgradeReceiver
import com.shijingfeng.background_service.receiver.unregisterAppUpgradeReceiver
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getStringById
import java.io.File

/** 应用下载 更新间隔时间 (毫秒值)  */
private const val APP_UPGRADE_UPDATE_INTERVAL_TIME = 500

/** 开源集合 本地下载的 apk 路径 */
private val OPEN_SOURCE_COLLECTION_KOTLIN_APK_PATH = "${PERSONAL_APK_FILE_DIR}open_source_collection_kotlin.apk"

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
 * 关闭应用升级 服务
 */
fun stopAppUpgradeService() {
    val intent = Intent(application, AppUpgradeService::class.java)

    application.stopService(intent)
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

    /** 通知管理器 */
    private var mNotificationManager: NotificationManager? = null
    /** 应用下载 通知 */
    private var mAppDownloadNotification: Notification? = null
    /** 应用下载 RemoteViews */
    private var mAppDownloadRemoteViews: RemoteViews? = null

    /** 用于防止频繁跨进程更新导致卡顿 */
    private var mPreTimestamp = 0L

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    override fun onCreate() {
        super.onCreate()
        // 注册 应用升级 Broadcast Receiver (在哪个进程中注册, onReceiver会执行在哪个进程, 可以同时在多个进程中注册)
        registerAppUpgradeReceiver()
    }

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
        val apkFile = File(OPEN_SOURCE_COLLECTION_KOTLIN_APK_PATH)

        if (apkFile.exists()) {
            val apkAppInfo = AppUtils.getApkInfo(apkFile)

            if (apkAppInfo == null) {
                // 本地 apk 文件不完整，或损坏
                apkFile.deleteOnExit()
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
                    installApp()
                    stopSelf()
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
     * 安装新版应用
     */
    private fun installApp() {
        val apkFile = File(OPEN_SOURCE_COLLECTION_KOTLIN_APK_PATH)

        if (!apkFile.exists()) {
            ToastUtils.showShort(getStringById(R.string.应用安装失败))
            return
        }
        AppUtils.installApp(apkFile)
    }

    /**
     * 开始下载更新安装包
     */
    private fun startDownloadApk() {
        // 显示下载通知
        showDownloadNotification()
        // 开始下载
        mDownloader = Downloader.Builder()
            .setOnProgress { _, progress ->
                val curTimestamp = System.currentTimeMillis()

                if (curTimestamp - mPreTimestamp >= APP_UPGRADE_UPDATE_INTERVAL_TIME) {
                    mPreTimestamp = curTimestamp
                    //跨进程通知 Notification 更新进度
                    mAppDownloadRemoteViews?.setProgressBar(R.id.pb_progress, 100, progress, false)
                    mAppDownloadRemoteViews?.setTextViewText(R.id.tv_progress, "$progress%")
                    mNotificationManager?.notify(NOTIFICATION_ID_APP_UPDATE, mAppDownloadNotification)
                }
            }
            .setOnSuccess { _, _ ->
                // 安装应用
                installApp()
                // 销毁前台服务
                stopForeground(true)
                // 销毁Service自身
                stopSelf()
            }
            .setOnFailure { _, _, _ ->
                ToastUtils.showShort(getStringById(R.string.安装包下载失败))
                // 销毁前台服务
                stopForeground(true)
                // 销毁Service自身
                stopSelf()
            }
            .build()
        mDownloader?.execute(
            url = mNewestAppInfo.downloadURL,
            filePath = OPEN_SOURCE_COLLECTION_KOTLIN_APK_PATH,
            replace = true
        )
    }

    /**
     * 显示下载通知
     */
    private fun showDownloadNotification() {
        mNotificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
        mAppDownloadRemoteViews = RemoteViews(packageName, R.layout.layout_notification_app_update)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //添加通知渠道
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID_APP_UPDATE,
                NOTIFICATION_CHANNEL_NAME_APP_UPDATE,
                NotificationManager.IMPORTANCE_DEFAULT
            )

            mNotificationManager?.createNotificationChannel(notificationChannel)
        }

        mAppDownloadNotification = NotificationCompat.Builder(applicationContext, NOTIFICATION_CHANNEL_ID_APP_UPDATE)
            // 设置优先级
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            // 设置小图标
            .setSmallIcon(R.mipmap.ic_launcher_round)
            // 设置自定义视图
            .setCustomContentView(mAppDownloadRemoteViews)
            .build()

        val cancelAppDownloadPendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            PENDING_CODE_CANCEL_APP_UPDATE,
            Intent().apply {
                action = AppUpgradeReceiver::class.java.name
                putExtra(RECEIVER_FLAG, CANCEL_APP_DOWNLOAD)
            },
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        mAppDownloadRemoteViews?.setOnClickPendingIntent(R.id.iv_cancel, cancelAppDownloadPendingIntent)

        //开启前台服务 (Android8.0及以上版本 开启服务5秒后未开启前台通知会 ANR)
        startForeground(NOTIFICATION_ID_APP_UPDATE, mAppDownloadNotification);
    }

    override fun onDestroy() {
        // 销毁 下载器
        mDownloader?.destory()
        // 取消注册 应用升级 Broadcast Receiver
        unregisterAppUpgradeReceiver()
        // 关闭下载通知
        mNotificationManager?.cancel(NOTIFICATION_ID_APP_UPDATE)
        super.onDestroy()
    }
}