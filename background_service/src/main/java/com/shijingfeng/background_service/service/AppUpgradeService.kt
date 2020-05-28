package com.shijingfeng.background_service.service

import android.app.Service
import android.content.Intent

/**
 * Function: 应用升级 Service
 * Date: 2020/5/27 20:32
 * Description:
 * @author ShiJingFeng
 */
internal class AppUpgradeService : Service() {

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    override fun onCreate() {
        super.onCreate()
    }

    /**
    flags参数:
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
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): Nothing? = null

    override fun onDestroy() {
        super.onDestroy()
    }
}