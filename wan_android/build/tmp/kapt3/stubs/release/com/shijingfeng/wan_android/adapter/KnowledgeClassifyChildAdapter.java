package com.shijingfeng.wan_android.adapter;

import java.lang.System;

/**
 * Function: 知识体系 二级数据 RecyclerView 适配器
 * Date: 2020/2/4 13:53
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014J.\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/shijingfeng/wan_android/adapter/KnowledgeClassifyChildAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseAdapter;", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildItem;", "context", "Landroid/content/Context;", "dataList", "", "(Landroid/content/Context;Ljava/util/List;)V", "convert", "", "holder", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "data", "position", "", "partialConvert", "payloads", "", "wan_android_release"})
public final class KnowledgeClassifyChildAdapter extends com.shijingfeng.base.base.adapter.BaseAdapter<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem> {
    
    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    @java.lang.Override()
    protected void convert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem data, int position) {
    }
    
    /**
     * 用户自定义处理数据 (单个Item内 局部刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     * @param payloads 局部刷新标记 (注：为什么是List，而不是Object, 因为在Item中的View刷新之前，可能存在短时间刷新多次，所以就会有多个占位符存入List中)
     */
    @java.lang.Override()
    protected void partialConvert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem data, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> payloads) {
    }
    
    public KnowledgeClassifyChildAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem> dataList) {
        super(null, 0, null);
    }
}