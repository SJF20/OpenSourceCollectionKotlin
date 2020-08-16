package com.shijingfeng.base.widget.rich_text;

import java.lang.System;

/**
 * 可点击的 ImageSpan 实现类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0007H\u0016Jp\u0010\u0014\u001a\u00020\u00112h\u0010\u0015\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0006j\u0002`\u0012Rt\u0010\u0005\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006j\u0004\u0018\u0001`\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/base/widget/rich_text/ClickableImageSpanImpl;", "Lcom/shijingfeng/base/widget/rich_text/ClickableImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "mOnItemEvent", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "data", "", "position", "", "flag", "", "Lcom/shijingfeng/base/common/extension/onItemEvent;", "onClick", "setOnItemClickListener", "onItemEvent", "base_debug"})
final class ClickableImageSpanImpl extends com.shijingfeng.base.widget.rich_text.ClickableImageSpan {
    private kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> mOnItemEvent;
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onItemEvent) {
    }
    
    public ClickableImageSpanImpl(@org.jetbrains.annotations.NotNull()
    android.graphics.drawable.Drawable d) {
        super(null, null);
    }
}