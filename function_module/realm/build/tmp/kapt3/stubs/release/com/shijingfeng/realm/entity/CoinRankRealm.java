package com.shijingfeng.realm.entity;

import java.lang.System;

/**
 * Function: 积分排行榜 Realm 实体类 集合
 * Date: 2020/5/11 14:27
 * Description:
 * Author: ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\tR\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/shijingfeng/realm/entity/CoinRankRealm;", "Lio/realm/RealmModel;", "userId", "", "username", "level", "", "rank", "coinCount", "(Ljava/lang/String;Ljava/lang/String;III)V", "getCoinCount", "()I", "setCoinCount", "(I)V", "getLevel", "setLevel", "getRank", "setRank", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getUsername", "setUsername", "realm_release"})
@io.realm.annotations.RealmClass(name = "coin_rank")
public class CoinRankRealm implements io.realm.RealmModel {
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "userId")
    @io.realm.annotations.Required()
    @io.realm.annotations.PrimaryKey()
    private java.lang.String userId;
    @org.jetbrains.annotations.NotNull()
    @io.realm.annotations.RealmField(name = "username")
    private java.lang.String username;
    @io.realm.annotations.RealmField(name = "level")
    private int level;
    @io.realm.annotations.RealmField(name = "rank")
    private int rank;
    @io.realm.annotations.RealmField(name = "coinCount")
    private int coinCount;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getLevel() {
        return 0;
    }
    
    public final void setLevel(int p0) {
    }
    
    public final int getRank() {
        return 0;
    }
    
    public final void setRank(int p0) {
    }
    
    public final int getCoinCount() {
        return 0;
    }
    
    public final void setCoinCount(int p0) {
    }
    
    public CoinRankRealm(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String username, int level, int rank, int coinCount) {
        super();
    }
    
    public CoinRankRealm() {
        super();
    }
}