package com.shijingfeng.base.arouter;

import java.lang.System;

/**
 * Function: 登录拦截器
 * Date: 2020/1/28 10:29
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Interceptor(priority = 1, name = "\u767b\u5f55\u62e6\u622a")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/base/arouter/LoginInterceptor;", "Lcom/alibaba/android/arouter/facade/template/IInterceptor;", "()V", "init", "", "context", "Landroid/content/Context;", "process", "postcard", "Lcom/alibaba/android/arouter/facade/Postcard;", "callback", "Lcom/alibaba/android/arouter/facade/callback/InterceptorCallback;", "base_debug"})
public final class LoginInterceptor implements com.alibaba.android.arouter.facade.template.IInterceptor {
    
    /**
     * 拦截器的初始化，会在 SDK 初始化的时候调用该方法，仅会调用一次
     * @param context Context
     */
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void process(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.Postcard postcard, @org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.callback.InterceptorCallback callback) {
    }
    
    public LoginInterceptor() {
        super();
    }
}