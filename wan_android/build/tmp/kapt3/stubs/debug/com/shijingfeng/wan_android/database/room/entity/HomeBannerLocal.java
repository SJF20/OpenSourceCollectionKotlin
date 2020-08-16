package com.shijingfeng.wan_android.database.room.entity;

import java.lang.System;

/**
 * Function: 首页 轮播图 Item 本地 实体类
 * Date: 2020/5/10 14:26
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/shijingfeng/wan_android/database/room/entity/HomeBannerLocal;", "", "identity", "", "desc", "", "imagePath", "isVisible", "order", "title", "type", "url", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getIdentity", "()I", "setIdentity", "(I)V", "getImagePath", "setImagePath", "setVisible", "getOrder", "setOrder", "getTitle", "setTitle", "getType", "setType", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "wan_android_debug"})
public final class HomeBannerLocal {
    
    /**
     * ID
     */
    @androidx.room.ColumnInfo(name = "id", index = true, defaultValue = "0")
    @androidx.room.PrimaryKey(autoGenerate = false)
    @com.google.gson.annotations.SerializedName(value = "id")
    private int identity;
    
    /**
     * 描述
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "desc", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "desc")
    private java.lang.String desc;
    
    /**
     * 图片地址
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "imagePath", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "imagePath")
    private java.lang.String imagePath;
    
    /**
     */
    @androidx.room.ColumnInfo(name = "isVisible", defaultValue = "1")
    @com.google.gson.annotations.SerializedName(value = "isVisible")
    private int isVisible;
    
    /**
     * 顺序 (从0开始)
     */
    @androidx.room.ColumnInfo(name = "order", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "order")
    private int order;
    
    /**
     * 标题
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "title", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "title")
    private java.lang.String title;
    
    /**
     */
    @androidx.room.ColumnInfo(name = "type", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "type")
    private int type;
    
    /**
     * 点击跳转的URL
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "url", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "url")
    private java.lang.String url;
    
    /**
     * ID
     */
    public final int getIdentity() {
        return 0;
    }
    
    /**
     * ID
     */
    public final void setIdentity(int p0) {
    }
    
    /**
     * 描述
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesc() {
        return null;
    }
    
    /**
     * 描述
     */
    public final void setDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 图片地址
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getImagePath() {
        return null;
    }
    
    /**
     * 图片地址
     */
    public final void setImagePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     */
    public final int isVisible() {
        return 0;
    }
    
    /**
     */
    public final void setVisible(int p0) {
    }
    
    /**
     * 顺序 (从0开始)
     */
    public final int getOrder() {
        return 0;
    }
    
    /**
     * 顺序 (从0开始)
     */
    public final void setOrder(int p0) {
    }
    
    /**
     * 标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    /**
     * 标题
     */
    public final void setTitle(@org.jetbrains.annotations.NotNull()
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
    
    /**
     * 点击跳转的URL
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    /**
     * 点击跳转的URL
     */
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public HomeBannerLocal(int identity, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, int isVisible, int order, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int type, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        super();
    }
    
    public HomeBannerLocal() {
        super();
    }
    
    /**
     * ID
     */
    public final int component1() {
        return 0;
    }
    
    /**
     * 描述
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 图片地址
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    /**
     */
    public final int component4() {
        return 0;
    }
    
    /**
     * 顺序 (从0开始)
     */
    public final int component5() {
        return 0;
    }
    
    /**
     * 标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    /**
     */
    public final int component7() {
        return 0;
    }
    
    /**
     * 点击跳转的URL
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    /**
     * Function: 首页 轮播图 Item 本地 实体类
     * Date: 2020/5/10 14:26
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.database.room.entity.HomeBannerLocal copy(int identity, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String imagePath, int isVisible, int order, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int type, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    /**
     * Function: 首页 轮播图 Item 本地 实体类
     * Date: 2020/5/10 14:26
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 首页 轮播图 Item 本地 实体类
     * Date: 2020/5/10 14:26
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 首页 轮播图 Item 本地 实体类
     * Date: 2020/5/10 14:26
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}