package com.shijingfeng.base.entity.event

/**
 * Function: 下载 Event
 * Author: ShiJingFeng
 * Date: 2019/11/24 22:27
 * Description: @JvmOverloads注解用于生成多个重载函数的java文件
 */
data class DownloadEvent @JvmOverloads constructor(

    /** 当前文件下载的大小  */
    var currentLength: Long,
    /** 总文件大小  */
    var totalLength: Long,
    /** 是否下载完成  */
    var done: Boolean = false,
    /** 用于多任务时的标记  */
    var tag: String? = null

)
