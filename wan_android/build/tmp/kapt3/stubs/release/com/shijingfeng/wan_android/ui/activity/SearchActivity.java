package com.shijingfeng.wan_android.ui.activity;

import java.lang.System;

/**
 * Function: 搜索 Activity
 * Date: 20-5-4 下午5:40
 * Description:
 * @author shijingfeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/SearchActivity")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0014J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0011H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/shijingfeng/wan_android/ui/activity/SearchActivity;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseActivity;", "Lcom/shijingfeng/wan_android/databinding/ActivityWanAndroidSearchBinding;", "Lcom/shijingfeng/wan_android/view_model/SearchViewModel;", "()V", "mSearchHistoryAdapter", "Lcom/shijingfeng/wan_android/adapter/SearchHistoryAdapter;", "mSearchHistoryLoadService", "Lcom/kingja/loadsir/core/LoadService;", "mSearchHotWordLoadService", "getLayoutId", "", "getVariableSparseArray", "Landroid/util/SparseArray;", "", "getViewModel", "initAction", "", "initData", "initObserver", "showSearchHistoryCallback", "status", "showSearchHotWordCallback", "wan_android_release"})
public final class SearchActivity extends com.shijingfeng.wan_android.base.WanAndroidBaseActivity<com.shijingfeng.wan_android.databinding.ActivityWanAndroidSearchBinding, com.shijingfeng.wan_android.view_model.SearchViewModel> {
    
    /**
     * 热门搜索 LoadService
     */
    private com.kingja.loadsir.core.LoadService<?> mSearchHotWordLoadService;
    
    /**
     * 搜索历史 LoadService
     */
    private com.kingja.loadsir.core.LoadService<?> mSearchHistoryLoadService;
    
    /**
     * 搜索历史 适配器
     */
    private com.shijingfeng.wan_android.adapter.SearchHistoryAdapter mSearchHistoryAdapter;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * 获取ViewModel
     * @return ViewModel
     */
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected com.shijingfeng.wan_android.view_model.SearchViewModel getViewModel() {
        return null;
    }
    
    /**
     * 初始化 DataBinding 变量ID 和 变量实体类 Map
     * @return DataBinding 变量SparseArray
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected android.util.SparseArray<java.lang.Object> getVariableSparseArray() {
        return null;
    }
    
    /**
     * 获取视图ID
     *
     * @return 视图ID
     */
    @java.lang.Override()
    protected int getLayoutId() {
        return 0;
    }
    
    /**
     * 初始化数据
     */
    @java.lang.Override()
    protected void initData() {
    }
    
    /**
     * 初始化事件
     */
    @java.lang.Override()
    protected void initAction() {
    }
    
    /**
     * 初始化 LiveData Observer
     */
    @java.lang.Override()
    protected void initObserver() {
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
    
    public SearchActivity() {
        super();
    }
}