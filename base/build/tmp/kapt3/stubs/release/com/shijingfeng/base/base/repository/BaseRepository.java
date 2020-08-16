package com.shijingfeng.base.base.repository;

import java.lang.System;

/**
 * Function: Repository基类
 * Date: 2020/1/17 19:20
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u001d\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0001\u00a2\u0006\u0002\u0010\bJ!\u0010\u0013\u001a\u0002H\u0014\"\u0014\b\u0002\u0010\u0014*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u00a2\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0001X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/shijingfeng/base/base/repository/BaseRepository;", "L", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "N", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "", "mLocalSource", "mNetworkSource", "(Lcom/shijingfeng/base/base/source/BaseLocalSource;Lcom/shijingfeng/base/base/source/BaseNetworkSource;)V", "getMLocalSource", "()Lcom/shijingfeng/base/base/source/BaseLocalSource;", "setMLocalSource", "(Lcom/shijingfeng/base/base/source/BaseLocalSource;)V", "Lcom/shijingfeng/base/base/source/BaseLocalSource;", "getMNetworkSource", "()Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "setMNetworkSource", "(Lcom/shijingfeng/base/base/source/BaseNetworkSource;)V", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "get", "T", "()Lcom/shijingfeng/base/base/repository/BaseRepository;", "onCleared", "", "base_release"})
public abstract class BaseRepository<L extends com.shijingfeng.base.base.source.BaseLocalSource, N extends com.shijingfeng.base.base.source.BaseNetworkSource> {
    @org.jetbrains.annotations.Nullable()
    private L mLocalSource;
    @org.jetbrains.annotations.Nullable()
    private N mNetworkSource;
    
    /**
     * 获取子类类型实例
     * @param <T> 泛型
     * @return 子类类型实例
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.shijingfeng.base.base.repository.BaseRepository<L, N>>T get() {
        return null;
    }
    
    /**
     * 销毁回调
     */
    public void onCleared() {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final L getMLocalSource() {
        return null;
    }
    
    protected final void setMLocalSource(@org.jetbrains.annotations.Nullable()
    L p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final N getMNetworkSource() {
        return null;
    }
    
    protected final void setMNetworkSource(@org.jetbrains.annotations.Nullable()
    N p0) {
    }
    
    public BaseRepository(@org.jetbrains.annotations.Nullable()
    L mLocalSource, @org.jetbrains.annotations.Nullable()
    N mNetworkSource) {
        super();
    }
    
    public BaseRepository() {
        super();
    }
}