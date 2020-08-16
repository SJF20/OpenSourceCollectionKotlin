package com.shijingfeng.wan_android.arouter;

import java.lang.System;

/**
 * Function: wan_android 模块 登录拦截 Provider
 * Date: 2020/2/3 15:14
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/wan_android/activity/LoginInterceptProvider")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/wan_android/arouter/WanAndroidLoginInterceptProvider;", "Lcom/shijingfeng/base/arouter/service/LoginInterceptProvider;", "()V", "init", "", "context", "Landroid/content/Context;", "process", "postcard", "Lcom/alibaba/android/arouter/facade/Postcard;", "callback", "Lcom/alibaba/android/arouter/facade/callback/InterceptorCallback;", "wan_android_debug"})
public final class WanAndroidLoginInterceptProvider implements com.shijingfeng.base.arouter.service.LoginInterceptProvider {
    
    /**
     * 只初始化一次, 在 DegradeServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * 登录拦截处理
     * @param postcard Postcard
     * @param callback InterceptorCallback
     */
    @java.lang.Override()
    public void process(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.Postcard postcard, @org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.callback.InterceptorCallback callback) {
    }
    
    public WanAndroidLoginInterceptProvider() {
        super();
    }
}