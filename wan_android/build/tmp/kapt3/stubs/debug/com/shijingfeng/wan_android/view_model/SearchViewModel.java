package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 搜索列表 ViewModel
 * Date: 20-5-3 下午9:26
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004Jv\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u001525\b\u0002\u0010A\u001a/\u0012\u0015\u0012\u0013\u0018\u00010C\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020?\u0018\u00010Bj\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u0001`G2-\b\u0002\u0010H\u001a\'\u0012\u0015\u0012\u0013\u0018\u00010I\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(J\u0012\u0004\u0012\u00020?\u0018\u00010Bj\u0004\u0018\u0001`KH\u0002J\b\u0010L\u001a\u00020?H\u0002J\u0010\u0010M\u001a\u00020\u001e2\u0006\u0010@\u001a\u00020\u0015H\u0002J\b\u0010N\u001a\u00020?H\u0002J\b\u0010O\u001a\u00020?H\u0002J\b\u0010P\u001a\u00020?H\u0016J\u000e\u0010Q\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0015J\u000e\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u000204J\u0010\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020\u001eH\u0002J\u0010\u0010V\u001a\u00020?2\u0006\u0010U\u001a\u00020\u001eH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\'0&\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\'0+0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u001a\u0010-\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010 \"\u0004\b/\u0010\"R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u001f\u00102\u001a\u0010\u0012\f\u0012\n 5*\u0004\u0018\u0001040403\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\bR\u0011\u0010:\u001a\u00020;\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=\u00a8\u0006W"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/SearchViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/SearchRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/SearchRepository;)V", "mBackClickListener", "Landroid/view/View$OnClickListener;", "getMBackClickListener", "()Landroid/view/View$OnClickListener;", "mClearHistoryClickListener", "getMClearHistoryClickListener", "mOnSearchHistoryReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMOnSearchHistoryReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "mOnSearchHotWordReloadListener", "getMOnSearchHotWordReloadListener", "mSearchClickListener", "getMSearchClickListener", "mSearchHistoryList", "Ljava/util/LinkedList;", "Lcom/shijingfeng/wan_android/entity/adapter/SearchHistoryItem;", "getMSearchHistoryList", "()Ljava/util/LinkedList;", "mSearchHistoryListEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "getMSearchHistoryListEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "mSearchHistoryLoadServiceStatus", "", "getMSearchHistoryLoadServiceStatus", "()I", "setMSearchHistoryLoadServiceStatus", "(I)V", "mSearchHistoryLoadServiceStatusEvent", "getMSearchHistoryLoadServiceStatusEvent", "mSearchHotWordList", "", "Lcom/shijingfeng/wan_android/entity/SearchHotWordEntity;", "getMSearchHotWordList", "()Ljava/util/List;", "mSearchHotWordListEvent", "", "getMSearchHotWordListEvent", "mSearchHotWordLoadServiceStatus", "getMSearchHotWordLoadServiceStatus", "setMSearchHotWordLoadServiceStatus", "mSearchHotWordLoadServiceStatusEvent", "getMSearchHotWordLoadServiceStatusEvent", "mSearchInput", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getMSearchInput", "()Landroidx/databinding/ObservableField;", "mSearchInputClearClickListener", "getMSearchInputClearClickListener", "mSearchInputClearVisibility", "Landroidx/databinding/ObservableInt;", "getMSearchInputClearVisibility", "()Landroidx/databinding/ObservableInt;", "addSearchHistoryItem", "", "searchHistoryItem", "onSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "clearSearchHistoryList", "getIndexByItem", "getSearchHistoryList", "getSearchHotWordList", "init", "removeSearchHistoryItem", "search", "keyword", "showSearchHistoryCallback", "status", "showSearchHotWordCallback", "wan_android_debug"})
public final class SearchViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.SearchRepository> {
    
    /**
     * 搜索热词 数据列表
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shijingfeng.wan_android.entity.SearchHotWordEntity> mSearchHotWordList = null;
    
    /**
     * 搜索历史 数据列表
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.LinkedList<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem> mSearchHistoryList = null;
    
    /**
     * 搜索热词 LoadService 状态
     */
    private int mSearchHotWordLoadServiceStatus = 0;
    
    /**
     * 搜索历史 LoadService 状态
     */
    private int mSearchHistoryLoadServiceStatus = 0;
    
    /**
     * 搜索热词 LoadService LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Integer> mSearchHotWordLoadServiceStatusEvent = null;
    
    /**
     * 搜索历史 LoadService LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Integer> mSearchHistoryLoadServiceStatusEvent = null;
    
    /**
     * 搜索热词 列表数据改变 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<java.util.List<com.shijingfeng.wan_android.entity.SearchHotWordEntity>> mSearchHotWordListEvent = null;
    
    /**
     * 搜索历史 列表数据改变 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem>> mSearchHistoryListEvent = null;
    
    /**
     * 搜索输入框
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableField<java.lang.String> mSearchInput = null;
    
    /**
     * 搜索输入框 清除按钮 可见性
     */
    @org.jetbrains.annotations.NotNull()
    private final androidx.databinding.ObservableInt mSearchInputClearVisibility = null;
    
    /**
     * 返回
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mBackClickListener = null;
    
    /**
     * 搜索输入框 清除文本
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mSearchInputClearClickListener = null;
    
    /**
     * 搜索
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mSearchClickListener = null;
    
    /**
     * 清空 搜索历史
     */
    @org.jetbrains.annotations.NotNull()
    private final android.view.View.OnClickListener mClearHistoryClickListener = null;
    
    /**
     * 热门搜索 重新加载
     */
    @org.jetbrains.annotations.NotNull()
    private final com.kingja.loadsir.callback.Callback.OnReloadListener mOnSearchHotWordReloadListener = null;
    
    /**
     * 搜索历史 重新加载
     */
    @org.jetbrains.annotations.NotNull()
    private final com.kingja.loadsir.callback.Callback.OnReloadListener mOnSearchHistoryReloadListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.SearchHotWordEntity> getMSearchHotWordList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.LinkedList<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem> getMSearchHistoryList() {
        return null;
    }
    
    public final int getMSearchHotWordLoadServiceStatus() {
        return 0;
    }
    
    public final void setMSearchHotWordLoadServiceStatus(int p0) {
    }
    
    public final int getMSearchHistoryLoadServiceStatus() {
        return 0;
    }
    
    public final void setMSearchHistoryLoadServiceStatus(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Integer> getMSearchHotWordLoadServiceStatusEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<java.lang.Integer> getMSearchHistoryLoadServiceStatusEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<java.util.List<com.shijingfeng.wan_android.entity.SearchHotWordEntity>> getMSearchHotWordListEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem>> getMSearchHistoryListEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableField<java.lang.String> getMSearchInput() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.databinding.ObservableInt getMSearchInputClearVisibility() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMBackClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMSearchInputClearClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMSearchClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View.OnClickListener getMClearHistoryClickListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kingja.loadsir.callback.Callback.OnReloadListener getMOnSearchHotWordReloadListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.kingja.loadsir.callback.Callback.OnReloadListener getMOnSearchHistoryReloadListener() {
        return null;
    }
    
    /**
     * 初始化
     */
    @java.lang.Override()
    public void init() {
    }
    
    /**
     * 搜索
     * @param keyword 搜索关键词
     */
    public final void search(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword) {
    }
    
    /**
     * 获取 搜索热词列表 数据
     */
    private final void getSearchHotWordList() {
    }
    
    /**
     * 获取 搜索历史列表 数据
     */
    private final void getSearchHistoryList() {
    }
    
    /**
     * 添加 某条搜索历史 Item
     * @param searchHistoryItem 搜索历史 Item 实体类
     */
    private final void addSearchHistoryItem(com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem searchHistoryItem, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> onSuccess, kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 删除 某条搜索历史 Item
     * @param searchHistoryItem 搜索历史 Item 实体类
     */
    public final void removeSearchHistoryItem(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem searchHistoryItem) {
    }
    
    /**
     * 清空 搜索历史列表 数据
     */
    private final void clearSearchHistoryList() {
    }
    
    /**
     * 搜索热词 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HOT_WORD_SUCCESS]
     */
    private final void showSearchHotWordCallback(@com.shijingfeng.wan_android.annotation.define.SearchHotWordLoadServiceStatus()
    int status) {
    }
    
    /**
     * 搜索历史 LoadSir 切换状态
     * @param status 要切换到的状态  默认: [LOAD_SERVICE_SEARCH_HISTORY_SUCCESS]
     */
    private final void showSearchHistoryCallback(@com.shijingfeng.wan_android.annotation.define.SearchHistoryLoadServiceStatus()
    int status) {
    }
    
    /**
     * 通过 搜索关键词名称 获取 下标
     * @param searchHistoryItem 搜索历史 Item 实体类
     * @return 下标
     */
    private final int getIndexByItem(com.shijingfeng.wan_android.entity.adapter.SearchHistoryItem searchHistoryItem) {
        return 0;
    }
    
    public SearchViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.SearchRepository repository) {
        super(null);
    }
    
    public SearchViewModel() {
        super(null);
    }
}