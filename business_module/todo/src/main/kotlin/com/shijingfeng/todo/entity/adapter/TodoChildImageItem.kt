package com.shijingfeng.todo.entity.adapter

import com.shijingfeng.todo.entity.Image

/**
 * Function: 图片 Item
 * Date: 2020/9/17 20:33
 * Description:
 * Author: ShiJingFeng
 */
internal class TodoChildImageItem(

    /** 图片列表 */
    var imageList: MutableList<Image> = mutableListOf()

) : TodoChildItem()