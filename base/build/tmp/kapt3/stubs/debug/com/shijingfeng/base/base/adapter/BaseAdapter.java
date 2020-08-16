package com.shijingfeng.base.base.adapter;

import java.lang.System;

/**
 * Function: 通用 RecyclerView Adapter
 * Date: 2020/1/24 10:13
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ%\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\bH$\u00a2\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\bJ\b\u0010-\u001a\u00020\bH\u0016J\u0018\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\bH\u0016J&\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e00H\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\bH\u0016J3\u00105\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\b2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001e0\nH\u0014\u00a2\u0006\u0002\u00106Jt\u00107\u001a\u00020#2l\u00108\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u0019j\u0004\u0018\u0001`$R\u001a\u0010\f\u001a\u00020\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0080\u0001\u0010\u0018\u001ah\u0012\u0015\u0012\u0013\u0018\u00010\u001a\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\u001e\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b( \u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u0019j\u0004\u0018\u0001`$X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u00069"}, d2 = {"Lcom/shijingfeng/base/base/adapter/BaseAdapter;", "T", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "mContext", "Landroid/content/Context;", "mLayoutId", "", "mDataList", "", "(Landroid/content/Context;ILjava/util/List;)V", "mChoiceItemPosition", "getMChoiceItemPosition", "()I", "setMChoiceItemPosition", "(I)V", "getMContext", "()Landroid/content/Context;", "getMDataList", "()Ljava/util/List;", "setMDataList", "(Ljava/util/List;)V", "getMLayoutId", "mOnItemEvent", "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "data", "position", "", "flag", "", "Lcom/shijingfeng/base/common/extension/onItemEvent;", "getMOnItemEvent", "()Lkotlin/jvm/functions/Function4;", "setMOnItemEvent", "(Lkotlin/jvm/functions/Function4;)V", "convert", "holder", "(Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;Lcom/shijingfeng/base/base/entity/BaseEntity;I)V", "getChoiceItemPosition", "getItemCount", "onBindViewHolder", "payloads", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "partialConvert", "(Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;Lcom/shijingfeng/base/base/entity/BaseEntity;ILjava/util/List;)V", "setOnItemEventListener", "onItemEvent", "base_debug"})
public abstract class BaseAdapter<T extends com.shijingfeng.base.base.entity.BaseEntity> extends androidx.recyclerview.widget.RecyclerView.Adapter<com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder> {
    
    /**
     * 当前操作的Item Position
     */
    private int mChoiceItemPosition = -1;
    
    /**
     * 回调监听器
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> mOnItemEvent;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context mContext = null;
    private final int mLayoutId = 0;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<? extends T> mDataList;
    
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
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    protected abstract void convert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    T data, int position);
    
    /**
     * 用户自定义处理数据 (单个Item内 局部刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部刷新标记 (注：为什么是List，而不是Object, 因为在Item中的View刷新之前，可能存在短时间刷新多次，所以就会有多个占位符存入List中)
     */
    protected void partialConvert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    T data, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> payloads) {
    }
    
    /**
     * 设置回调监听器
     * @param onItemEvent 回调监听器
     */
    public final void setOnItemEventListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function4<? super android.view.View, java.lang.Object, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onItemEvent) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    /**
     * 获取当前操作的 Item Position
     * @return 当前操作的 Item Position
     */
    public final int getChoiceItemPosition() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final android.content.Context getMContext() {
        return null;
    }
    
    protected final int getMLayoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final java.util.List<T> getMDataList() {
        return null;
    }
    
    protected final void setMDataList(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> p0) {
    }
    
    public BaseAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, int mLayoutId, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> mDataList) {
        super();
    }
}