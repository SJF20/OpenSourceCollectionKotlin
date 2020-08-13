package com.shijingfeng.skin_changer.manager

import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.Resources.NotFoundException
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.shijingfeng.skin_changer.annotation.SkinType.PLUGIN
import com.shijingfeng.skin_changer.constant.*
import com.shijingfeng.skin_changer.global.appContext
import com.shijingfeng.skin_changer.global.getSkinPluginPackageName
import com.shijingfeng.skin_changer.global.getSkinSuffix
import com.shijingfeng.skin_changer.global.getSkinType

/**
 * Function: 资源管理器
 * Date: 2020/7/20 13:34
 * Description:
 * @author ShiJingFeng
 */
class ResourcesManager(
    /** Resources 资源类 */
    private var mResources: Resources,
    /** 主题渠道 */
    private val mSkinChannel: String,
    /** 当插件资源中没有时是否可以从本地获取 (true: 开启  false: 关闭) */
    private val mEnableDataUnify: Boolean
) {
    /**
     * 通过默认颜色资源名称 获取 当前主题显示的Color
     *
     * @param defaultColorResName 默认Color资源名称
     * @return 当前主题显示的Color
     */
    @ColorInt
    fun getRealColor(defaultColorResName: String): Int {
        val realColorResName = getRealResName(defaultColorResName)
        @ColorRes var colorId = getColorIdByResName(realColorResName)

        if (colorId != RESOURCE_NONE) {
            return mResources.getColor(colorId)
        } else if (mEnableDataUnify && getSkinType(mSkinChannel) == PLUGIN) {
            colorId = getColorIdByResNameInHost(realColorResName)
            if (colorId != RESOURCE_NONE) {
                return appContext.resources.getColor(colorId)
            }
        }
        return RESOURCE_NONE
    }

    /**
     * 通过默认颜色资源名称 获取 当前主题显示的ColorStateList
     *
     * @param defaultColorResName 默认Color资源名称
     * @return 当前主题显示的ColorStateList
     */
    fun getRealColorStateList(defaultColorResName: String): ColorStateList? {
        val realColorResName = getRealResName(defaultColorResName)
        @ColorRes var colorId = getColorIdByResName(realColorResName)

        if (colorId != RESOURCE_NONE) {
            return mResources.getColorStateList(colorId)
        } else if (mEnableDataUnify && getSkinType(mSkinChannel) == PLUGIN) {
            colorId = getColorIdByResNameInHost(realColorResName)
            if (colorId != RESOURCE_NONE) {
                return appContext.resources.getColorStateList(colorId)
            }
        }
        return null
    }

    /**
     * 通过 Color资源名称 获取 Color ID
     *
     * @param colorResName Color资源名称
     * @return Color ID
     */
    @ColorRes
    private fun getColorIdByResName(
        colorResName: String
    ) = try {
        mResources.getIdentifier(colorResName, RESOURCE_TYPE_COLOR, getSkinPluginPackageName(mSkinChannel))
    } catch (e: NotFoundException) {
        e.printStackTrace()
        RESOURCE_NONE
    }

    /**
     * 在宿主App中 通过 Color资源名称 获取 Color ID
     *
     * @param colorResName Color资源名称
     * @return Color ID
     */
    private fun getColorIdByResNameInHost(
        colorResName: String
    ) = try {
        appContext.resources.getIdentifier(colorResName, RESOURCE_TYPE_COLOR, appContext.packageName)
    } catch (e: NotFoundException) {
        e.printStackTrace()
        RESOURCE_NONE
    }

    /**
     * 通过默认Drawable资源名称 获取 当前主题显示的Drawable
     *
     * @param defaultDrawableResName 默认Drawable资源名称
     * @return 当前主题显示的Drawable
     */
    fun getRealDrawableByResName(
        defaultDrawableResName: String
    ): Drawable? {
        val realDrawableResName = getRealResName(defaultDrawableResName)
        @DrawableRes var drawableId = RESOURCE_NONE

        for (i in 1..4) {
            when (i) {
                1 -> drawableId = getDrawableIdByResName(realDrawableResName, RESOURCE_TYPE_DRAWABLE)
                2 -> drawableId = getDrawableIdByResNameInHost(realDrawableResName, RESOURCE_TYPE_DRAWABLE)
                3 -> drawableId = getDrawableIdByResName(realDrawableResName, RESOURCE_TYPE_MIPMAP)
                4 -> drawableId = getDrawableIdByResNameInHost(realDrawableResName, RESOURCE_TYPE_MIPMAP)
            }
            if (drawableId != RESOURCE_NONE) {
                return if ((i and 1) == 1) {
                    // 奇数
                    mResources.getDrawable(drawableId)
                } else if (mEnableDataUnify && getSkinType(mSkinChannel) == PLUGIN) {
                    // 偶数
                    appContext.resources.getDrawable(drawableId)
                } else {
                    null
                }
            }
        }
        return null
    }

    /**
     * 通过 Drawable资源名称 获取 Drawable ID
     *
     * @param drawableResName Drawable资源名称
     * @param drawableType Drawable类型 (drawable文件内Drawable, mipmap文件夹内Drawable)
     * @return Drawable ID
     */
    @DrawableRes
    private fun getDrawableIdByResName(
        drawableResName: String,
        drawableType: String = RESOURCE_TYPE_DRAWABLE
    ) = try {
        mResources.getIdentifier(drawableResName, drawableType, getSkinPluginPackageName(mSkinChannel))
    } catch (e: NotFoundException) {
        e.printStackTrace()
        RESOURCE_NONE
    }

    /**
     * 在宿主App中 通过 Drawable资源名称 获取 Drawable ID
     *
     * @param drawableResName Drawable资源名称
     * @param drawableType Drawable类型 (drawable文件内Drawable, mipmap文件夹内Drawable)
     * @return Drawable ID
     */
    @DrawableRes
    private fun getDrawableIdByResNameInHost(
        drawableResName: String,
        drawableType: String = RESOURCE_TYPE_DRAWABLE
    ) = try {
        appContext.resources.getIdentifier(drawableResName, drawableType, appContext.packageName)
    } catch (e: NotFoundException) {
        e.printStackTrace()
        RESOURCE_NONE
    }

    /**
     * 通过默认资源名称 获取 Array数据
     *
     * @param arrayResName 默认Color资源名称
     * @return 当前主题显示的ColorStateList
     */
    fun getStringArrayByName(
        arrayResName: String
    ): Array<String>? {
        @ArrayRes var arrayId = getArrayIdByResName(arrayResName)

        if (arrayId != RESOURCE_NONE) {
            return mResources.getStringArray(arrayId)
        } else if (mEnableDataUnify && getSkinType(mSkinChannel) == PLUGIN) {
            arrayId = getArrayIdByResNameInHost(arrayResName)
            if (arrayId != RESOURCE_NONE) {
                return appContext.resources.getStringArray(arrayId)
            }
        }
        return null
    }

    /**
     * 通过 Array资源名称 获取 Array ID
     *
     * @param arrayResName Array资源名称
     * @return Array ID
     */
    @ArrayRes
    private fun getArrayIdByResName(
        arrayResName: String
    ) = try {
        mResources.getIdentifier(arrayResName, RESOURCE_TYPE_ARRAY, getSkinPluginPackageName(mSkinChannel))
    } catch (e: NotFoundException) {
        e.printStackTrace()
        RESOURCE_NONE
    }

    /**
     * 在宿主App中 通过 Array资源名称 获取 Array ID
     *
     * @param arrayResName Array资源名称
     * @return Array ID
     */
    private fun getArrayIdByResNameInHost(
        arrayResName: String
    ) = try {
        appContext.resources.getIdentifier(arrayResName, RESOURCE_TYPE_ARRAY, appContext.packageName)
    } catch (e: NotFoundException) {
        e.printStackTrace()
        RESOURCE_NONE
    }

    /**
     * 根据后缀 获取要切换到的皮肤真实资源名称
     *
     * @param defaultResName 默认资源名称
     * @return 真实资源名称
     */
    private fun getRealResName(defaultResName: String): String {
        val skinSuffix = getSkinSuffix(mSkinChannel)

        if (skinSuffix.isEmpty() || defaultResName.isEmpty()) return defaultResName

        return "${defaultResName}_${skinSuffix}"
    }

    /**
     * 设置 Resources
     *
     * @param resources Resources
     */
    fun setResources(resources: Resources) {
        this.mResources = resources
    }

    /**
     * 获取 Resources
     */
    fun getResources() = mResources

}