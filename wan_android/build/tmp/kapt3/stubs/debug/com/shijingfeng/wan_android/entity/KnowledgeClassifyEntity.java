package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * 知识体系 实体类
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\bH\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J_\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0001J\u0013\u00101\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u000103H\u00d6\u0003J\b\u00104\u001a\u00020\u0003H\u0016J\t\u00105\u001a\u00020\bH\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b\'\u0010\u001f\u00a8\u00067"}, d2 = {"Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "identity", "", "name", "courseId", "parentChapterId", "order", "", "visible", "userControlSetTop", "", "childrenList", "", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyChildren;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZLjava/util/List;)V", "getChildrenList", "()Ljava/util/List;", "setChildrenList", "(Ljava/util/List;)V", "getCourseId", "()Ljava/lang/String;", "setCourseId", "(Ljava/lang/String;)V", "getIdentity", "setIdentity", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getParentChapterId", "setParentChapterId", "getUserControlSetTop", "()Z", "setUserControlSetTop", "(Z)V", "getVisible", "setVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "getId", "hashCode", "toString", "wan_android_debug"})
public final class KnowledgeClassifyEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "courseId")
    private java.lang.String courseId;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "parentChapterId")
    private java.lang.String parentChapterId;
    @com.google.gson.annotations.SerializedName(value = "order")
    private int order;
    @com.google.gson.annotations.SerializedName(value = "visible")
    private int visible;
    @com.google.gson.annotations.SerializedName(value = "userControlSetTop")
    private boolean userControlSetTop;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "children")
    private java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren> childrenList;
    
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
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCourseId() {
        return null;
    }
    
    public final void setCourseId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParentChapterId() {
        return null;
    }
    
    public final void setParentChapterId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getOrder() {
        return 0;
    }
    
    public final void setOrder(int p0) {
    }
    
    public final int getVisible() {
        return 0;
    }
    
    public final void setVisible(int p0) {
    }
    
    public final boolean getUserControlSetTop() {
        return false;
    }
    
    public final void setUserControlSetTop(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren> getChildrenList() {
        return null;
    }
    
    public final void setChildrenList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren> p0) {
    }
    
    public KnowledgeClassifyEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentChapterId, int order, int visible, boolean userControlSetTop, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren> childrenList) {
        super();
    }
    
    public KnowledgeClassifyEntity() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren> component8() {
        return null;
    }
    
    /**
     * 知识体系 实体类
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String parentChapterId, int order, int visible, boolean userControlSetTop, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyChildren> childrenList) {
        return null;
    }
    
    /**
     * 知识体系 实体类
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 知识体系 实体类
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 知识体系 实体类
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}