package com.shijingfeng.background_service.receiver

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.TextUtils
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.AppUtils
import com.shijingfeng.background_service.R
import com.shijingfeng.background_service.constant.NEWEST_APP_INFO_STR
import com.shijingfeng.background_service.entity.NewestAppInfoEntity
import com.shijingfeng.background_service.service.startAppUpgradeService
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.EMPTY_OBJECT
import com.shijingfeng.base.common.constant.PERSONAL_APK_FILE_DIR
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.util.deserialize
import com.shijingfeng.base.util.getStringById
import java.io.File

/** 检查更新 Broadcast Receiver */
private var mCheckForUpdateReceiver: CheckForUpdateReceiver? = null

/**
 * 注册 检查更新 Broadcast Receiver
 */
fun registerCheckForUpdateReceiver() {
    if (mCheckForUpdateReceiver == null) {
        mCheckForUpdateReceiver = CheckForUpdateReceiver()
        application.registerReceiver(mCheckForUpdateReceiver, IntentFilter().apply {
            addAction(CheckForUpdateReceiver::class.java.name)
        })
    }
}

/**
 * 取消注册 检查更新 Broadcast Receiver
 */
fun unregisterCheckForUpdateReceiver() {
    if (mCheckForUpdateReceiver != null) {
        application.unregisterReceiver(mCheckForUpdateReceiver)
        mCheckForUpdateReceiver = null
    }
}

/**
 * Function: 检查更新 Broadcast Receiver
 * Date: 2020/5/24 15:07
 * Description:
 * @author ShiJingFeng
 */
internal class CheckForUpdateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val bundle = intent?.extras
        val newestAppInfoStr = bundle?.getString(NEWEST_APP_INFO_STR, EMPTY_OBJECT) ?: EMPTY_OBJECT
        val newestAppInfo = deserialize(newestAppInfoStr, NewestAppInfoEntity::class.java)
        val description = newestAppInfo.buildUpdateDescription

        // 取消注册 检查更新 Broadcast Receiver
        unregisterCheckForUpdateReceiver()

        if (AppUtils.isAppForeground()) {
            // 应用处于前台，弹框展示详情，由用户决定是否更新
            val curActivity = ActivityUtils.getTopActivity()

            if (curActivity != null) {
                AlertDialog.Builder(curActivity)
                    .setTitle(getStringById(R.string.开源集合有新版本了))
                    .setMessage(if (TextUtils.isEmpty(description)) getStringById(R.string.暂无详细描述) else description)
                    .setCancelable(false)
                    .setPositiveButton(getStringById(R.string.是)) { _, _ ->
                        startAppUpgradeService(bundle = Bundle().apply {
                            putString(NEWEST_APP_INFO_STR, newestAppInfoStr)
                        })
                    }
                    .setNegativeButton(getStringById(R.string.否), null)
                    .show()
            }
        } else {
            // 从后台切换到前台
            AppUtils.launchApp(AppUtils.getAppPackageName())

            runOnUiThread(200) {
                //应用处于前台，弹框展示详情，由用户决定是否更新
                val curActivity = ActivityUtils.getTopActivity()

                if (curActivity != null) {
                    AlertDialog.Builder(curActivity)
                        .setTitle(getStringById(R.string.开源集合有新版本了))
                        .setMessage(if (TextUtils.isEmpty(description)) getStringById(R.string.暂无详细描述) else description)
                        .setCancelable(false)
                        .setPositiveButton(getStringById(R.string.是)) { _, _ ->
                            startAppUpgradeService(bundle = Bundle().apply {
                                putString(NEWEST_APP_INFO_STR, newestAppInfoStr)
                            })
                        }
                        .setNegativeButton(getStringById(R.string.否), null)
                        .show()
                }
            }
        }
    }
}