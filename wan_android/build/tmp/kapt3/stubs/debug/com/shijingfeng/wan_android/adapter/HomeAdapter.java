package com.shijingfeng.wan_android.adapter;

import java.lang.System;

/**
 * Function: 首页 列表适配器
 * Date: 2020/2/3 21:54
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u00a2\u0006\u0002\u0010\tJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0014J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u000eJ\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0006H\u0014R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\f\u00a8\u0006#"}, d2 = {"Lcom/shijingfeng/wan_android/adapter/HomeAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseMultiItemAdapter;", "Lcom/shijingfeng/wan_android/entity/adapter/HomeItem;", "context", "Landroid/content/Context;", "dataList", "", "multiItemTypeSupport", "Lcom/shijingfeng/base/base/adapter/support/MultiItemTypeSupport;", "(Landroid/content/Context;Ljava/util/List;Lcom/shijingfeng/base/base/adapter/support/MultiItemTypeSupport;)V", "mBannerIndex", "", "Ljava/lang/Integer;", "convert", "", "holder", "Lcom/shijingfeng/base/base/adapter/viewholder/CommonViewHolder;", "data", "position", "initArticleItemData", "homeArticleItem", "Lcom/shijingfeng/wan_android/entity/HomeArticleItem;", "initBannerItemData", "homeBannerItem", "Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerListItem;", "initTopArticleItemData", "homeSetToTopItem", "Lcom/shijingfeng/wan_android/entity/adapter/HomeTopArticleItem;", "notifyDataChanged", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "partialConvert", "payloads", "", "wan_android_debug"})
public final class HomeAdapter extends com.shijingfeng.base.base.adapter.BaseMultiItemAdapter<com.shijingfeng.wan_android.entity.adapter.HomeItem> {
    
    /**
     * 轮播图当前下标  null: 最初状态 (下标为 0)  not null: 轮播图下标
     */
    private java.lang.Integer mBannerIndex;
    
    /**
     * 用户自定义处理数据 (单个Item内 全局刷新)
     * @param holder ViewHolder
     * @param data 数据
     * @param position 下标位置
     */
    @java.lang.Override()
    protected void convert(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.adapter.HomeItem data, int position) {
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
    com.shijingfeng.wan_android.entity.adapter.HomeItem data, int position, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> payloads) {
    }
    
    /**
     * 初始化 轮播图 数据
     * @param holder CommonViewHolder
     * @param homeBannerItem 轮播图数据实体类
     */
    private final void initBannerItemData(com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem homeBannerItem) {
    }
    
    /**
     * 初始化 置顶文章 数据
     * @param holder CommonViewHolder
     * @param homeSetToTopItem 置顶文章数据实体类
     */
    private final void initTopArticleItemData(com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem homeSetToTopItem) {
    }
    
    /**
     * 初始化 文章 数据
     * @param holder CommonViewHolder
     * @param homeArticleItem 文章数据实体类
     */
    private final void initArticleItemData(com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder, com.shijingfeng.wan_android.entity.HomeArticleItem homeArticleItem) {
    }
    
    /**
     * View 绑定到 Window 上 (可见)
     */
    @java.lang.Override()
    public void onViewAttachedToWindow(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder) {
    }
    
    /**
     * View 从 Window 上解绑 (不可见)
     */
    @java.lang.Override()
    public void onViewDetachedFromWindow(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder) {
    }
    
    /**
     * View 被销毁
     */
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.viewholder.CommonViewHolder holder) {
    }
    
    /**
     * 全部数据视图更新
     */
    public final void notifyDataChanged() {
    }
    
    public HomeAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends com.shijingfeng.wan_android.entity.adapter.HomeItem> dataList, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.base.adapter.support.MultiItemTypeSupport<com.shijingfeng.wan_android.entity.adapter.HomeItem> multiItemTypeSupport) {
        super(null, null, null);
    }
}