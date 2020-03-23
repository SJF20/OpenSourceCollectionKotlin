package com.shijingfeng.wan_android.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import java.util.*

/**
 * Function: 知识体系 实体类 集合
 * Date: 2020/2/4 11:33
 * Description:
 * @author ShiJingFeng
 */

/**
 * 知识体系 实体类
 */
internal data class KnowledgeClassifyEntity(

    @SerializedName("id")
    var identity: String = "",

    @SerializedName("name")
    var name: String = "",

    @SerializedName("courseId")
    var courseId: String = "",

    @SerializedName("parentChapterId")
    var parentChapterId: String = "",

    @SerializedName("order")
    var order: Int = 0,

    @SerializedName("visible")
    var visible: Int = 0,

    @SerializedName("userControlSetTop")
    var userControlSetTop: Boolean = false,

    @SerializedName("children")
    var childrenList: List<KnowledgeClassifyChildren> = ArrayList()

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
 * 知识体系 第二级数据 实体类
 */
internal data class KnowledgeClassifyChildren(

    @SerializedName("id")
    var identity: String = "",

    @SerializedName("name")
    var name: String = "",

    @SerializedName("courseId")
    var courseId: String = "",

    @SerializedName("parentChapterId")
    var parentChapterId: String = "",

    @SerializedName("order")
    var order: Int = 0,

    @SerializedName("visible")
    var visible: Int = 0,

    @SerializedName("userControlSetTop")
    var userControlSetTop: Boolean = false,

    @SerializedName("children")
    var grandchildren: List<KnowledgeClassifyGrandchildren> = ArrayList()

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
 * 知识体系 第三级数据 实体类
 */
internal class KnowledgeClassifyGrandchildren : BaseEntity()