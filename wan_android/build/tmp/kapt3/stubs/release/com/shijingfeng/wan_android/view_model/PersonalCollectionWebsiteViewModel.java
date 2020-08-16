package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 我的收藏 -> 网站收藏 ViewModel
 * Date: 2020/3/25 23:28
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020\u001a2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020$0#R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006%"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/PersonalCollectionWebsiteViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionWebsiteRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/PersonalCollectionWebsiteRepository;)V", "mListDataChangeEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "getMListDataChangeEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "getMOnRefreshListener", "()Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "mPageOperateType", "", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "mWebsiteCollectedListItemList", "Ljava/util/ArrayList;", "getMWebsiteCollectedListItemList", "()Ljava/util/ArrayList;", "getWebsiteCollectedList", "", "init", "load", "refresh", "uncollected", "websiteId", "", "updateWebsite", "dataMap", "", "", "wan_android_release"})
public final class PersonalCollectionWebsiteViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.PersonalCollectionWebsiteRepository> {
    
    /**
     * 页面操作类型
     */
    @com.shijingfeng.base.annotation.define.PageOperateType()
    private int mPageOperateType = 1;
    
    /**
     * 网站收藏列表 数据列表
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity> mWebsiteCollectedListItemList = null;
    
    /**
     * 列表数据改变 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity>> mListDataChangeEvent = null;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity> getMWebsiteCollectedListItemList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity>> getMListDataChangeEvent() {
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
     * 获取 网站收藏列表 数据
     */
    private final void getWebsiteCollectedList() {
    }
    
    /**
     * 编辑
     * @param dataMap 请求携带的数据 (id, name, link)
     */
    public final void updateWebsite(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> dataMap) {
    }
    
    /**
     * 取消收藏
     * @param websiteId 网站ID
     */
    public final void uncollected(@org.jetbrains.annotations.NotNull()
    java.lang.String websiteId) {
    }
    
    public PersonalCollectionWebsiteViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.PersonalCollectionWebsiteRepository repository) {
        super(null);
    }
    
    public PersonalCollectionWebsiteViewModel() {
        super(null);
    }
}