package com.shijingfeng.todo.entity;

import java.lang.System;

/**
 * 主页 -> 待办 分组后的 实体类 Item
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\rH\u00c6\u0003J\t\u0010/\u001a\u00020\rH\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\bH\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\bH\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\rH\u00c6\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u00c6\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<H\u00d6\u0003J\b\u0010=\u001a\u00020\u0003H\u0016J\t\u0010>\u001a\u00020\rH\u00d6\u0001J\t\u0010?\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001e\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001e\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001e\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0016\"\u0004\b,\u0010\u0018\u00a8\u0006@"}, d2 = {"Lcom/shijingfeng/todo/entity/MainTodoGroupItem;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "userId", "title", "content", "completeDate", "", "completeDateStr", "date", "dateStr", "status", "", "priority", "todoType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;III)V", "getCompleteDate", "()J", "setCompleteDate", "(J)V", "getCompleteDateStr", "()Ljava/lang/String;", "setCompleteDateStr", "(Ljava/lang/String;)V", "getContent", "setContent", "getDate", "setDate", "getDateStr", "setDateStr", "getIdentity", "setIdentity", "getPriority", "()I", "setPriority", "(I)V", "getStatus", "setStatus", "getTitle", "setTitle", "getTodoType", "setTodoType", "getUserId", "setUserId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getId", "hashCode", "toString", "todo_release"})
public final class MainTodoGroupItem extends com.shijingfeng.base.base.entity.BaseEntity {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "userId")
    private java.lang.String userId;
    
    /**
     * 标题
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "title")
    private java.lang.String title;
    
    /**
     * 内容
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "content")
    private java.lang.String content;
    
    /**
     * 完成日期
     */
    @com.google.gson.annotations.SerializedName(value = "completeDate")
    private long completeDate;
    
    /**
     * 完成日期字符串
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "completeDateStr")
    private java.lang.String completeDateStr;
    
    /**
     * 日期
     */
    @com.google.gson.annotations.SerializedName(value = "date")
    private long date;
    
    /**
     * 日期字符串
     */
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "dateStr")
    private java.lang.String dateStr;
    
    /**
     * 状态
     */
    @com.google.gson.annotations.SerializedName(value = "status")
    private int status;
    
    /**
     * 优先级
     */
    @com.google.gson.annotations.SerializedName(value = "id")
    private int priority;
    
    /**
     * 类型
     */
    @com.google.gson.annotations.SerializedName(value = "type")
    private int todoType;
    
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
    public final java.lang.String getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
     * 内容
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    /**
     * 内容
     */
    public final void setContent(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 完成日期
     */
    public final long getCompleteDate() {
        return 0L;
    }
    
    /**
     * 完成日期
     */
    public final void setCompleteDate(long p0) {
    }
    
    /**
     * 完成日期字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCompleteDateStr() {
        return null;
    }
    
    /**
     * 完成日期字符串
     */
    public final void setCompleteDateStr(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 日期
     */
    public final long getDate() {
        return 0L;
    }
    
    /**
     * 日期
     */
    public final void setDate(long p0) {
    }
    
    /**
     * 日期字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateStr() {
        return null;
    }
    
    /**
     * 日期字符串
     */
    public final void setDateStr(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 状态
     */
    public final int getStatus() {
        return 0;
    }
    
    /**
     * 状态
     */
    public final void setStatus(int p0) {
    }
    
    /**
     * 优先级
     */
    public final int getPriority() {
        return 0;
    }
    
    /**
     * 优先级
     */
    public final void setPriority(int p0) {
    }
    
    /**
     * 类型
     */
    public final int getTodoType() {
        return 0;
    }
    
    /**
     * 类型
     */
    public final void setTodoType(int p0) {
    }
    
    public MainTodoGroupItem(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, long completeDate, @org.jetbrains.annotations.NotNull()
    java.lang.String completeDateStr, long date, @org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, int status, int priority, int todoType) {
        super();
    }
    
    public MainTodoGroupItem() {
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
    
    /**
     * 标题
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    /**
     * 内容
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    /**
     * 完成日期
     */
    public final long component5() {
        return 0L;
    }
    
    /**
     * 完成日期字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    /**
     * 日期
     */
    public final long component7() {
        return 0L;
    }
    
    /**
     * 日期字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    /**
     * 状态
     */
    public final int component9() {
        return 0;
    }
    
    /**
     * 优先级
     */
    public final int component10() {
        return 0;
    }
    
    /**
     * 类型
     */
    public final int component11() {
        return 0;
    }
    
    /**
     * 主页 -> 待办 分组后的 实体类 Item
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.todo.entity.MainTodoGroupItem copy(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, long completeDate, @org.jetbrains.annotations.NotNull()
    java.lang.String completeDateStr, long date, @org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, int status, int priority, int todoType) {
        return null;
    }
    
    /**
     * 主页 -> 待办 分组后的 实体类 Item
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 主页 -> 待办 分组后的 实体类 Item
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 主页 -> 待办 分组后的 实体类 Item
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}