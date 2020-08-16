package com.shijingfeng.wan_android.entity.event;

import java.lang.System;

/**
 * Function: 文章收藏相关 Event
 * Date: 2020/2/3 19:56
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/shijingfeng/wan_android/entity/event/ArticleCollectionEvent;", "", "fromName", "", "id", "collected", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCollected", "()Z", "setCollected", "(Z)V", "getFromName", "()Ljava/lang/String;", "setFromName", "(Ljava/lang/String;)V", "getId", "setId", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "wan_android_debug"})
public final class ArticleCollectionEvent {
    
    /**
     * 发出 Event 的类的名称 (注意：是全限定类名称)
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fromName;
    
    /**
     * 文章 id
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id;
    
    /**
     * 是否收藏  true 收藏  false 取消收藏
     */
    private boolean collected;
    
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
     * 文章 id
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    /**
     * 文章 id
     */
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 是否收藏  true 收藏  false 取消收藏
     */
    public final boolean getCollected() {
        return false;
    }
    
    /**
     * 是否收藏  true 收藏  false 取消收藏
     */
    public final void setCollected(boolean p0) {
    }
    
    public ArticleCollectionEvent(@org.jetbrains.annotations.NotNull()
    java.lang.String fromName, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean collected) {
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
     * 文章 id
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 是否收藏  true 收藏  false 取消收藏
     */
    public final boolean component3() {
        return false;
    }
    
    /**
     * Function: 文章收藏相关 Event
     * Date: 2020/2/3 19:56
     * Description:
     * @author ShiJingFeng
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.wan_android.entity.event.ArticleCollectionEvent copy(@org.jetbrains.annotations.NotNull()
    java.lang.String fromName, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean collected) {
        return null;
    }
    
    /**
     * Function: 文章收藏相关 Event
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
     * Function: 文章收藏相关 Event
     * Date: 2020/2/3 19:56
     * Description:
     * @author ShiJingFeng
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 文章收藏相关 Event
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