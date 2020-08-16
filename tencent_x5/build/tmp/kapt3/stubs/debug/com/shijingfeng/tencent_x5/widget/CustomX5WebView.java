package com.shijingfeng.tencent_x5.widget;

import java.lang.System;

/**
 * Function: 自定义腾讯X5WebView (用于解决 API23 以下 onScrollListener无法使用问题)
 * Date: 2020/2/2 20:40
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0081\u0001\u0010\u0018\u001a\u00020\u00122y\u0010\u0019\u001au\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nR\u0081\u0001\u0010\t\u001au\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/shijingfeng/tencent_x5/widget/CustomX5WebView;", "Lcom/tencent/smtt/sdk/WebView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOnScrollChangeListener", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "webView", "scrollX", "scrollY", "oldScrollX", "oldScrollY", "", "onScrollChanged", "l", "t", "oldl", "oldt", "setCustomOnScrollChangeListener", "onScrollChangeListener", "tencent_x5_debug"})
public final class CustomX5WebView extends com.tencent.smtt.sdk.WebView {
    private kotlin.jvm.functions.Function5<? super com.tencent.smtt.sdk.WebView, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> mOnScrollChangeListener;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 设置自定以滑动改变监听器
     * @param onScrollChangeListener 滑动改变监听器
     */
    public final void setCustomOnScrollChangeListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function5<? super com.tencent.smtt.sdk.WebView, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onScrollChangeListener) {
    }
    
    @java.lang.Override()
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
    }
    
    public CustomX5WebView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null, false);
    }
    
    public CustomX5WebView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null, false);
    }
    
    public CustomX5WebView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, false);
    }
}