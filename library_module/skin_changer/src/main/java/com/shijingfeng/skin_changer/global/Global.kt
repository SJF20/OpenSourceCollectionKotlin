/** 生成的 Java 类名 */
@file:JvmName("Global")
package com.shijingfeng.skin_changer.global

import android.content.Context
import android.os.Handler
import android.os.Looper
import com.shijingfeng.skin_changer.annotation.SkinType.PLUGIN
import com.shijingfeng.skin_changer.annotation.SkinType.HOST
import com.shijingfeng.skin_changer.constant.SP_KEY_SKIN_PLUGIN_PACKAGE_NAME
import com.shijingfeng.skin_changer.constant.SP_KEY_SKIN_PLUGIN_PATH
import com.shijingfeng.skin_changer.constant.SP_KEY_SKIN_SUFFIX
import com.shijingfeng.skin_changer.constant.SP_KEY_SKIN_TYPE
import com.shijingfeng.skin_changer.constant.SP_NAME

/**
 * Function: 全局数据和操作
 * Date: 2020/7/21 12:50
 * Description:
 * @author ShiJingFeng
 */

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/** Application Context */
internal lateinit var appContext: Context

/** Application Context 是否已赋值初始化过 */
internal fun appContextHasInitialized() = ::appContext.isInitialized

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/** 主题渠道Set (SkinChangerManager唯一标志, 用于单个App中多套主题独立更换, 本地存储时拼接到 [SP_NAME] 后面) */
internal val skinChannelSet = mutableSetOf<String>()

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/** 皮肤插件路径 Map (Key: 主题渠道  Value: 皮肤插件路径) (不是相对于App的路径, 是设备存储路径) */
private val skinPluginPathMap = mutableMapOf<String, String>()
/** 皮肤插件包名 Map (Key: 主题渠道  Value: 皮肤插件包名) */
private val skinPluginPackageNameMap = mutableMapOf<String, String>()
/** 皮肤后缀 Map (Key: 主题渠道  Value: 皮肤后缀名) (用于切换到指定后缀的主题) */
private val skinSuffixMap = mutableMapOf<String, String>()
/** 换肤类型 Map (Key: 主题渠道  Value: 换肤类型 [PLUGIN] [HOST]) */
private val skinTypeMap = mutableMapOf<String, Int>()

/**
 * 获取插件路径  如果内存中有，则从内存中获取，否则从硬盘中获取
 *
 * @param skinChannel 皮肤渠道
 */
fun getSkinPluginPath(skinChannel: String): String {
    val skinPluginPath = skinPluginPathMap[skinChannel]

    if (!skinPluginPath.isNullOrEmpty()) {
        return skinPluginPath
    }

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    return sp?.getString(SP_KEY_SKIN_PLUGIN_PATH, "") ?: ""
}

/**
 * 添加插件路径到 内存 和 硬盘 中
 *
 * @param skinChannel 皮肤渠道
 */
fun putSkinPluginPath(
    skinChannel: String,
    skinPluginPath: String
) {
    if (skinPluginPath == skinPluginPathMap[skinChannel]) {
        return
    }

    skinPluginPathMap[skinChannel] = skinPluginPath

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.putString(SP_KEY_SKIN_PLUGIN_PATH, skinPluginPath)
        ?.apply()
}

/**
 * 从 内存 和 硬盘 中 删除插件路径
 *
 * @param skinChannel 主题皮肤渠道
 */
fun removeSkinPluginPath(skinChannel: String) {
    skinPluginPathMap.remove(skinChannel)

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.remove(SP_KEY_SKIN_PLUGIN_PATH)
        ?.apply()
}

/**
 * 获取插件包名  如果内存中有，则从内存中获取，否则从硬盘中获取
 *
 * @param skinChannel 皮肤渠道
 */
fun getSkinPluginPackageName(skinChannel: String): String  {
    val skinPluginPackageName = skinPluginPackageNameMap[skinChannel]

    if (!skinPluginPackageName.isNullOrEmpty()) {
        return skinPluginPackageName
    }

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    return sp?.getString(SP_KEY_SKIN_PLUGIN_PACKAGE_NAME, "") ?: ""
}

/**
 * 添加插件包名到 内存 和 硬盘 中
 *
 * @param skinChannel 皮肤渠道
 */
fun putSkinPluginPackageName(
    skinChannel: String,
    skinPluginPackageName: String
) {
    if (skinPluginPackageName == skinPluginPackageNameMap[skinChannel]) {
        return
    }

    skinPluginPackageNameMap[skinChannel] = skinPluginPackageName

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.putString(SP_KEY_SKIN_PLUGIN_PACKAGE_NAME, skinPluginPackageName)
        ?.apply()
}

/**
 * 从 内存 和 硬盘 中 删除插件包名
 *
 * @param skinChannel 主题皮肤渠道
 */
fun removeSkinPluginPackageName(skinChannel: String) {
    skinPluginPackageNameMap.remove(skinChannel)

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.remove(SP_KEY_SKIN_PLUGIN_PACKAGE_NAME)
        ?.apply()
}

/**
 * 获取主题皮肤后缀  如果内存中有，则从内存中获取，否则从硬盘中获取
 *
 * @param skinChannel 皮肤渠道
 */
fun getSkinSuffix(skinChannel: String): String {
    val skinSuffix = skinSuffixMap[skinChannel]

    if (!skinSuffix.isNullOrEmpty()) {
        return skinSuffix
    }

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    return sp?.getString(SP_KEY_SKIN_SUFFIX, "") ?: ""
}

/**
 * 添加主题皮肤后缀到 内存 和 硬盘 中
 *
 * @param skinChannel 皮肤渠道
 */
fun putSkinSuffix(
    skinChannel: String,
    skinSuffix: String
) {
    if (skinSuffix == skinSuffixMap[skinChannel]) {
        return
    }

    skinSuffixMap[skinChannel] = skinSuffix

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.putString(SP_KEY_SKIN_SUFFIX, skinSuffix)
        ?.apply()
}

/**
 * 从 内存 和 硬盘 中 删除皮肤后缀
 *
 * @param skinChannel 主题皮肤渠道
 */
fun removeSkinSuffix(skinChannel: String) {
    skinSuffixMap.remove(skinChannel)

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.remove(SP_KEY_SKIN_SUFFIX)
        ?.apply()
}

/**
 * 获取皮肤类型  如果内存中有，则从内存中获取，否则从硬盘中获取
 *
 * @param skinChannel 主题皮肤渠道
 */
fun getSkinType(skinChannel: String): Int {
    val skinType = skinTypeMap[skinChannel]

    if (skinType != null) {
        return skinType
    }

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    return sp?.getInt(SP_KEY_SKIN_TYPE, 0) ?: 0
}

/**
 * 添加主题皮肤类型到 内存 和 硬盘 中
 *
 * @param skinChannel 皮肤渠道
 * @param skinType 主题皮肤类型
 */
fun putSkinType(
    skinChannel: String,
    skinType: Int
) {
    if (skinType == skinTypeMap[skinChannel]) {
        return
    }

    skinTypeMap[skinChannel] = skinType

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.putInt(SP_KEY_SKIN_TYPE, skinType)
        ?.apply()
}

/**
 * 从 内存 和 硬盘 中 删除皮肤类型
 *
 * @param skinChannel 主题皮肤渠道
 */
fun removeSkinType(skinChannel: String) {
    skinTypeMap.remove(skinChannel)

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.remove(SP_KEY_SKIN_TYPE)
        ?.apply()
}

/**
 * 清空 内存 和 硬盘 数据
 *
 * @param skinChannel 皮肤渠道
 */
fun clear(skinChannel: String) {
    skinChannelSet.remove(skinChannel)
    skinPluginPathMap.remove(skinChannel)
    skinPluginPackageNameMap.remove(skinChannel)
    skinSuffixMap.remove(skinChannel)

    val sp = appContext.getSharedPreferences(
        if (skinChannel.isEmpty()) SP_NAME else "${SP_NAME}_${skinChannel}",
        Context.MODE_PRIVATE
    )

    sp?.edit()
        ?.remove(SP_KEY_SKIN_PLUGIN_PATH)
        ?.remove(SP_KEY_SKIN_PLUGIN_PACKAGE_NAME)
        ?.remove(SP_KEY_SKIN_SUFFIX)
        ?.apply()
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/** 主线程 Handler */
private val mainHandler = Handler(Looper.getMainLooper())

/** 获取 主线程 Handler */
internal fun getMainHandler() = mainHandler

/**
 * 运行在主线程
 * @param action 要执行的回调
 */
internal fun runOnUiThread(
    delay: Long = 0L,
    action: () -> Unit
) = mainHandler.postDelayed(action, delay)

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////