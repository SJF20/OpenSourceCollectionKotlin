package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 项目 二级数据 ViewModel
 * Date: 20-4-29 下午10:17
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u000201H\u0016J\b\u00107\u001a\u000201H\u0002J\b\u00108\u001a\u000201H\u0002J\u0006\u00109\u001a\u000201J\u000e\u0010:\u001a\u0002012\u0006\u00102\u001a\u000203R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\nR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020-\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006;"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/ProjectChildViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/ProjectChildRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/ProjectChildRepository;)V", "mCollectedStatusEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Landroid/util/SparseArray;", "", "getMCollectedStatusEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mNeedUpdateTheme", "", "getMNeedUpdateTheme", "()Z", "setMNeedUpdateTheme", "(Z)V", "mOnLoadMoreListener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "mOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "getMOnRefreshListener", "()Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "mPage", "", "mPageOperateType", "mProjectChildDataChangeEvent", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "Lcom/shijingfeng/wan_android/entity/ProjectChildItem;", "getMProjectChildDataChangeEvent", "mProjectChildItemList", "", "getMProjectChildItemList", "()Ljava/util/List;", "setMProjectChildItemList", "(Ljava/util/List;)V", "mProjectIndex", "Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;", "getMProjectIndex", "()Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;", "setMProjectIndex", "(Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;)V", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "collected", "", "articleId", "", "getProjectChild", "page", "init", "load", "loadMore", "refresh", "uncollected", "wan_android_debug"})
public final class ProjectChildViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.ProjectChildRepository> {
    
    /**
     * 当前页码
     */
    private int mPage = 1;
    
    /**
     * 页面操作类型
     */
    @com.shijingfeng.base.annotation.define.PageOperateType()
    private int mPageOperateType = 1;
    
    /**
     * 项目 某个索引数据
     */
    @org.jetbrains.annotations.Nullable()
    private com.shijingfeng.wan_android.entity.ProjectIndexEntity mProjectIndex;
    
    /**
     * 项目 二级数据 列表
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.shijingfeng.wan_android.entity.ProjectChildItem> mProjectChildItemList;
    
    /**
     * 项目 二级数据 列表 改变 SingleLiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.ProjectChildItem>> mProjectChildDataChangeEvent = null;
    
    /**
     * 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> mCollectedStatusEvent = null;
    
    /**
     * 是否需要更新主题(当Fragment在没有显示的情况下，RecyclerView更新Adapter无反应)  true: 需要  false: 不需要
     */
    private boolean mNeedUpdateTheme = false;
    
    /**
     * LoadService 重新加载监听器
     */
    @org.jetbrains.annotations.NotNull()
    private final com.kingja.loadsir.callback.Callback.OnReloadListener mReloadListener = null;
    
    /**
     * 下拉刷新
     */
    @org.jetbrains.annotations.NotNull()
    private final com.scwang.smartrefresh.layout.listener.OnRefreshListener mOnRefreshListener = null;
    
    /**
     * 上拉加载
     */
    @org.jetbrains.annotations.NotNull()
    private final com.scwang.smartrefresh.layout.listener.OnLoadMoreListener mOnLoadMoreListener = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.entity.ProjectIndexEntity getMProjectIndex() {
        return null;
    }
    
    public final void setMProjectIndex(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.ProjectIndexEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.ProjectChildItem> getMProjectChildItemList() {
        return null;
    }
    
    public final void setMProjectChildItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.ProjectChildItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.ProjectChildItem>> getMProjectChildDataChangeEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMCollectedStatusEvent() {
        return null;
    }
    
    public final boolean getMNeedUpdateTheme() {
        return false;
    }
    
    public final void setMNeedUpdateTheme(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kingja.loadsir.callback.Callback.OnReloadListener getMReloadListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scwang.smartrefresh.layout.listener.OnRefreshListener getMOnRefreshListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scwang.smartrefresh.layout.listener.OnLoadMoreListener getMOnLoadMoreListener() {
        return null;
    }
    
    /**
     * 初始化
     */
    @java.lang.Override()
    public void init() {
    }
    
    /**
     * 加载数据
     */
    private final void load() {
    }
    
    /**
     * 下拉刷新
     */
    public final void refresh() {
    }
    
    /**
     * 上拉加载
     */
    private final void loadMore() {
    }
    
    /**
     * 项目 二级数据
     * @param page 页码 (从 [PROJECT_CHILD_FIRST_PAGE] 开始)
     */
    private final void getProjectChild(int page) {
    }
    
    /**
     * 收藏
     * @param articleId 文章ID
     */
    public final void collected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId) {
    }
    
    /**
     * 取消收藏
     * @param articleId 文章ID
     */
    public final void uncollected(@org.jetbrains.annotations.NotNull()
    java.lang.String articleId) {
    }
    
    public ProjectChildViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.ProjectChildRepository repository) {
        super(null);
    }
    
    public ProjectChildViewModel() {
        super(null);
    }
}