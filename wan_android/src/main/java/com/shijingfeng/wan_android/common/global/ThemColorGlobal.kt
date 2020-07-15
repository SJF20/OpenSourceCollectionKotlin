/** 生成的 Java 类名 */
@file:JvmName("ThemeColorGlobal")

package com.shijingfeng.wan_android.common.global

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shijingfeng.base.util.*
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.utils.ThemeUtil
import com.zhy.changeskin.SkinManager
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Function: 主题颜色 全局类
 * Date: 2020/5/30 23:28
 * Description:
 * @author ShiJingFeng
 */

/** 主题颜色 列表 */
internal val themeColorList by lazy { getStringArrayById(R.array.themeColorArray) }

/** 主题颜色名称 列表 */
internal val themeColorNameList by lazy { getStringArrayById(R.array.themeColorNameArray) }

/**
 * 换肤框架实例
 *
 * 使用创建对象的方式而不使用单例的原因: 每个模块都可以独立的更换主题
 */
internal val skinManager: SkinManager by lazy {
    try {
        SkinManager::class.java.getDeclaredConstructor().run {
            isAccessible = true
            newInstance()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
    SkinManager.getInstance()
}

/**
 * View 背景 批量设置 主题背景颜色
 *
 * @param views View数组
 * @param resName 资源ID 名称
 * @param resType 资源类型 (Color, Drawable)
 */
fun <T : View> setThemeBackground(
    vararg views: T,
    resName: String = "",
    resType: String = ""
) {
    when (resType) {
        // Color(颜色)
        RESOURCE_TYPE_COLOR -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            @ColorInt val color = getColorByIdName(curThemeResName)

            if (color != 0) {
                for (view in views) {
                    val drawable = view.background

                    if (drawable is ColorDrawable && drawable.color == color) {
                        continue
                    }
                    view.background = ColorDrawable(color)
                }
            }
        }
        // Drawable(图片)
        RESOURCE_TYPE_DRAWABLE -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getDrawableByIdName(curThemeResName)

            if (drawable != null) {
                for (view in views) {
                    val oldDrawable = view.background

                    if (drawable != oldDrawable) {
                        view.background = drawable
                    }
                }
            }
        }
        // Mipmap(图标)
        RESOURCE_TYPE_MIPMAP -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getMipmapByIdName(curThemeResName)

            if (drawable != null) {
                for (view in views) {
                    val oldDrawable = view.background

                    if (drawable != oldDrawable) {
                        view.background = drawable
                    }
                }
            }
        }
        // 默认设置主题颜色
        else -> {
            @ColorInt val color = Color.parseColor(ThemeUtil.curThemeColor)

            for (view in views) {
                val drawable = view.background

                if (drawable is ColorDrawable && drawable.color == color) {
                    continue
                }
                view.background = ColorDrawable(color)
            }
        }
    }
}

/**
 * View 背景Tint 批量设置 主题背景颜色
 *
 * @param views View数组
 */
fun <T : View> setThemeBackgroundTintList(vararg views: T) {
    @ColorInt val curThemeColor = Color.parseColor(ThemeUtil.curThemeColor)
    val curThemeColorStateList = ColorStateList.valueOf(curThemeColor)

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
    @ColorInt val curThemeColor = Color.parseColor(ThemeUtil.curThemeColor)
    val curThemeColorStateList = ColorStateList.valueOf(curThemeColor)

    textViews.forEach { textView ->
        textView.setTextColor(curThemeColorStateList)
    }
}

/**
 * ImageView 批量设置 主题图片
 *
 * @param imageViews ImageView数组
 * @param resName 资源ID 名称
 * @param resType 资源类型 (Drawable)
 */
fun <T : ImageView> setThemeSrc(
    vararg imageViews: T,
    resName: String = "",
    resType: String = ""
) {
    when (resType) {
        // Drawable(图片)
        RESOURCE_TYPE_DRAWABLE -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getDrawableByIdName(curThemeResName)

            if (drawable != null) {
                for (view in imageViews) {
                    if (view is CircleImageView) {
                        (view as CircleImageView).setImageDrawable(drawable)
                    }
                }
            }
        }
        // Mipmap(图标)
        RESOURCE_TYPE_MIPMAP -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getMipmapByIdName(curThemeResName)

            if (drawable != null) {
                for (view in imageViews) {
                    if (view is CircleImageView) {
                        (view as CircleImageView).setImageDrawable(drawable)
                    }
                }
            }
        }
        else -> {}
    }
}

/**
 * ImageView Tint 批量设置 主题Tint颜色
 *
 * @param imageViews ImageView数组
 */
fun <T : ImageView> setThemeTint(vararg imageViews: T) {
    @ColorInt val curThemeColor = Color.parseColor(ThemeUtil.curThemeColor)
    val curThemeColorStateList = ColorStateList.valueOf(curThemeColor)

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
    resName: String = "",
    resType: String = ""
) {
    when (resType) {
        // Drawable(图片)
        RESOURCE_TYPE_DRAWABLE -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getDrawableByIdName(curThemeResName)

            if (drawable != null) {
                for (view in views) {
                    view.buttonDrawable = drawable
                }
            }
        }
        // Mipmap(图标)
        RESOURCE_TYPE_MIPMAP -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getMipmapByIdName(curThemeResName)

            if (drawable != null) {
                for (view in views) {
                    view.buttonDrawable = drawable
                }
            }
        }
        else -> {
            val curThemeResName = resName + "_" + ThemeUtil.curThemeName
            val drawable = getDrawableByIdName(curThemeResName)

            if (drawable != null) {
                for (view in views) {
                    view.buttonDrawable = drawable
                }
            }
        }
    }
}