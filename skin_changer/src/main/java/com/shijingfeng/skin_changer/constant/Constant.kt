/** 生成的 Java 类名 */
@file:JvmName("Constant")
package com.shijingfeng.skin_changer.constant

/**
 * Function: 皮肤相关的静态数据
 * Date: 2020/7/20 13:40
 * Description:
 * @author ShiJingFeng
 */

/** SkinChanger SharedPreferences 名字 */
internal const val SP_NAME = "skin_changer"
/** 插件路径 SharedPreferences Key */
internal const val SP_KEY_SKIN_PLUGIN_PATH = "skin_plugin_path"
/** 插件包名 SharedPreferences Key */
internal const val SP_KEY_SKIN_PLUGIN_PACKAGE_NAME = "skin_plugin_package_name"
/** 主题皮肤后缀 SharedPreferences Key */
internal const val SP_KEY_SKIN_SUFFIX = "skin_suffix"
/** 主题皮肤类型 SharedPreferences Key */
internal const val SP_KEY_SKIN_TYPE = "skin_type"

/** 资源类型: Color(颜色) */
internal const val RESOURCE_TYPE_COLOR = "color"
/** 资源类型: Drawable(图片) */
internal const val RESOURCE_TYPE_DRAWABLE = "drawable"
/** 资源类型: Mipmap(图标) */
internal const val RESOURCE_TYPE_MIPMAP = "mipmap"
/** 资源类型: String(字符串文本) */
internal const val RESOURCE_TYPE_STRING = "string"
/** 资源名称: Dimen(尺寸) */
internal const val RESOURCE_TYPE_DIMEN = "dimen"
/** 资源名称: Array(数组) */
internal const val RESOURCE_TYPE_ARRAY = "array"

/** 没有资源 或 资源获取失败 */
const val RESOURCE_NONE = 0