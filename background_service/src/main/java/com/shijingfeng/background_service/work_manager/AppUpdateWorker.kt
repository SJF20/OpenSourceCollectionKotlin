package com.shijingfeng.background_service.work_manager

import android.content.Context
import androidx.work.*
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.WORKER_NAME_APP_UPDATE
import com.shijingfeng.base.common.constant.WORKER_NAME_CHECK_FOR_UPDATE

/**
 * 开启 应用更新 Worker
 */
fun startUpdate() {
    val constraints = Constraints.Builder()
        // 网络连接时执行
        .setRequiredNetworkType(NetworkType.CONNECTED)
        // 不在电量不足时执行
        .setRequiresBatteryNotLow(true)
        .build()
    val inputData = Data.Builder()
        .build()
    val request = OneTimeWorkRequest.Builder(AppUpdateWorker::class.java)
        .addTag(WORKER_NAME_APP_UPDATE)
        .setInputData(inputData)
        .setConstraints(constraints)
        .build()

    WorkManager.getInstance(application).enqueueUniqueWork(
        WORKER_NAME_APP_UPDATE,
        ExistingWorkPolicy.KEEP,
        request
    )
}

/**
 * 取消 应用更新 Worker
 */
fun cancelUpdate() {
    WorkManager
        .getInstance(application)
        .cancelUniqueWork(WORKER_NAME_APP_UPDATE)
}

/**
 * Function: 应用更新 Worker
 * Date: 2020/5/24 17:22
 * Description:
 * @author ShiJingFeng
 */
internal class AppUpdateWorker(
    context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {
        TODO("Not yet implemented")
    }
}