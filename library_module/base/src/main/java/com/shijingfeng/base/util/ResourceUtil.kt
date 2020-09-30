/** 生成的 Java 类名 */
@file:JvmName("ResourceUtil")
package com.shijingfeng.base.util

import android.content.res.Resources
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.ResourceUtils
import com.shijingfeng.base.base.application.application

/**
 * Function: 资源工具类
 * Date: 2020/2/2 21:25
 * Description:
 * @author ShiJingFeng
 */

/** 资源类型: Color(颜色) */
const val RESOURCE_TYPE_COLOR = "color"
/** 资源类型: Drawable(图片) */
const val RESOURCE_TYPE_DRAWABLE = "drawable"
/** 资源类型: Mipmap(图标) */
const val RESOURCE_TYPE_MIPMAP = "mipmap"
/** 资源类型: String(字符串文本) */
const val RESOURCE_TYPE_STRING = "string"
/** 资源名称: Dimen(尺寸) */
const val RESOURCE_TYPE_DIMEN = "dimen"
/** 资源名称: Array(数组) */
const val RESOURCE_TYPE_ARRAY = "array"

/** 没有资源 */
const val RESOURCE_NONE = 0

/**
 * 通过发射获取资源ID
 * @param variableName 资源ID 名称
 * @param cls 资源ID 类型
 * @return 资源ID
 */
fun getResId(variableName: String, cls: Class<*>): Int {
    return try {
        val idField = cls.getDeclaredField(variableName)

        idField.getInt(idField)
    } catch (e: NoSuchFieldException) {
        e.printStackTrace()
        RESOURCE_NONE
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
        RESOURCE_NONE
    }
}

/**
 * 通过 资源ID 获取 ColorInt
 * @param color Color Id
 * @return ColorInt
 */
@ColorInt
fun getColorById(@ColorRes color: Int) = application.resources.getColor(color)

/**
 * 通过 资源名称 获取 ColorInt
 * @param colorResName 资源名称
 */
@ColorInt
fun getColorByIdName(colorResName: String): Int {
    try {
        @ColorRes val colorId = application.resources.getIdentifier(colorResName, RESOURCE_TYPE_COLOR, application.packageName)

        return getColorById(colorId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return RESOURCE_NONE
}

/**
 * 通过 资源ID 获取 Drawable
 *
 * @param drawableId Drawable Id
 * @return Drawable
 */
fun getDrawableById(@DrawableRes drawableId: Int): Drawable? = ResourceUtils.getDrawable(drawableId)

/**
 * 通过 颜色资源ID 获取 Drawable
 *
 * @param colorId Color Id
 * @return Drawable
 */
fun getDrawableByColorId(@ColorRes colorId: Int): Drawable? = ColorDrawable(getColorById(colorId))

/**
 * Color 转换为 Drawable
 *
 * @param color Color
 * @return Drawable
 */
fun getDrawableByColor(@ColorInt color: Int): Drawable? = ColorDrawable(color)

/**
 * 通过 资源名称 获取 Drawable
 * @param drawableResName 资源名称
 */
fun getDrawableByIdName(drawableResName: String): Drawable? {
    try {
        @DrawableRes val drawableId = application.resources.getIdentifier(drawableResName, RESOURCE_TYPE_DRAWABLE, application.packageName)

        return getDrawableById(drawableId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return null
}

/**
 * 通过 资源名称 获取 Drawable (mipmap文件夹内)
 * @param mipmapResName 资源名称
 */
fun getMipmapByIdName(mipmapResName: String): Drawable? {
    try {
        @DrawableRes val drawableId = application.resources.getIdentifier(mipmapResName, RESOURCE_TYPE_MIPMAP, application.packageName)

        return getDrawableById(drawableId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return null
}

/**
 * 通过 资源ID 获取 String字符串
 * @param stringId 字符串 Id
 * @return 字符串
 */
fun getStringById(@StringRes stringId: Int) = application.resources.getString(stringId)

/**
 * 通过 资源名称 获取 String字符串
 * @param stringResName
 */
fun getStringByIdName(stringResName: String): String {
    try {
        @StringRes val stringId = application.resources.getIdentifier(stringResName, RESOURCE_TYPE_STRING, application.packageName)

        return getStringById(stringId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return ""
}

/**
 * 通过 资源ID 获取 尺寸
 * @param dimenId 尺寸 Id
 * @return 尺寸
 */
fun getDimensionById(@DimenRes dimenId: Int) = application.resources.getDimension(dimenId)

/**
 * 通过 资源名称 获取 尺寸
 * @param dimenResName
 */
fun getDimensionByIdName(dimenResName: String): Float {
    try {
        @StringRes val dimenId = application.resources.getIdentifier(dimenResName, RESOURCE_TYPE_DIMEN, application.packageName)

        return getDimensionById(dimenId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return 0F
}

/**
 * 通过 资源ID 获取 字符串数组
 * @param arrayId 字符串数组资源 ID
 * @return 字符串数组资源
 */
fun getStringArrayById(@ArrayRes arrayId: Int): Array<String>? = application.resources.getStringArray(arrayId)

/**
 * 通过 资源名称 获取 字符串数组
 * @param arrayResName 字符串数组 资源名称
 * @return 字符串数组资源
 */
fun getStringArrayByIdName(arrayResName: String): Array<String>? {
    try {
        @ArrayRes val arrayId = application.resources.getIdentifier(arrayResName, RESOURCE_TYPE_ARRAY, application.packageName)

        return getStringArrayById(arrayId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return null
}

/**
 * 通过 资源ID 获取 整数数组
 * @param arrayId 整数数组 ID
 * @return 整数数组
 */
fun getIntArrayById(@ArrayRes arrayId: Int): IntArray? = application.resources.getIntArray(arrayId)

/**
 * 通过 资源名称 获取 整数数组
 * @param arrayResName 整数数组 资源名称
 * @return 整数数组资源
 */
fun getIntArrayByIdName(arrayResName: String): IntArray? {
    try {
        @ArrayRes val arrayId = application.resources.getIdentifier(arrayResName, RESOURCE_TYPE_ARRAY, application.packageName)

        return getIntArrayById(arrayId)
    } catch (e: Resources.NotFoundException) {
        e.printStackTrace()
    }
    return null
}