package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 我的收藏 -> 收藏文章列表 ViewModel
 * Date: 2020/3/24 22:56
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0018H\u0002J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\u0006\u0010$\u001a\u00020\u001fJ\u000e\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006\'"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/PersonalCollectionArticleViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionArticleRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionArticleRepository;)V", "mArticleCollectedListItemList", "Ljava/util/ArrayList;", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionArticleItem;", "getMArticleCollectedListItemList", "()Ljava/util/ArrayList;", "mListDataChangeEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "getMListDataChangeEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mOnLoadMoreListener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "mOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "getMOnRefreshListener", "()Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "mPage", "", "mPageOperateType", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getArticleCollectedList", "", "page", "init", "load", "loadMore", "refresh", "uncollectedInCollectedList", "articleCollectedListItem", "wan_android_release"})
public final class PersonalCollectionArticleViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.PersonalCollectionArticleRepository> {
    
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
     * 文章收藏列表 数据列表
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.shijingfeng.wan_android.entity.PersonalCollectionArticleItem> mArticleCollectedListItemList = null;
    
    /**
     * 列表数据改变 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.PersonalCollectionArticleItem>> mListDataChangeEvent = null;
    
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
    public final java.util.ArrayList<com.shijingfeng.wan_android.entity.PersonalCollectionArticleItem> getMArticleCollectedListItemList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.PersonalCollectionArticleItem>> getMListDataChangeEvent() {
        return null;
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
     * 获取 文章收藏列表
     * @param page 页码 (从 [PERSONAL_COLLECTION_ARTICLE_FIRST_PAGE] 开始)
     */
    private final void getArticleCollectedList(int page) {
    }
    
    /**
     * 取消收藏
     * @param articleCollectedListItem 文章收藏列表 Item 实体
     */
    public final void uncollectedInCollectedList(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.PersonalCollectionArticleItem articleCollectedListItem) {
    }
    
    public PersonalCollectionArticleViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.PersonalCollectionArticleRepository repository) {
        super(null);
    }
    
    public PersonalCollectionArticleViewModel() {
        super(null);
    }
}