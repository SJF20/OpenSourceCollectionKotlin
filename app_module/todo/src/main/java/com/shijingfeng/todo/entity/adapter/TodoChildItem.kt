package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.base.base.entity.BaseEntity

/**
 * Function:
 * Date: 2020/9/17 17:27
 * Description:
 * @author ShiJingFeng
 */
internal abstract class TodoChildItem : BaseEntity() {

    companion object {

        /** Item类型: 未知 */
        const val ITEM_TYPE_UNKNOWN = 0
        /** Item类型: 文本 */
        const val ITEM_TYPE_TEXT = 1
        /** Item类型: 图片 */
        const val ITEM_TYPE_IMAGE = 2

    }

    /**
     * 获取类型
     */
    fun getType() = when (this) {
        // 文本类型
        is TodoChildTextItem -> ITEM_TYPE_TEXT
        // 图片类型
        is TodoChildImageItem -> ITEM_TYPE_IMAGE
        // 未知类型
        else -> ITEM_TYPE_UNKNOWN
    }

}