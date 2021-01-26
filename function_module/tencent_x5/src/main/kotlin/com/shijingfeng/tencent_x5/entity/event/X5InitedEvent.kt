package com.shijingfeng.tencent_x5.entity.event

/**
 * Function: 腾讯X5内核初始化完成 Event
 * Author: ShiJingFeng
 * Date: 2019/12/24 11:47
 * Description: @JvmOverloads注解用于生成多个重载函数的java文件
 */
data class X5InitedEvent @JvmOverloads constructor(

    var success: Boolean = true

)
