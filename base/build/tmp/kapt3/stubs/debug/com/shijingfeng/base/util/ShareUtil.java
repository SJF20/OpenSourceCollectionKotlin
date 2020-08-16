package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u001a\u0018\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u0001\u001a\"\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a,\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0014"}, d2 = {"SHARE_TITLE", "", "getSHARE_TITLE", "()Ljava/lang/String;", "shareFile", "", "context", "Landroid/content/Context;", "imageUris", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "shareImage", "title", "imagePath", "shareText", "content", "shareTextAndImage", "msgTitle", "msgText", "imgPath", "base_debug"})
public final class ShareUtil {
    
    /**
     * 分享标题
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String SHARE_TITLE = null;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getSHARE_TITLE() {
        return null;
    }
    
    /**
     * 分享纯文字
     * @param title    标题
     * @param content  文本内容
     */
    public static final void shareText(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    java.lang.String content) {
    }
    
    /**
     * 分享单张图片
     * @param imagePath  图片本地路径
     */
    public static final void shareImage(@org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath) {
    }
    
    /**
     * 分享功能
     * @param context       上下文
     * @param msgTitle      消息标题
     * @param msgText       消息内容
     * @param imgPath       图片路径，不分享图片则传null
     */
    public static final void shareTextAndImage(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String msgTitle, @org.jetbrains.annotations.Nullable()
    java.lang.String msgText, @org.jetbrains.annotations.Nullable()
    java.lang.String imgPath) {
    }
    
    /**
     * 分享多个文件
     */
    public static final void shareFile(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.net.Uri> imageUris) {
    }
}