package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 我的收藏 ViewModel
 * Date: 2020/3/22 19:42
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/PersonalCollectionViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mCurPosition", "", "getMCurPosition", "()I", "setMCurPosition", "(I)V", "wan_android_release"})
public final class PersonalCollectionViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.PersonalCollectionRepository> {
    
    /**
     * 当前 ViewPager 下标
     */
    private int mCurPosition = 0;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    public final int getMCurPosition() {
        return 0;
    }
    
    public final void setMCurPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    public PersonalCollectionViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.PersonalCollectionRepository repository) {
        super(null);
    }
    
    public PersonalCollectionViewModel() {
        super(null);
    }
}