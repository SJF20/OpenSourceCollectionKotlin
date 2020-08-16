package com.shijingfeng.wan_android.adapter;

import java.lang.System;

/**
 * Function: 主题颜色 适配器
 * Date: 2020/5/31 11:19
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/wan_android/adapter/ThemeColorAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseAdapter;", "Lcom/shijingfeng/wan_android/entity/adapter/ThemeColorItem;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mPreChoosePosition", "", "convert", "", "holder", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "data", "position", "wan_android_debug"})
public final class ThemeColorAdapter extends com.shijingfeng.base.base.adapter.BaseAdapter<com.shijingfeng.wan_android.entity.adapter.ThemeColorItem> {
    
    /**
     * 前一个选中的 Position
     */
    private int mPreChoosePosition = -1;
    
    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    @java.lang.Override()
    protected void convert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.adapter.ThemeColorItem data, int position) {
    }
    
    public ThemeColorAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, 0, null);
    }
}