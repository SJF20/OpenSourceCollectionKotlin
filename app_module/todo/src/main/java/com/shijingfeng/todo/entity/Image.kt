package com.shijingfeng.todo.entity

import android.graphics.Bitmap

/**
 * Function: 图片实体类
 * Date: 2020/9/17 20:35
 * Description:
 * @author ShiJingFeng
 */
internal class Image(
    /** 图片类型 */
    var imageType: Int = IMAGE_TYPE_NONE,
    /** 网络图片 URL地址 */
    var imageUrl: String? = null,
    /** 本地存储图片文件路径 */
    var imageFilePath: String? = null,
    /** 内存中图片Bitmap */
    var imageBitmap: Bitmap? = null,
) : Media() {

    companion object {
        /** 未知图片类型 */
        const val IMAGE_TYPE_NONE = 0
        /** 网络图片类型 */
        const val IMAGE_TYPE_NETWORK = 1
        /** 本地存储图片类型 */
        const val IMAGE_TYPE_DISK = 2
        /** 内存中图片类型 */
        const val IMAGE_TYPE_MEMORY = 3
    }

}