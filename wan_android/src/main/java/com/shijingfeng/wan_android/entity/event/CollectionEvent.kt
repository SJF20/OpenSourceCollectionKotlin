package com.shijingfeng.wan_android.entity.event

/**
 * Function: 收藏相关 Event
 * Date: 2020/2/3 19:56
 * Description:
 * @author ShiJingFeng
 */
data class CollectionEvent(

    /** 文章 或 网址 id */
    var id: String,

    /** 是否收藏  true 收藏  false 取消收藏 */
    var collected: Boolean

)