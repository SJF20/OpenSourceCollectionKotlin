package com.shijingfeng.base.entity.event.live_data;

import java.lang.System;

/**
 * Function: 列表数据改变 Event
 * Author: ShiJingFeng
 * Date: 2019/12/7 14:59
 * Description: @JvmOverloads注解用于生成多个重载函数的java文件
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BU\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0004H\u00c6\u0003J\t\u0010 \u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u00c6\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u00c6\u0003J]\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003J\t\u0010(\u001a\u00020\u0004H\u00d6\u0001J\t\u0010)\u001a\u00020*H\u00d6\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019\u00a8\u0006+"}, d2 = {"Lcom/shijingfeng/base/entity/event/live_data/ListDataChangeEvent;", "T", "", "type", "", "insertIndex", "insertOrder", "extraData", "dataList", "", "indexList", "(IIILjava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getExtraData", "()Ljava/lang/Object;", "setExtraData", "(Ljava/lang/Object;)V", "getIndexList", "setIndexList", "getInsertIndex", "()I", "setInsertIndex", "(I)V", "getInsertOrder", "setInsertOrder", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "base_release"})
public final class ListDataChangeEvent<T extends java.lang.Object> {
    
    /**
     * 操作类型
     */
    private int type;
    
    /**
     * 插入的下标 (用于插入)
     */
    private int insertIndex;
    
    /**
     * 插入顺序 默认倒序
     */
    private int insertOrder;
    
    /**
     * 额外携带的数据
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object extraData;
    
    /**
     * 数据列表 (用于 刷新，添加 或 插入)
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.List<? extends T> dataList;
    
    /**
     * 下标列表 (用于 删除 或 修改)
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.Integer> indexList;
    
    /**
     * 操作类型
     */
    public final int getType() {
        return 0;
    }
    
    /**
     * 操作类型
     */
    public final void setType(int p0) {
    }
    
    /**
     * 插入的下标 (用于插入)
     */
    public final int getInsertIndex() {
        return 0;
    }
    
    /**
     * 插入的下标 (用于插入)
     */
    public final void setInsertIndex(int p0) {
    }
    
    /**
     * 插入顺序 默认倒序
     */
    public final int getInsertOrder() {
        return 0;
    }
    
    /**
     * 插入顺序 默认倒序
     */
    public final void setInsertOrder(int p0) {
    }
    
    /**
     * 额外携带的数据
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getExtraData() {
        return null;
    }
    
    /**
     * 额外携带的数据
     */
    public final void setExtraData(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    /**
     * 数据列表 (用于 刷新，添加 或 插入)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> getDataList() {
        return null;
    }
    
    /**
     * 数据列表 (用于 刷新，添加 或 插入)
     */
    public final void setDataList(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> p0) {
    }
    
    /**
     * 下标列表 (用于 删除 或 修改)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Integer> getIndexList() {
        return null;
    }
    
    /**
     * 下标列表 (用于 删除 或 修改)
     */
    public final void setIndexList(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> p0) {
    }
    
    public ListDataChangeEvent(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type, int insertIndex, @com.shijingfeng.base.annotation.define.Order()
    int insertOrder, @org.jetbrains.annotations.Nullable()
    java.lang.Object extraData, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> dataList, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> indexList) {
        super();
    }
    
    public ListDataChangeEvent(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type, int insertIndex, @com.shijingfeng.base.annotation.define.Order()
    int insertOrder, @org.jetbrains.annotations.Nullable()
    java.lang.Object extraData, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> dataList) {
        super();
    }
    
    public ListDataChangeEvent(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type, int insertIndex, @com.shijingfeng.base.annotation.define.Order()
    int insertOrder, @org.jetbrains.annotations.Nullable()
    java.lang.Object extraData) {
        super();
    }
    
    public ListDataChangeEvent(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type, int insertIndex, @com.shijingfeng.base.annotation.define.Order()
    int insertOrder) {
        super();
    }
    
    public ListDataChangeEvent(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type, int insertIndex) {
        super();
    }
    
    public ListDataChangeEvent(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type) {
        super();
    }
    
    public ListDataChangeEvent() {
        super();
    }
    
    /**
     * 操作类型
     */
    public final int component1() {
        return 0;
    }
    
    /**
     * 插入的下标 (用于插入)
     */
    public final int component2() {
        return 0;
    }
    
    /**
     * 插入顺序 默认倒序
     */
    public final int component3() {
        return 0;
    }
    
    /**
     * 额外携带的数据
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component4() {
        return null;
    }
    
    /**
     * 数据列表 (用于 刷新，添加 或 插入)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<T> component5() {
        return null;
    }
    
    /**
     * 下标列表 (用于 删除 或 修改)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.Integer> component6() {
        return null;
    }
    
    /**
     * Function: 列表数据改变 Event
     * Author: ShiJingFeng
     * Date: 2019/12/7 14:59
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.entity.event.live_data.ListDataChangeEvent<T> copy(@com.shijingfeng.base.annotation.define.DataOperateType()
    int type, int insertIndex, @com.shijingfeng.base.annotation.define.Order()
    int insertOrder, @org.jetbrains.annotations.Nullable()
    java.lang.Object extraData, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends T> dataList, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.Integer> indexList) {
        return null;
    }
    
    /**
     * Function: 列表数据改变 Event
     * Author: ShiJingFeng
     * Date: 2019/12/7 14:59
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 列表数据改变 Event
     * Author: ShiJingFeng
     * Date: 2019/12/7 14:59
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 列表数据改变 Event
     * Author: ShiJingFeng
     * Date: 2019/12/7 14:59
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}