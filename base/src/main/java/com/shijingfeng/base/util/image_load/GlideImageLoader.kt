package com.shijingfeng.base.util.image_load

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.shijingfeng.base.listener.Target

/**
 * Function: Glide 图片加载器
 * Date: 2020/1/23 21:36
 * Description:
 * @author ShiJingFeng
 */
class GlideImageLoader : ImageLoader() {

    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    override fun displayImage(
        context: Context,
        imageView: ImageView,
        imagePath: String,
        @DrawableRes placeholder: Int,
        @DrawableRes error: Int
    ) {
        Glide.with(context)
            .load(imagePath)
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .into(imageView)
    }

    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param drawableRes 本地图片资源 ID
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    override fun displayImage(
        context: Context,
        imageView: ImageView,
        drawableRes: Int,
        placeholder: Int,
        error: Int
    ) {
        Glide.with(context)
            .load(drawableRes)
            .placeholder(placeholder)
            .error(error)
            .dontAnimate()
            .into(imageView)
    }

    /**
     * 显示图片
     * @param context Context
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    override fun displayImage(
        context: Context,
        imagePath: String,
        target: Target<Drawable?>
    ) {
        Glide.with(context)
            .load(imagePath)
            .dontAnimate()
            .into(object : CustomTarget<Drawable>() {

                override fun onLoadStarted(placeholder: Drawable?) {
                    super.onLoadStarted(placeholder)
                    target.onLoadStarted(placeholder)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    target.onLoadFailed(errorDrawable)
                }

                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    target.onLoadFinished(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    target.onLoadFailed(placeholder)
                }
            })
    }

    /**
     * 显示视频缩略图
     * @param context Context
     * @param imageView ImageView
     * @param videoFilePath 视频文件路径 (本地路径 或 网络路径)
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    override fun displayVideoThumb(
        context: Context,
        imageView: ImageView,
        videoFilePath: String,
        placeholder: Int,
        error: Int
    ) {
        Glide.with(context)
            .load(videoFilePath)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .placeholder(placeholder)
            .error(error)
            .into(imageView)
    }

    /**
     * 显示视频缩略图
     * @param context Context
     * @param videoFilePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    override fun displayVideoThumb(
        context: Context,
        videoFilePath: String,
        target: Target<Drawable?>
    ) {
        Glide.with(context)
            .load(videoFilePath)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .centerCrop()
            .into(object : CustomTarget<Drawable>() {

                override fun onLoadStarted(placeholder: Drawable?) {
                    super.onLoadStarted(placeholder)
                    target.onLoadStarted(placeholder)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    target.onLoadFailed(errorDrawable)
                }

                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    target.onLoadFinished(resource)
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    target.onLoadFailed(placeholder)
                }

            })
    }
}