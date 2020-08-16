package com.shijingfeng.base.widget.rich_text;

import java.lang.System;

/**
 * Function: 富文本 TextView
 * Date: 20-4-7 上午9:47
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJp\u0010\u001b\u001a\u00020\u00142h\u0010\u001c\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00140\nj\u0002`\u0015Rt\u0010\t\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\nj\u0004\u0018\u0001`\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/shijingfeng/base/widget/rich_text/RichTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnItemEvent", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "data", "position", "", "flag", "", "Lcom/shijingfeng/base/common/extension/onItemEvent;", "richText", "getRichText", "()Ljava/lang/String;", "setRichText", "(Ljava/lang/String;)V", "setOnItemEventListener", "onItemEvent", "base_debug"})
public final class RichTextView extends androidx.appcompat.widget.AppCompatTextView {
    private kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> mOnItemEvent;
    
    /**
     * 富文本
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String richText = "";
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRichText() {
        return null;
    }
    
    public final void setRichText(@org.jetbrains.annotations.NotNull()
    java.lang.String richText) {
    }
    
    /**
     * 设置事件回调
     * @param onItemEvent 事件回调函数
     */
    public final void setOnItemEventListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onItemEvent) {
    }
    
    public RichTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public RichTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public RichTextView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}