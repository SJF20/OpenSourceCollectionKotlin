package com.shijingfeng.base.databinding.view_adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"onClick", "", "view", "Landroid/view/View;", "listener", "Landroid/view/View$OnClickListener;", "disEnableClickThrottle", "", "clickThrottleMs", "", "base_debug"})
public final class ViewViewAdapter {
    
    /**
     * Function: View View适配器
     * Date: 2020/1/27 16:02
     * Description:
     * @author ShiJingFeng
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"onClick", "disEnableClickThrottle", "clickThrottleMs"})
    public static final void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.view.View.OnClickListener listener, boolean disEnableClickThrottle, @androidx.annotation.IntRange(from = 0L)
    int clickThrottleMs) {
    }
}