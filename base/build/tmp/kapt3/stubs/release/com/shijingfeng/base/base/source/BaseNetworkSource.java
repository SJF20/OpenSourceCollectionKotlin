package com.shijingfeng.base.base.source;

import java.lang.System;

/**
 * Function: 网络资源 基类
 * Date: 2020/1/17 19:41
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010J\u0015\u0010\u0017\u001a\u0002H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u0000\u00a2\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "", "()V", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable$delegate", "Lkotlin/Lazy;", "mCoroutinesJobList", "", "Lkotlinx/coroutines/Job;", "getMCoroutinesJobList", "()Ljava/util/List;", "mCoroutinesJobList$delegate", "addCoroutinesJob", "", "job", "addDisposable", "disposable", "Lio/reactivex/disposables/Disposable;", "clearCoroutinesJob", "clearDisposable", "get", "T", "()Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "onCleared", "base_release"})
public abstract class BaseNetworkSource {
    
    /**
     * Disposable 容器
     */
    private final kotlin.Lazy mCompositeDisposable$delegate = null;
    
    /**
     * 协程任务容器
     */
    private final kotlin.Lazy mCoroutinesJobList$delegate = null;
    
    /**
     * Disposable 容器
     */
    private final io.reactivex.disposables.CompositeDisposable getMCompositeDisposable() {
        return null;
    }
    
    /**
     * 协程任务容器
     */
    private final java.util.List<kotlinx.coroutines.Job> getMCoroutinesJobList() {
        return null;
    }
    
    /**
     * 获取子类类型实例
     * @param <T> 泛型
     * @return 子类类型实例
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.shijingfeng.base.base.source.BaseNetworkSource>T get() {
        return null;
    }
    
    /**
     * 添加 Disposable
     * @param disposable Disposable
     */
    public final void addDisposable(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable disposable) {
    }
    
    /**
     * 添加 协程任务
     * @param job 协程任务
     */
    public final void addCoroutinesJob(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.Job job) {
    }
    
    /**
     * 清空 Disposable
     */
    public final void clearDisposable() {
    }
    
    /**
     * 清空 协程任务
     */
    public final void clearCoroutinesJob() {
    }
    
    /**
     * 清除数据
     */
    public void onCleared() {
    }
    
    public BaseNetworkSource() {
        super();
    }
}