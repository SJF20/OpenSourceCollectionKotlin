package com.shijingfeng.base.base.application

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.Utils
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadSir
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.shijingfeng.apt_api.manager.dispatch
import com.shijingfeng.apt_api.manager.staticInit
import com.shijingfeng.base.BuildConfig.DEBUG
import com.shijingfeng.base.callback.EmptyCallback
import com.shijingfeng.base.callback.LoadFailCallback
import com.shijingfeng.base.callback.LoadingCallback
import com.shijingfeng.base.common.constant.*
import com.shijingfeng.base.util.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import me.jessyan.retrofiturlmanager.RetrofitUrlManager
import java.util.*

/** Application实例 */
lateinit var application: BaseApplication

/**
 * Function:  Application基类
 * Date: 2020/1/18 16:38
 * Description:
 * @author ShiJingFeng
 */
abstract class BaseApplication : Application() {

    companion object {
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
    }

    /**
     * 注意 多进程 会创建多个Application对象，则 onCreate() 会执行多次
     * 多进程中 变量在相应的进程内存中
     */
    final override fun onCreate() {
        super.onCreate()
        // 每个进程都有单独的内存区域, application不相同，也不会覆盖
        application = this
        // Application主进程初始化操作
        init()
        if (isMainProcess) {
            // 模块事件分发器初始化 (使用Gradle插件)
            staticInit()
            // 开始 其他 module App 初始化 (在主进程中初始化)
            dispatch(DISPATCHER_GROUP_APPLICATION)
        }
    }

    /**
     * 初始化
     */
    protected open fun init() {
        if (isMainProcess) {
            // 初始化万能工具类
            initUtils()
            // 初始化 ARouter 路由框架
            initARouter()
            // 初始化 LoadSir
            initLoadSir()
            // 初始化 RetrofitUrlManager
            initRetrofitUrlManager()

            // 注册广播
            registerGlobalReceiver()
        }
    }

    /**
     * 注册全局广播 (注意如果可以在 Activity 或 Service 中注册(可以取消注册), 那么就不要注册全局广播)
     */
    private fun registerGlobalReceiver() {

    }

    /**
     * 初始化 ARouter 路由框架
     */
    private fun initARouter() {
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
        RetrofitUrlManager.getInstance().run {
            // 设置是否开启Debug调试  true:开启  false:关闭
            setDebug(true)
            //将每个 BaseUrl 进行初始化,运行时可以随时改变 DOMAIN_NAME 对应的值,从而达到切换 BaseUrl 的效果
            // 玩安卓 BaseUrl
            putDomain(BASE_URL_NAME_WAN_ANDROID, BASE_URL_VALUE_WAN_ANDROID)
            // Weather BaseUrl
            putDomain(BASE_URL_NAME_WEATHER, BASE_URL_VALUE_WEATHER)
            // 蒲公英 (用于检测版本更新 和 下载应用) BaseUrl
            putDomain(BASE_URL_NAME_PGYER, BASE_URL_VALUE_PGYER)
            // 高德行政区域查询 BaseUrl Value
            putDomain(BASE_URL_NAME_AMAP_CITY_SEARCH, BASE_URL_VALUE_AMAP_CITY_SEARCH)
        }
    }

}