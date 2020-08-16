package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 知识体系 详细数据 ViewModel
 * Date: 20-4-25 下午4:00
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/KnowledgeClassifyDetailViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "()V", "mBackListener", "Landroid/view/View$OnClickListener;", "getMBackListener", "()Landroid/view/View$OnClickListener;", "setMBackListener", "(Landroid/view/View$OnClickListener;)V", "mCurrentFragmentPosition", "", "getMCurrentFragmentPosition", "()I", "setMCurrentFragmentPosition", "(I)V", "mKnowledgeClassify", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;", "getMKnowledgeClassify", "()Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;", "setMKnowledgeClassify", "(Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;)V", "wan_android_debug"})
public final class KnowledgeClassifyDetailViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.base.base.repository.BaseRepository<?, ?>> {
    
    /**
     * 知识体系 一级 Item 数据
     */
    @org.jetbrains.annotations.Nullable()
    private com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity mKnowledgeClassify;
    
    /**
     * 当前 Fragment Item Position
     */
    private int mCurrentFragmentPosition = 0;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private android.view.View.OnClickListener mBackListener;
    
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity getMKnowledgeClassify() {
        return null;
    }
    
    public final void setMKnowledgeClassify(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity p0) {
    }
    
    public final int getMCurrentFragmentPosition() {
        return 0;
    }
    
    public final void setMCurrentFragmentPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackListener() {
        return null;
    }
    
    public final void setMBackListener(@org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener p0) {
    }
    
    public KnowledgeClassifyDetailViewModel() {
        super(null);
    }
}