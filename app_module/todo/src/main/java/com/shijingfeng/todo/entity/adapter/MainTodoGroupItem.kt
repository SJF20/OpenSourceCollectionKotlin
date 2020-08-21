package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.todo.entity.MainTodoItem

/**
 * Function: 主页 -> 待办 实体类
 * Date: 2020/5/21 15:02
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoGroupItem(

    /** 唯一ID (以天为单位的毫秒值) */
    val identity: Long = 0L,
    /** 日期 */
    var date: String = "",
    /** 分组下的列表 */
    var todoItemList: MutableList<MainTodoItem> = mutableListOf()

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity.toString()
    }

}