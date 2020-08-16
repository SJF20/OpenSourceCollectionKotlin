package com.shijingfeng.base.base.entity;

import java.lang.System;

/**
 * Function: 实体类基类
 * Author: ShiJingFeng
 * Date: 2019/11/14 10:43
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0000\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/shijingfeng/base/base/entity/BaseEntity;", "", "()V", "get", "T", "()Lcom/shijingfeng/base/base/entity/BaseEntity;", "getId", "", "base_debug"})
public abstract class BaseEntity {
    
    /**
     * 获取ID
     * @return ID
     */
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getId() {
        return null;
    }
    
    /**
     * 获取子类
     * @param <T> 子类类型
     * @return 子类
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends com.shijingfeng.base.base.entity.BaseEntity>T get() {
        return null;
    }
    
    public BaseEntity() {
        super();
    }
}