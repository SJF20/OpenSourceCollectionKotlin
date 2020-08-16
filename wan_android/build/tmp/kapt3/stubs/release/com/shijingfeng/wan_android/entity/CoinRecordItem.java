package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * 积分记录 Item 实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\tH\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\b\u00101\u001a\u00020\u0003H\u0016J\t\u00102\u001a\u00020\u0007H\u00d6\u0001J\t\u00103\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015\u00a8\u00064"}, d2 = {"Lcom/shijingfeng/wan_android/entity/CoinRecordItem;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "userId", "username", "coinCount", "", "timestamp", "", "desc", "reason", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;I)V", "getCoinCount", "()I", "setCoinCount", "(I)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getIdentity", "setIdentity", "getReason", "setReason", "getTimestamp", "()J", "setTimestamp", "(J)V", "getType", "setType", "getUserId", "setUserId", "getUsername", "setUsername", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getId", "hashCode", "toString", "wan_android_release"})
public final class CoinRecordItem extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 此条记录 的 ID
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    
    /**
     * 此条记录 的 所有者ID
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userId")
    private java.lang.String userId;
    
    /**
     * 此条记录 的 所有者用户名
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userName")
    private java.lang.String username;
    
    /**
     * 此记录 的 积分总数量
     */
    @com.google.gson.annotations.SerializedName(value = "coinCount")
    private int coinCount;
    
    /**
     * 日期时间 毫秒值 时间戳
     */
    @com.google.gson.annotations.SerializedName(value = "date")
    private long timestamp;
    
    /**
     * 此条记录 的 描述
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "desc")
    private java.lang.String desc;
    
    /**
     * 此条记录 的 积分用途或获得途径
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "reason")
    private java.lang.String reason;
    
    /**
     */
    @com.google.gson.annotations.SerializedName(value = "type")
    private int type;
    
    /**
     * 获取ID
     * @return ID
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getId() {
        return null;
    }
    
    /**
     * 此条记录 的 ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIdentity() {
        return null;
    }
    
    /**
     * 此条记录 的 ID
     */
    public final void setIdentity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 此条记录 的 所有者ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    /**
     * 此条记录 的 所有者ID
     */
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 此条记录 的 所有者用户名
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    /**
     * 此条记录 的 所有者用户名
     */
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 此记录 的 积分总数量
     */
    public final int getCoinCount() {
        return 0;
    }
    
    /**
     * 此记录 的 积分总数量
     */
    public final void setCoinCount(int p0) {
    }
    
    /**
     * 日期时间 毫秒值 时间戳
     */
    public final long getTimestamp() {
        return 0L;
    }
    
    /**
     * 日期时间 毫秒值 时间戳
     */
    public final void setTimestamp(long p0) {
    }
    
    /**
     * 此条记录 的 描述
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesc() {
        return null;
    }
    
    /**
     * 此条记录 的 描述
     */
    public final void setDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 此条记录 的 积分用途或获得途径
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReason() {
        return null;
    }
    
    /**
     * 此条记录 的 积分用途或获得途径
     */
    public final void setReason(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     */
    public final int getType() {
        return 0;
    }
    
    /**
     */
    public final void setType(int p0) {
    }
    
    public CoinRecordItem(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, int coinCount, long timestamp, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, int type) {
        super();
    }
    
    public CoinRecordItem() {
        super();
    }
    
    /**
     * 此条记录 的 ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * 此条记录 的 所有者ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 此条记录 的 所有者用户名
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    /**
     * 此记录 的 积分总数量
     */
    public final int component4() {
        return 0;
    }
    
    /**
     * 日期时间 毫秒值 时间戳
     */
    public final long component5() {
        return 0L;
    }
    
    /**
     * 此条记录 的 描述
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    /**
     * 此条记录 的 积分用途或获得途径
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    /**
     */
    public final int component8() {
        return 0;
    }
    
    /**
     * 积分记录 Item 实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.CoinRecordItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, int coinCount, long timestamp, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, int type) {
        return null;
    }
    
    /**
     * 积分记录 Item 实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 积分记录 Item 实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 积分记录 Item 实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}