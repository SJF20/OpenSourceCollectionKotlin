/** 生成的 Java 类名 */
@file:JvmName("SkinChangerUtil")
package com.shijingfeng.skin_changer.util

import android.view.View
import com.shijingfeng.skin_changer.R
import com.shijingfeng.skin_changer.entity.SkinAttribute
import com.shijingfeng.skin_changer.global.toJsonString

/**
 * Function:
 * Date: 2020/9/8 17:36
 * Description:
 * @author ShiJingFeng
 */

/**
 * 设置资源
 */
fun setResource(view: View, skinAttributeList: List<SkinAttribute>) {
    view.setTag(R.id.skin_changer_tag_id, skinAttributeList.toJsonString())
}

/**
 * 设置资源
 */
fun setResource(resourceMap: Map<View, List<SkinAttribute>>) {
    resourceMap.forEach { entry ->
        val view = entry.key
        val value = entry.value

        view.setTag(R.id.skin_changer_tag_id, value.toJsonString())
    }
}