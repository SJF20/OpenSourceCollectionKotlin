package com.shijingfeng.todo.view_model;

import java.lang.System;

/**
 * Function: 主页 -> 待办 ViewModel
 * Date: 2020/5/19 9:42
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0014H\u0002J\u0016\u0010(\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\b\u0010,\u001a\u00020&H\u0016J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u00a8\u00060"}, d2 = {"Lcom/shijingfeng/todo/view_model/MainTodoViewModel;", "Lcom/shijingfeng/todo/base/TodoBaseViewModel;", "Lcom/shijingfeng/todo/source/repository/MainTodoRepository;", "repository", "(Lcom/shijingfeng/todo/source/repository/MainTodoRepository;)V", "mListDataChangeEvent", "Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "Lcom/shijingfeng/todo/entity/adapter/MainTodoItem;", "getMListDataChangeEvent", "()Lcom/shijingfeng/base/livedata/SingleLiveEvent;", "setMListDataChangeEvent", "(Lcom/shijingfeng/base/livedata/SingleLiveEvent;)V", "mMainTodoItemList", "", "getMMainTodoItemList", "()Ljava/util/List;", "mMainTodoItemMapList", "", "", "", "getMMainTodoItemMapList", "()Ljava/util/Map;", "mOnLoadMoreListener", "Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "getMOnLoadMoreListener", "()Lcom/scwang/smartrefresh/layout/listener/OnLoadMoreListener;", "mOnRefreshListener", "Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "getMOnRefreshListener", "()Lcom/scwang/smartrefresh/layout/listener/OnRefreshListener;", "mPage", "mPageOperateType", "mReloadListener", "Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getMReloadListener", "()Lcom/kingja/loadsir/callback/Callback$OnReloadListener;", "getTodoData", "", "page", "groupByDate", "todoItemList", "", "Lcom/shijingfeng/todo/entity/MainTodoGroupItem;", "init", "load", "loadMore", "refresh", "todo_release"})
public final class MainTodoViewModel extends com.shijingfeng.todo.base.TodoBaseViewModel<com.shijingfeng.todo.source.repository.MainTodoRepository> {
    
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
     * 待办列表
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.shijingfeng.todo.entity.adapter.MainTodoItem> mMainTodoItemList = null;
    
    /**
     * 待办 Map 列表
     * Key: 毫秒值 (以天为单位)
     * Value: [mMainTodoItemList] 下标
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Long, java.lang.Integer> mMainTodoItemMapList = null;
    
    /**
     * 列表数据改变 LiveData Event
     */
    @org.jetbrains.annotations.NotNull()
    private com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.todo.entity.adapter.MainTodoItem>> mListDataChangeEvent;
    
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
    public final java.util.List<com.shijingfeng.todo.entity.adapter.MainTodoItem> getMMainTodoItemList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, java.lang.Integer> getMMainTodoItemMapList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.todo.entity.adapter.MainTodoItem>> getMListDataChangeEvent() {
        return null;
    }
    
    public final void setMListDataChangeEvent(@org.jetbrains.annotations.NotNull()
    com.shijingfeng.base.livedata.SingleLiveEvent<com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<com.shijingfeng.todo.entity.adapter.MainTodoItem>> p0) {
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
     * 获取 待办 数据
     * @param page 页码 (从 [MAIN_TODO_FIRST_PAGE] 开始)
     */
    private final void getTodoData(int page) {
    }
    
    /**
     * 通过日期进行分组
     *
     * @param todoItemList 要分组的列表
     */
    private final void groupByDate(java.util.List<com.shijingfeng.todo.entity.MainTodoGroupItem> todoItemList) {
    }
    
    public MainTodoViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.todo.source.repository.MainTodoRepository repository) {
        super(null);
    }
    
    public MainTodoViewModel() {
        super(null);
    }
}