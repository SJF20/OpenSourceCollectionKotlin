package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b\u001a#\u0010\u000b\u001a\u00020\b2\u0016\u0010\f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\r\"\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"layout", "", "linearLayout", "Landroid/widget/LinearLayout;", "childViewList", "", "Landroid/view/View;", "totalWidth", "", "interval", "gravity", "measureTotalWidth", "viewArray", "", "([Landroid/view/View;)I", "base_release"})
public final class LayoutUtil {
    
    /**
     * 布局 (按控件宽度逐行排列, 无固定列数)
     * @param linearLayout 容器LinearLayout
     * @param childViewList 子View列表
     * @param totalWidth 横向总宽度
     * @param interval 间隔大小
     * @param gravity 对齐方式
     */
    public static final void layout(@org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout linearLayout, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends android.view.View> childViewList, int totalWidth, int interval, int gravity) {
    }
    
    /**
     * 测量多个View的宽
     * @param viewArray View数组
     * @return 总宽度
     */
    public static final int measureTotalWidth(@org.jetbrains.annotations.NotNull()
    android.view.View... viewArray) {
        return 0;
    }
}