package com.shijingfeng.skin_changer.entity

import com.shijingfeng.skin_changer.constant.BACK_GROUND
import com.shijingfeng.skin_changer.constant.TEXT_COLOR
import com.shijingfeng.skin_changer.constant.TINT

/**
 * Function: 对应 xml 中的 属性
 * Date: 2020/7/22 13:28
 * Description:
 * Author: ShiJingFeng
 */
data class SkinAttribute(

    /** 属性名 (例如: [BACK_GROUND] [TEXT_COLOR] [TINT]) */
    val name: String,
    /** 资源名字符串 (例如: wan_android_theme_color) */
    val data: String

)