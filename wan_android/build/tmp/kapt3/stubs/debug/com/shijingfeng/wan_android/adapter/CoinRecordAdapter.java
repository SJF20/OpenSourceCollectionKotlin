package com.shijingfeng.wan_android.adapter;

import java.lang.System;

/**
 * Function: 积分记录 Adapter
 * Date: 2020/2/3 21:48
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0014\u00a8\u0006\u000f"}, d2 = {"Lcom/shijingfeng/wan_android/adapter/CoinRecordAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseAdapter;", "Lcom/shijingfeng/wan_android/entity/CoinRecordItem;", "context", "Landroid/content/Context;", "dataList", "", "(Landroid/content/Context;Ljava/util/List;)V", "convert", "", "holder", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "data", "position", "", "wan_android_debug"})
public final class CoinRecordAdapter extends com.shijingfeng.base.base.adapter.BaseAdapter<com.shijingfeng.wan_android.entity.CoinRecordItem> {
    
    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    @java.lang.Override()
    protected void convert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.CoinRecordItem data, int position) {
    }
    
    public CoinRecordAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.entity.CoinRecordItem> dataList) {
        super(null, 0, null);
    }
}