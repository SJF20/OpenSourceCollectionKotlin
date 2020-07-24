package com.shijingfeng.skin_changer.entity

import android.view.View

/**
 * Function: 对应 xml 中的 元素
 * Date: 2020/7/22 13:37
 * Description:
 * @author ShiJingFeng
 */
data class SkinElement(
    /** View */
    val view: View,
    /** 一个 View 对应的多个 属性 */
    val attributeList: List<SkinAttribute>
)