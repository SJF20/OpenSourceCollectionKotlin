package com.shijingfeng.todo.source.repository;

import java.lang.System;

/**
 * Function: 主页 仓库
 * Date: 2020/5/17 16:33
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/todo/source/repository/MainRepository;", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/todo/source/local/MainLocalSource;", "Lcom/shijingfeng/todo/source/network/MainNetworkSource;", "localSource", "networkSource", "(Lcom/shijingfeng/todo/source/local/MainLocalSource;Lcom/shijingfeng/todo/source/network/MainNetworkSource;)V", "onCleared", "", "todo_debug"})
public final class MainRepository extends com.shijingfeng.base.base.repository.BaseRepository<com.shijingfeng.todo.source.local.MainLocalSource, com.shijingfeng.todo.source.network.MainNetworkSource> {
    
    /**
     * 销毁回调
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public MainRepository(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.todo.source.local.MainLocalSource localSource, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.todo.source.network.MainNetworkSource networkSource) {
        super(null, null);
    }
    
    public MainRepository() {
        super(null, null);
    }
}