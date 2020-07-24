package com.shijingfeng.skin_changer.processor

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.AnyThread
import androidx.annotation.ColorInt
import androidx.core.view.forEach
import com.shijingfeng.skin_changer.R
import com.shijingfeng.skin_changer.constant.*
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.skin_changer.entity.SkinElement
import com.shijingfeng.skin_changer.global.runOnUiThread
import com.shijingfeng.skin_changer.listener.ExecuteListener
import com.shijingfeng.skin_changer.listener.ParseListener
import com.shijingfeng.skin_changer.manager.ResourcesManager
import org.json.JSONObject

/**
 * Function: 处理器
 * Date: 2020/7/22 13:40
 * Description:
 * @author ShiJingFeng
 */
internal class Processor(
    /** 主题渠道 */
    private val mSkinChannel: String,
    /** 资源管理器 */
    private val mResourcesManager: ResourcesManager,
    /** 解析监听器 */
    private val mParseListener: ParseListener? = null,
    /** 主题切换执行监听器 */
    private val mExecuteListener: ExecuteListener? = null
) {

    /**
     * 开始处理
     */
    @AnyThread
    fun process(activity: Activity): List<SkinElement> {
        val skinElementList = mutableListOf<SkinElement>()
        val content = activity.findViewById<View>(android.R.id.content)

        recursionAddSkinView(content, skinElementList)
        return skinElementList
    }

    /**
     * 递归遍历 添加 SkinElement
     */
    fun recursionAddSkinView(
        view: View,
        skinElementList: MutableList<SkinElement>
    ) {
        val skinElement = getSkinElement(view)

        if (skinElement != null) {
            skinElementList.add(skinElement)
        }
        if (view is ViewGroup) {
            view.forEach { child ->
                recursionAddSkinView(child, skinElementList)
            }
        }
    }

    /**
     * 获取 View 中的 SkinElement
     *
     * @param view 指定的View
     * @return SkinElement
     */
    private fun getSkinElement(view: View): SkinElement? {
        val tag = view.getTag(R.id.skin_changer_tag_id) ?: view.tag ?: null

        if (tag == null || tag !is String) {
            return null
        }

        val skinAttributeList = parseTag(view, tag)

        if (skinAttributeList.isNotEmpty()) {
            changeTag(view)
            return SkinElement(view, skinAttributeList)
        }
        return null
    }

    /**
     * 解析标签
     *
     * @param view View
     * @param tag 标签
     * @return 解析后的数据
     */
    private fun parseTag(view: View, tag: String): List<SkinAttribute> {
        val skinAttributeList = mutableListOf<SkinAttribute>()

        if (tag.isEmpty()) return skinAttributeList

        try {
            val jsonObject = JSONObject(tag)

            jsonObject.keys().forEach { key ->
                val parseResult = mParseListener?.onParse(
                    view = view,
                    name = key
                )
                val skinAttribute = if (parseResult != null) {
                    SkinAttribute(
                        name = key,
                        data = parseResult
                    )
                } else {
                    SkinAttribute(
                        name = key,
                        data = jsonObject.getString(key)
                    )
                }
                val executeResult = mExecuteListener?.onExecute(
                    view = view,
                    skinAttribute = skinAttribute
                ) ?: false

                if (!executeResult) {
                    //用户没有自定义处理，交由框架处理
                    runOnUiThread {
                        execute(view, skinAttribute)
                    }
                }
                skinAttributeList.add(skinAttribute)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            return skinAttributeList
        }
    }

    /**
     * 改变Tag
     */
    private fun changeTag(view: View) {
        if (view.getTag(R.id.skin_changer_tag_id) == null) {
            view.setTag(R.id.skin_changer_tag_id, view.tag)
            view.tag = null
        }
    }

    /**
     * 执行主题切换
     */
    private fun execute(
        view: View,
        skinAttribute: SkinAttribute
    ) {
        val name = skinAttribute.name
        val data = skinAttribute.data as String

        if (name.isEmpty() || data.isEmpty()) return

        when (name) {
            // 背景
            BACK_GROUND -> {
                val drawable = mResourcesManager.getRealDrawableByResName(data)

                if (drawable != null) {
                    view.background = drawable
                } else {
                    @ColorInt val color = mResourcesManager.getRealColor(data)

                    if (color != RESOURCE_NONE) {
                        view.setBackgroundColor(color)
                    }
                }
            }
            // 背景 Tint
            BACK_GROUND_TINT -> {
                val colorStateList = mResourcesManager.getRealColorStateList(data) ?: return

                view.backgroundTintList = colorStateList
            }
            // 文本颜色
            TEXT_COLOR -> {
                if (view is TextView) {
                    val colorStateList = mResourcesManager.getRealColorStateList(data) ?: return

                    view.setTextColor(colorStateList)
                }
            }
            // ImageView 图片
            SRC -> {
                if (view is ImageView) {
                    val drawable = mResourcesManager.getRealDrawableByResName(data) ?: return

                    view.setImageDrawable(drawable)
                }
            }
            // ImageView Tint
            TINT -> {
                if (view is ImageView) {
                    val colorStateList = mResourcesManager.getRealColorStateList(data) ?: return

                    view.imageTintList = colorStateList
                }
            }
            // CompoundButton (CheckBox, RadioButton 等) 图片
            BUTTON_DRAWABLE -> {
                if (view is CompoundButton) {
                    val drawable = mResourcesManager.getRealDrawableByResName(data) ?: return

                    view.buttonDrawable = drawable
                }
            }
            else -> {}
        }

    }

}

