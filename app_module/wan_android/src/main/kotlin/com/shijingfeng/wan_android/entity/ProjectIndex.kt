package com.shijingfeng.wan_android.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 项目 索引数据 实体类
 * Date: 20-4-29 下午8:43
 * Description:
 * Author: shijingfeng
 */
internal data class ProjectIndexEntity(

    @SerializedName("courseId")
    var courseId: String = "",

    @SerializedName("id")
    var identity: String = "",

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
    var children: List<ProjectIndexChildren> = mutableListOf()

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
 * 项目 索引数据 Children 实体类
 */
internal class ProjectIndexChildren : BaseEntity()