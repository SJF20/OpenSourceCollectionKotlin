package com.shijingfeng.base.base.application

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.Utils
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshFooter
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.shijingfeng.base.BuildConfig
import com.shijingfeng.base.BuildConfig.DEBUG
import com.shijingfeng.base.BuildConfig.IS_DEBUG
import com.shijingfeng.base.callback.EmptyCallback
import com.shijingfeng.base.callback.LoadFailCallback
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.BASE_URL_NAME_WAN_ANDROID
import com.shijingfeng.base.common.constant.BASE_URL_VALUE_WAN_ANDROID
import com.shijingfeng.base.common.constant.PERSONAL_CACHE_DIR
import com.shijingfeng.base.common.constant.PERSONAL_GLIDE_CACHE_DIR
import com.shijingfeng.base.entity.event.X5InitedEvent
import com.shijingfeng.base.util.e
import com.shijingfeng.base.util.enable
import com.tencent.smtt.sdk.QbSdk
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import org.greenrobot.eventbus.EventBus
import java.io.File

/**
 * Function:  Application基类
 * Date: 2020/1/18 16:38
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseApplication : Application() {

    companion object {
        /** MainApp Context  */
        protected lateinit var sInstance: Application
        /** X5内核是否初始化完成  */
        private var sX5Inited = false

        //static 代码段可以防止内存泄露
        init {
            //设置全局的Header构建器
            SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, _ ->
                //layout.setPrimaryColorsId(R.color.colorPrimary, android.R.color.white);//全局设置主题颜色
                //.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
                ClassicsHeader(context)
            }
            //设置全局的Footer构建器
            SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
                //指定为经典Footer，默认是 BallPulseFooter
                //            return new ClassicsFooter(context).setDrawableSize(20);
                ClassicsFooter(context)
            }
        }

        /**
         * 获取 Application
         * @return Application
         */
        fun getApplication() = sInstance

        /**
         * 腾讯X5内核是否初始化完成
         * @return true 初始化完成  false 正在初始化
         */
        fun isX5Inited() = sX5Inited

    }

    /** X5内核是否初始化成功  true:成功 false:失败  */
    private var mX5InitSuccess = false

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        //创建目录
        createDirectory()
        //初始化 ARouter 路由框架
        initArouter()
        //初始化万能工具类
        initUtils()
        //初始化 LoadSir
        initLoadSir()
        //初始化 RetrofitUrlManager
        initRetrofitUrlManager()
        //初始化腾讯X5
        initX5()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //初始化MultiDex
        MultiDex.install(this)
    }

    /**
     * 初始化 ARouter 路由框架
     */
    private fun initArouter() {
        if (DEBUG) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            // 打印日志
            ARouter.openLog()
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    /**
     * 初始化万能工具类
     */
    private fun initUtils() {
        //初始化万能工具类 (神器)
        Utils.init(this)
        //开启Log打印
        enable(true)
    }

    /**
     * 初始化 LoadSir
     */
    private fun initLoadSir() {
        LoadSir.beginBuilder()
            .addCallback(LoadingCallback())
            .addCallback(LoadFailCallback())
            .addCallback(EmptyCallback())
            .setDefaultCallback(SuccessCallback::class.java)
            .commit()
    }

    /**
     * 初始化 RetrofitUrlManager
     */
    private fun initRetrofitUrlManager() {
        RetrofitUrlManager.getInstance().setDebug(true)
        //将每个 BaseUrl 进行初始化,运行时可以随时改变 DOMAIN_NAME 对应的值,从而达到切换 BaseUrl 的效果
        RetrofitUrlManager.getInstance().putDomain(
            BASE_URL_NAME_WAN_ANDROID,
            BASE_URL_VALUE_WAN_ANDROID
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
                if (!success) {
                    e("测试", "腾讯X5内核加载失败")
                }
            }

            /**
             * x5內核初始化完成回调
             */
            override fun onCoreInitFinished() {
                e("测试", "腾讯X5内核初始化完毕")
                sX5Inited = true
                EventBus.getDefault().post(X5InitedEvent(mX5InitSuccess))
            }

        }
        //x5内核初始化接口
        QbSdk.initX5Environment(this, cb)
    }

    /**
     * 创建目录
     */
    private fun createDirectory() {
        val personalCacheDir = File(PERSONAL_CACHE_DIR)
        val personalGlideCacheDir = File(PERSONAL_GLIDE_CACHE_DIR)

        //创建 cache 私有目录
        if (!personalCacheDir.exists()) personalCacheDir.mkdirs()
        //创建 glide 私有目录
        if (!personalGlideCacheDir.exists()) personalGlideCacheDir.mkdirs()
    }

}