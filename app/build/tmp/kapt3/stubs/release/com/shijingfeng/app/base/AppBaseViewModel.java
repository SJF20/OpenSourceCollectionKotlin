package com.shijingfeng.app.base;

import java.lang.System;

/**
 * Function: app 模块 ViewModel 基类
 * Date: 2020/2/2 22:31
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/shijingfeng/app/base/AppBaseViewModel;", "R", "Lcom/shijingfeng/base/base/repository/BaseRepository;", "Lcom/shijingfeng/base/base/viewmodel/BaseViewModel;", "repository", "(Lcom/shijingfeng/base/base/repository/BaseRepository;)V", "app_release"})
public abstract class AppBaseViewModel<R extends com.shijingfeng.base.base.repository.BaseRepository<?, ?>> extends com.shijingfeng.base.base.viewmodel.BaseViewModel<R> {
    
    public AppBaseViewModel(@org.jetbrains.annotations.Nullable()
    R repository) {
        super(null);
    }
    
    public AppBaseViewModel() {
        super(null);
    }
}