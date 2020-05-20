package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.base.common.constant.ADAPTER_TYPE_UNKNOWN
import com.shijingfeng.todo.entity.TodoItem

/** 主页 -> 待办 分组后的 标题Item */
const val MAIN_TODO_GROUP_TITLE_ITEM = 0
/** 主页 -> 待办 分组后的 普通Item */
const val MAIN_TODO_GROUP_ITEM = 1

/**
 * Function: 主页 -> 待办 适配器 实体抽象父类
 * Date: 2020/5/19 22:47
 * Description:
 * @author ShiJingFeng
 */
abstract class TodoGroupItem : BaseEntity() {

    /**
     * 获取类型
     * @return 类型
     */
    fun getType() = when (this) {
        // 分组后的 标题Item
        is TodoGroupTitleItem -> MAIN_TODO_GROUP_TITLE_ITEM
        // 分组后的 普通Item
        is TodoItem -> MAIN_TODO_GROUP_ITEM
        else -> ADAPTER_TYPE_UNKNOWN
    }

}