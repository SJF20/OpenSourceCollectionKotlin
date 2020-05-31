package com.shijingfeng.wan_android.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 主题颜色 实体类
 * Date: 2020/5/31 11:19
 * Description:
 * @author ShiJingFeng
 */
internal data class ThemeColorItem(
    // RGB颜色值 例如: #FFFFFF
    val rgbColor: String = "#00000000",
    // 是否被选择
    var isSelected: Boolean = false
) : BaseEntity()