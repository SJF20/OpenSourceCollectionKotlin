package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * Function: 积分信息 实体类
 * Date: 2020/2/3 16:10
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0006H\u00c6\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\b\u0010\"\u001a\u00020\u0003H\u0016J\t\u0010#\u001a\u00020\u0006H\u00d6\u0001J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006%"}, d2 = {"Lcom/shijingfeng/wan_android/entity/CoinInfoEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "userId", "", "username", "coinCount", "", "rank", "level", "(Ljava/lang/String;Ljava/lang/String;III)V", "getCoinCount", "()I", "setCoinCount", "(I)V", "getLevel", "setLevel", "getRank", "setRank", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getId", "hashCode", "toString", "wan_android_release"})
public final class CoinInfoEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    
    /**
     * 用户ID
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userId")
    private java.lang.String userId;
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "username")
    private java.lang.String username;
    
    /**
     * 总积分
     */
    @com.google.gson.annotations.SerializedName(value = "coinCount")
    private int coinCount;
    
    /**
     * 当前排名
     */
    @com.google.gson.annotations.SerializedName(value = "rank")
    private int rank;
    
    /**
     * 等级
     */
    @com.google.gson.annotations.SerializedName(value = "level")
    private int level;
    
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
     * 用户ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    /**
     * 用户ID
     */
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    /**
     * 用户名
     */
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 总积分
     */
    public final int getCoinCount() {
        return 0;
    }
    
    /**
     * 总积分
     */
    public final void setCoinCount(int p0) {
    }
    
    /**
     * 当前排名
     */
    public final int getRank() {
        return 0;
    }
    
    /**
     * 当前排名
     */
    public final void setRank(int p0) {
    }
    
    /**
     * 等级
     */
    public final int getLevel() {
        return 0;
    }
    
    /**
     * 等级
     */
    public final void setLevel(int p0) {
    }
    
    public CoinInfoEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, int coinCount, int rank, int level) {
        super();
    }
    
    public CoinInfoEntity() {
        super();
    }
    
    /**
     * 用户ID
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * 用户名
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 总积分
     */
    public final int component3() {
        return 0;
    }
    
    /**
     * 当前排名
     */
    public final int component4() {
        return 0;
    }
    
    /**
     * 等级
     */
    public final int component5() {
        return 0;
    }
    
    /**
     * Function: 积分信息 实体类
     * Date: 2020/2/3 16:10
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.CoinInfoEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, int coinCount, int rank, int level) {
        return null;
    }
    
    /**
     * Function: 积分信息 实体类
     * Date: 2020/2/3 16:10
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 积分信息 实体类
     * Date: 2020/2/3 16:10
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 积分信息 实体类
     * Date: 2020/2/3 16:10
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}