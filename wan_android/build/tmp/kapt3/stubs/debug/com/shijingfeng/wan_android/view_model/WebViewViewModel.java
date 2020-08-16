package com.shijingfeng.wan_android.view_model;

import java.lang.System;

/**
 * Function: 通用 WebView ViewModel
 * Date: 2020/3/13 20:02
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/shijingfeng/wan_android/view_model/WebViewViewModel;", "Lcom/shijingfeng/wan_android/base/WanAndroidBaseViewModel;", "Lcom/shijingfeng/wan_android/source/repository/WebViewRepository;", "repository", "(Lcom/shijingfeng/wan_android/source/repository/WebViewRepository;)V", "mFromName", "", "getMFromName", "()Ljava/lang/String;", "setMFromName", "(Ljava/lang/String;)V", "mTitle", "getMTitle", "setMTitle", "mUrl", "getMUrl", "setMUrl", "collectedWebsite", "", "dataMap", "", "", "wan_android_debug"})
public final class WebViewViewModel extends com.shijingfeng.wan_android.base.WanAndroidBaseViewModel<com.shijingfeng.wan_android.source.repository.WebViewRepository> {
    
    /**
     * 上一个页面的全限定名称
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mFromName = "";
    
    /**
     * 加载的URL
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mUrl = "";
    
    /**
     * 标题
     */
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mTitle = "";
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFromName() {
        return null;
    }
    
    public final void setMFromName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMUrl() {
        return null;
    }
    
    public final void setMUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMTitle() {
        return null;
    }
    
    public final void setMTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * 收藏
     * @param dataMap 请求携带数据 (name, link)
     */
    public final void collectedWebsite(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> dataMap) {
    }
    
    public WebViewViewModel(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.wan_android.source.repository.WebViewRepository repository) {
        super(null);
    }
    
    public WebViewViewModel() {
        super(null);
    }
}