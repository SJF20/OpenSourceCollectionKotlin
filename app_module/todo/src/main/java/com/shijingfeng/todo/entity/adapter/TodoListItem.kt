package com.shijingfeng.todo.entity.adapter

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.todo.constant.STATUS_NEED_TO_DO
import com.shijingfeng.todo.constant.STATUS_DONE

/**
 * Function: 主页 -> 待办 分组后的 实体类 Item
 * Date: 2020/9/11 22:11
 * Description:
 * Author: ShiJingFeng
 */
internal data class TodoListItem(

    @SerializedName("id")
    var identity: String = "",

    @SerializedName("userId")
    var userId: String = "",

    /** 标题 */
    @SerializedName("title")
    var title: String = "",

    /** 内容 */
    @SerializedName("content")
    var content: String = "",

    /** 完成日期 (完成之后才会有，否则为空) */
    @SerializedName("completeDate")
    var completeDate: Long? = 0L,

    /** 完成日期字符串 (完成之后才会有，否则为空字符串) */
    @SerializedName("completeDateStr")
    var completeDateStr: String = "",

    /** 待办日期 */
    @SerializedName("date")
    var date: Long = 0L,

    /** 待办日期字符串 */
    @SerializedName("dateStr")
    var dateStr: String = "",

    /** 状态 */
    @SerializedName("status")
    var status: Int = 0,

    /** 优先级 */
    @SerializedName("priority")
    var priority: Int = 0,

    /** 类型 */
    @SerializedName("type")
    var todoType: Int = 0,

    /** 是否选中  true: 选中  false: 没有选中 */
    var selected: Boolean = false

) : BaseEntity() {

    /**
     * 获取类型 [STATUS_NEED_TO_DO] [STATUS_DONE]
     */
    fun getType() = status

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity
    }
}