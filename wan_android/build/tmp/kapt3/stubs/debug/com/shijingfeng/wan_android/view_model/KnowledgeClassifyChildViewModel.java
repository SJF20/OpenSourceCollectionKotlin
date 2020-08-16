package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 知识体系 二级数据 ViewModel
 * Date: 2020/4/21 20:30
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020+H\u0016J\b\u00101\u001a\u00020+H\u0002J\b\u00102\u001a\u00020+H\u0002J\u0006\u00103\u001a\u00020+J\u000e\u00104\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u001f\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\'\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u00a8\u00065"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/KnowledgeClassifyChildViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/KnowledgeClassifyChildRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/KnowledgeClassifyChildRepository;)V", "mCollectedStatusEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Landroid/util/SparseArray;", "", "getMCollectedStatusEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mKnowledgeClassifyChildDataChangeEvent", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildItem;", "getMKnowledgeClassifyChildDataChangeEvent", "mKnowledgeClassifyChildItemList", "", "getMKnowledgeClassifyChildItemList", "()Ljava/util/List;", "setMKnowledgeClassifyChildItemList", "(Ljava/util/List;)V", "mKnowledgeClassifyChildren", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildren;", "getMKnowledgeClassifyChildren", "()Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildren;", "setMKnowledgeClassifyChildren", "(Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildren;)V", "mOnLoadMoreListener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "mOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "getMOnRefreshListener", "()Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "mPage", "", "mPageOperateType", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "collected", "", "articleId", "", "getKnowledgeClassifyChildList", "page", "init", "load", "loadMore", "refresh", "uncollected", "wan_android_debug"})
public final class KnowledgeClassifyChildViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.KnowledgeClassifyChildRepository> {
    
    /**
     * 当前页码
     */
    private int mPage = 0;
    
    /**
     * 页面操作类型
     */
    @com.shijingfeng.base.annotation.define.PageOperateType()
    private int mPageOperateType = 1;
    
    /**
     * 知识体系 二级数据　列表
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem> mKnowledgeClassifyChildItemList;
    
    /**
     * 知识体系　二级数据 列表 改变 SingleLiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem>> mKnowledgeClassifyChildDataChangeEvent = null;
    
    /**
     * 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> mCollectedStatusEvent = null;
    
    /**
     * 知识体系 二级数据
     */
    @org.jetbrains.annotations.Nullable()
    private com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren mKnowledgeClassifyChildren;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem> getMKnowledgeClassifyChildItemList() {
        return null;
    }
    
    public final void setMKnowledgeClassifyChildItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildItem>> getMKnowledgeClassifyChildDataChangeEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMCollectedStatusEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren getMKnowledgeClassifyChildren() {
        return null;
    }
    
    public final void setMKnowledgeClassifyChildren(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren p0) {
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
     * 获取 知识体系 二级数据
     * @param page 页码 (从 [KNOWLEDGE_CLASSIFY_CHILD_FIRST_PAGE] 开始)
     */
    private final void getKnowledgeClassifyChildList(int page) {
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
    
    public KnowledgeClassifyChildViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.KnowledgeClassifyChildRepository repository) {
        super(null);
    }
    
    public KnowledgeClassifyChildViewModel() {
        super(null);
    }
}