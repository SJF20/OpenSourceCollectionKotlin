package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 搜索列表 ViewModel
 * Date: 20-5-3 下午9:26
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0014H\u0002J\u000e\u0010*\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0#0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000e\u00a8\u0006+"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/SearchListViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/SearchListRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/SearchListRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mCollectedStatusEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Landroid/util/SparseArray;", "", "getMCollectedStatusEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mOnLoadMoreListener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "mPage", "", "mSearchHotWord", "", "getMSearchHotWord", "()Ljava/lang/String;", "setMSearchHotWord", "(Ljava/lang/String;)V", "mSearchList", "", "Lcom/shijingfeng/wan_android/entity/SearchListItem;", "getMSearchList", "()Ljava/util/List;", "setMSearchList", "(Ljava/util/List;)V", "mSearchListDataChangeEvent", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "getMSearchListDataChangeEvent", "collected", "", "articleId", "getSearchData", "page", "uncollected", "wan_android_debug"})
public final class SearchListViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.SearchListRepository> {
    
    /**
     * 当前页码
     */
    private int mPage = 1;
    
    /**
     * 搜索关键词
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mSearchHotWord = "";
    
    /**
     * 搜索列表
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.shijingfeng.wan_android.entity.SearchListItem> mSearchList;
    
    /**
     * 搜索列表 数据改变 SingleLiveEvent
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.SearchListItem>> mSearchListDataChangeEvent = null;
    
    /**
     * 文章收藏状态 SingleLiveEvent  true 收藏  false 取消收藏
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> mCollectedStatusEvent = null;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    /**
     * 上拉加载
     */
    @org.jetbrains.annotations.NotNull()
    private final com.scwang.smartrefresh.layout.listener.OnLoadMoreListener mOnLoadMoreListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMSearchHotWord() {
        return null;
    }
    
    public final void setMSearchHotWord(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.SearchListItem> getMSearchList() {
        return null;
    }
    
    public final void setMSearchList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.SearchListItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.SearchListItem>> getMSearchListDataChangeEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<android.util.SparseArray<java.lang.Object>> getMCollectedStatusEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scwang.smartrefresh.layout.listener.OnLoadMoreListener getMOnLoadMoreListener() {
        return null;
    }
    
    /**
     * 获取搜索数据
     */
    private final void getSearchData(int page) {
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
    
    public SearchListViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.SearchListRepository repository) {
        super(null);
    }
    
    public SearchListViewModel() {
        super(null);
    }
}