@file:JvmName("ProcessUtil")
package com.shijingfeng.base.util

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.os.Process
import android.text.TextUtils
import com.blankj.utilcode.util.Utils
import com.shijingfeng.base.base.application.application
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * Function: 进程相关 工具类
 * Date: 2020/5/29 21:39
 * Description:
 * @author ShiJingFeng
 */

/**
 * 是否运行在主进程
 */
fun isMainProcess() = application.packageName == getCurrentProcessName()

/**
 * 获取当前进程名
 */
fun getCurrentProcessName(): String {
    var name = getCurrentProcessNameByFile()

    if (!TextUtils.isEmpty(name)) {
        return name!!
    }

    name = getCurrentProcessNameByAms()

    if (!TextUtils.isEmpty(name)) {
        return name!!
    }

    name = getCurrentProcessNameByReflect()

    return name!!
}

/**
 * 通过文件 获取当前进程名
 */
private fun getCurrentProcessNameByFile(): String? {
    return try {
        val file = File("/proc/" + Process.myPid() + "/" + "cmdline")
        val mBufferedReader = BufferedReader(FileReader(file))
        val processName = mBufferedReader.readLine().trim { it <= ' ' }

        mBufferedReader.close()
        processName
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}

/**
 * 通过 AMS 获取当前进程名
 */
private fun getCurrentProcessNameByAms(): String? {
    val am = application.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val info = am.runningAppProcesses

    if (info == null || info.size == 0) {
        return ""
    }

    val pid = Process.myPid()

    for (aInfo in info) {
        if (aInfo.pid == pid) {
            if (aInfo.processName != null) {
                return aInfo.processName
            }
        }
    }
    return ""
}

/**
 * 通过反射 获取当前进程名
 */
private fun getCurrentProcessNameByReflect(): String? {
    var processName = ""
    try {
        val loadedApkField = application.javaClass.getField("mLoadedApk")

        loadedApkField.isAccessible = true

        val loadedApk = loadedApkField[application]
        val activityThreadField = loadedApk::class.java.getDeclaredField("mActivityThread")

        activityThreadField.isAccessible = true

        val activityThread = activityThreadField[loadedApk]
        val getProcessName = activityThread.javaClass.getDeclaredMethod("getProcessName")

        processName = getProcessName.invoke(activityThread) as String
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return processName
}
