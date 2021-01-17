package com.shijingfeng.todo.entity

/**
 * Function:
 * Date: 2020/9/17 20:58
 * Description:
 * Author: ShiJingFeng
 */
internal class Video(

) : Media() {

    companion object {

        /** 未知视频类型 */
        const val VIDEO_TYPE_NONE = 0
        /** 网络视频类型 */
        const val VIDEO_TYPE_NETWORK = 1
        /** 本地存储视频类型 */
        const val VIDEO_TYPE_DISK = 2
        /** 内存中视频类型 */
        const val VIDEO_TYPE_MEMORY = 3

    }

}