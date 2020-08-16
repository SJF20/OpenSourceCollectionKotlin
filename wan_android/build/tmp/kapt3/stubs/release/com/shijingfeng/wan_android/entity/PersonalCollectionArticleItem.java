package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * 我的收藏 -> 文章收藏列表 Item 实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b=\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u00a5\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0015J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0010H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0006H\u00c6\u0003J\t\u0010B\u001a\u00020\u0006H\u00c6\u0003J\t\u0010C\u001a\u00020\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0006H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0006H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\u00a9\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010PH\u00d6\u0003J\b\u0010Q\u001a\u00020\u0003H\u0016J\t\u0010R\u001a\u00020\u0006H\u00d6\u0001J\t\u0010S\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b\'\u0010\u0019R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001e\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\u001e\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001e\u0010\u0014\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001d\u00a8\u0006T"}, d2 = {"Lcom/shijingfeng/wan_android/entity/PersonalCollectionArticleItem;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "author", "chapterId", "", "chapterName", "courseId", "desc", "envelopePic", "link", "niceDate", "origin", "originId", "publishTime", "", "title", "userId", "visible", "zan", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;III)V", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "getChapterId", "()I", "setChapterId", "(I)V", "getChapterName", "setChapterName", "getCourseId", "setCourseId", "getDesc", "setDesc", "getEnvelopePic", "setEnvelopePic", "getIdentity", "setIdentity", "getLink", "setLink", "getNiceDate", "setNiceDate", "getOrigin", "setOrigin", "getOriginId", "setOriginId", "getPublishTime", "()J", "setPublishTime", "(J)V", "getTitle", "setTitle", "getUserId", "setUserId", "getVisible", "setVisible", "getZan", "setZan", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getId", "hashCode", "toString", "wan_android_release"})
public final class PersonalCollectionArticleItem extends com.shijingfeng.base.base.entity.BaseEntity {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    
    /**
     * 文章的作者
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "author")
    private java.lang.String author;
    
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
    @com.google.gson.annotations.SerializedName(value = "courseId")
    private int courseId;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "desc")
    private java.lang.String desc;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "envelopePic")
    private java.lang.String envelopePic;
    
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
    @com.google.gson.annotations.SerializedName(value = "origin")
    private java.lang.String origin;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "originId")
    private java.lang.String originId;
    @com.google.gson.annotations.SerializedName(value = "publishTime")
    private long publishTime;
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title")
    private java.lang.String title;
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
    public final java.lang.String getOrigin() {
        return null;
    }
    
    public final void setOrigin(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOriginId() {
        return null;
    }
    
    public final void setOriginId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final long getPublishTime() {
        return 0L;
    }
    
    public final void setPublishTime(long p0) {
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
    
    public PersonalCollectionArticleItem(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String originId, long publishTime, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int userId, int visible, int zan) {
        super();
    }
    
    public PersonalCollectionArticleItem() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * 文章的作者
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 文章领域的类型 ID
     */
    public final int component3() {
        return 0;
    }
    
    /**
     * 文章领域的类型 名称 (例如 Flutter)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    /**
     * 文章链接
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    /**
     * 文章标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final int component14() {
        return 0;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int component16() {
        return 0;
    }
    
    /**
     * 我的收藏 -> 文章收藏列表 Item 实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.PersonalCollectionArticleItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String author, int chapterId, @org.jetbrains.annotations.NotNull()
    java.lang.String chapterName, int courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String desc, @org.jetbrains.annotations.NotNull()
    java.lang.String envelopePic, @org.jetbrains.annotations.NotNull()
    java.lang.String link, @org.jetbrains.annotations.NotNull()
    java.lang.String niceDate, @org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    java.lang.String originId, long publishTime, @org.jetbrains.annotations.NotNull()
    java.lang.String title, int userId, int visible, int zan) {
        return null;
    }
    
    /**
     * 我的收藏 -> 文章收藏列表 Item 实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 我的收藏 -> 文章收藏列表 Item 实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 我的收藏 -> 文章收藏列表 Item 实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}