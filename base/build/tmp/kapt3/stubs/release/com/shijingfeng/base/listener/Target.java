package com.shijingfeng.base.listener;

import java.lang.System;

/**
 * Function: ImageLoader 加载回调接口
 * Date: 2020/1/22 20:17
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/base/listener/Target;", "R", "", "onLoadFailed", "", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "onLoadFinished", "resource", "(Ljava/lang/Object;)V", "onLoadStarted", "placeholder", "base_release"})
public abstract interface Target<R extends java.lang.Object> {
    
    /**
     * 加载开始
     * @param placeholder 加载中 占位符
     */
    public abstract void onLoadStarted(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable placeholder);
    
    /**
     * 加载完成
     * @param resource 资源
     */
    public abstract void onLoadFinished(@org.jetbrains.annotations.Nullable()
    R resource);
    
    /**
     * 加载失败
     * @param errorDrawable 加载错误 占位符
     */
    public abstract void onLoadFailed(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable errorDrawable);
    
    /**
     * Function: ImageLoader 加载回调接口
     * Date: 2020/1/22 20:17
     * Description:
     * @author ShiJingFeng
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        /**
         * 加载开始
         * @param placeholder 加载中 占位符
         */
        public static <R extends java.lang.Object>void onLoadStarted(com.shijingfeng.base.listener.Target<R> $this, @org.jetbrains.annotations.Nullable()
        android.graphics.drawable.Drawable placeholder) {
        }
        
        /**
         * 加载完成
         * @param resource 资源
         */
        public static <R extends java.lang.Object>void onLoadFinished(com.shijingfeng.base.listener.Target<R> $this, @org.jetbrains.annotations.Nullable()
        R resource) {
        }
        
        /**
         * 加载失败
         * @param errorDrawable 加载错误 占位符
         */
        public static <R extends java.lang.Object>void onLoadFailed(com.shijingfeng.base.listener.Target<R> $this, @org.jetbrains.annotations.Nullable()
        android.graphics.drawable.Drawable errorDrawable) {
        }
    }
}