package com.shijingfeng.background_service.manager;

import java.lang.System;

/**
 * Function: 下载管理器
 * Date: 2020/5/27 21:40
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\nJ*\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\rJ%\u0010\u0013\u001a\u00020\n2\u0016\u0010\u0014\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00160\u0015\"\u0004\u0018\u00010\u0016H\u0002\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/shijingfeng/background_service/manager/Downloader;", "", "builder", "Lcom/shijingfeng/background_service/manager/Downloader$Builder;", "(Lcom/shijingfeng/background_service/manager/Downloader$Builder;)V", "mFutureMap", "", "", "Ljava/util/concurrent/Future;", "cancel", "", "id", "mayInterruptIfRunning", "", "destory", "execute", "url", "filePath", "replace", "releaseResource", "closeables", "", "Ljava/io/Closeable;", "([Ljava/io/Closeable;)V", "Builder", "background_service_debug"})
public final class Downloader {
    
    /**
     * Future Map
     */
    private final java.util.Map<java.lang.String, java.util.concurrent.Future<java.lang.String>> mFutureMap = null;
    
    /**
     * 构建器
     */
    private final com.shijingfeng.background_service.manager.Downloader.Builder builder = null;
    
    /**
     * 执行下载任务
     *
     * @param id 本次下载任务的唯一ID
     * @param url 要下载的url
     * @param filePath 下载到的本地地址 (推荐使用应用程序私有目录，否则需要请求外部存储权限)
     * Android Q(10.0)严格限制外部存储，需要通过 MediaStore 或 SAF 或 使用兼容模式(以后会废弃)
     */
    public final void execute(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath, boolean replace) {
    }
    
    /**
     * 释放流资源
     * @param closeables
     */
    private final void releaseResource(java.io.Closeable... closeables) {
    }
    
    /**
     * 取消下载任务
     */
    public final void cancel(@org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean mayInterruptIfRunning) {
    }
    
    /**
     * 注意一定要在 onDestroy 中调用 destroy 否则会导致内存泄漏
     */
    public final void destory() {
    }
    
    private Downloader(com.shijingfeng.background_service.manager.Downloader.Builder builder) {
        super();
    }
    
    /**
     * 构建器
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010.\u001a\u00020/J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J@\u0010\u0014\u001a\u00020\u000028\u0010\t\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\nJY\u0010\u001d\u001a\u00020\u00002Q\u0010\u0016\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(0\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00110\u0017J@\u0010#\u001a\u00020\u000028\u0010\u001f\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00110\nJU\u0010)\u001a\u00020\u00002M\u0010$\u001aI\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u00110\u0017JB\u0010-\u001a\u00020\u00002:\u0010*\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u00110\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bRN\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015Rg\u0010\u0016\u001aO\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eRN\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015Rc\u0010$\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\'\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eRP\u0010*\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/shijingfeng/background_service/manager/Downloader$Builder;", "", "()V", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "setExecutorService", "(Ljava/util/concurrent/ExecutorService;)V", "onCancel", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "", "isCanceled", "", "getOnCancel", "()Lkotlin/jvm/functions/Function2;", "setOnCancel", "(Lkotlin/jvm/functions/Function2;)V", "onFailure", "Lkotlin/Function3;", "msg", "", "throwable", "getOnFailure", "()Lkotlin/jvm/functions/Function3;", "setOnFailure", "(Lkotlin/jvm/functions/Function3;)V", "onProgress", "", "progress", "getOnProgress", "setOnProgress", "onSize", "", "curSize", "totalSize", "getOnSize", "setOnSize", "onSuccess", "filePath", "getOnSuccess", "setOnSuccess", "build", "Lcom/shijingfeng/background_service/manager/Downloader;", "data", "background_service_debug"})
    public static final class Builder {
        
        /**
         * 下载线程执行器
         */
        @org.jetbrains.annotations.NotNull()
        private java.util.concurrent.ExecutorService executorService;
        
        /**
         * 下载进度 回调函数 [0, 100]
         */
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onProgress;
        
        /**
         * 下载大小进度 回调函数 [0, totalSize]
         */
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> onSize;
        
        /**
         * 下载成功 回调函数
         */
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSuccess;
        
        /**
         * 下载失败 回调函数
         */
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> onFailure;
        
        /**
         * 下载取消 回调函数  isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况
         */
        @org.jetbrains.annotations.Nullable()
        private kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onCancel;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.concurrent.ExecutorService getExecutorService() {
            return null;
        }
        
        public final void setExecutorService(@org.jetbrains.annotations.NotNull()
        java.util.concurrent.ExecutorService p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Integer, kotlin.Unit> getOnProgress() {
            return null;
        }
        
        public final void setOnProgress(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function3<java.lang.String, java.lang.Long, java.lang.Long, kotlin.Unit> getOnSize() {
            return null;
        }
        
        public final void setOnSize(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> getOnSuccess() {
            return null;
        }
        
        public final void setOnSuccess(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function3<java.lang.String, java.lang.String, java.lang.Throwable, kotlin.Unit> getOnFailure() {
            return null;
        }
        
        public final void setOnFailure(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final kotlin.jvm.functions.Function2<java.lang.String, java.lang.Boolean, kotlin.Unit> getOnCancel() {
            return null;
        }
        
        public final void setOnCancel(@org.jetbrains.annotations.Nullable()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> p0) {
        }
        
        /**
         * 设置 下载线程执行器
         * @param executorService 下载线程执行器
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader.Builder setExecutorService(@org.jetbrains.annotations.NotNull()
        java.util.concurrent.ExecutorService executorService) {
            return null;
        }
        
        /**
         * 设置 下载进度 回调函数 [0, 100]
         * @param onProgress 下载进度 回调函数 [0, 100]
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader.Builder setOnProgress(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> onProgress) {
            return null;
        }
        
        /**
         * 设置 下载大小进度 回调函数 [0, totalSize]
         * @param onSize 下载大小进度 回调函数 [0, totalSize]
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader.Builder setOnSize(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.Long, ? super java.lang.Long, kotlin.Unit> onSize) {
            return null;
        }
        
        /**
         * 设置 下载成功 回调函数
         * @param onSuccess 下载成功 回调函数
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader.Builder setOnSuccess(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSuccess) {
            return null;
        }
        
        /**
         * 设置 下载失败 回调函数
         * @param onFailure 下载失败 回调函数
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader.Builder setOnFailure(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.Throwable, kotlin.Unit> onFailure) {
            return null;
        }
        
        /**
         * 设置 下载取消 回调函数
         * @param onCancel 下载取消 回调函数 isCanceled:  true:已被取消  false:该任务已经完成, 未被取消, 或其他特殊情况
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader.Builder setOnCancel(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onCancel) {
            return null;
        }
        
        /**
         * 构建 DownloadManager
         */
        @org.jetbrains.annotations.NotNull()
        public final com.shijingfeng.background_service.manager.Downloader build() {
            return null;
        }
        
        public Builder() {
            super();
        }
    }
}