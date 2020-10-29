package com.shijingfeng.weather

import android.content.Context
import android.util.Log
import androidx.work.Configuration
import cn.bmob.v3.Bmob
import cn.bmob.v3.BmobConfig
import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.common.constant.BMOB_APP_KEY
import io.realm.Realm
import java.util.concurrent.Executors

/**
 * Function: 天气 Application (只有设置为 application 单独调试时，才会调用)
 * Date: 2020/9/27 17:53
 * Description:
 * @author ShiJingFeng
 */
internal class WeatherApplication : BaseApplication(), Configuration.Provider {

    /**
     * 绑定Context, 先于 onCreate 执行
     */
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // 因为 SophixStubApplication 中调用了 MultiDex.install(this) 为了防止重复调用，故从 BaseApplication 移到此处
        // 初始化MultiDex  Android5.0(API 21)以上不需要了
//        MultiDex.install(this)
    }

    /**
     * 主进程初始化
     */
    override fun mainProcessInit() {
        super.mainProcessInit()
        // 初始化 Bmob 后端
        initBmob()
        //初始化 Realm 数据库
        initRealm()
    }

    /**
     * 初始化 Bmob 后端
     */
    private fun initBmob() {
        Bmob.initialize(
            BmobConfig.Builder(this)
                .setApplicationId(BMOB_APP_KEY)
                //请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(20)
                //文件分片上传时每片的大小（单位字节），默认512 * 1024
                .setUploadBlockSize(512 * 1024)
                //文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(1800)
                .build()
        )
    }

    /**
     * 初始化 Realm 数据库
     */
    private fun initRealm() {
        // 初始化 Realm 数据库
        Realm.init(this)
    }

    /**
     * 获取 WorkManager 初始化配置
     *
     * @return WorkManager 初始化配置
     */
    override fun getWorkManagerConfiguration() = Configuration.Builder()
        // 如需同步调用，则需使用 Executors.newSingleThreadPool()
        .setExecutor(Executors.newCachedThreadPool())
        // 设置日志打印级别
        .setMinimumLoggingLevel(Log.INFO)
        .build()

}