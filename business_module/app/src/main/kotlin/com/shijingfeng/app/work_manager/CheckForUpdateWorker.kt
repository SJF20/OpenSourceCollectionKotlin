package com.shijingfeng.app.work_manager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.text.TextUtils
import androidx.annotation.WorkerThread
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_HIGH
import androidx.core.app.NotificationManagerCompat
import androidx.work.*
import com.blankj.utilcode.util.AppUtils
import com.shijingfeng.app.R
import com.shijingfeng.app.api.AppApi
import com.shijingfeng.app.constant.NEWEST_APP_INFO_STR
import com.shijingfeng.app.constant.RECEIVER_FLAG
import com.shijingfeng.app.constant.SHOW_APP_UPDATE_HINT_DIALOG
import com.shijingfeng.app.entity.NewestAppInfoEntity
import com.shijingfeng.app.entity.ResultEntity
import com.shijingfeng.app.receiver.CheckForUpdateReceiver
import com.shijingfeng.app.receiver.registerCheckForUpdateReceiver
import com.shijingfeng.app.receiver.unregisterCheckForUpdateReceiver
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.network.util.RetrofitUtil
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.base.util.serialize

/**
 * 开启 检查更新 Worker
 */
fun startCheckForUpdateWorker() {
    val constraints = Constraints.Builder()
        // 网络连接时执行
        .setRequiredNetworkType(NetworkType.CONNECTED)
        // 不在电量不足时执行
        .setRequiresBatteryNotLow(true)
        .build()
    val inputData = Data.Builder()
        .build()
    val request = OneTimeWorkRequest.Builder(CheckForUpdateWorker::class.java)
        .addTag(WORKER_NAME_CHECK_FOR_UPDATE)
        .setInputData(inputData)
        .setConstraints(constraints)
        .build()

    WorkManager.getInstance(application).enqueueUniqueWork(
        WORKER_NAME_CHECK_FOR_UPDATE,
        ExistingWorkPolicy.KEEP,
        request
    )
}

/**
 * 取消 检查更新 Worker
 */
fun cancelCheckForUpdateWorker() {
    WorkManager
        .getInstance(application)
        .cancelUniqueWork(WORKER_NAME_CHECK_FOR_UPDATE)
}

/**
 * Function: 检查更新 Worker
 * Date: 2020/5/23 17:45
 * Description:
 * Author: ShiJingFeng
 */
internal class CheckForUpdateWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    /**
     * 1. doWork()进程: 当前应用进程
     * 2. doWork()线程: 使用自定义线程池(没指定就是默认的)
     * 3. doWork()执行完后此 Worker 就会被销毁
     */
    override fun doWork(): Result {
        val outputData = Data.Builder().build()

        getNewestAppInfoFromServer()
        return Result.success(outputData)
    }

    /**
     * Worker停止 (通常是遇见异常)
     */
    override fun onStopped() {
        super.onStopped()
        unregisterCheckForUpdateReceiver()
    }

    /**
     * 从服务器上获取最新 App 版本信息
     */
    @WorkerThread
    private fun getNewestAppInfoFromServer() {
        // 注册 检查更新 广播
        registerCheckForUpdateReceiver()

        val appApi = RetrofitUtil.create(AppApi::class.java)

        try {
            val response = appApi.getNewestAppInfoFromServer(
                versionName = AppUtils.getAppVersionName()
            ).execute()

            if (response.isSuccessful) {
                val result: ResultEntity<NewestAppInfoEntity?>? = response.body()

                result?.run {
                    data?.run {
                        if (buildHaveNewVersion) {
                            // 有新版本
                            showAppUpdateNotification(data)
                        }
                    }
                }
            }
        } catch (e: java.io.IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 显示应用更新通知
     */
    private fun showAppUpdateNotification(newestAppInfo: NewestAppInfoEntity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //添加通知渠道
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID_APP_UPDATE_HINT,
                NOTIFICATION_CHANNEL_NAME_APP_UPDATE_HINT,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

            notificationManager?.createNotificationChannel(notificationChannel)
        }

        val checkForUpdatePendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            PENDING_CODE_CHECK_FOR_UPDATE,
            Intent().apply {
                action = CheckForUpdateReceiver::class.java.name
                putExtra(RECEIVER_FLAG, SHOW_APP_UPDATE_HINT_DIALOG)
                putExtra(NEWEST_APP_INFO_STR, serialize(newestAppInfo))
            },
            FLAG_UPDATE_CURRENT
        )

        val description = newestAppInfo.buildUpdateDescription
        val notificationManagerCompat = NotificationManagerCompat.from(applicationContext)
        val notificationCompatBuilder = NotificationCompat.Builder(
            applicationContext,
            NOTIFICATION_CHANNEL_ID_APP_UPDATE_HINT
        )   // 设置优先级
            .setPriority(PRIORITY_HIGH)
            // 设置文本标题
            .setContentTitle(getStringById(R.string.开源集合有新版本了))
            // 设置文本内容
            .setContentText(if (TextUtils.isEmpty(description)) getStringById(R.string.暂无详细描述) else description)
            // 设置小图标
            .setSmallIcon(R.mipmap.ic_launcher_round)
            // 设置时间毫秒值
            .setWhen(System.currentTimeMillis())
            // 设置点击通知会取消  true:是  false:否
            .setAutoCancel(true)
            // 通知点击事件 PendingIntent
            .setContentIntent(checkForUpdatePendingIntent)

        notificationManagerCompat.notify(NOTIFICATION_ID_APP_UPDATE_HINT, notificationCompatBuilder.build())
    }

}