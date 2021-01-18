package com.shijingfeng.wan_android

import androidx.annotation.Keep
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shijingfeng.apt_data.annotations.ModuleEventReceiver
import com.shijingfeng.apt_data.interfaces.ModuleEventListener
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.common.constant.DISPATCHER_GROUP_APPLICATION
import com.shijingfeng.base.util.LOG_LIFECYCLE
import com.shijingfeng.base.util.e
import com.shijingfeng.skin_changer.constant.BACK_GROUND_TINT
import com.shijingfeng.skin_changer.constant.TINT
import com.shijingfeng.skin_changer.manager.SkinChangerManager
import com.shijingfeng.wan_android.BuildConfig.MODULE_NAME
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_ASSETS_FILE
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_FILE
import com.shijingfeng.wan_android.common.constant.WAN_ANDROID_SKIN_PACKAGE
import com.shijingfeng.wan_android.common.global.skinChangerManager
import com.shijingfeng.wan_android.utils.checkTokenExpire
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.FileOutputStream

/**
 * Function: 模块 Application初始化
 * Date: 2020/5/25 22:12
 * Description:
 * Author: ShiJingFeng
 */
@Keep // 因此类通过反射调用，所以应防止被混淆
@ModuleEventReceiver(
    group = DISPATCHER_GROUP_APPLICATION
)
internal class WanAndroidModuleApplication : ModuleEventListener {

    /**
     * 接收回调
     */
    override fun onReceive(data: Map<String, Any>): Boolean {
        e(LOG_LIFECYCLE, "$MODULE_NAME ModuleApplication onCreate")
        // 检查 玩安卓 Token 是否过期
        checkTokenExpire()
        // 复制 asset目录中 玩Android skin文件 到本地内部存储目录中
        copySkinFileToLocal()
        // 初始化换肤框架
        initSkinChanger()
        return super.onReceive(data)
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