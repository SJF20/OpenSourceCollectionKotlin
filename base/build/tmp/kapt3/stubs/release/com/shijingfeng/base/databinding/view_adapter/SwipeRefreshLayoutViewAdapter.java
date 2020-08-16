package com.shijingfeng.base.databinding.view_adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032)\u0010\u0004\u001a%\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0004\u0018\u0001`\tH\u0007\u00a8\u0006\n"}, d2 = {"setOnRefreshListener", "", "swipeRefreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "onSwipeRefresh", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "refreshLayout", "Lcom/shijingfeng/base/common/extension/onSwipeRefresh;", "base_release"})
public final class SwipeRefreshLayoutViewAdapter {
    
    /**
     * 设置 下拉刷新 回调
     * @param swipeRefreshLayout SwipeRefreshLayout
     * @param onSwipeRefresh 刷新回调监听器
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"onRefreshListener"})
    public static final void setOnRefreshListener(@org.jetbrains.annotations.NotNull()
    androidx.swiperefreshlayout.widget.SwipeRefreshLayout swipeRefreshLayout, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super androidx.swiperefreshlayout.widget.SwipeRefreshLayout, kotlin.Unit> onSwipeRefresh) {
    }
}