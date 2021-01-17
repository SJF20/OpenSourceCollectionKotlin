package com.shijingfeng.wan_android.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 搜索页面 -> 搜索历史 实体类
 * Date: 2020/5/5 17:28
 * Description:
 * Author: ShiJingFeng
 */
internal data class SearchHistoryItem(

    /** 搜索关键词 */
    var name: String = ""

) : BaseEntity()