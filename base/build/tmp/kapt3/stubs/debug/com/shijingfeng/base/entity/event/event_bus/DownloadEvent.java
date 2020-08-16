package com.shijingfeng.base.entity.event.event_bus;

import java.lang.System;

/**
 * Function: 下载 Event
 * Author: ShiJingFeng
 * Date: 2019/11/24 22:27
 * Description: @JvmOverloads注解用于生成多个重载函数的java文件
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u00c6\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006\""}, d2 = {"Lcom/shijingfeng/base/entity/event/event_bus/DownloadEvent;", "", "currentLength", "", "totalLength", "done", "", "tag", "", "(JJZLjava/lang/String;)V", "getCurrentLength", "()J", "setCurrentLength", "(J)V", "getDone", "()Z", "setDone", "(Z)V", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getTotalLength", "setTotalLength", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "base_debug"})
public final class DownloadEvent {
    
    /**
     * 当前文件下载的大小
     */
    private long currentLength;
    
    /**
     * 总文件大小
     */
    private long totalLength;
    
    /**
     * 是否下载完成
     */
    private boolean done;
    
    /**
     * 用于多任务时的标记
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.String tag;
    
    /**
     * 当前文件下载的大小
     */
    public final long getCurrentLength() {
        return 0L;
    }
    
    /**
     * 当前文件下载的大小
     */
    public final void setCurrentLength(long p0) {
    }
    
    /**
     * 总文件大小
     */
    public final long getTotalLength() {
        return 0L;
    }
    
    /**
     * 总文件大小
     */
    public final void setTotalLength(long p0) {
    }
    
    /**
     * 是否下载完成
     */
    public final boolean getDone() {
        return false;
    }
    
    /**
     * 是否下载完成
     */
    public final void setDone(boolean p0) {
    }
    
    /**
     * 用于多任务时的标记
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTag() {
        return null;
    }
    
    /**
     * 用于多任务时的标记
     */
    public final void setTag(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public DownloadEvent(long currentLength, long totalLength, boolean done, @org.jetbrains.annotations.Nullable()
    java.lang.String tag) {
        super();
    }
    
    public DownloadEvent(long currentLength, long totalLength, boolean done) {
        super();
    }
    
    public DownloadEvent(long currentLength, long totalLength) {
        super();
    }
    
    /**
     * 当前文件下载的大小
     */
    public final long component1() {
        return 0L;
    }
    
    /**
     * 总文件大小
     */
    public final long component2() {
        return 0L;
    }
    
    /**
     * 是否下载完成
     */
    public final boolean component3() {
        return false;
    }
    
    /**
     * 用于多任务时的标记
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    /**
     * Function: 下载 Event
     * Author: ShiJingFeng
     * Date: 2019/11/24 22:27
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     */
    @org.jetbrains.annotations.NotNull()
    public final com.shijingfeng.base.entity.event.event_bus.DownloadEvent copy(long currentLength, long totalLength, boolean done, @org.jetbrains.annotations.Nullable()
    java.lang.String tag) {
        return null;
    }
    
    /**
     * Function: 下载 Event
     * Author: ShiJingFeng
     * Date: 2019/11/24 22:27
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Function: 下载 Event
     * Author: ShiJingFeng
     * Date: 2019/11/24 22:27
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Function: 下载 Event
     * Author: ShiJingFeng
     * Date: 2019/11/24 22:27
     * Description: @JvmOverloads注解用于生成多个重载函数的java文件
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}