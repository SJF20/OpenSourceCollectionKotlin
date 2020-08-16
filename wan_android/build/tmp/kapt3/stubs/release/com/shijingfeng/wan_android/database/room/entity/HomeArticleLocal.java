package com.shijingfeng.wan_android.database.room.entity;

import java.lang.System;

/**
 * 首页 文章 本地实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\bg\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u009d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u00a2\u0006\u0002\u0010!J\t\u0010`\u001a\u00020\u0003H\u00c6\u0003J\t\u0010a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010g\u001a\u00020\u0005H\u00c6\u0003J\t\u0010h\u001a\u00020\u0005H\u00c6\u0003J\t\u0010i\u001a\u00020\u0016H\u00c6\u0003J\t\u0010j\u001a\u00020\u0003H\u00c6\u0003J\t\u0010k\u001a\u00020\u0005H\u00c6\u0003J\t\u0010l\u001a\u00020\u0016H\u00c6\u0003J\t\u0010m\u001a\u00020\u0005H\u00c6\u0003J\t\u0010n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010o\u001a\u00020\u0005H\u00c6\u0003J\t\u0010p\u001a\u00020\u0005H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010s\u001a\u00020\u0003H\u00c6\u0003J\t\u0010t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010u\u001a\u00020\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\u0005H\u00c6\u0003J\t\u0010w\u001a\u00020\u0003H\u00c6\u0003J\t\u0010x\u001a\u00020\u0005H\u00c6\u0003J\t\u0010y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010{\u001a\u00020\u0005H\u00c6\u0003J\u00a1\u0002\u0010|\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010}\u001a\u00020~2\b\u0010\u007f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u0081\u0001\u001a\u00020\u0005H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\'\"\u0004\b-\u0010)R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010#\"\u0004\b/\u0010%R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\'\"\u0004\b1\u0010)R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\'\"\u0004\b3\u0010)R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010#\"\u0004\b7\u0010%R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\'\"\u0004\b9\u0010)R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\'\"\u0004\b;\u0010)R\u001e\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\'\"\u0004\b=\u0010)R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010#\"\u0004\b?\u0010%R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010#\"\u0004\bC\u0010%R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010#\"\u0004\bE\u0010%R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010#\"\u0004\bG\u0010%R\u001e\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010#\"\u0004\bI\u0010%R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\'\"\u0004\bO\u0010)R\u001e\u0010\u0018\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010#\"\u0004\bS\u0010%R\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\'\"\u0004\bU\u0010)R\u001e\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010#\"\u0004\bW\u0010%R\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010#\"\u0004\bY\u0010%R\u001e\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\'\"\u0004\b[\u0010)R\u001e\u0010\u001f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\'\"\u0004\b]\u0010)R\u001e\u0010 \u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\'\"\u0004\b_\u0010)\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/shijingfeng/wan_android/database/room/entity/HomeArticleLocal;", "", "identity", "", "apkLink", "", "audit", "author", "chapterId", "chapterName", "collected", "courseId", "desc", "envelopePic", "fresh", "link", "niceDate", "niceShareDate", "origin", "prefix", "projectLink", "publishTime", "", "selfVisible", "shareDate", "shareUser", "superChapterId", "superChapterName", "title", "itemType", "userId", "visible", "zan", "(ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;IIII)V", "getApkLink", "()Ljava/lang/String;", "setApkLink", "(Ljava/lang/String;)V", "getAudit", "()I", "setAudit", "(I)V", "getAuthor", "setAuthor", "getChapterId", "setChapterId", "getChapterName", "setChapterName", "getCollected", "setCollected", "getCourseId", "setCourseId", "getDesc", "setDesc", "getEnvelopePic", "setEnvelopePic", "getFresh", "setFresh", "getIdentity", "setIdentity", "getItemType", "setItemType", "getLink", "setLink", "getNiceDate", "setNiceDate", "getNiceShareDate", "setNiceShareDate", "getOrigin", "setOrigin", "getPrefix", "setPrefix", "getProjectLink", "setProjectLink", "getPublishTime", "()J", "setPublishTime", "(J)V", "getSelfVisible", "setSelfVisible", "getShareDate", "setShareDate", "getShareUser", "setShareUser", "getSuperChapterId", "setSuperChapterId", "getSuperChapterName", "setSuperChapterName", "getTitle", "setTitle", "getUserId", "setUserId", "getVisible", "setVisible", "getZan", "setZan", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "wan_android_release"})
public final class HomeArticleLocal {
    
    /**
     * ID
     */
    @androidx.room.ColumnInfo(name = "id", index = true, defaultValue = "0")
    @androidx.room.PrimaryKey(autoGenerate = false)
    @com.google.gson.annotations.SerializedName(value = "id")
    private int identity;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "apkLink", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "apkLink")
    private java.lang.String apkLink;
    @androidx.room.ColumnInfo(name = "audit", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "audit")
    private int audit;
    
    /**
     * 文章的作者
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "author", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "author")
    private java.lang.String author;
    
    /**
     * 文章领域的类型 ID
     */
    @androidx.room.ColumnInfo(name = "chapterId", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "chapterId")
    private int chapterId;
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "chapterName", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "chapterName")
    private java.lang.String chapterName;
    
    /**
     * 注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true)
     */
    @androidx.room.ColumnInfo(name = "collect", defaultValue = "false")
    @com.google.gson.annotations.SerializedName(value = "collect")
    private int collected;
    @androidx.room.ColumnInfo(name = "courseId", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "courseId")
    private int courseId;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "desc", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "desc")
    private java.lang.String desc;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "envelopePic", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "envelopePic")
    private java.lang.String envelopePic;
    
    /**
     * 是否是最新的 (注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true))
     */
    @androidx.room.ColumnInfo(name = "fresh", defaultValue = "false")
    @com.google.gson.annotations.SerializedName(value = "fresh")
    private int fresh;
    
    /**
     * 文章链接
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "link", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "link")
    private java.lang.String link;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "niceDate", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "niceDate")
    private java.lang.String niceDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "niceShareDate", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "niceShareDate")
    private java.lang.String niceShareDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "origin", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "origin")
    private java.lang.String origin;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "prefix", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "prefix")
    private java.lang.String prefix;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "projectLink", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "projectLink")
    private java.lang.String projectLink;
    @androidx.room.ColumnInfo(name = "publishTime", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "publishTime")
    private long publishTime;
    @androidx.room.ColumnInfo(name = "selfVisible", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "selfVisible")
    private int selfVisible;
    
    /**
     * 分享时的时间戳
     */
    @androidx.room.ColumnInfo(name = "shareDate", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "shareDate")
    private long shareDate;
    
    /**
     * 分享文章的用户
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "shareUser", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "shareUser")
    private java.lang.String shareUser;
    
    /**
     * 所属的文章领域类型 ID
     */
    @androidx.room.ColumnInfo(name = "superChapterId", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "superChapterId")
    private int superChapterId;
    
    /**
     * 所属的文章领域类型 名称 (例如 跨平台)
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "superChapterName", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "superChapterName")
    private java.lang.String superChapterName;
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(name = "title", defaultValue = "")
    @com.google.gson.annotations.SerializedName(value = "title")
    private java.lang.String title;
    @androidx.room.ColumnInfo(name = "type", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "type")
    private int itemType;
    @androidx.room.ColumnInfo(name = "userId", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "userId")
    private int userId;
    @androidx.room.ColumnInfo(name = "visible", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "visible")
    private int visible;
    @androidx.room.ColumnInfo(name = "zan", defaultValue = "0")
    @com.google.gson.annotations.SerializedName(value = "zan")
    private int zan;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getApkLink() {
        return null;
    }
    
    public final void setApkLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getAudit() {
        return 0;
    }
    
    public final void setAudit(int p0) {
    }
    
    /**
     * 文章的作者
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    /**
     * 文章的作者
     */
    public final void setAuthor(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 文章领域的类型 ID
     */
    public final int getChapterId() {
        return 0;
    }
    
    /**
     * 文章领域的类型 ID
     */
    public final void setChapterId(int p0) {
    }
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getChapterName() {
        return null;
    }
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    public final void setChapterName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true)
     */
    public final int getCollected() {
        return 0;
    }
    
    /**
     * 注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true)
     */
    public final void setCollected(int p0) {
    }
    
    public final int getCourseId() {
        return 0;
    }
    
    public final void setCourseId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDesc() {
        return null;
    }
    
    public final void setDesc(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEnvelopePic() {
        return null;
    }
    
    public final void setEnvelopePic(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 是否是最新的 (注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true))
     */
    public final int getFresh() {
        return 0;
    }
    
    /**
     * 是否是最新的 (注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true))
     */
    public final void setFresh(int p0) {
    }
    
    /**
     * 文章链接
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLink() {
        return null;
    }
    
    /**
     * 文章链接
     */
    public final void setLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNiceDate() {
        return null;
    }
    
    public final void setNiceDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNiceShareDate() {
        return null;
    }
    
    public final void setNiceShareDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrigin() {
        return null;
    }
    
    public final void setOrigin(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrefix() {
        return null;
    }
    
    public final void setPrefix(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProjectLink() {
        return null;
    }
    
    public final void setProjectLink(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long getPublishTime() {
        return 0L;
    }
    
    public final void setPublishTime(long p0) {
    }
    
    public final int getSelfVisible() {
        return 0;
    }
    
    public final void setSelfVisible(int p0) {
    }
    
    /**
     * 分享时的时间戳
     */
    public final long getShareDate() {
        return 0L;
    }
    
    /**
     * 分享时的时间戳
     */
    public final void setShareDate(long p0) {
    }
    
    /**
     * 分享文章的用户
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getShareUser() {
        return null;
    }
    
    /**
     * 分享文章的用户
     */
    public final void setShareUser(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 所属的文章领域类型 ID
     */
    public final int getSuperChapterId() {
        return 0;
    }
    
    /**
     * 所属的文章领域类型 ID
     */
    public final void setSuperChapterId(int p0) {
    }
    
    /**
     * 所属的文章领域类型 名称 (例如 跨平台)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuperChapterName() {
        return null;
    }
    
    /**
     * 所属的文章领域类型 名称 (例如 跨平台)
     */
    public final void setSuperChapterName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    /**
     * 文章标题
     */
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getItemType() {
        return 0;
    }
    
    public final void setItemType(int p0) {
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void setUserId(int p0) {
    }
    
    public final int getVisible() {
        return 0;
    }
    
    public final void setVisible(int p0) {
    }
    
    public final int getZan() {
        return 0;
    }
    
    public final void setZan(int p0) {
    }
    
    public HomeArticleLocal(int identity, @org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, int audit, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, int collected, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, int fresh, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String niceShareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, long publishTime, int selfVisible, long shareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, int superChapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String superChapterName, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int itemType, int userId, int visible, int zan) {
        super();
    }
    
    public HomeArticleLocal() {
        super();
    }
    
    /**
     * ID
     */
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    /**
     * 文章的作者
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    /**
     * 文章领域的类型 ID
     */
    public final int component5() {
        return 0;
    }
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    /**
     * 注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true)
     */
    public final int component7() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    /**
     * 是否是最新的 (注: Sqlite 不支持 布尔类型，所以使用 0 (false) 1 (true))
     */
    public final int component11() {
        return 0;
    }
    
    /**
     * 文章链接
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    public final long component18() {
        return 0L;
    }
    
    public final int component19() {
        return 0;
    }
    
    /**
     * 分享时的时间戳
     */
    public final long component20() {
        return 0L;
    }
    
    /**
     * 分享文章的用户
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    /**
     * 所属的文章领域类型 ID
     */
    public final int component22() {
        return 0;
    }
    
    /**
     * 所属的文章领域类型 名称 (例如 跨平台)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    public final int component25() {
        return 0;
    }
    
    public final int component26() {
        return 0;
    }
    
    public final int component27() {
        return 0;
    }
    
    public final int component28() {
        return 0;
    }
    
    /**
     * 首页 文章 本地实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.database.room.entity.HomeArticleLocal copy(int identity, @org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, int audit, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, int collected, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, int fresh, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String niceShareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, long publishTime, int selfVisible, long shareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, int superChapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String superChapterName, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int itemType, int userId, int visible, int zan) {
        return null;
    }
    
    /**
     * 首页 文章 本地实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 首页 文章 本地实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 首页 文章 本地实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}