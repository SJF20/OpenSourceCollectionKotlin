package com.shijingfeng.base.databinding.view_adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u001a\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0007\u00a8\u0006\b"}, d2 = {"setOnLoadMoreListener", "", "refreshLayout", "Lcom/scwang/smartrefresh/layout/SmartRefreshLayout;", "listener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "setOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "base_release"})
public final class SmartRefreshLayoutViewAdapter {
    
    /**
     * 下拉刷新
     * @param refreshLayout SmartRefreshLayout
     * @param listener 下拉刷新监听器
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"onRefreshListener"})
    public static final void setOnRefreshListener(@org.jetbrains.annotations.NotNull()
    com.scwang.smartrefresh.layout.SmartRefreshLayout refreshLayout, @org.jetbrains.annotations.Nullable()
    com.scwang.smartrefresh.layout.listener.OnRefreshListener listener) {
    }
    
    /**
     * 上拉加载
     * @param refreshLayout SmartRefreshLayout
     * @param listener 上拉加载监听器
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"onLoadMoreListener"})
    public static final void setOnLoadMoreListener(@org.jetbrains.annotations.NotNull()
    com.scwang.smartrefresh.layout.SmartRefreshLayout refreshLayout, @org.jetbrains.annotations.Nullable()
    com.scwang.smartrefresh.layout.listener.OnLoadMoreListener listener) {
    }
}