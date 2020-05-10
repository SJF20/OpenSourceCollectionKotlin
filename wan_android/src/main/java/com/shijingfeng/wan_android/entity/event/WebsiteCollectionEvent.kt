package com.shijingfeng.wan_android.entity.event

import com.shijingfeng.base.common.constant.*
import com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity

/**
 * Function: 网站收藏相关 Event
 * Date: 2020/2/3 19:56
 * Description:
 * @author ShiJingFeng
 */
internal data class WebsiteCollectionEvent(

    /** 发出 Event 的类的名称 (注意：是全限定类名称) */
    var fromName: String,

    /** 操作类型 [NONE] 无操作 [ADD] 收藏 [REMOVE] 取消收藏 [UPDATE] 更新收藏 */
    var type: Int,

    /** 网站 id (用于 取消收藏 使用) */
    var id: String? = null,

    /** 网站收藏 实体类 (用于 添加收藏, 更新收藏 使用) */
    var personalCollectionWebsite: PersonalCollectionWebsiteEntity? = null

)