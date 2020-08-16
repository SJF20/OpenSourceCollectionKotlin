package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 系统设置 ViewModel
 * Date: 2020/5/30 22:57
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0019\u0012\u0012\b\u0002\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/SettingViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "repository", "(Lcom/shijingfeng/base/base/repository/BaseRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mCurThemeColor", "", "getMCurThemeColor", "()I", "setMCurThemeColor", "(I)V", "mCurThemeColorNamePosition", "getMCurThemeColorNamePosition", "setMCurThemeColorNamePosition", "wan_android_release"})
public final class SettingViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.base.base.repository.BaseRepository<?, ?>> {
    
    /**
     * 当前选择的主题(临时存储) RGB颜色字符串
     */
    private int mCurThemeColor;
    
    /**
     * 当前选择的 主题名称 位置
     */
    private int mCurThemeColorNamePosition = 0;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    public final int getMCurThemeColor() {
        return 0;
    }
    
    public final void setMCurThemeColor(int p0) {
    }
    
    public final int getMCurThemeColorNamePosition() {
        return 0;
    }
    
    public final void setMCurThemeColorNamePosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    public SettingViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.base.base.repository.BaseRepository<?, ?> repository) {
        super(null);
    }
    
    public SettingViewModel() {
        super(null);
    }
}