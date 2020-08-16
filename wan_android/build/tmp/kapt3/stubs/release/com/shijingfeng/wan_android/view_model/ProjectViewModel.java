package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 项目 ViewModel
 * Date: 2020/2/12 17:10
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/ProjectViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/ProjectRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/ProjectRepository;)V", "mCurrentFragmentPosition", "", "getMCurrentFragmentPosition", "()I", "setMCurrentFragmentPosition", "(I)V", "mProjectIndexDataChangeEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;", "getMProjectIndexDataChangeEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mProjectIndexList", "", "getMProjectIndexList", "()Ljava/util/List;", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getProjectIndex", "", "init", "wan_android_release"})
public final class ProjectViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.ProjectRepository> {
    
    /**
     * 当前 Fragment Item Position
     */
    private int mCurrentFragmentPosition = 0;
    
    /**
     * 项目 索引数据 列表
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexEntity> mProjectIndexList = null;
    
    /**
     * 项目 索引数据 列表 改变 SingleLiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.ProjectIndexEntity>> mProjectIndexDataChangeEvent = null;
    
    /**
     * LoadService 重新加载监听器
     */
    @org.jetbrains.annotations.NotNull()
    private final com.kingja.loadsir.callback.Callback.OnReloadListener mReloadListener = null;
    
    public final int getMCurrentFragmentPosition() {
        return 0;
    }
    
    public final void setMCurrentFragmentPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexEntity> getMProjectIndexList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.ProjectIndexEntity>> getMProjectIndexDataChangeEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kingja.loadsir.callback.Callback.OnReloadListener getMReloadListener() {
        return null;
    }
    
    /**
     * 初始化
     */
    @java.lang.Override()
    public void init() {
    }
    
    /**
     * 获取 项目 索引数据
     */
    private final void getProjectIndex() {
    }
    
    public ProjectViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.ProjectRepository repository) {
        super(null);
    }
    
    public ProjectViewModel() {
        super(null);
    }
}