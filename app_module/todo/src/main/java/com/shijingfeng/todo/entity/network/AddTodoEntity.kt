package com.shijingfeng.todo.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 添加 待办事项 实体类
 * Date: 2020/9/17 10:39
 * Description:
 * @author ShiJingFeng
 */
internal data class AddTodoEntity(

    @SerializedName("completeDate")
    var completeDate: Long,

    @SerializedName("completeDateStr")
    var completeDateStr: String,

    @SerializedName("content")
    var content: String,

    @SerializedName("date")
    var date: Long,

    @SerializedName("dateStr")
    var dateStr: String,

    @SerializedName("id")
    var id: Int,

    @SerializedName("priority")
    var priority: Int,

    @SerializedName("status")
    var status: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("type")
    var type: Int,

    @SerializedName("userId")
    var userId: Int

) : BaseEntity()