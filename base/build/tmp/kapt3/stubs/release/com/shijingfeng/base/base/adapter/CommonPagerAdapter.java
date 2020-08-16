package com.shijingfeng.base.base.adapter;

import java.lang.System;

/**
 * Function: 通用 PagerAdapter
 * Date: 2020/1/27 14:15
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0012H\u0016Jt\u0010&\u001a\u00020\u00182l\u0010\'\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0004\u0018\u0001`\u0019R\u0014\u0010\u0003\u001a\u00020\u0004X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0080\u0001\u0010\f\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0012\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rj\u0004\u0018\u0001`\u0019X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/shijingfeng/base/base/adapter/CommonPagerAdapter;", "T", "Landroidx/viewpager/widget/PagerAdapter;", "mContext", "Landroid/content/Context;", "mDataList", "", "(Landroid/content/Context;Ljava/util/List;)V", "getMContext", "()Landroid/content/Context;", "getMDataList", "()Ljava/util/List;", "mOnItemEvent", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "data", "", "position", "", "flag", "", "Lcom/shijingfeng/base/common/extension/onItemEvent;", "getMOnItemEvent", "()Lkotlin/jvm/functions/Function4;", "setMOnItemEvent", "(Lkotlin/jvm/functions/Function4;)V", "destroyItem", "container", "Landroid/view/ViewGroup;", "any", "getCount", "instantiateItem", "isViewFromObject", "", "setOnItemEventListener", "onItemEvent", "base_release"})
public class CommonPagerAdapter<T extends java.lang.Object> extends androidx.viewpager.widget.PagerAdapter {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> mOnItemEvent;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mContext = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<T> mDataList = null;
    
    @org.jetbrains.annotations.Nullable()
    protected final kotlin.jvm.functions.Function4<android.view.View, java.lang.Object, java.lang.Integer, java.lang.String, kotlin.Unit> getMOnItemEvent() {
        return null;
    }
    
    protected final void setMOnItemEvent(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> p0) {
    }
    
    /**
     * 初始化 Item
     * @param container  父容器
     * @param position   下标位置
     * @return           初始化生成的View对象
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    /**
     * 销毁 Item
     * @param container 父容器
     * @param position  下标位置
     * @param any    View对象
     */
    @java.lang.Override()
    public void destroyItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object any) {
    }
    
    /**
     * 判断 Item
     * @param view    View
     * @param any  对象
     * @return        是否是同一个Item
     */
    @java.lang.Override()
    public boolean isViewFromObject(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    java.lang.Object any) {
        return false;
    }
    
    /**
     * 获取 Item 数量
     * @return 数量
     */
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    /**
     * 设置 事件回调监听
     * @param onItemEvent 事件回调监听
     */
    public final void setOnItemEventListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onItemEvent) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Context getMContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final java.util.List<T> getMDataList() {
        return null;
    }
    
    public CommonPagerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> mDataList) {
        super();
    }
}