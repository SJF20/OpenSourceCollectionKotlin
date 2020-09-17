package com.shijingfeng.todo.entity.network

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.todo.entity.adapter.TodoItem

/**
 * Function: 主页 -> 待办 实体类
 * Date: 2020/5/19 21:24
 * Description:
 * @author ShiJingFeng
 */

/**
 * 主页 -> 待办 实体类
 */
internal data class TodoEntity (

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
    var todoItemList: List<TodoItem> = ArrayList()

) : BaseEntity()