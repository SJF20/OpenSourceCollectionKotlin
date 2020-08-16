package com.shijingfeng.wan_android.entity.event;

import java.lang.System;

/**
 * Function: 网站收藏相关 Event
 * Date: 2020/2/3 19:56
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u00c6\u0003J5\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/shijingfeng/wan_android/entity/event/WebsiteCollectionEvent;", "", "fromName", "", "type", "", "id", "personalCollectionWebsite", "Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "(Ljava/lang/String;ILjava/lang/String;Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;)V", "getFromName", "()Ljava/lang/String;", "setFromName", "(Ljava/lang/String;)V", "getId", "setId", "getPersonalCollectionWebsite", "()Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;", "setPersonalCollectionWebsite", "(Lcom/shijingfeng/wan_android/entity/PersonalCollectionWebsiteEntity;)V", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "wan_android_debug"})
public final class WebsiteCollectionEvent {
    
    /**
     * 发出 Event 的类的名称 (注意：是全限定类名称)
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fromName;
    
    /**
     * 操作类型 [NONE] 无操作 [ADD] 收藏 [REMOVE] 取消收藏 [UPDATE] 更新收藏
     */
    private int type;
    
    /**
     * 网站 id (用于 取消收藏 使用)
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.String id;
    
    /**
     * 网站收藏 实体类 (用于 添加收藏, 更新收藏 使用)
     */
    @org.jetbrains.annotations.Nullable()
    private com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity personalCollectionWebsite;
    
    /**
     * 发出 Event 的类的名称 (注意：是全限定类名称)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFromName() {
        return null;
    }
    
    /**
     * 发出 Event 的类的名称 (注意：是全限定类名称)
     */
    public final void setFromName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 操作类型 [NONE] 无操作 [ADD] 收藏 [REMOVE] 取消收藏 [UPDATE] 更新收藏
     */
    public final int getType() {
        return 0;
    }
    
    /**
     * 操作类型 [NONE] 无操作 [ADD] 收藏 [REMOVE] 取消收藏 [UPDATE] 更新收藏
     */
    public final void setType(int p0) {
    }
    
    /**
     * 网站 id (用于 取消收藏 使用)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getId() {
        return null;
    }
    
    /**
     * 网站 id (用于 取消收藏 使用)
     */
    public final void setId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    /**
     * 网站收藏 实体类 (用于 添加收藏, 更新收藏 使用)
     */
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity getPersonalCollectionWebsite() {
        return null;
    }
    
    /**
     * 网站收藏 实体类 (用于 添加收藏, 更新收藏 使用)
     */
    public final void setPersonalCollectionWebsite(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity p0) {
    }
    
    public WebsiteCollectionEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String fromName, int type, @org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity personalCollectionWebsite) {
        super();
    }
    
    /**
     * 发出 Event 的类的名称 (注意：是全限定类名称)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    /**
     * 操作类型 [NONE] 无操作 [ADD] 收藏 [REMOVE] 取消收藏 [UPDATE] 更新收藏
     */
    public final int component2() {
        return 0;
    }
    
    /**
     * 网站 id (用于 取消收藏 使用)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    /**
     * 网站收藏 实体类 (用于 添加收藏, 更新收藏 使用)
     */
    @org.jetbrains.annotations.Nullable()
    public final com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity component4() {
        return null;
    }
    
    /**
     * Function: 网站收藏相关 Event
     * Date: 2020/2/3 19:56
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.event.WebsiteCollectionEvent copy(@org.jetbrains.annotations.NotNull()
    java.lang.String fromName, int type, @org.jetbrains.annotations.Nullable()
    java.lang.String id, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.entity.PersonalCollectionWebsiteEntity personalCollectionWebsite) {
        return null;
    }
    
    /**
     * Function: 网站收藏相关 Event
     * Date: 2020/2/3 19:56
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 网站收藏相关 Event
     * Date: 2020/2/3 19:56
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 网站收藏相关 Event
     * Date: 2020/2/3 19:56
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}