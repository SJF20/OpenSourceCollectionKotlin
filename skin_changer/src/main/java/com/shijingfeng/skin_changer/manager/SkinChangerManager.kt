package com.shijingfeng.skin_changer.manager

import android.app.Activity
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager.GET_ACTIVITIES
import android.content.res.AssetManager
import android.content.res.Resources
import android.view.View
import androidx.annotation.WorkerThread
import com.shijingfeng.skin_changer.annotation.SkinType.HOST
import com.shijingfeng.skin_changer.annotation.SkinType.PLUGIN
import com.shijingfeng.skin_changer.processor.Processor
import com.shijingfeng.skin_changer.constant.SP_NAME
import com.shijingfeng.skin_changer.entity.SkinElement
import com.shijingfeng.skin_changer.global.*
import com.shijingfeng.skin_changer.global.appContext
import com.shijingfeng.skin_changer.listener.ExecuteListener
import com.shijingfeng.skin_changer.listener.ParseListener
import com.shijingfeng.skin_changer.listener.SkinChangingCallback
import java.io.File
import java.util.concurrent.Executors

/**
 * Function: SkinChanger 管理器
 * Date: 2020/7/21 9:40
 * Description:
 * @author ShiJingFeng
 */
class SkinChangerManager private constructor(
    private val mVar: Variable,
    private val mListener: Listener
) {

    /** Activity管理器 */
    private val mActivityManager = ActivityManager()

    /** 资源管理器 */
    private var mResourcesManager = ResourcesManager(
        mResources = appContext.resources,
        mSkinChannel = mVar.skinChannel,
        mEnableDataUnify = mVar.enableDataUnify
    )

    /** 处理器 */
    private var mProcessor = Processor(
        mSkinChannel = mVar.skinChannel,
        mResourcesManager = mResourcesManager,
        mParseListener = mListener.parseListener,
        mExecuteListener = mListener.executeListener
    )

    /** 单线程 线程池 (可以用于子线程顺序执行) */
    private val mSingleThreadExecutor = Executors.newSingleThreadExecutor()

    /**
     * 初始化, 建议放在 Application 中初始化
     */
    private fun init() {
        when (getSkinType(mVar.skinChannel)) {
            // 插件式换肤
            PLUGIN -> {
                val valid = isPluginValid(
                    skinPluginPath = getSkinPluginPath(mVar.skinChannel),
                    skinPluginPackageName = getSkinPluginPackageName(mVar.skinChannel)
                )

                if (valid) {
                    mSingleThreadExecutor.execute {
                        loadSkinPlugin(
                            skinPluginPath = getSkinPluginPath(mVar.skinChannel),
                            skinPluginPackageName = getSkinPluginPackageName(mVar.skinChannel)
                        )
                    }
                }
            }
            // 宿主内部换肤
            HOST -> {
                removeSkinPluginPath(skinChannel = mVar.skinChannel)
                putSkinPluginPackageName(
                    skinChannel = mVar.skinChannel,
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
                skinChannel = mVar.skinChannel,
                skinPluginPath = skinPluginPath
            )
            putSkinPluginPackageName(
                skinChannel = mVar.skinChannel,
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
     * 通知 观察者 更新
     */
    private fun notifyObserver(activity: Activity) {
        mProcessor.process(activity)
    }

    /**
     * 注册当前Activity为换肤页面
     */
    fun register(activity: Activity) {
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
            skinChannel = mVar.skinChannel,
            skinType = HOST
        )
        putSkinSuffix(
            skinChannel = mVar.skinChannel,
            skinSuffix = skinSuffix
        )
        removeSkinPluginPath(
            skinChannel = mVar.skinChannel
        )
        putSkinPluginPackageName(
            skinChannel = mVar.skinChannel,
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
        skinPluginPath: String = getSkinPluginPath(mVar.skinChannel),
        skinPluginPackageName: String = getSkinPluginPackageName(mVar.skinChannel),
        skinChangingCallback: SkinChangingCallback? = null
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
                        skinChannel = mVar.skinChannel,
                        skinType = PLUGIN
                    )
                    putSkinSuffix(
                        skinChannel = mVar.skinChannel,
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
     * 局部换肤
     *
     * @param view 当前局部换肤的View
     */
    fun changeSkinInPart(view: View): List<SkinElement> {
        val skinElementList = mutableListOf<SkinElement>()

        mProcessor.recursionAddSkinView(view, skinElementList)
        return skinElementList
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
         * 设置 解析监听器
         *
         * @param parseListener 解析监听器
         */
        fun setParseListener(parseListener: ParseListener): Builder {
            this.mListener.parseListener = parseListener
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
                mVar = mVar,
                mListener = mListener
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

        /** 解析监听器 */
        var parseListener: ParseListener? = null

        /** 主题切换执行监听器 */
        var executeListener: ExecuteListener? = null

    }

}