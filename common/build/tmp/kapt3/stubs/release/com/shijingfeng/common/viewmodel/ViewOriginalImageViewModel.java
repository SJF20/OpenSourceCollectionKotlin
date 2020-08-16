package com.shijingfeng.common.viewmodel;

import java.lang.System;

/**
 * Function: 查看原图 ViewModel
 * Date: 2020/1/29 9:41
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/shijingfeng/common/viewmodel/ViewOriginalImageViewModel;", "Lcom/shijingfeng/common/base/CommonBaseViewModel;", "Lcom/shijingfeng/common/source/repository/ViewOriginalImageRepository;", "repository", "(Lcom/shijingfeng/common/source/repository/ViewOriginalImageRepository;)V", "mCurrentPosition", "", "getMCurrentPosition", "()I", "setMCurrentPosition", "(I)V", "mDataList", "", "Lcom/shijingfeng/common/entity/ViewOriginalImageItem;", "getMDataList", "()Ljava/util/List;", "setMDataList", "(Ljava/util/List;)V", "mFromName", "", "getMFromName", "()Ljava/lang/String;", "setMFromName", "(Ljava/lang/String;)V", "mSaveImageLiveEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lokhttp3/ResponseBody;", "getMSaveImageLiveEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "downloadImage", "", "imageUrl", "common_release"})
public final class ViewOriginalImageViewModel extends com.shijingfeng.common.base.CommonBaseViewModel<com.shijingfeng.common.source.repository.ViewOriginalImageRepository> {
    
    /**
     * 上一个页面的全限定名称
     */
    @org.jetbrains.annotations.NotNull()
    public java.lang.String mFromName;
    
    /**
     * 图片数据列表
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.shijingfeng.common.entity.ViewOriginalImageItem> mDataList;
    
    /**
     * 首先展示的图片 在 图片数据列表的 位置
     */
    private int mCurrentPosition = 0;
    
    /**
     * 保存图片 LiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<okhttp3.ResponseBody> mSaveImageLiveEvent = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFromName() {
        return null;
    }
    
    public final void setMFromName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.common.entity.ViewOriginalImageItem> getMDataList() {
        return null;
    }
    
    public final void setMDataList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.common.entity.ViewOriginalImageItem> p0) {
    }
    
    public final int getMCurrentPosition() {
        return 0;
    }
    
    public final void setMCurrentPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<okhttp3.ResponseBody> getMSaveImageLiveEvent() {
        return null;
    }
    
    /**
     * 下载图片
     */
    public final void downloadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl) {
    }
    
    public ViewOriginalImageViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.common.source.repository.ViewOriginalImageRepository repository) {
        super(null);
    }
    
    public ViewOriginalImageViewModel() {
        super(null);
    }
}