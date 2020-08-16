package com.shijingfeng.base.widget.rich_text;

import java.lang.System;

/**
 * Function: TextView 富文本 图片获取器
 * Date: 20-4-7 上午10:51
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/shijingfeng/base/widget/rich_text/RichTextImageGetter;", "Landroid/text/Html$ImageGetter;", "mContext", "Landroid/content/Context;", "mTextView", "Landroid/widget/TextView;", "(Landroid/content/Context;Landroid/widget/TextView;)V", "errorBitmap", "Landroid/graphics/Bitmap;", "getErrorBitmap", "()Landroid/graphics/Bitmap;", "setErrorBitmap", "(Landroid/graphics/Bitmap;)V", "placeholderBitmap", "getPlaceholderBitmap", "setPlaceholderBitmap", "getDrawable", "Landroid/graphics/drawable/Drawable;", "source", "", "base_release"})
public final class RichTextImageGetter implements android.text.Html.ImageGetter {
    
    /**
     * 图片加载中 占位图
     */
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap placeholderBitmap;
    
    /**
     * 图片加载失败 占位图
     */
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap errorBitmap;
    private final android.content.Context mContext = null;
    private final android.widget.TextView mTextView = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getPlaceholderBitmap() {
        return null;
    }
    
    public final void setPlaceholderBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getErrorBitmap() {
        return null;
    }
    
    public final void setErrorBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    /**
     * 从 路径 获取 Drawable
     * @param source 路径 (本地路径 或 网络路径)
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.graphics.drawable.Drawable getDrawable(@org.jetbrains.annotations.Nullable()
    java.lang.String source) {
        return null;
    }
    
    public RichTextImageGetter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    android.widget.TextView mTextView) {
        super();
    }
}