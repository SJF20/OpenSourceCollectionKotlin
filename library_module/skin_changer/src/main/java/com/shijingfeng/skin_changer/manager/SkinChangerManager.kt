package com.shijingfeng.skin_changer.manager

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.GET_ACTIVITIES
import android.content.res.AssetManager
import android.content.res.Resources
import android.view.View
import androidx.annotation.WorkerThread
import androidx.fragment.app.Fragment
import com.shijingfeng.skin_changer.R
import com.shijingfeng.skin_changer.annotation.SkinType.HOST
import com.shijingfeng.skin_changer.annotation.SkinType.PLUGIN
import com.shijingfeng.skin_changer.processor.Processor
import com.shijingfeng.skin_changer.constant.SP_NAME
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.skin_changer.global.ExecuteListener
import com.shijingfeng.skin_changer.global.*
import com.shijingfeng.skin_changer.global.appContext
import com.shijingfeng.skin_changer.interfaces.ISkinChanger
import com.shijingfeng.skin_changer.listener.SkinChangingListener
import org.json.JSONObject
import java.io.File
import java.util.concurrent.Executors

/**
 * Function: SkinChanger 管理器
 * Date: 2020/7/21 9:40
 * Description:
 * @author ShiJingFeng
 */
class SkinChangerManager private constructor(
    variable: Variable,
    listener: Listener
) {
    /** 数据 */
    private val mVariable = variable
    /** 监听器 */
    private val mListener = listener

    /** Activity管理器 */
    private val mActivityManager = ActivityManager()

    /** 资源管理器 */
    private var mResourcesManager = ResourcesManager(
        mResources = appContext.resources,
        mSkinChannel = mVariable.skinChannel,
        mEnableDataUnify = mVariable.enableDataUnify
    )

    /** Processor Map (Key: [Activity] Name  Value: [Processor]) */
    private val mProcessorMap = hashMapOf<String, Processor>()

    /** 执行监听回调 Map (Key: [Activity] Name  Value: [ExecuteListener]函数实现) */
    private val mExecuteListenerMap = hashMapOf<String, ExecuteListener>()

    /** 单线程 线程池 (可以用于子线程顺序执行) */
    private val mSingleThreadExecutor = Executors.newSingleThreadExecutor()

    /**
     * 初始化, 建议放在 Application 中初始化
     */
    private fun init() {
        when (getSkinType(mVariable.skinChannel)) {
            // 插件式换肤
            PLUGIN -> {
                val valid = isPluginValid(
                    skinPluginPath = getSkinPluginPath(mVariable.skinChannel),
                    skinPluginPackageName = getSkinPluginPackageName(mVariable.skinChannel)
                )

                if (valid) {
                    mSingleThreadExecutor.execute {
                        loadSkinPlugin(
                            skinPluginPath = getSkinPluginPath(mVariable.skinChannel),
                            skinPluginPackageName = getSkinPluginPackageName(mVariable.skinChannel)
                        )
                    }
                }
            }
            // 宿主内部换肤
            HOST -> {
                removeSkinPluginPath(skinChannel = mVariable.skinChannel)
                putSkinPluginPackageName(
                    skinChannel = mVariable.skinChannel,
                    skinPluginPackageName = appContext.packageName
                )
                mResourcesManager.setResources(appContext.resources)
            }
            else -> {}
        }
    }

    /**
     * 检查皮肤插件是否可用
     */
    private fun isPluginValid(
        skinPluginPath: String,
        skinPluginPackageName: String
    ): Boolean {
        if (skinPluginPath.isEmpty() || skinPluginPackageName.isEmpty()) {
            return false
        }
        if (!File(skinPluginPath).exists()) {
            return false
        }
        val packageInfo = getPackageArchiveInfo(skinPluginPath) ?: return false

        if (packageInfo.packageName != skinPluginPackageName) {
            return false
        }
        return true
    }

    /**
     * 获取本地存储中的apk信息
     *
     * @param apkFilePath apk路径
     */
    private fun getPackageArchiveInfo(apkFilePath: String): PackageInfo? {
        val packageManager = appContext.packageManager

        return packageManager.getPackageArchiveInfo(apkFilePath, GET_ACTIVITIES)
    }

    /**
     * 加载皮肤插件
     *
     * @param skinPluginPath 插件路径
     * @param skinPluginPackageName 插件包名
     */
    @WorkerThread
    private fun loadSkinPlugin(
        skinPluginPath: String,
        skinPluginPackageName: String
    ): Boolean {
        try {
            val assetManager = AssetManager::class.java.newInstance()
            val addAssetPath = assetManager.javaClass.getMethod(
                "addAssetPath",
                String::class.java
            )

            addAssetPath.invoke(assetManager, skinPluginPath)

            val resources = Resources(
                assetManager,
                appContext.resources.displayMetrics,
                appContext.resources.configuration
            )

            putSkinPluginPath(
                skinChannel = mVariable.skinChannel,
                skinPluginPath = skinPluginPath
            )
            putSkinPluginPackageName(
                skinChannel = mVariable.skinChannel,
                skinPluginPackageName = skinPluginPackageName
            )
            mResourcesManager.setResources(resources)
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }

    /**
     * 通知 观察者列表 全部更新
     */
    private fun notifyAllObserver() {
        mActivityManager.getActivityList().forEach { activity ->
            notifyObserver(activity)
        }
    }

    /**
     * 通知 观察者 更新 (整个 Activity)
     */
    private fun notifyObserver(activity: Activity) {
        val executeListenerList = mutableListOf<ExecuteListener>()
        val partExecuteListener = mExecuteListenerMap[activity::class.java.name]
        val globalExecuteListener = mListener.executeListener

        if (partExecuteListener != null) {
            executeListenerList.add(partExecuteListener)
        }
        if (globalExecuteListener != null) {
            executeListenerList.add(globalExecuteListener)
        }

        val processor = Processor(
            skinChannel = mVariable.skinChannel,
            resourcesManager = mResourcesManager,
            executeListenerList = executeListenerList
        )

        mProcessorMap[activity::class.java.name] = processor
        processor.process(activity)
    }

    /**
     * 通知 观察者 更新 (整个 Fragment)
     */
    private fun notifyObserver(fragment: Fragment) {
        fragment.view?.run {
            notifyObserver(this)
        }
    }

    /**
     * 通知 观察者 更新 (从指定的 View 开始)
     */
    private fun notifyObserver(view: View) {
        // 注意 view.getContext() 不一定会返回为 Activity, 具体请看: https://www.jianshu.com/p/d48a6e723f35
        val activity = if (view.context != null && view.context is Activity) view.context as Activity else return
        val processor = mProcessorMap[activity::class.java.name]

        processor?.process(view)
    }

    /**
     * 注册当前Activity为换肤页面
     */
    fun register(
        activity: Activity,
        executeListener: ExecuteListener? = null
    ) {
        if (activity is ISkinChanger) {
            val resourceMap = activity.getResource()

            if (resourceMap.isNullOrEmpty()) {
                return
            }
            resourceMap.forEach { entry ->
                val view = entry.key
                val skinAttributeList = entry.value
                val jsonStr = skinAttributeList.toJsonString()

                view.setTag(R.id.skin_changer_tag_id, jsonStr)
            }
        } else {
            throw IllegalArgumentException("Activity 必须实现 ${ISkinChanger::class.java.simpleName} 接口")
        }

        if (executeListener != null) {
            mExecuteListenerMap[activity::class.java.name] = executeListener
        }
        mActivityManager.add(activity)
        activity.findViewById<View>(android.R.id.content).post {
            notifyObserver(activity)
        }
    }

    /**
     * 解注册当前Activity为换肤页面 (注意一旦调用[register], 必须要调用[unregister], 防止内存泄漏)
     */
    fun unregister(activity: Activity) {
        mActivityManager.remove(activity)
        mExecuteListenerMap.remove(activity::class.java.name)
        mProcessorMap.remove(activity::class.java.name)
    }

    /**
     * 更新 (整个 Activity)
     */
    fun update(activity: Activity) {
        notifyObserver(activity)
    }

    /**
     * 更新 (整个 Fragment)
     */
    fun update(fragment: Fragment) {
        notifyObserver(fragment)
    }

    /**
     * 更新 (从指定的 View 开始)
     */
    fun update(view: View) {
        notifyObserver(view)
    }

    /**
     * 应用内部换肤
     *
     * @param skinSuffix 主题皮肤后缀
     */
    fun changeSkinByAppInternal(
        skinSuffix: String
    ) {
        putSkinType(
            skinChannel = mVariable.skinChannel,
            skinType = HOST
        )
        putSkinSuffix(
            skinChannel = mVariable.skinChannel,
            skinSuffix = skinSuffix
        )
        removeSkinPluginPath(
            skinChannel = mVariable.skinChannel
        )
        putSkinPluginPackageName(
            skinChannel = mVariable.skinChannel,
            skinPluginPackageName = appContext.packageName
        )
        notifyAllObserver()
    }

    /**
     * 插件式换肤
     *
     * @param skinSuffix 主题皮肤后缀
     * @param skinPluginPath 插件路径 (可以在初始化时指定默认插件路径)
     * @param skinPluginPackageName 插件包名 (可以在初始化时指定默认插件包名)
     * @param skinChangingCallback 主题皮肤切换回调监听器
     */
    fun changeSkinByPlugin(
        skinSuffix: String,
        skinPluginPath: String = getSkinPluginPath(mVariable.skinChannel),
        skinPluginPackageName: String = getSkinPluginPackageName(mVariable.skinChannel),
        skinChangingCallback: SkinChangingListener? = null
    ) {
        val valid = isPluginValid(
            skinPluginPath = skinPluginPath,
            skinPluginPackageName = skinPluginPackageName
        )

        if (!valid) throw IllegalArgumentException("插件路径或包名有误")

        skinChangingCallback?.onStart()

        mSingleThreadExecutor.execute {
            val loadPluginSuccess = loadSkinPlugin(
                skinPluginPath = skinPluginPath,
                skinPluginPackageName = skinPluginPackageName
            )

            runOnUiThread {
                if (loadPluginSuccess) {
                    putSkinType(
                        skinChannel = mVariable.skinChannel,
                        skinType = PLUGIN
                    )
                    putSkinSuffix(
                        skinChannel = mVariable.skinChannel,
                        skinSuffix = skinSuffix
                    )
                    notifyAllObserver()
                    skinChangingCallback?.onCompleted()
                } else {
                    skinChangingCallback?.onError(null)
                }
            }
        }
    }

    /**
     * 获取资源管理器
     */
    fun getResourcesManager() = mResourcesManager

    /**
     * Builder模式 构建器
     */
    class Builder(
        // Context环境
        context: Context,
        // 主题渠道 (SkinChangerManager唯一标识, 用于单个App中多套主题独立更换, 本地存储时拼接到 [SP_NAME] 后面)
        skinChannel: String = "default"
    ) {

        /** 变量 */
        private val mVar = Variable()

        /** 监听器 */
        private val mListener = Listener()

        init {
            if (skinChannel.isEmpty()) {
                throw IllegalArgumentException("SkinChangerManager 中的 skinChannel(主题渠道) 不能为空")
            }

            mVar.skinChannel = skinChannel

            if (!appContextHasInitialized()) {
                appContext = context.applicationContext
            }
            skinChannelSet.add(skinChannel)
        }

        /**
         * 设置 默认皮肤插件路径 (不是相对于App的路径, 是设备存储路径)
         *
         * @param defaultSkinPluginPath 默认皮肤插件路径 (本地没有时，才会使用默认的)
         */
        fun setDefaultSkinPluginPath(defaultSkinPluginPath: String): Builder {
            val localSkinPluginPath = getSkinPluginPath(mVar.skinChannel)

            if (localSkinPluginPath.isEmpty()) {
                putSkinPluginPath(
                    skinChannel = mVar.skinChannel,
                    skinPluginPath = defaultSkinPluginPath
                )
            }
            return this
        }

        /**
         * 设置 皮肤插件包名
         *
         * @param defaultSkinPluginPackageName 皮肤插件包名
         */
        fun setDefaultSkinPluginPackageName(defaultSkinPluginPackageName: String): Builder {
            val localSkinPluginPackageName = getSkinPluginPackageName(mVar.skinChannel)

            if (localSkinPluginPackageName.isEmpty()) {
                putSkinPluginPackageName(
                    skinChannel = mVar.skinChannel,
                    skinPluginPackageName = defaultSkinPluginPackageName
                )
            }
            return this
        }

        /**
         * 当插件资源中没有时是否可以从本地获取
         *
         * @param enable 当插件资源中没有时是否可以从本地获取 (true: 开启  false: 关闭)
         */
        fun enableDataUnify(enable: Boolean): Builder {
            mVar.enableDataUnify = enable
            return this
        }

        /**
         * 设置 主题切换执行监听器
         *
         * @param executeListener 主题切换执行监听器
         */
        fun setExecuteListener(executeListener: ExecuteListener): Builder {
            this.mListener.executeListener = executeListener
            return this
        }

        /**
         * 开始构建
         */
        fun build(): SkinChangerManager {
            val skinChangerManager = SkinChangerManager(
                variable = mVar,
                listener = mListener
            )

            skinChangerManager.init()
            return skinChangerManager
        }

    }

    /**
     * 变量
     */
    private class Variable {

        /** 主题渠道 (SkinChangerManager唯一标志, 用于单个App中多套主题独立更换, 本地存储时拼接到 [SP_NAME] 后面) */
        var skinChannel = ""
        /** 当插件资源中没有时是否可以从本地获取 (true: 开启  false: 关闭) */
        var enableDataUnify = true

    }

    /**
     * 回调监听器
     */
    private class Listener {

        /** 主题切换执行监听器 */
        var executeListener: ExecuteListener? = null

    }

}