package com.shijingfeng.base.util.image_load

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.shijingfeng.base.R
import com.shijingfeng.base.annotation.define.GlideOutputType
import com.shijingfeng.base.listener.Target

/** 图片加载器 实例 (可以随时切换加载框架) */
val INSTANCE = GlideImageLoader()

/**
 * 获取实例
 * @return 实例
 */
fun getImageLoaderInstance() = INSTANCE

/**
 * Function: 图片加载器
 * Date: 2020/1/23 21:16
 * Description: (用于屏蔽具体图片加载框架)
 * Author: ShiJingFeng
 */
abstract class ImageLoader {

    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param outputType 输出源类型
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    abstract fun displayImage(
        context: Context,
        imageView: ImageView,
        imagePath: String?,
        @GlideOutputType outputType: Int = AS_DRAWABLE,
        @DrawableRes placeholder: Int = R.drawable.ic_image,
        @DrawableRes error: Int = R.drawable.ic_image
    )

    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param drawableRes 本地图片资源 ID
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    abstract fun displayImage(
        context: Context,
        imageView: ImageView,
        @DrawableRes drawableRes: Int,
        @DrawableRes placeholder: Int = R.drawable.ic_image,
        @DrawableRes error: Int = R.drawable.ic_image
    )

    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param bitmap Bitmap
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    abstract fun displayImage(
        context: Context,
        imageView: ImageView,
        bitmap: Bitmap?,
        @DrawableRes placeholder: Int = R.drawable.ic_image,
        @DrawableRes error: Int = R.drawable.ic_image
    )

    /**
     * 显示图片
     * @param context Context
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    abstract fun <T> displayImage(
        context: Context,
        imagePath: String,
        @GlideOutputType outputType: Int = AS_DRAWABLE,
        target: Target<T>
    )

    /**
     * 显示视频缩略图
     * @param context Context
     * @param imageView ImageView
     * @param videoFilePath 视频文件路径 (本地路径 或 网络路径)
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    abstract fun displayVideoThumb(
        context: Context,
        imageView: ImageView,
        videoFilePath: String,
        @DrawableRes placeholder: Int = R.drawable.ic_image,
        @DrawableRes error: Int = R.drawable.ic_image
    )

    /**
     * 显示视频缩略图
     * @param context Context
     * @param videoFilePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    abstract fun displayVideoThumb(
        context: Context,
        videoFilePath: String,
        target: Target<Drawable>
    )

}