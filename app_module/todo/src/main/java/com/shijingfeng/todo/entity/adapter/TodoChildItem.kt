package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.todo.annotation.define.TodoChildType
import com.shijingfeng.todo.annotation.define.TodoChildType.*

/**
 * Function: TodoChild实体类 抽象基类
 * Date: 2020/9/17 17:27
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class TodoChildItem : BaseEntity() {

    /**
     * 获取类型
     */
    @TodoChildType
    fun getType() = when (this) {
        // 文本类型
        is TodoChildTextItem -> ITEM_TYPE_TEXT
        // 图片类型
        is TodoChildImageItem -> ITEM_TYPE_IMAGE
        // 未知类型
        else -> ITEM_TYPE_UNKNOWN
    }

}