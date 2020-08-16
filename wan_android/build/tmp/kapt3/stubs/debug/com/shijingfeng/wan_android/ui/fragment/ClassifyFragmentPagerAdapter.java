package com.shijingfeng.wan_android.ui.fragment;

import java.lang.System;

/**
 * 知识体系 ViewPager Fragment 适配器
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B_\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012P\u0010\u0005\u001aL\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001b\u0012\u0019\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006j\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002`\r\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/shijingfeng/wan_android/ui/fragment/ClassifyFragmentPagerAdapter;", "Lcom/shijingfeng/base/base/adapter/BaseFragmentPagerAdapter;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseFragment;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onFragmentCreate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "fragment", "", "Lcom/shijingfeng/base/base/adapter/OnFragmentCreate;", "(Landroidx/fragment/app/FragmentManager;Lkotlin/jvm/functions/Function2;)V", "createItem", "getCount", "wan_android_debug"})
public final class ClassifyFragmentPagerAdapter extends com.shijingfeng.base.base.adapter.BaseFragmentPagerAdapter<com.shijingfeng.wan_android.base.WanAndroidBaseFragment<?, ?>> {
    
    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.shijingfeng.wan_android.base.WanAndroidBaseFragment<?, ?> createItem(int position) {
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
    
    public ClassifyFragmentPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super com.shijingfeng.wan_android.base.WanAndroidBaseFragment<?, ?>, kotlin.Unit> onFragmentCreate) {
        super(null, false, null, null);
    }
}