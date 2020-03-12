package com.shijingfeng.base.util.image_load

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.shijingfeng.base.R
import com.shijingfeng.base.base.application.BaseApplication
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
 * @author ShiJingFeng
 */
abstract class ImageLoader {

    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    abstract fun displayImage(
        context: Context,
        imageView: ImageView,
        imagePath: String,
        @DrawableRes placeholder: Int = 0,
        @DrawableRes error: Int = 0
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
        @DrawableRes placeholder: Int = 0,
        @DrawableRes error: Int = 0
    )

    /**
     * 显示图片
     * @param context Context
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    abstract fun displayImage(
        context: Context,
        imagePath: String,
        target: Target<Drawable?>
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
        @DrawableRes placeholder: Int = 0,
        @DrawableRes error: Int = 0
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
        target: Target<Drawable?>
    )

}