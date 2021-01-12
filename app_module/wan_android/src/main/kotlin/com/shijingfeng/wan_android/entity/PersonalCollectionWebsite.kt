package com.shijingfeng.wan_android.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 我的收藏 -> 网站收藏列表 实体类
 * Date: 2020/3/25 22:37
 * Description:
 * Author: ShiJingFeng
 */
internal data class PersonalCollectionWebsiteEntity(

    /** 收藏的网站 ID */
    @SerializedName("id")
    var identity: String = "",

    /** 用户 ID */
    @SerializedName("userId")
    var userId: String = "",

    /** 网站名称 */
    @SerializedName("name")
    var name: String = "",

    /** 网站链接 */
    @SerializedName("link")
    var link: String = "",

    /** 网站描述 */
    @SerializedName("desc")
    var desc: String = "",

    /** 网站图标 */
    @SerializedName("icon")
    var icon: String = "",

    @SerializedName("order")
    var order: Int = 0,

    @SerializedName("visible")
    var visible: Int = 1

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId() = identity

}