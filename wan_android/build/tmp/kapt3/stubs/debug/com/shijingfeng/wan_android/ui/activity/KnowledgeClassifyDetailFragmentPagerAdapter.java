package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * 知识体系 ViewPager Fragment 适配器
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/KnowledgeClassifyDetailFragmentPagerAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseFragmentPagerAdapter;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "mKnowledgeClassify", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;", "(Landroidx/fragment/app/FragmentManager;Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;)V", "createItem", "Lcom/shijingfeng/wan_android/ui/fragment/KnowledgeClassifyChildFragment;", "position", "", "getCount", "wan_android_debug"})
public final class KnowledgeClassifyDetailFragmentPagerAdapter extends com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter<com.shijingfeng.wan_android.base.WanAndroidBaseFragment<?, ?>> {
    
    /**
     * 知识体系　一级 Item 实体类
     */
    private final com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity mKnowledgeClassify = null;
    
    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.shijingfeng.wan_android.ui.fragment.KnowledgeClassifyChildFragment createItem(int position) {
        return null;
    }
    
    /**
     * 获取 Fragment List Count
     * @return Fragment List Count
     */
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    public KnowledgeClassifyDetailFragmentPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity mKnowledgeClassify) {
        super(null, false, null, null);
    }
}