package com.shijingfeng.base.util.image_load

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory
import com.bumptech.glide.module.AppGlideModule
import com.shijingfeng.base.common.constant.PERSONAL_GLIDE_CACHE_DIR
import java.io.File

/** 缓存空间大小 */
private const val DISK_CACHE_SIZE_BYTES: Long = 1024L * 1024L * 500L

/**
 * Function: 自定义 Glide
 * Date: 2020/1/23 21:03
 * Description:
 * @author ShiJingFeng
 */
@GlideModule
class CustomGlide : AppGlideModule() {

    /**
     * 应用配置
     * @param context Context
     * @param builder GlideBuilder
     */
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        //设置 Glide 硬盘缓存路径和大小
        builder.setDiskCache(DiskLruCacheFactory({
            File(PERSONAL_GLIDE_CACHE_DIR)
        }, DISK_CACHE_SIZE_BYTES))
    }
}