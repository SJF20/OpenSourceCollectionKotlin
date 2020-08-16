package com.shijingfeng.base.base.viewmodel.factory;

import java.lang.System;

/**
 * Function: 通用 ViewModel 工厂
 * Date: 2020/1/22 19:36
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u0018\u0010\u0002\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/base/base/viewmodel/factory/CommonViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "mRepository", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "(Lcom/shijingfeng/base/base/repository/BaseRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "base_debug"})
public final class CommonViewModelFactory implements androidx.lifecycle.ViewModelProvider.Factory {
    private com.shijingfeng.base.base.repository.BaseRepository<?, ?> mRepository;
    
    /**
     * 创建 ViewModel
     * @param modelClass 要创建的 ViewModel 反射类
     */
    @java.lang.Override()
    public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    public CommonViewModelFactory(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.base.base.repository.BaseRepository<?, ?> mRepository) {
        super();
    }
    
    public CommonViewModelFactory() {
        super();
    }
}