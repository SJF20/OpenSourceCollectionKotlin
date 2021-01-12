package com.shijingfeng.wan_android.entity.adapter

import androidx.annotation.ColorInt
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 主题颜色 实体类
 * Date: 2020/5/31 11:19
 * Description:
 * Author: ShiJingFeng
 */
internal data class ThemeColorItem(
    // 颜色值
    @ColorInt val color: Int = 0,
    // 是否被选择
    var isSelected: Boolean = false
) : BaseEntity()