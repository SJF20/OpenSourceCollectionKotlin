/** 生成的 Java 类名 */
@file:JvmName("ThemeColorGlobal")

package com.shijingfeng.wan_android.common.global

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shijingfeng.base.util.*
import com.shijingfeng.skin_changer.manager.SkinChangerManager
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.utils.ThemeUtil
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Function: 主题颜色 全局类
 * Date: 2020/5/30 23:28
 * Description:
 * Author: ShiJingFeng
 */

/** 主题颜色 列表 */
internal val themeColorList by lazy {
    skinChangerManager.getResourcesManager().getStringArrayByName(getStringById(R.string.array_id_themeColorArray))?.map { rgbStr ->
        Color.parseColor(rgbStr)
    }?.toIntArray() ?: intArrayOf()
}

/** 主题颜色名称 列表 */
internal val themeColorNameList by lazy { skinChangerManager.getResourcesManager().getStringArrayByName(getStringById(R.string.array_id_themeColorNameArray)) ?: arrayOf() }

/** 换肤框架实例 (每个模块都可以独立的更换主题) */
internal lateinit var skinChangerManager: SkinChangerManager

/**
 * View 背景 批量设置 主题背景颜色
 *
 * @param views View数组
 * @param resName 资源ID 名称
 */
fun <T : View> setThemeBackground(
    vararg views: T,
    resName: String = ""
) {
    @ColorInt val color = ThemeUtil.curThemeColor
    val drawable = if (resName.isNotEmpty()) skinChangerManager.getResourcesManager().getRealDrawableByResName(resName) else null

    for (view in views) {
        if (drawable != null) {
            view.background = drawable
        } else {
            view.setBackgroundColor(color)
        }
    }
}

/**
 * View 背景Tint 批量设置 主题背景颜色
 *
 * @param views View数组
 */
fun <T : View> setThemeBackgroundTintList(vararg views: T) {
    val curThemeColorStateList = ColorStateList.valueOf(ThemeUtil.curThemeColor)

    for (view in views) {
        when (view) {
            is FloatingActionButton -> view.backgroundTintList = curThemeColorStateList
            else -> view.backgroundTintList = curThemeColorStateList
        }
    }
}

/**
 * TextView 文本 批量设置 主题文本颜色
 *
 * @param textViews TextView数组
 */
fun <T : TextView> setThemeTextColor(vararg textViews: T) {
    val curThemeColorStateList = ColorStateList.valueOf(ThemeUtil.curThemeColor)

    textViews.forEach { textView ->
        textView.setTextColor(curThemeColorStateList)
    }
}

/**
 * ImageView 批量设置 主题图片
 *
 * @param imageViews ImageView数组
 * @param resName 资源ID 名称
 */
fun <T : ImageView> setThemeSrc(
    vararg imageViews: T,
    resName: String
) {
    val drawable = skinChangerManager.getResourcesManager().getRealDrawableByResName(resName)

    if (drawable != null) {
        for (view in imageViews) {
            if (view is CircleImageView) {
                (view as CircleImageView).setImageDrawable(drawable)
            } else {
                view.setImageDrawable(drawable)
            }
        }
    }
}

/**
 * ImageView Tint 批量设置 主题Tint颜色
 *
 * @param imageViews ImageView数组
 */
fun <T : ImageView> setThemeTint(vararg imageViews: T) {
    val curThemeColorStateList = ColorStateList.valueOf(ThemeUtil.curThemeColor)

    imageViews.forEach { imageView ->
        imageView.imageTintList = curThemeColorStateList
    }
}

/**
 * View 批量设置 主题 ButtonDrawable
 *
 * @param views View数组
 * @param resName 资源ID 名称
 * @param resType 资源类型 (Drawable)
 */
fun <T : CompoundButton> setThemeButtonDrawable(
    vararg views: T,
    resName: String
) {
    val drawable = skinChangerManager.getResourcesManager().getRealDrawableByResName(resName)

    if (drawable != null) {
        for (view in views) {
            view.buttonDrawable = drawable
        }
    }
}