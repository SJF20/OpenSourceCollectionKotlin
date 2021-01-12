package com.shijingfeng.background_service.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import com.blankj.utilcode.util.ProcessUtils
import com.shijingfeng.background_service.constant.CANCEL_APP_DOWNLOAD
import com.shijingfeng.background_service.constant.RECEIVER_FLAG
import com.shijingfeng.background_service.service.stopAppUpgradeService
import com.shijingfeng.base.base.application.application

/** 应用升级 Broadcast Receiver (每个进程都有独立的内存, 所以 mAppUpgradeReceiver 每个进程都有一份, 各不相同)*/
private var mAppUpgradeReceiver: AppUpgradeReceiver? = null

/**
 * 注册 应用升级 Broadcast Receiver (在哪个进程中注册, onReceiver会执行在哪个进程, 可以同时在多个进程中注册)
 */
fun registerAppUpgradeReceiver() {
    // 每个进程都有独立的内存, 所以 mAppUpgradeReceiver 每个进程都有一份, 各不相同
    if (mAppUpgradeReceiver == null) {
        mAppUpgradeReceiver = AppUpgradeReceiver()
        application.registerReceiver(mAppUpgradeReceiver, IntentFilter().apply {
            addAction(AppUpgradeReceiver::class.java.name)
        })
    }
}

/**
 * 取消注册 应用升级 Broadcast Receiver
 */
fun unregisterAppUpgradeReceiver() {
    // 每个进程都有独立的内存, 所以 mAppUpgradeReceiver 每个进程都有一份, 各不相同
    if (mAppUpgradeReceiver != null) {
        application.unregisterReceiver(mAppUpgradeReceiver)
        mAppUpgradeReceiver = null
    }
}

/**
 * Function: 应用升级 Broadcast Receiver (在哪个进程中注册，onReceiver会执行在哪个进程, 可以同时在多个进程中注册)
 * Date: 2020/5/29 22:55
 * Description:
 * Author: ShiJingFeng
 */
class AppUpgradeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.extras
        val flag = bundle?.getString(RECEIVER_FLAG, "") ?: ""

        when (flag) {
            // 取消应用下载
            CANCEL_APP_DOWNLOAD -> {
                stopAppUpgradeService()
            }
        }
    }

}