package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * Function: 广场 实体类
 * Date: 2020/5/7 14:57
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0006H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003JU\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0001J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,H\u00d6\u0003J\t\u0010-\u001a\u00020\u0003H\u00d6\u0001J\t\u0010.\u001a\u00020/H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011\u00a8\u00060"}, d2 = {"Lcom/shijingfeng/wan_android/entity/SquareEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "curPage", "", "offset", "over", "", "pageCount", "size", "total", "dataList", "", "Lcom/shijingfeng/wan_android/entity/SquareItem;", "(IIZIIILjava/util/List;)V", "getCurPage", "()I", "setCurPage", "(I)V", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getOffset", "setOffset", "getOver", "()Z", "setOver", "(Z)V", "getPageCount", "setPageCount", "getSize", "setSize", "getTotal", "setTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "", "wan_android_release"})
public final class SquareEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 当前页码
     */
    @com.google.gson.annotations.SerializedName(value = "curPage")
    private int curPage;
    
    /**
     * 当前 条 位置（从0开始）
     */
    @com.google.gson.annotations.SerializedName(value = "offset")
    private int offset;
    @com.google.gson.annotations.SerializedName(value = "over")
    private boolean over;
    
    /**
     * 全部 页 数量
     */
    @com.google.gson.annotations.SerializedName(value = "pageCount")
    private int pageCount;
    
    /**
     * 当前 页 有多少 条
     */
    @com.google.gson.annotations.SerializedName(value = "size")
    private int size;
    
    /**
     * 全部 条 数量
     */
    @com.google.gson.annotations.SerializedName(value = "total")
    private int total;
    
    /**
     * 当前 页 的 条 列表数据
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "datas")
    private java.util.List<com.shijingfeng.wan_android.entity.SquareItem> dataList;
    
    /**
     * 当前页码
     */
    public final int getCurPage() {
        return 0;
    }
    
    /**
     * 当前页码
     */
    public final void setCurPage(int p0) {
    }
    
    /**
     * 当前 条 位置（从0开始）
     */
    public final int getOffset() {
        return 0;
    }
    
    /**
     * 当前 条 位置（从0开始）
     */
    public final void setOffset(int p0) {
    }
    
    public final boolean getOver() {
        return false;
    }
    
    public final void setOver(boolean p0) {
    }
    
    /**
     * 全部 页 数量
     */
    public final int getPageCount() {
        return 0;
    }
    
    /**
     * 全部 页 数量
     */
    public final void setPageCount(int p0) {
    }
    
    /**
     * 当前 页 有多少 条
     */
    public final int getSize() {
        return 0;
    }
    
    /**
     * 当前 页 有多少 条
     */
    public final void setSize(int p0) {
    }
    
    /**
     * 全部 条 数量
     */
    public final int getTotal() {
        return 0;
    }
    
    /**
     * 全部 条 数量
     */
    public final void setTotal(int p0) {
    }
    
    /**
     * 当前 页 的 条 列表数据
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.SquareItem> getDataList() {
        return null;
    }
    
    /**
     * 当前 页 的 条 列表数据
     */
    public final void setDataList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.SquareItem> p0) {
    }
    
    public SquareEntity(int curPage, int offset, boolean over, int pageCount, int size, int total, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.SquareItem> dataList) {
        super();
    }
    
    public SquareEntity() {
        super();
    }
    
    /**
     * 当前页码
     */
    public final int component1() {
        return 0;
    }
    
    /**
     * 当前 条 位置（从0开始）
     */
    public final int component2() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    /**
     * 全部 页 数量
     */
    public final int component4() {
        return 0;
    }
    
    /**
     * 当前 页 有多少 条
     */
    public final int component5() {
        return 0;
    }
    
    /**
     * 全部 条 数量
     */
    public final int component6() {
        return 0;
    }
    
    /**
     * 当前 页 的 条 列表数据
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.SquareItem> component7() {
        return null;
    }
    
    /**
     * Function: 广场 实体类
     * Date: 2020/5/7 14:57
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.SquareEntity copy(int curPage, int offset, boolean over, int pageCount, int size, int total, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.SquareItem> dataList) {
        return null;
    }
    
    /**
     * Function: 广场 实体类
     * Date: 2020/5/7 14:57
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 广场 实体类
     * Date: 2020/5/7 14:57
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 广场 实体类
     * Date: 2020/5/7 14:57
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}