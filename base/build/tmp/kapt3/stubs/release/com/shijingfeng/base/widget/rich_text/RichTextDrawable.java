package com.shijingfeng.base.widget.rich_text;

import java.lang.System;

/**
 * 富文本 Drawable
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/shijingfeng/base/widget/rich_text/RichTextDrawable;", "Landroid/graphics/drawable/BitmapDrawable;", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/content/Context;Landroid/graphics/Bitmap;)V", "richTextBitmap", "getRichTextBitmap", "()Landroid/graphics/Bitmap;", "setRichTextBitmap", "(Landroid/graphics/Bitmap;)V", "draw", "", "canvas", "Landroid/graphics/Canvas;", "base_release"})
final class RichTextDrawable extends android.graphics.drawable.BitmapDrawable {
    @org.jetbrains.annotations.Nullable()
    private android.graphics.Bitmap richTextBitmap;
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Bitmap getRichTextBitmap() {
        return null;
    }
    
    public final void setRichTextBitmap(@org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap p0) {
    }
    
    @java.lang.Override()
    public void draw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public RichTextDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap) {
        super();
    }
}