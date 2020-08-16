package com.shijingfeng.base.base.adapter.support;

import java.lang.System;

/**
 * Function: 多种Item类型支持
 * Date: 2020/1/23 20:58
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/base/base/adapter/support/MultiItemTypeSupport;", "T", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "", "getItemViewType", "", "position", "data", "(ILcom/shijingfeng/base/base/entity/BaseEntity;)I", "getLayoutId", "itemType", "base_debug"})
public abstract interface MultiItemTypeSupport<T extends com.shijingfeng.base.base.entity.BaseEntity> {
    
    /**
     * 根据 Item类型 获取 Layout Id
     * @param itemType Item类型
     * @return Layout Id
     */
    @androidx.annotation.LayoutRes()
    public abstract int getLayoutId(int itemType);
    
    /**
     * 获取 Item类型
     * @param position 下标位置
     * @param data 数据
     * @return Item类型
     */
    public abstract int getItemViewType(int position, @org.jetbrains.annotations.NotNull()
    T data);
}