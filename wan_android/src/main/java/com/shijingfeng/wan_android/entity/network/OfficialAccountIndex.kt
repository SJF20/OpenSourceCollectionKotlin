package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 公众号 索引数据 实体类
 * Date: 2020/4/29 17:01
 * Description:
 * @author ShiJingFeng
 */
internal data class OfficialAccountIndexEntity(

    @SerializedName("id")
    var identity: String = "",

    @SerializedName("courseId")
    var courseId: String = "",

    @SerializedName("name")
    var name: String = "",

    @SerializedName("order")
    var order: Int = 0,

    @SerializedName("parentChapterId")
    var parentChapterId: String = "",

    @SerializedName("userControlSetTop")
    var userControlSetTop: Boolean = false,

    @SerializedName("visible")
    var visible: Int = 0,

    @SerializedName("children")
    var children: List<OfficialAccountIndexChildren> = mutableListOf()

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity
    }

}

/**
 * 公众号 索引数据 Children 实体类
 */
internal class OfficialAccountIndexChildren : BaseEntity()