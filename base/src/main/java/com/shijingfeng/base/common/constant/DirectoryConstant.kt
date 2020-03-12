@file:JvmName("DirectoryConstant")
package com.shijingfeng.base.common.constant

import com.shijingfeng.base.base.application.BaseApplication.Companion.getApplication
import java.io.File

/**
 * Function: 目录 静态常量
 * Date: 2020/1/18 19:02
 * Description:
 * @author ShiJingFeng
 */

/** 外部存储 -> 应用私有目录 -> cache目录  */
val PERSONAL_CACHE_DIR: String by lazy { getApplication().externalCacheDir!!.absolutePath }
/** 外部存储 -> 应用私有目录 -> glide目录  */
val PERSONAL_GLIDE_CACHE_DIR: String by lazy { PERSONAL_CACHE_DIR + File.separator + "glide" }
