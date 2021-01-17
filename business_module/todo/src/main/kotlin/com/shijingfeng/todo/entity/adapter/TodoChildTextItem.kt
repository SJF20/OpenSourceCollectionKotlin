package com.shijingfeng.todo.entity.adapter

/**
 * Function: 文本 Item
 * Date: 2020/9/17 17:28
 * Description:
 * Author: ShiJingFeng
 */
internal data class TodoChildTextItem(

    /** 文本 */
    val text: CharSequence

) : TodoChildItem()