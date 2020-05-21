package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.todo.entity.MainTodoGroupItem

/**
 * Function: 主页 -> 待办 实体类
 * Date: 2020/5/21 15:02
 * Description:
 * @author ShiJingFeng
 */
internal class MainTodoItem(

    /** 唯一ID */
    val identity: Long = 0L,
    /** 日期 */
    var date: String = "",
    /** 分组下的列表 */
    var todoItemList: MutableList<MainTodoGroupItem> = mutableListOf()

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity.toString()
    }

}