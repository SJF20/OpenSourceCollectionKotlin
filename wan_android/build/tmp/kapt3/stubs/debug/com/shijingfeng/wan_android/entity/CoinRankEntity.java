package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * 积分排行榜 实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0006H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J_\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0001J\u0013\u0010.\u001a\u00020\u00062\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u00020\u0003H\u00d6\u0001J\t\u00102\u001a\u000203H\u00d6\u0001R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016\u00a8\u00064"}, d2 = {"Lcom/shijingfeng/wan_android/entity/CoinRankEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "dataSource", "", "offset", "over", "", "curPage", "pageCount", "size", "total", "coinRankItemList", "", "Lcom/shijingfeng/wan_android/entity/CoinRankItem;", "(IIZIIIILjava/util/List;)V", "getCoinRankItemList", "()Ljava/util/List;", "setCoinRankItemList", "(Ljava/util/List;)V", "getCurPage", "()I", "setCurPage", "(I)V", "getDataSource", "setDataSource", "getOffset", "setOffset", "getOver", "()Z", "setOver", "(Z)V", "getPageCount", "setPageCount", "getSize", "setSize", "getTotal", "setTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "", "wan_android_debug"})
public final class CoinRankEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 数据来源 默认 [DATA_SOURCE_NETWORK]
     */
    private int dataSource;
    
    /**
     * 此页开始的下标
     */
    @com.google.gson.annotations.SerializedName(value = "offset")
    private int offset;
    
    /**
     */
    @com.google.gson.annotations.SerializedName(value = "over")
    private boolean over;
    
    /**
     * 当前页面的页码 (-1 代表从本地获取的 全部 Item)
     */
    @com.google.gson.annotations.SerializedName(value = "curPage")
    private int curPage;
    
    /**
     * 页面的数量
     */
    @com.google.gson.annotations.SerializedName(value = "pageCount")
    private int pageCount;
    
    /**
     * 当前页的Item数量
     */
    @com.google.gson.annotations.SerializedName(value = "size")
    private int size;
    
    /**
     * Item总数
     */
    @com.google.gson.annotations.SerializedName(value = "total")
    private int total;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "datas")
    private java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> coinRankItemList;
    
    /**
     * 数据来源 默认 [DATA_SOURCE_NETWORK]
     */
    public final int getDataSource() {
        return 0;
    }
    
    /**
     * 数据来源 默认 [DATA_SOURCE_NETWORK]
     */
    public final void setDataSource(int p0) {
    }
    
    /**
     * 此页开始的下标
     */
    public final int getOffset() {
        return 0;
    }
    
    /**
     * 此页开始的下标
     */
    public final void setOffset(int p0) {
    }
    
    /**
     */
    public final boolean getOver() {
        return false;
    }
    
    /**
     */
    public final void setOver(boolean p0) {
    }
    
    /**
     * 当前页面的页码 (-1 代表从本地获取的 全部 Item)
     */
    public final int getCurPage() {
        return 0;
    }
    
    /**
     * 当前页面的页码 (-1 代表从本地获取的 全部 Item)
     */
    public final void setCurPage(int p0) {
    }
    
    /**
     * 页面的数量
     */
    public final int getPageCount() {
        return 0;
    }
    
    /**
     * 页面的数量
     */
    public final void setPageCount(int p0) {
    }
    
    /**
     * 当前页的Item数量
     */
    public final int getSize() {
        return 0;
    }
    
    /**
     * 当前页的Item数量
     */
    public final void setSize(int p0) {
    }
    
    /**
     * Item总数
     */
    public final int getTotal() {
        return 0;
    }
    
    /**
     * Item总数
     */
    public final void setTotal(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> getCoinRankItemList() {
        return null;
    }
    
    public final void setCoinRankItemList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> p0) {
    }
    
    public CoinRankEntity(@com.shijingfeng.base.annotation.define.DataSource()
    int dataSource, int offset, boolean over, int curPage, int pageCount, int size, int total, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> coinRankItemList) {
        super();
    }
    
    public CoinRankEntity() {
        super();
    }
    
    /**
     * 数据来源 默认 [DATA_SOURCE_NETWORK]
     */
    public final int component1() {
        return 0;
    }
    
    /**
     * 此页开始的下标
     */
    public final int component2() {
        return 0;
    }
    
    /**
     */
    public final boolean component3() {
        return false;
    }
    
    /**
     * 当前页面的页码 (-1 代表从本地获取的 全部 Item)
     */
    public final int component4() {
        return 0;
    }
    
    /**
     * 页面的数量
     */
    public final int component5() {
        return 0;
    }
    
    /**
     * 当前页的Item数量
     */
    public final int component6() {
        return 0;
    }
    
    /**
     * Item总数
     */
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> component8() {
        return null;
    }
    
    /**
     * 积分排行榜 实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.CoinRankEntity copy(@com.shijingfeng.base.annotation.define.DataSource()
    int dataSource, int offset, boolean over, int curPage, int pageCount, int size, int total, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.CoinRankItem> coinRankItemList) {
        return null;
    }
    
    /**
     * 积分排行榜 实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 积分排行榜 实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 积分排行榜 实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}