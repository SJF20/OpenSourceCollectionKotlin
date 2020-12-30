package com.shijingfeng.app

import android.util.Log
import androidx.work.Configuration
import cn.bmob.v3.Bmob
import cn.bmob.v3.BmobConfig
import com.shijingfeng.background_service.work_manager.startCheckForHotfixPatchWorker
import com.shijingfeng.background_service.work_manager.startCheckForUpdateWorker
import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.common.constant.BMOB_APP_KEY
import com.shijingfeng.base.common.constant.UMENG_PUSH_APP_KEY
import com.shijingfeng.base.common.constant.UMENG_PUSH_MESSAGE_SECRET
import com.shijingfeng.base.entity.event.event_bus.X5InitedEvent
import com.shijingfeng.base.util.LOG_TENCENT_X5
import com.shijingfeng.base.util.LOG_UMENG
import com.shijingfeng.base.util.e
import com.shijingfeng.base.util.isMainProcess
import com.shijingfeng.tencent_x5.global.isX5Inited
import com.tencent.smtt.sdk.QbSdk
import com.umeng.commonsdk.UMConfigure
import com.umeng.message.IUmengRegisterCallback
import com.umeng.message.PushAgent
import io.realm.Realm
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.Executors

/** 友盟推送 PushAgent */
internal lateinit var pushAgent: PushAgent

/**
 * Function: App 模块 Application
 * Date: 2020/2/2 22:29
 * Description:
 * @author ShiJingFeng
 */
internal class AppApplication : BaseApplication(), Configuration.Provider {

    /** X5内核是否初始化成功  true:成功 false:失败  */
    private var mX5InitSuccess = false

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        // 初始化友盟推送
        initUmengPush()
        if (isMainProcess) {
            // 初始化 Bmob 后端
            initBmob()
            // 初始化腾讯X5
            initX5()
            // 初始化 Realm 数据库
            initRealm()
            // 开启 检查更新 Worker
            startCheckForUpdateWorker()
            // 开启 检查更新热修复补丁 Worker
            startCheckForHotfixPatchWorker()
        }
    }

    /**
     * 初始化友盟推送
     */
    private fun initUmengPush() {
        UMConfigure.setLogEnabled(BuildConfig.DEBUG)
        // 在此处调用基础组件包提供的初始化函数 相应信息可在应用管理 -> 应用信息 中找到 http://message.umeng.com/list/apps
        // 参数一：当前上下文context；
        // 参数二：应用申请的Appkey（需替换）；
        // 参数三：渠道名称；
        // 参数四：设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure.DEVICE_TYPE_BOX则表示盒子；默认为手机；
        // 参数五：Push推送业务的secret 填充Umeng Message Secret对应信息（需替换）
        UMConfigure.init(
            this,
            UMENG_PUSH_APP_KEY,
            "Umeng",
            UMConfigure.DEVICE_TYPE_PHONE,
            UMENG_PUSH_MESSAGE_SECRET
        )
        pushAgent = PushAgent.getInstance(this).apply {
            register(object : IUmengRegisterCallback {
                override fun onSuccess(deviceToken: String?) {
                    e(LOG_UMENG, "deviceToken: $deviceToken")
                }

                override fun onFailure(s1: String?, s2: String?) {
                    e(LOG_UMENG, "友盟推送注册失败: s1:${s1}     s2: $s2")
                }
            })
        }
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
     * 初始化腾讯X5
     */
    private fun initX5() {
        //搜集本地TBS内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        val cb = object : QbSdk.PreInitCallback {

            /**
             * x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
             * @param success true 内核加载成功  false 内核加载失败, 自动切换到系统内核
             */
            override fun onViewInitFinished(success: Boolean) {
                mX5InitSuccess = success
                if (success) {
                    e(LOG_TENCENT_X5, "腾讯X5内核加载成功")
                } else {
                    e(LOG_TENCENT_X5, "腾讯X5内核加载失败")
                }
            }

            /**
             * x5內核初始化完成回调
             */
            override fun onCoreInitFinished() {
                e(LOG_TENCENT_X5, "腾讯X5内核初始化完毕")
                isX5Inited = true
                EventBus.getDefault().post(X5InitedEvent(mX5InitSuccess))
            }

        }
        //x5内核初始化接口
        QbSdk.initX5Environment(this, cb)
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