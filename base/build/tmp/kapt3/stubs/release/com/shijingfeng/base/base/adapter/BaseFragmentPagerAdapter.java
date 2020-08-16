package com.shijingfeng.base.base.adapter;

import java.lang.System;

/**
 * Function: 通用 ViewPager FragmentPagerAdapter
 * Date: 2020/1/27 10:43
 * Description: FragmentPagerAdapter(mFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) 会调用setMaxLifecycle (Fragment fragment, Lifecycle.State state)，而不会调用setUserVisibleHint
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u008c\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012F\b\u0002\u0010\b\u001a@\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0010\u0012+\b\u0002\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013\u00a2\u0006\u0002\u0010\u0014J\u0015\u0010\u0017\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\nH&\u00a2\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0015\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0002\u0010\u0018J\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\nH\u0016JH\u0010!\u001a\u00020\u000f2@\u0010\"\u001a<\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\b\u0012\u0004\u0012\u00028\u0000`\u0010J-\u0010#\u001a\u00020\u000f2%\u0010$\u001a!\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000f0\u0012j\u0002`\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\b\u001a@\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\tj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R1\u0010\u0011\u001a%\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/shijingfeng/base/base/adapter/BaseFragmentPagerAdapter;", "T", "Lcom/shijingfeng/base/base/fragment/BaseFragment;", "Landroidx/fragment/app/FragmentPagerAdapter;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "mBanDestroyed", "", "mOnFragmentCreate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "fragment", "", "Lcom/shijingfeng/base/base/adapter/OnFragmentCreate;", "mOnFragmentDestroy", "Lkotlin/Function1;", "Lcom/shijingfeng/base/base/adapter/OnFragmentDestroy;", "(Landroidx/fragment/app/FragmentManager;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "mRegisteredFragmentSparseArray", "Landroid/util/SparseArray;", "createItem", "(I)Lcom/shijingfeng/base/base/fragment/BaseFragment;", "destroyItem", "container", "Landroid/view/ViewGroup;", "any", "", "getFragmentByPosition", "getItem", "instantiateItem", "setOnFragmentCreateListener", "onFragmentCreate", "setOnFragmentDestroyListener", "onFragmentDestroy", "base_release"})
public abstract class BaseFragmentPagerAdapter<T extends com.shijingfeng.base.base.fragment.BaseFragment> extends androidx.fragment.app.FragmentPagerAdapter {
    
    /**
     * Fragment 容器
     */
    private final android.util.SparseArray<T> mRegisteredFragmentSparseArray = null;
    
    /**
     * 是否禁止销毁   true 禁止销毁  false 系统默认销毁机制
     */
    private final boolean mBanDestroyed = false;
    
    /**
     * Fragment 创建 监听器
     * 因为 ViewPager 可以设置预先加载Fragment数量 (setOffscreenPageLimit())
     * 所以 Fragment 可能不会全部创建完, 按需添加回调监听 Fragment 创建
     */
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, kotlin.Unit> mOnFragmentCreate;
    
    /**
     * Fragment 销毁 监听器
     */
    private kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> mOnFragmentDestroy;
    
    /**
     * 为了防止 Fragment 重建导致 手动创建的 Fragment 引用 (在 Activity 或 ViewModel 中创建的 Fragment 列表)
     * 和 缓存的Fragment 不是一个Fragment
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public T getItem(int position) {
        return null;
    }
    
    /**
     * 初始化 Fragment Item
     * 如果 FragmentManager 中没有此 Fragment 则会调用 getItem(Int) 创建 Fragment
     * 否则会调用 FragmentManager attach(Fragment) 显示 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Object instantiateItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position) {
        return null;
    }
    
    /**
     * 销毁 Fragment Item
     */
    @java.lang.Override()
    public void destroyItem(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup container, int position, @org.jetbrains.annotations.NotNull()
    java.lang.Object any) {
    }
    
    /**
     * 创建 Fragment Item
     * @param position 下标
     * @return 创建好的 Fragment
     */
    @org.jetbrains.annotations.NotNull()
    public abstract T createItem(int position);
    
    /**
     * 设置 Fragment 创建 回调监听
     * 因为 ViewPager 可以设置预先加载Fragment数量 (setOffscreenPageLimit())
     * 所以 Fragment 可能不会全部创建完, 按需添加回调监听 Fragment 创建
     */
    public final void setOnFragmentCreateListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, kotlin.Unit> onFragmentCreate) {
    }
    
    /**
     * 设置 Fragment 销毁 回调监听
     */
    public final void setOnFragmentDestroyListener(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onFragmentDestroy) {
    }
    
    /**
     * 通过 下标 获取 Fragment
     * @param position 下标
     * @return Fragment
     */
    @org.jetbrains.annotations.Nullable()
    public final T getFragmentByPosition(int position) {
        return null;
    }
    
    public BaseFragmentPagerAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fragmentManager, boolean mBanDestroyed, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, kotlin.Unit> mOnFragmentCreate, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> mOnFragmentDestroy) {
        super(null);
    }
}