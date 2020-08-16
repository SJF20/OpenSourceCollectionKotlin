package com.shijingfeng.wan_android.database.room.entity;

import java.lang.System;

/**
 * 首页 置顶文章 标签 本地实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J)\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/database/room/entity/HomeTopArticleTagLocal;", "", "homeTopArticleId", "", "name", "", "url", "(ILjava/lang/String;Ljava/lang/String;)V", "getHomeTopArticleId", "()I", "setHomeTopArticleId", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUrl", "setUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "wan_android_release"})
public final class HomeTopArticleTagLocal {
    
    /**
     * 用于关联
     */
    @androidx.room.ColumnInfo(name = "home_top_article_foreign_id", index = true, defaultValue = "0")
    private int homeTopArticleId;
    
    /**
     * 标签名
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "name", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    
    /**
     * 标签 URL
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "url", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "url")
    private java.lang.String url;
    
    /**
     * 用于关联
     */
    public final int getHomeTopArticleId() {
        return 0;
    }
    
    /**
     * 用于关联
     */
    public final void setHomeTopArticleId(int p0) {
    }
    
    /**
     * 标签名
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    /**
     * 标签名
     */
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    /**
     * 标签 URL
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    /**
     * 标签 URL
     */
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public HomeTopArticleTagLocal(int homeTopArticleId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        super();
    }
    
    public HomeTopArticleTagLocal() {
        super();
    }
    
    /**
     * 用于关联
     */
    public final int component1() {
        return 0;
    }
    
    /**
     * 标签名
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 标签 URL
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    /**
     * 首页 置顶文章 标签 本地实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.database.room.entity.HomeTopArticleTagLocal copy(int homeTopArticleId, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    /**
     * 首页 置顶文章 标签 本地实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 首页 置顶文章 标签 本地实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 首页 置顶文章 标签 本地实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}