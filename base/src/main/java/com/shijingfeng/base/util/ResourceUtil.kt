/** 生成的 Java 类名 */
@file:JvmName("ResourceUtil")
package com.shijingfeng.base.util

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.blankj.utilcode.util.ResourceUtils
import com.shijingfeng.base.base.application.application

/**
 * Function: 资源工具类
 * Date: 2020/2/2 21:25
 * Description:
 * @author ShiJingFeng
 */

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
        0
    } catch (e: IllegalAccessException) {
        e.printStackTrace()
        0
    }
}

/**
 * 获取 ColorInt
 * @param color Color Id
 * @return ColorInt
 */
fun getColorById(@ColorRes color: Int) = application.resources.getColor(color)

/**
 * 获取 Drawable
 * @param drawableId Drawable Id
 * @return Drawable
 */
fun getDrawableById(@DrawableRes drawableId: Int): Drawable? = ResourceUtils.getDrawable(drawableId)

/**
 * 获取 String字符串
 * @param stringId 字符串 Id
 * @return 字符串
 */
fun getStringById(@StringRes stringId: Int) = application.resources.getString(stringId)