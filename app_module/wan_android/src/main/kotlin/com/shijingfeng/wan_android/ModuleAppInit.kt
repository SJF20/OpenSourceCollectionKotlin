package com.shijingfeng.wan_android

import android.app.Application
import androidx.annotation.Keep
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shijingfeng.apt_api.listener.ApplicationListener
import com.shijingfeng.apt_data.annotations.ApplicationReceiver
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.interfaces.AppInit
import com.shijingfeng.base.util.LOG_LIFECYCLE
import com.shijingfeng.base.util.e
import com.shijingfeng.skin_changer.constant.BACK_GROUND_TINT
import com.shijingfeng.skin_changer.constant.TINT
import com.shijingfeng.skin_changer.manager.SkinChangerManager
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_ASSETS_FILE
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_FILE
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_PACKAGE
import com.shijingfeng.wan_android.common.global.skinChangerManager
import com.shijingfeng.wan_android.utils.checkTokenExpire
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.FileOutputStream

/**
 * Function: 模块 Application初始化 (类名不要变化(反射的缘故), 除非包括其他模块全局更改类名为同一个 并在 base模块中更改反射类名)
 * Date: 2020/5/25 22:12
 * Description:
 * @author ShiJingFeng
 */
@Keep // ModuleAppInit是通过反射调用，所以应防止被混淆
@ApplicationReceiver
internal class ModuleAppInit : AppInit, ApplicationListener {

    /**
     * 初始化 (对应 Application OnCreate())
     */
    override fun onCreate(application: Application) {
        super<ApplicationListener>.onCreate(application)
        e(LOG_LIFECYCLE, "wan_android ModuleAppInit onCreate")
        // 检查 玩安卓 Token 是否过期
        checkTokenExpire()
        // 复制 asset目录中 玩Android skin文件 到本地内部存储目录中
        copySkinFileToLocal()
        // 初始化换肤框架
        initSkinChanger()
    }

    /**
     * 初始化换肤框架
     */
    private fun initSkinChanger() {
        skinChangerManager = SkinChangerManager.Builder(application, "wan_android")
            .setDefaultSkinPluginPath(WAN_ANDROID_SKIN_FILE)
            .setDefaultSkinPluginPackageName(WAN_ANDROID_SKIN_PACKAGE)
            .setExecuteListener executeListener@{ view, skinAttribute ->
                val data = skinAttribute.data

                if (data.isEmpty()) return@executeListener false

                when (skinAttribute.name) {
                    TINT -> {
                        if (view is CircleImageView) {
                            view.setImageDrawable(skinChangerManager.getResourcesManager().getRealDrawableByResName(data))
                            return@executeListener true
                        }
                    }
                    BACK_GROUND_TINT -> {
                        if (view is FloatingActionButton) {
                            view.backgroundTintList = skinChangerManager.getResourcesManager().getRealColorStateList(data)
                            return@executeListener true
                        }
                    }
                    else -> {}
                }
                return@executeListener false
            }
            .build()
    }

    /**
     * 复制 asset目录中 玩Android skin文件 到本地内部存储目录中
     */
    private fun copySkinFileToLocal() {
        val skinFile = File(WAN_ANDROID_SKIN_FILE)

        if (!skinFile.exists() && skinFile.createNewFile()) {
            application.assets.open(WAN_ANDROID_SKIN_ASSETS_FILE).use { inputStream ->
                FileOutputStream(skinFile).use { fileOutputStream ->
                    val byteArray = ByteArray(1024)
                    var length: Int

                    while (inputStream.read(byteArray).also { length = it } != -1) {
                        fileOutputStream.write(byteArray, 0, length)
                    }
                }
            }
        }
    }

}