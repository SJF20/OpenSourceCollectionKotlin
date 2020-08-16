package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 积分记录 ViewModel
 * Date: 2020/3/16 21:51
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020)H\u0016J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\b\u00a8\u0006/"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/CoinRecordViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/CoinRecordRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/CoinRecordRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mCoinRecordItemList", "", "Lcom/shijingfeng/wan_android/entity/CoinRecordItem;", "getMCoinRecordItemList", "()Ljava/util/List;", "setMCoinRecordItemList", "(Ljava/util/List;)V", "mListDataChangeEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "getMListDataChangeEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "setMListDataChangeEvent", "(Lcom/shijingfeng/base/livedata/SingleLiveEvent;)V", "mOnLoadMoreListener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "mOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "getMOnRefreshListener", "()Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "mPage", "", "mPageOperateType", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "mTextOperateClickListener", "getMTextOperateClickListener", "getCoinRecordList", "", "page", "init", "load", "loadMore", "refresh", "wan_android_release"})
public final class CoinRecordViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.CoinRecordRepository> {
    
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
     * 积分记录 数据列表
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.shijingfeng.wan_android.entity.CoinRecordItem> mCoinRecordItemList;
    
    /**
     * 列表数据改变 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.CoinRecordItem>> mListDataChangeEvent;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    /**
     * 查看规则
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mTextOperateClickListener = null;
    
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
    public final java.util.List<com.shijingfeng.wan_android.entity.CoinRecordItem> getMCoinRecordItemList() {
        return null;
    }
    
    public final void setMCoinRecordItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.CoinRecordItem> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.CoinRecordItem>> getMListDataChangeEvent() {
        return null;
    }
    
    public final void setMListDataChangeEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.CoinRecordItem>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMTextOperateClickListener() {
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
    private final void refresh() {
    }
    
    /**
     * 上拉加载
     */
    private final void loadMore() {
    }
    
    /**
     * 获取积分记录列表
     * @param page 页码 (从 [COIN_RECORD_FIRST_PAGE] 开始)
     */
    private final void getCoinRecordList(int page) {
    }
    
    public CoinRecordViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.CoinRecordRepository repository) {
        super(null);
    }
    
    public CoinRecordViewModel() {
        super(null);
    }
}