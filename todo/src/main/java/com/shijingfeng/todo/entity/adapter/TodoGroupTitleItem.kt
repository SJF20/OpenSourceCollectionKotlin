package com.shijingfeng.todo.entity.adapter

/**
 * Function: 主页 -> 待办 适配器分组标题 实体类
 * Date: 2020/5/19 22:49
 * Description:
 * @author ShiJingFeng
 */
internal data class TodoGroupTitleItem(

    /** 日期时间 */
    var dateTime: String = ""

) : TodoGroupItem()