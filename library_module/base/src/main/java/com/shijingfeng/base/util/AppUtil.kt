/** 生成的 Java 类名 */
@file:JvmName("AppUtil")
package com.shijingfeng.base.util

import androidx.core.app.NotificationManagerCompat
import com.blankj.utilcode.util.ActivityUtils
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.NOTIFICATION_ID_APP_UPDATE_HINT
import com.shijingfeng.base.common.global.sophixHasInitialized
import com.taobao.sophix.SophixManager
import kotlin.system.exitProcess

/**
 * Function: 应用操作相关 工具类
 * Date: 2020/5/24 21:17
 * Description:
 * @author ShiJingFeng
 */

/**
 * 应用退出 (不完全)
 */
fun exitApp() {
    // 关闭所有的Activity
    ActivityUtils.finishAllActivities()
    // 关闭 更新提示 通知
    NotificationManagerCompat.from(application).cancel(NOTIFICATION_ID_APP_UPDATE_HINT)
    // 关闭热修复进程
    if (sophixHasInitialized) {
        SophixManager.getInstance().killProcessSafely()
    }
}

/**
 * 应用完全退出
 */
fun killApp() {
    // 关闭所有的Activity
    ActivityUtils.finishAllActivities()
    // 关闭 更新提示 通知
    NotificationManagerCompat.from(application).cancel(NOTIFICATION_ID_APP_UPDATE_HINT)
    // 关闭热修复进程
    if (sophixHasInitialized) {
        SophixManager.getInstance().killProcessSafely()
    }
    // 退出当前进程
    exitProcess(0)
}