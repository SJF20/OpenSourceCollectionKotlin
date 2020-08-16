package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * 公众号 二级数据 Item 实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bp\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u00c1\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\'J\t\u0010p\u001a\u00020\u0003H\u00c6\u0003J\t\u0010q\u001a\u00020\u0003H\u00c6\u0003J\t\u0010r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010s\u001a\u00020\u0003H\u00c6\u0003J\t\u0010t\u001a\u00020\tH\u00c6\u0003J\t\u0010u\u001a\u00020\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\u0003H\u00c6\u0003J\t\u0010w\u001a\u00020\u0003H\u00c6\u0003J\t\u0010x\u001a\u00020\u0003H\u00c6\u0003J\t\u0010y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010{\u001a\u00020\u0003H\u00c6\u0003J\t\u0010|\u001a\u00020\u0019H\u00c6\u0003J\t\u0010}\u001a\u00020\u0006H\u00c6\u0003J\t\u0010~\u001a\u00020\u0019H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0082\u0001\u001a\b\u0012\u0004\u0012\u00020!0 H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0088\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008a\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0006H\u00c6\u0003J\n\u0010\u008c\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u008d\u0001\u001a\u00020\tH\u00c6\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0006H\u00c6\u0003J\u00c6\u0002\u0010\u008f\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00032\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u0006H\u00c6\u0001J\u0016\u0010\u0090\u0001\u001a\u00020\t2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001H\u00d6\u0003J\t\u0010\u0093\u0001\u001a\u00020\u0003H\u0016J\n\u0010\u0094\u0001\u001a\u00020\u0006H\u00d6\u0001J\n\u0010\u0095\u0001\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010-\"\u0004\b7\u0010/R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010)\"\u0004\b9\u0010+R\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u001e\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010-\"\u0004\b=\u0010/R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+R\u001e\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010)\"\u0004\bA\u0010+R\u001e\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R\u001e\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u00103\"\u0004\bE\u00105R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001e\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010-\"\u0004\bI\u0010/R\u001e\u0010\u0012\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010)\"\u0004\bK\u0010+R\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010)\"\u0004\bO\u0010+R\u001e\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010)\"\u0004\bQ\u0010+R\u001e\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010)\"\u0004\bS\u0010+R\u001e\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010)\"\u0004\bU\u0010+R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001e\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010-\"\u0004\b[\u0010/R\u001e\u0010\u001b\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010YR\u001e\u0010\u001c\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010)\"\u0004\b_\u0010+R\u001e\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010-\"\u0004\ba\u0010/R\u001e\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010)\"\u0004\bc\u0010+R$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001e\u0010\"\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010)\"\u0004\bi\u0010+R\u001e\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010-\"\u0004\bk\u0010/R\u001e\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010-\"\u0004\bm\u0010/R\u001e\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010-\"\u0004\bo\u0010/\u00a8\u0006\u0096\u0001"}, d2 = {"Lcom/shijingfeng/wan_android/entity/OfficialAccountChildItem;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "apkLink", "audit", "", "author", "canEdit", "", "chapterId", "chapterName", "collected", "courseId", "desc", "descMd", "envelopePic", "fresh", "link", "niceDate", "niceShareDate", "origin", "prefix", "projectLink", "publishTime", "", "selfVisible", "shareDate", "shareUser", "superChapterId", "superChapterName", "tagList", "", "Lcom/shijingfeng/wan_android/entity/OfficialAccountChildTag;", "title", "itemType", "userId", "visible", "zan", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZILjava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIJLjava/lang/String;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;IIII)V", "getApkLink", "()Ljava/lang/String;", "setApkLink", "(Ljava/lang/String;)V", "getAudit", "()I", "setAudit", "(I)V", "getAuthor", "setAuthor", "getCanEdit", "()Z", "setCanEdit", "(Z)V", "getChapterId", "setChapterId", "getChapterName", "setChapterName", "getCollected", "setCollected", "getCourseId", "setCourseId", "getDesc", "setDesc", "getDescMd", "setDescMd", "getEnvelopePic", "setEnvelopePic", "getFresh", "setFresh", "getIdentity", "setIdentity", "getItemType", "setItemType", "getLink", "setLink", "getNiceDate", "setNiceDate", "getNiceShareDate", "setNiceShareDate", "getOrigin", "setOrigin", "getPrefix", "setPrefix", "getProjectLink", "setProjectLink", "getPublishTime", "()J", "setPublishTime", "(J)V", "getSelfVisible", "setSelfVisible", "getShareDate", "setShareDate", "getShareUser", "setShareUser", "getSuperChapterId", "setSuperChapterId", "getSuperChapterName", "setSuperChapterName", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "getTitle", "setTitle", "getUserId", "setUserId", "getVisible", "setVisible", "getZan", "setZan", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "getId", "hashCode", "toString", "wan_android_debug"})
public final class OfficialAccountChildItem extends com.shijingfeng.base.base.entity.BaseEntity {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "apkLink")
    private java.lang.String apkLink;
    @com.google.gson.annotations.SerializedName(value = "audit")
    private int audit;
    
    /**
     * 文章的作者
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "author")
    private java.lang.String author;
    
    /**
     * 是否可编辑
     */
    @com.google.gson.annotations.SerializedName(value = "canEdit")
    private boolean canEdit;
    
    /**
     * 文章领域的类型 ID
     */
    @com.google.gson.annotations.SerializedName(value = "chapterId")
    private int chapterId;
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "chapterName")
    private java.lang.String chapterName;
    @com.google.gson.annotations.SerializedName(value = "collect")
    private boolean collected;
    @com.google.gson.annotations.SerializedName(value = "courseId")
    private int courseId;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "desc")
    private java.lang.String desc;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "descMd")
    private java.lang.String descMd;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "envelopePic")
    private java.lang.String envelopePic;
    
    /**
     * 是否是最新的
     */
    @com.google.gson.annotations.SerializedName(value = "fresh")
    private boolean fresh;
    
    /**
     * 文章链接
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "link")
    private java.lang.String link;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "niceDate")
    private java.lang.String niceDate;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "niceShareDate")
    private java.lang.String niceShareDate;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "origin")
    private java.lang.String origin;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "prefix")
    private java.lang.String prefix;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "projectLink")
    private java.lang.String projectLink;
    @com.google.gson.annotations.SerializedName(value = "publishTime")
    private long publishTime;
    @com.google.gson.annotations.SerializedName(value = "selfVisible")
    private int selfVisible;
    
    /**
     * 分享时的时间戳
     */
    @com.google.gson.annotations.SerializedName(value = "shareDate")
    private long shareDate;
    
    /**
     * 分享文章的用户
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "shareUser")
    private java.lang.String shareUser;
    
    /**
     * 所属的文章领域类型 ID
     */
    @com.google.gson.annotations.SerializedName(value = "superChapterId")
    private int superChapterId;
    
    /**
     * 所属的文章领域类型 名称 (例如 跨平台)
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "superChapterName")
    private java.lang.String superChapterName;
    
    /**
     * 标签列表 (例如: 问答, 导航, 公众号)
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "tags")
    private java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountChildTag> tagList;
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title")
    private java.lang.String title;
    @com.google.gson.annotations.SerializedName(value = "type")
    private int itemType;
    @com.google.gson.annotations.SerializedName(value = "userId")
    private int userId;
    @com.google.gson.annotations.SerializedName(value = "visible")
    private int visible;
    @com.google.gson.annotations.SerializedName(value = "zan")
    private int zan;
    
    /**
     * 获取ID
     * @return ID
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIdentity() {
        return null;
    }
    
    public final void setIdentity(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
     * 是否可编辑
     */
    public final boolean getCanEdit() {
        return false;
    }
    
    /**
     * 是否可编辑
     */
    public final void setCanEdit(boolean p0) {
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
    
    public final boolean getCollected() {
        return false;
    }
    
    public final void setCollected(boolean p0) {
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
    public final java.lang.String getDescMd() {
        return null;
    }
    
    public final void setDescMd(@org.jetbrains.annotations.NotNull()
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
     * 是否是最新的
     */
    public final boolean getFresh() {
        return false;
    }
    
    /**
     * 是否是最新的
     */
    public final void setFresh(boolean p0) {
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
     * 标签列表 (例如: 问答, 导航, 公众号)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountChildTag> getTagList() {
        return null;
    }
    
    /**
     * 标签列表 (例如: 问答, 导航, 公众号)
     */
    public final void setTagList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountChildTag> p0) {
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
    
    public OfficialAccountChildItem(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, int audit, @org.jetbrains.annotations.NotNull()
    java.lang.String author, boolean canEdit, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, boolean collected, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String descMd, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, boolean fresh, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String niceShareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, long publishTime, int selfVisible, long shareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, int superChapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String superChapterName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountChildTag> tagList, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int itemType, int userId, int visible, int zan) {
        super();
    }
    
    public OfficialAccountChildItem() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
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
     * 是否可编辑
     */
    public final boolean component5() {
        return false;
    }
    
    /**
     * 文章领域的类型 ID
     */
    public final int component6() {
        return 0;
    }
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    /**
     * 是否是最新的
     */
    public final boolean component13() {
        return false;
    }
    
    /**
     * 文章链接
     */
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    public final long component20() {
        return 0L;
    }
    
    public final int component21() {
        return 0;
    }
    
    /**
     * 分享时的时间戳
     */
    public final long component22() {
        return 0L;
    }
    
    /**
     * 分享文章的用户
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    /**
     * 所属的文章领域类型 ID
     */
    public final int component24() {
        return 0;
    }
    
    /**
     * 所属的文章领域类型 名称 (例如 跨平台)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component25() {
        return null;
    }
    
    /**
     * 标签列表 (例如: 问答, 导航, 公众号)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountChildTag> component26() {
        return null;
    }
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    public final int component28() {
        return 0;
    }
    
    public final int component29() {
        return 0;
    }
    
    public final int component30() {
        return 0;
    }
    
    public final int component31() {
        return 0;
    }
    
    /**
     * 公众号 二级数据 Item 实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.OfficialAccountChildItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String apkLink, int audit, @org.jetbrains.annotations.NotNull()
    java.lang.String author, boolean canEdit, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, boolean collected, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String descMd, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, boolean fresh, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String niceShareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String prefix, @org.jetbrains.annotations.NotNull()
    java.lang.String projectLink, long publishTime, int selfVisible, long shareDate, @org.jetbrains.annotations.NotNull()
    java.lang.String shareUser, int superChapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String superChapterName, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.OfficialAccountChildTag> tagList, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int itemType, int userId, int visible, int zan) {
        return null;
    }
    
    /**
     * 公众号 二级数据 Item 实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 公众号 二级数据 Item 实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 公众号 二级数据 Item 实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}