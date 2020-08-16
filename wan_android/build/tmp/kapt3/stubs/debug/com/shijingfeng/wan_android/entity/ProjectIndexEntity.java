package com.shijingfeng.wan_android.entity;

import java.lang.System;

/**
 * Function: 项目 索引数据 实体类
 * Date: 20-4-29 下午8:43
 * Description:
 * @author shijingfeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0007H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\nH\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J_\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0001J\u0013\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000103H\u00d6\u0003J\b\u00104\u001a\u00020\u0003H\u0016J\t\u00105\u001a\u00020\u0007H\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b\'\u0010\u001f\u00a8\u00067"}, d2 = {"Lcom/shijingfeng/wan_android/entity/ProjectIndexEntity;", "Lcom/shijingfeng/base/base/entity/BaseEntity;", "courseId", "", "identity", "name", "order", "", "parentChapterId", "userControlSetTop", "", "visible", "children", "", "Lcom/shijingfeng/wan_android/entity/ProjectIndexChildren;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZILjava/util/List;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getCourseId", "()Ljava/lang/String;", "setCourseId", "(Ljava/lang/String;)V", "getIdentity", "setIdentity", "getName", "setName", "getOrder", "()I", "setOrder", "(I)V", "getParentChapterId", "setParentChapterId", "getUserControlSetTop", "()Z", "setUserControlSetTop", "(Z)V", "getVisible", "setVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "getId", "hashCode", "toString", "wan_android_debug"})
public final class ProjectIndexEntity extends com.shijingfeng.base.base.entity.BaseEntity {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "courseId")
    private java.lang.String courseId;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "id")
    private java.lang.String identity;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "name")
    private java.lang.String name;
    @com.google.gson.annotations.SerializedName(value = "order")
    private int order;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "parentChapterId")
    private java.lang.String parentChapterId;
    @com.google.gson.annotations.SerializedName(value = "userControlSetTop")
    private boolean userControlSetTop;
    @com.google.gson.annotations.SerializedName(value = "visible")
    private int visible;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "children")
    private java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexChildren> children;
    
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
    public final java.lang.String getCourseId() {
        return null;
    }
    
    public final void setCourseId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    public final int getOrder() {
        return 0;
    }
    
    public final void setOrder(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParentChapterId() {
        return null;
    }
    
    public final void setParentChapterId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getUserControlSetTop() {
        return false;
    }
    
    public final void setUserControlSetTop(boolean p0) {
    }
    
    public final int getVisible() {
        return 0;
    }
    
    public final void setVisible(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexChildren> getChildren() {
        return null;
    }
    
    public final void setChildren(@org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexChildren> p0) {
    }
    
    public ProjectIndexEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int order, @org.jetbrains.annotations.NotNull()
    java.lang.String parentChapterId, boolean userControlSetTop, int visible, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexChildren> children) {
        super();
    }
    
    public ProjectIndexEntity() {
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
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexChildren> component8() {
        return null;
    }
    
    /**
     * Function: 项目 索引数据 实体类
     * Date: 20-4-29 下午8:43
     * Description:
     * @author shijingfeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.ProjectIndexEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String courseId, @org.jetbrains.annotations.NotNull()
    java.lang.String identity, @org.jetbrains.annotations.NotNull()
    java.lang.String name, int order, @org.jetbrains.annotations.NotNull()
    java.lang.String parentChapterId, boolean userControlSetTop, int visible, @org.jetbrains.annotations.NotNull()
    java.util.List<com.shijingfeng.wan_android.entity.ProjectIndexChildren> children) {
        return null;
    }
    
    /**
     * Function: 项目 索引数据 实体类
     * Date: 20-4-29 下午8:43
     * Description:
     * @author shijingfeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 项目 索引数据 实体类
     * Date: 20-4-29 下午8:43
     * Description:
     * @author shijingfeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 项目 索引数据 实体类
     * Date: 20-4-29 下午8:43
     * Description:
     * @author shijingfeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}