package com.shijingfeng.wan_android.entity.event

/**
 * Function: 文章收藏相关 Event
 * Date: 2020/2/3 19:56
 * Description:
 * Author: ShiJingFeng
 */
internal data class ArticleCollectionEvent(

    /** 发出 Event 的类的名称 (注意：是全限定类名称) */
    var fromName: String,

    /** 文章 id */
    var id: String,

    /** 是否收藏  true 收藏  false 取消收藏 */
    var collected: Boolean

)