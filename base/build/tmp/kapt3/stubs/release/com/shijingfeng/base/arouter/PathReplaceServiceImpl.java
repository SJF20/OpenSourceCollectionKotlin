package com.shijingfeng.base.arouter;

import java.lang.System;

/**
 * Function: 全局路径替换 Service (项目中只允许有一个 PathReplaceService 子类, 否则执行最新加载的那一个)
 * Date: 2020/1/13 11:56
 * Description:
 *
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/base/provider/PathReplaceServiceImpl")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/shijingfeng/base/arouter/PathReplaceServiceImpl;", "Lcom/alibaba/android/arouter/facade/service/PathReplaceService;", "()V", "mPathMap", "", "", "mUriPathMap", "Landroid/net/Uri;", "pathMap", "", "getPathMap", "()Ljava/util/Map;", "uriPathMap", "getUriPathMap", "forString", "path", "forUri", "uri", "init", "", "context", "Landroid/content/Context;", "replacePath", "oldPath", "newPath", "replaceUriPath", "oldUri", "newUri", "base_release"})
public final class PathReplaceServiceImpl implements com.alibaba.android.arouter.facade.service.PathReplaceService {
    
    /**
     * Key(String): 替换前的路径  Value(String): 替换后的路径
     */
    private final java.util.Map<java.lang.String, java.lang.String> mPathMap = null;
    
    /**
     * Key(String): 替换前的 URI 路径  Value(String): 替换后的 URI 路径
     */
    private final java.util.Map<android.net.Uri, android.net.Uri> mUriPathMap = null;
    
    /**
     * 只初始化一次, 在 PathReplaceServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String forString(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.net.Uri forUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    /**
     * 替换路径
     * @param oldPath 旧路径
     * @param newPath 新路径
     */
    public final void replacePath(@org.jetbrains.annotations.NotNull()
    java.lang.String oldPath, @org.jetbrains.annotations.NotNull()
    java.lang.String newPath) {
    }
    
    /**
     * 替换 URI 路径
     * @param oldUri 旧的 URI 路径
     * @param newUri 新的 URI 路径
     */
    public final void replaceUriPath(@org.jetbrains.annotations.NotNull()
    android.net.Uri oldUri, @org.jetbrains.annotations.NotNull()
    android.net.Uri newUri) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getPathMap() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<android.net.Uri, android.net.Uri> getUriPathMap() {
        return null;
    }
    
    public PathReplaceServiceImpl() {
        super();
    }
}