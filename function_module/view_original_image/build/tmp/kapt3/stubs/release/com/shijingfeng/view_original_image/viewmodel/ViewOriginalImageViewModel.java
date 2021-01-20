package com.shijingfeng.view_original_image.viewmodel;

import java.lang.System;

/**
 * Function: 查看原图 ViewModel
 * Date: 2020/1/29 9:41
 * Description:
 * Author: ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u00020\u0002H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/shijingfeng/view_original_image/viewmodel/ViewOriginalImageViewModel;", "Lcom/shijingfeng/view_original_image/base/CommonBaseViewModel;", "Lcom/shijingfeng/view_original_image/source/repository/ViewOriginalImageRepository;", "()V", "mCurrentPosition", "", "getMCurrentPosition", "()I", "setMCurrentPosition", "(I)V", "mDataList", "", "Lcom/shijingfeng/view_original_image/entity/ViewOriginalImageItem;", "getMDataList", "()Ljava/util/List;", "setMDataList", "(Ljava/util/List;)V", "mFromName", "", "getMFromName", "()Ljava/lang/String;", "setMFromName", "(Ljava/lang/String;)V", "mSaveImageLiveEvent", "Lcom/shijingfeng/base/mvvm/livedata/SingleLiveEvent;", "Lokhttp3/ResponseBody;", "getMSaveImageLiveEvent", "()Lcom/shijingfeng/base/mvvm/livedata/SingleLiveEvent;", "downloadImage", "", "imageUrl", "getRepository", "view_original_image_release"})
public final class ViewOriginalImageViewModel extends com.shijingfeng.view_original_image.base.CommonBaseViewModel<com.shijingfeng.view_original_image.source.repository.ViewOriginalImageRepository> {
    
    /**
     * 上一个页面的全限定名称
     */
    public java.lang.String mFromName;
    
    /**
     * 图片数据列表
     */
    public java.util.List<com.shijingfeng.view_original_image.entity.ViewOriginalImageItem> mDataList;
    
    /**
     * 首先展示的图片 在 图片数据列表的 位置
     */
    private int mCurrentPosition = 0;
    
    /**
     * 保存图片 LiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.mvvm.livedata.SingleLiveEvent<okhttp3.ResponseBody> mSaveImageLiveEvent = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFromName() {
        return null;
    }
    
    public final void setMFromName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.view_original_image.entity.ViewOriginalImageItem> getMDataList() {
        return null;
    }
    
    public final void setMDataList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.view_original_image.entity.ViewOriginalImageItem> p0) {
    }
    
    public final int getMCurrentPosition() {
        return 0;
    }
    
    public final void setMCurrentPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.mvvm.livedata.SingleLiveEvent<okhttp3.ResponseBody> getMSaveImageLiveEvent() {
        return null;
    }
    
    /**
     * 获取 Repository
     * @return Repository
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected com.shijingfeng.view_original_image.source.repository.ViewOriginalImageRepository getRepository() {
        return null;
    }
    
    /**
     * 下载图片
     */
    public final void downloadImage(@org.jetbrains.annotations.NotNull()
    java.lang.String imageUrl) {
    }
    
    public ViewOriginalImageViewModel() {
        super();
    }
}