package com.shijingfeng.todo.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 主页 -> 待办 实体类
 * Date: 2020/5/19 21:24
 * Description:
 * @author ShiJingFeng
 */

/**
 * 主页 -> 待办 实体类
 */
internal data class MainTodo (

    /** 此页开始的下标  */
    @SerializedName("offset")
    var offset: Int = 0,

    /**  */
    @SerializedName("over")
    var over: Boolean = false,

    /** 当前页面的页码 (-1 代表从本地获取的 全部 Item)  */
    @SerializedName("curPage")
    var curPage: Int = -1,

    /** 页面的数量  */
    @SerializedName("pageCount")
    var pageCount: Int = 1,

    /** 当前页的Item数量  */
    @SerializedName("size")
    var size: Int = 0,

    /** Item总数  */
    @SerializedName("total")
    var total: Int = 0,

    @SerializedName("datas")
    var todoItemList: MutableList<MainTodoGroupItem> = ArrayList()

) : BaseEntity()

/**
 * 主页 -> 待办 分组后的 实体类 Item
 */
internal data class MainTodoGroupItem(

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

    /** 完成日期 */
    @SerializedName("completeDate")
    var completeDate: Long = 0L,

    /** 完成日期字符串 */
    @SerializedName("completeDateStr")
    var completeDateStr: String = "",

    /** 日期 */
    @SerializedName("date")
    var date: Long = 0L,

    /** 日期字符串 */
    @SerializedName("dateStr")
    var dateStr: String = "",

    /** 状态 */
    @SerializedName("status")
    var status: Int = 0,

    /** 优先级 */
    @SerializedName("id")
    var priority: Int = 0,

    /** 类型 */
    @SerializedName("type")
    var todoType: Int = 0

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity
    }
}