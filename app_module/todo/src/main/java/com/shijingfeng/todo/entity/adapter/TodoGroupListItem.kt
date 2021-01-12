package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function: 主页 -> 待办 实体类
 * Date: 2020/5/21 15:02
 * Description:
 * Author: ShiJingFeng
 */
internal class TodoGroupListItem(

    /** 唯一ID (以天为单位的毫秒值, 注意: 并不是精确到毫秒的时间戳) */
    var identity: Long = 0L,
    /** 该组是否选中  true: 选中  false: 没有选中 */
    var selected: Boolean = false,
    /** 待办日期字符串 */
    var dateStr: String = "",
    /** 分组下的列表 */
    var todoItemList: MutableList<TodoListItem> = mutableListOf()

) : BaseEntity() {

    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return identity.toString()
    }

}