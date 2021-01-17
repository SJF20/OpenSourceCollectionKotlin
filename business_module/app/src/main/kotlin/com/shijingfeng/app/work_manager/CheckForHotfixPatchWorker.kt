package com.shijingfeng.app.work_manager

import android.content.Context
import androidx.work.*
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.WORKER_NAME_CHECK_FOR_HOTFIX_PATCH
import com.taobao.sophix.SophixManager
import java.util.concurrent.TimeUnit

/**
 * 开启 检查更新热修复补丁 Worker
 */
fun startCheckForHotfixPatchWorker() {
    val constraints = Constraints.Builder()
        // 网络连接时执行
        .setRequiredNetworkType(NetworkType.CONNECTED)
        // 不在电量不足时执行
        .setRequiresBatteryNotLow(true)
        .build()
    val inputData = Data.Builder()
        .build()
    // 每隔一个小时请求网络检查一次
    val request = PeriodicWorkRequest.Builder(CheckForHotfixPatchWorker::class.java, 1, TimeUnit.HOURS)
        .addTag(WORKER_NAME_CHECK_FOR_HOTFIX_PATCH)
        .setInputData(inputData)
        .setConstraints(constraints)
        .build()

    WorkManager.getInstance(application).enqueueUniquePeriodicWork(
        WORKER_NAME_CHECK_FOR_HOTFIX_PATCH,
        ExistingPeriodicWorkPolicy.KEEP,
        request
    )
}

/**
 * 取消 检查更新热修复补丁 Worker
 */
fun cancelCheckForHotfixPatchWorker() {
    WorkManager
        .getInstance(application)
        .cancelUniqueWork(WORKER_NAME_CHECK_FOR_HOTFIX_PATCH)
}

/**
 * Function: 检查更新热修复补丁 Worker
 * Date: 2020/7/17 22:50
 * Description:
 * Author: ShiJingFeng
 */
internal class CheckForHotfixPatchWorker(
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

        // queryAndLoadNewPatch 不可放在 attachBaseContext 中，否则无网络权限，

        // 该方法主要用于查询服务器是否有新的可用补丁. SDK内部限制连续两次queryAndLoadNewPatch()方法调用不能短于3s, 否则的话就会报code:19的错误码. 如果查询到可用的话, 首先下载补丁到本地, 然后

        // 1. 应用原本没有补丁, 那么如果当前应用的补丁是热补丁, 那么会立刻加载(不管是冷补丁还是热补丁). 如果当前应用的补丁是冷补丁, 那么需要重启生效.
        // 2. 应用已经存在一个补丁, 请求发现有新补丁后，本次不受影响。并且在下次启动时补丁文件删除, 下载并预加载新补丁。在下下次启动时应用新补丁。
        // 3. 补丁在后台发布之后, 并不会主动下行推送到客户端, 需要手动调用queryAndLoadNewPatch方法查询后台补丁是否可用.
        // 4. 只会下载补丁版本号比当前应用存在的补丁版本号高的补丁, 比如当前应用已经下载了补丁版本号为5的补丁, 那么只有后台发布的补丁版本号>5才会重新下载.
        SophixManager.getInstance().queryAndLoadNewPatch()
        return Result.success(outputData)
    }
}