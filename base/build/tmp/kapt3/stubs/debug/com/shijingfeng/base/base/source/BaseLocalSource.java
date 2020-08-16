package com.shijingfeng.base.base.source;

import java.lang.System;

/**
 * Function: 本地资源 基类
 * Date: 2020/1/17 19:24
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0000\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/shijingfeng/base/base/source/BaseLocalSource;", "", "()V", "get", "T", "()Lcom/shijingfeng/base/base/source/BaseLocalSource;", "onCleared", "", "base_debug"})
public abstract class BaseLocalSource {
    
    /**
     * 获取子类类型实例
     * @param <T> 泛型
     * @return 子类类型实例
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.shijingfeng.base.base.source.BaseLocalSource>T get() {
        return null;
    }
    
    /**
     * 清除数据
     */
    public void onCleared() {
    }
    
    public BaseLocalSource() {
        super();
    }
}