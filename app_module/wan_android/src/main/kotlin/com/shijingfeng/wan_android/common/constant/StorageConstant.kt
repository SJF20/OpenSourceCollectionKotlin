@file:JvmName("StorageConstant")
package com.shijingfeng.wan_android.common.constant

import com.shijingfeng.base.common.constant.PERSONAL_INTERNAL_FILE_DIR
import java.io.File

/**
 * Function: wan_android模块相关 目录 静态常量
 * Date: 2020/7/19 17:12
 * Description:
 * Author: ShiJingFeng
 */

/** 内部存储 -> 应用私有目录 -> skin目录  /data/data/<application package>/files/skin/ */
internal val PERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR: String by lazy {
    val skinPath = PERSONAL_INTERNAL_FILE_DIR + "skin"
    val skinFile = File(skinPath)

    if (!skinFile.exists()) {
        skinFile.mkdirs()
    }
    skinPath + File.separator
}

/** 玩Android 本地皮肤文件 */
internal val WAN_ANDROID_SKIN_FILE: String by lazy {
    PERSONAL_INTERNAL_WAN_ANDROID_SKIN_FILE_DIR + WAN_ANDROID_SKIN_ASSETS_FILE
}

/** assets目录内 玩Android皮肤文件 */
internal const val WAN_ANDROID_SKIN_ASSETS_FILE = "wan_android_skin.skin"

/** assets目录内 图片点击 js文件 */
internal const val IMAGE_CLICK_JS_ASSETS_FILE = "js/image_click.js"