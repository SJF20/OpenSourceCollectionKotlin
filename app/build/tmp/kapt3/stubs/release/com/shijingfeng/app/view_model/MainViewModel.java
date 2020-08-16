package com.shijingfeng.app.view_model;

import java.lang.System;

/**
 * Function: 主页 ViewModel
 * Date: 2020/3/16 13:39
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/app/view_model/MainViewModel;", "Lcom/shijingfeng/app/base/AppBaseViewModel;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "repository", "(Lcom/shijingfeng/base/base/repository/BaseRepository;)V", "mWanAndroidMainListener", "Landroid/view/View$OnClickListener;", "getMWanAndroidMainListener", "()Landroid/view/View$OnClickListener;", "app_release"})
public final class MainViewModel extends com.shijingfeng.app.base.AppBaseViewModel<com.shijingfeng.base.base.repository.BaseRepository<?, ?>> {
    
    /**
     * 跳转到 wan_android 模块 主页
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mWanAndroidMainListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMWanAndroidMainListener() {
        return null;
    }
    
    public MainViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.base.base.repository.BaseRepository<?, ?> repository) {
        super(null);
    }
    
    public MainViewModel() {
        super(null);
    }
}