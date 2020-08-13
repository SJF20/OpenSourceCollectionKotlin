package com.shijingfeng.base.entity.event.event_bus

/**
 * Function: 上传 Event
 * Author: ShiJingFeng
 * Date: 2019/11/24 22:27
 * Description: @JvmOverloads注解用于生成多个重载函数的java文件
 */
// TODO 需要指定一个唯一标志，否则采用回调监听的方式
data class UploadEvent @JvmOverloads constructor(

    /** 当前文件上传的大小  */
    var currentLength: Long,
    /** 总文件大小  */
    var totalLength: Long,
    /** 是否上传完成  */
    var done: Boolean = false,
    /** 用于多任务时的标记  */
    var tag: String? = null

)
