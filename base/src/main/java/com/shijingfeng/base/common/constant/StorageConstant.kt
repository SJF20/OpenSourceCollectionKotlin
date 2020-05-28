@file:JvmName("StorageConstant")
package com.shijingfeng.base.common.constant

import com.shijingfeng.base.base.application.application
import java.io.File

/**
 * Function: 目录 静态常量
 * Date: 2020/1/18 19:02
 * Description:
 * @author ShiJingFeng
 */

/** 外部存储 -> 应用私有目录 -> cache目录  /storage/emulated/0/Android/data/<application package>/cache/ */
val PERSONAL_CACHE_DIR: String by lazy {
    var file = application.externalCacheDir

    if (file == null) {
        // 外部存储不可用, 改为内部存储 缓存目录 /data/data/<application package>/cache/
        file = application.cacheDir!!
    }

    if (!file.exists()) {
        file.mkdirs()
    }
    file.absolutePath + File.separator
}

/** 外部存储 -> 应用私有目录 -> files 内 apk 目录  /storage/emulated/0/Android/data/<application package>/files/apk/ */
val PERSONAL_APK_FILE_DIR: String by lazy {
    var file = application.getExternalFilesDir("apk")

    if (file == null) {
        // 外部存储不可用, 改为内部存储 文件目录 /data/data/<application package>/files/
        file = application.filesDir!!
    }

    if (!file.exists()) {
        file.mkdirs()
    }
    file.absolutePath + File.separator
}

/** 外部存储 -> 应用私有目录 -> glide目录 /storage/emulated/0/Android/data/<application package>/cache/glide/
 *  如果外部存储不存在, 则是: /data/data/<application package>/cache/glide/
*/
val PERSONAL_GLIDE_CACHE_DIR: String by lazy {
    val glidePath = PERSONAL_CACHE_DIR + "glide"
    val glideFile = File(glidePath)

    if (!glideFile.exists()) {
        glideFile.mkdirs()
    }
    glidePath + File.separator
}