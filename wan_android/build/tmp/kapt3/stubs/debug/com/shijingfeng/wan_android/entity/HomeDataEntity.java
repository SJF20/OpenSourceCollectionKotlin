package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * Function: 首页数据 聚合
 * Date: 2020/2/4 16:04
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\bH\u00c6\u0003J-\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020!H\u00d6\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\""}, d2 = {"Lcom/shijingfeng/wan_android/entity/HomeDataEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "homeBannerListItem", "Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerListItem;", "homeTopArticleItemList", "", "Lcom/shijingfeng/wan_android/entity/adapter/HomeTopArticleItem;", "homeArticle", "Lcom/shijingfeng/wan_android/entity/HomeArticleEntity;", "(Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerListItem;Ljava/util/List;Lcom/shijingfeng/wan_android/entity/HomeArticleEntity;)V", "getHomeArticle", "()Lcom/shijingfeng/wan_android/entity/HomeArticleEntity;", "setHomeArticle", "(Lcom/shijingfeng/wan_android/entity/HomeArticleEntity;)V", "getHomeBannerListItem", "()Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerListItem;", "setHomeBannerListItem", "(Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerListItem;)V", "getHomeTopArticleItemList", "()Ljava/util/List;", "setHomeTopArticleItemList", "(Ljava/util/List;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "wan_android_debug"})
public final class HomeDataEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 首页 轮播图数据
     */
    @org.jetbrains.annotations.NotNull()
    private com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem homeBannerListItem;
    
    /**
     * 首页 置顶文章数据
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem> homeTopArticleItemList;
    
    /**
     * 首页 文章数据
     */
    @org.jetbrains.annotations.NotNull()
    private com.shijingfeng.wan_android.entity.HomeArticleEntity homeArticle;
    
    /**
     * 首页 轮播图数据
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem getHomeBannerListItem() {
        return null;
    }
    
    /**
     * 首页 轮播图数据
     */
    public final void setHomeBannerListItem(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem p0) {
    }
    
    /**
     * 首页 置顶文章数据
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem> getHomeTopArticleItemList() {
        return null;
    }
    
    /**
     * 首页 置顶文章数据
     */
    public final void setHomeTopArticleItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem> p0) {
    }
    
    /**
     * 首页 文章数据
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.HomeArticleEntity getHomeArticle() {
        return null;
    }
    
    /**
     * 首页 文章数据
     */
    public final void setHomeArticle(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.HomeArticleEntity p0) {
    }
    
    public HomeDataEntity(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem homeBannerListItem, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem> homeTopArticleItemList, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.HomeArticleEntity homeArticle) {
        super();
    }
    
    public HomeDataEntity() {
        super();
    }
    
    /**
     * 首页 轮播图数据
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem component1() {
        return null;
    }
    
    /**
     * 首页 置顶文章数据
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem> component2() {
        return null;
    }
    
    /**
     * 首页 文章数据
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.HomeArticleEntity component3() {
        return null;
    }
    
    /**
     * Function: 首页数据 聚合
     * Date: 2020/2/4 16:04
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.HomeDataEntity copy(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.adapter.HomeBannerListItem homeBannerListItem, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeTopArticleItem> homeTopArticleItemList, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.HomeArticleEntity homeArticle) {
        return null;
    }
    
    /**
     * Function: 首页数据 聚合
     * Date: 2020/2/4 16:04
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 首页数据 聚合
     * Date: 2020/2/4 16:04
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 首页数据 聚合
     * Date: 2020/2/4 16:04
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}