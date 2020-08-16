package com.shijingfeng.base.util.image_load;

import java.lang.System;

/**
 * Function: 图片加载器
 * Date: 2020/1/23 21:16
 * Description: (用于屏蔽具体图片加载框架)
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\nH&J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\nH&J6\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012H&J4\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0003\u0010\u000b\u001a\u00020\n2\b\b\u0003\u0010\f\u001a\u00020\nH&J&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012H&\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/base/util/image_load/ImageLoader;", "", "()V", "displayImage", "", "context", "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "drawableRes", "", "placeholder", "error", "imagePath", "", "outputType", "T", "target", "Lcom/shijingfeng/base/listener/Target;", "displayVideoThumb", "videoFilePath", "Landroid/graphics/drawable/Drawable;", "base_release"})
public abstract class ImageLoader {
    
    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param outputType 输出源类型
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    public abstract void displayImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @com.shijingfeng.base.annotation.define.GlideOutputType()
    int outputType, @androidx.annotation.DrawableRes()
    int placeholder, @androidx.annotation.DrawableRes()
    int error);
    
    /**
     * 显示图片
     * @param context Context
     * @param imageView ImageView控件
     * @param drawableRes 本地图片资源 ID
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    public abstract void displayImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @androidx.annotation.DrawableRes()
    int drawableRes, @androidx.annotation.DrawableRes()
    int placeholder, @androidx.annotation.DrawableRes()
    int error);
    
    /**
     * 显示图片
     * @param context Context
     * @param imagePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    public abstract <T extends java.lang.Object>void displayImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, @com.shijingfeng.base.annotation.define.GlideOutputType()
    int outputType, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.listener.Target<T> target);
    
    /**
     * 显示视频缩略图
     * @param context Context
     * @param imageView ImageView
     * @param videoFilePath 视频文件路径 (本地路径 或 网络路径)
     * @param placeholder 加载中 占位符
     * @param error 加载错误 占位符
     */
    public abstract void displayVideoThumb(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @org.jetbrains.annotations.NotNull()
    java.lang.String videoFilePath, @androidx.annotation.DrawableRes()
    int placeholder, @androidx.annotation.DrawableRes()
    int error);
    
    /**
     * 显示视频缩略图
     * @param context Context
     * @param videoFilePath 路径 (本地路径 或 网络路径)
     * @param target 加载回调
     */
    public abstract void displayVideoThumb(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String videoFilePath, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.listener.Target<android.graphics.drawable.Drawable> target);
    
    public ImageLoader() {
        super();
    }
}