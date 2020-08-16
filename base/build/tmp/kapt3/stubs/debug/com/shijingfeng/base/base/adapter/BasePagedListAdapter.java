package com.shijingfeng.base.base.adapter;

import java.lang.System;

/**
 * Function: 通用 Paging分页加载 Adapter
 * Date: 2020/1/27 13:58
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00040\u0003B%\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0002\u0010\u000bB%\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u00a2\u0006\u0002\u0010\u000eJ9\u0010\'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\b2\u0010\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010*H$\u00a2\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\bJ\u000e\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u001fJ\u0018\u0010/\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0016J&\u0010/\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c00H\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bH\u0016Jt\u00105\u001a\u00020!2l\u00106\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u0017j\u0004\u0018\u0001`\"R\u001a\u0010\u000f\u001a\u00020\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0080\u0001\u0010\u0016\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b( \u0012\u0004\u0012\u00020!\u0018\u00010\u0017j\u0004\u0018\u0001`\"X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00067"}, d2 = {"Lcom/shijingfeng/base/base/adapter/BasePagedListAdapter;", "T", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "Landroidx/paging/PagedListAdapter;", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "context", "Landroid/content/Context;", "layoutId", "", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroid/content/Context;ILandroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "config", "Landroidx/recyclerview/widget/AsyncDifferConfig;", "(Landroid/content/Context;ILandroidx/recyclerview/widget/AsyncDifferConfig;)V", "mChoiceItemPosition", "getMChoiceItemPosition", "()I", "setMChoiceItemPosition", "(I)V", "mContext", "mLayoutId", "mOnItemEvent", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "data", "position", "", "flag", "", "Lcom/shijingfeng/base/common/extension/onItemEvent;", "getMOnItemEvent", "()Lkotlin/jvm/functions/Function4;", "setMOnItemEvent", "(Lkotlin/jvm/functions/Function4;)V", "convert", "holder", "payloads", "", "(Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;Lcom/shijingfeng/base/base/entity/BaseEntity;ILjava/util/List;)V", "getChoiceItemPosition", "getPositionById", "id", "onBindViewHolder", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnItemEventListener", "onItemEvent", "base_debug"})
public abstract class BasePagedListAdapter<T extends com.shijingfeng.base.base.entity.BaseEntity> extends androidx.paging.PagedListAdapter<T, com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder> {
    private final android.content.Context mContext = null;
    private final int mLayoutId = 0;
    
    /**
     * 当前操作的Item Position
     */
    private int mChoiceItemPosition = -1;
    
    /**
     * 回调监听器
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> mOnItemEvent;
    
    protected final int getMChoiceItemPosition() {
        return 0;
    }
    
    protected final void setMChoiceItemPosition(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final kotlin.jvm.functions.Function4<android.view.View, java.lang.Object, java.lang.Integer, java.lang.String, kotlin.Unit> getMOnItemEvent() {
        return null;
    }
    
    protected final void setMOnItemEvent(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Object> payloads) {
    }
    
    /**
     * 用户自定义处理数据
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部更新数据标志
     */
    protected abstract void convert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.Nullable()
    T data, int position, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends java.lang.Object> payloads);
    
    /**
     * 通过ID 获取当前Position位置
     * @param id 位置
     */
    public final int getPositionById(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return 0;
    }
    
    /**
     * 设置回调监听器
     * @param onItemEvent 回调监听器
     */
    public final void setOnItemEventListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onItemEvent) {
    }
    
    /**
     * 获取当前操作的 Item Position
     * @return 当前操作的 Item Position
     */
    public final int getChoiceItemPosition() {
        return 0;
    }
    
    public BasePagedListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int layoutId, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.DiffUtil.ItemCallback<T> diffCallback) {
        super(null);
    }
    
    public BasePagedListAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int layoutId, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.AsyncDifferConfig<T> config) {
        super(null);
    }
}