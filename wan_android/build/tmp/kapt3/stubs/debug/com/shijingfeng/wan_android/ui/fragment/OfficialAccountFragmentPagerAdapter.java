package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * 公众号 ViewPager Fragment 适配器
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012P\u0010\u0005\u001aL\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002`\r\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/OfficialAccountFragmentPagerAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseFragmentPagerAdapter;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onFragmentCreate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "fragment", "", "Lcom/shijingfeng/base/base/adapter/OnFragmentCreate;", "mOfficialAccountIndexList", "", "Lcom/shijingfeng/wan_android/entity/OfficialAccountIndexEntity;", "(Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function2;Ljava/util/List;)V", "createItem", "Lcom/shijingfeng/wan_android/ui/fragment/OfficialAccountChildFragment;", "getCount", "wan_android_debug"})
public final class OfficialAccountFragmentPagerAdapter extends com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter<com.shijingfeng.wan_android.base.WanAndroidBaseFragment<?, ?>> {
    
    /**
     * 知识体系　一级 Item 实体类
     */
    private final java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity> mOfficialAccountIndexList = null;
    
    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.shijingfeng.wan_android.ui.fragment.OfficialAccountChildFragment createItem(int position) {
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
    
    public OfficialAccountFragmentPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.shijingfeng.wan_android.base.WanAndroidBaseFragment<?, ?>, kotlin.Unit> onFragmentCreate, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountIndexEntity> mOfficialAccountIndexList) {
        super(null, false, null, null);
    }
}