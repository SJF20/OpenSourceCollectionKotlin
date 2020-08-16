package com.shijingfeng.base.arouter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u00006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u001aJ\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a8\u0006\u0012"}, d2 = {"getFragment", "T", "Lcom/shijingfeng/base/base/fragment/BaseFragment;", "path", "", "(Ljava/lang/String;)Lcom/shijingfeng/base/base/fragment/BaseFragment;", "navigation", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "requestCode", "", "animSparseArray", "Landroid/util/SparseIntArray;", "callback", "Lcom/alibaba/android/arouter/facade/callback/NavigationCallback;", "base_release"})
public final class ARouterUtil {
    
    /**
     * 跳到指定路径页面
     * @param path 路径
     * @param bundle 携带的数据
     * @param requestCode 请求码
     * @param animSparseArray Activity切换动画, Key: KEY_ENTER_ANIM, KEY_EXIT_ANIM
     * @param callback 跳转回调
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object navigation(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.Nullable()
    android.os.Bundle bundle, int requestCode, @org.jetbrains.annotations.Nullable()
    android.util.SparseIntArray animSparseArray, @org.jetbrains.annotations.Nullable()
    com.alibaba.android.arouter.facade.callback.NavigationCallback callback) {
        return null;
    }
    
    /**
     * 通过 ARouter 获取 Fragment
     */
    public static final <T extends com.shijingfeng.base.base.fragment.BaseFragment>T getFragment(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
}