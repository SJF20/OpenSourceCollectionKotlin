package com.shijingfeng.base.util.image_load

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.shijingfeng.base.annotation.define.GlideOutputType
import com.shijingfeng.base.listener.Target
import com.shijingfeng.base.util.cast

/** Glide输出源: Drawable */
const val AS_DRAWABLE = 1
/** Glide输出源: Bitmap */
const val AS_BITMAP = 2
/** Glide输出源: Gif */
const val AS_GIF = 3
/** Glide输出源: File */
const val AS_FILE = 4

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
     * @param outputType Glide输出源类型
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    override fun displayImage(
        context: Context,
        imageView: ImageView,
        imagePath: String?,
        @GlideOutputType outputType: Int,
        @DrawableRes placeholder: Int,
        @DrawableRes error: Int
    ) {
        val requestManager = Glide.with(context)
        val requestBuilder = when (outputType) {
            AS_DRAWABLE -> requestManager.asDrawable()
            AS_BITMAP -> requestManager.asBitmap()
            AS_GIF -> requestManager.asGif()
            AS_FILE -> requestManager.asFile()
            else -> requestManager.asDrawable()
        }

        requestBuilder
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
        @DrawableRes drawableRes: Int,
        @DrawableRes placeholder: Int,
        @DrawableRes error: Int
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
     * @param imageView ImageView控件
     * @param bitmap Bitmap
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    override fun displayImage(
        context: Context,
        imageView: ImageView,
        bitmap: Bitmap?,
        placeholder: Int,
        error: Int
    ) {
        Glide.with(context)
            .load(bitmap)
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
    override fun <T> displayImage(
        context: Context,
        imagePath: String,
        @GlideOutputType outputType: Int,
        target: Target<T>
    ) {
//        val requestManager = Glide.with(context)
//
//        when (outputType) {
//            AS_DRAWABLE -> requestManager
//                .asDrawable()
//                .load(imagePath)
//                .dontAnimate()
//                .into(object : CustomTarget<Drawable>() {
//                    override fun onLoadStarted(placeholder: Drawable?) {
//                        super.onLoadStarted(placeholder)
//                        target.onLoadStarted(placeholder)
//                    }
//
//                    override fun onLoadFailed(errorDrawable: Drawable?) {
//                        super.onLoadFailed(errorDrawable)
//                        target.onLoadFailed(errorDrawable)
//                    }
//
//                    override fun onResourceReady(
//                        resource: Drawable,
//                        transition: Transition<in Drawable>?
//                    ) {
//                        target.onLoadFinished(CastUtil.cast(resource))
//                    }
//
//                    override fun onLoadCleared(placeholder: Drawable?) {
//                        target.onLoadFailed(placeholder)
//                    }
//                })
//            AS_BITMAP -> CastUtil.cast(requestManager.asBitmap())
//            AS_GIF -> CastUtil.cast(requestManager.asGif())
//            AS_FILE -> CastUtil.cast(requestManager.asFile())
//            else -> CastUtil.cast(requestManager.asDrawable())
//        }

        val requestManager = Glide.with(context)

        val requestBuilder: RequestBuilder<Any> = when (outputType) {
            AS_DRAWABLE -> cast(requestManager.asDrawable())
            AS_BITMAP -> cast(requestManager.asBitmap())
            AS_GIF -> cast(requestManager.asGif())
            AS_FILE -> cast(requestManager.asFile())
            else -> cast(requestManager.asDrawable())
        }

        requestBuilder
            .load(imagePath)
            .dontAnimate()
            .into(object : CustomTarget<Any>() {

                override fun onLoadStarted(placeholder: Drawable?) {
                    super.onLoadStarted(placeholder)
                    target.onLoadStarted(placeholder)
                }

                override fun onLoadFailed(errorDrawable: Drawable?) {
                    super.onLoadFailed(errorDrawable)
                    target.onLoadFailed(errorDrawable)
                }

                override fun onResourceReady(
                    resource: Any,
                    transition: Transition<in Any>?
                ) {
                    target.onLoadFinished(cast(resource))
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
        target: Target<Drawable>
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