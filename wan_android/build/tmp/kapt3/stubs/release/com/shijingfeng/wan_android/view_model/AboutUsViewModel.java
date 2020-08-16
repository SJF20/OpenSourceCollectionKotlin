package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 主页 -> 侧边栏 -> 关于我们 ViewModel
 * Date: 2020/2/12 17:06
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/AboutUsViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "repository", "(Lcom/shijingfeng/base/base/repository/BaseRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "wan_android_release"})
public final class AboutUsViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.base.base.repository.BaseRepository<?, ?>> {
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    public AboutUsViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.base.base.repository.BaseRepository<?, ?> repository) {
        super(null);
    }
    
    public AboutUsViewModel() {
        super(null);
    }
}