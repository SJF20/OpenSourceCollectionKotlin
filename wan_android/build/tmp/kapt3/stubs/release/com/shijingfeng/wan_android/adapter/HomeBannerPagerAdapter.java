package com.shijingfeng.wan_android.adapter;

import java.lang.System;

/**
 * Function: 首页轮播图ViewPager适配器
 * Date: 2020/2/3 22:19
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/shijingfeng/wan_android/adapter/HomeBannerPagerAdapter;", "Lcom/shijingfeng/sjf_banner/library/banner/adapter/BaseBannerPagerAdapter;", "Lcom/shijingfeng/wan_android/entity/adapter/HomeBannerItem;", "context", "Landroid/content/Context;", "dataList", "", "(Landroid/content/Context;Ljava/util/List;)V", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "wan_android_release"})
public final class HomeBannerPagerAdapter extends com.shijingfeng.sjf_banner.library.banner.adapter.BaseBannerPagerAdapter<com.shijingfeng.wan_android.entity.adapter.HomeBannerItem> {
    
    /**
     * 初始化 Item
     * @param container 容器 ViewGroup
     * @param position 当前 Item 索引
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    public HomeBannerPagerAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.util.List<com.shijingfeng.wan_android.entity.adapter.HomeBannerItem> dataList) {
        super(null, null);
    }
}