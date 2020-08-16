package com.shijingfeng.base.arouter.service;

import java.lang.System;

/**
 * Function: 登录拦截 Provider
 * Date: 2020/1/14 19:51
 * Description:
 *
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/shijingfeng/base/arouter/service/LoginInterceptProvider;", "Lcom/alibaba/android/arouter/facade/template/IProvider;", "process", "", "postcard", "Lcom/alibaba/android/arouter/facade/Postcard;", "callback", "Lcom/alibaba/android/arouter/facade/callback/InterceptorCallback;", "base_release"})
public abstract interface LoginInterceptProvider extends com.alibaba.android.arouter.facade.template.IProvider {
    
    /**
     * 登录拦截处理
     * @param postcard Postcard
     * @param callback InterceptorCallback
     */
    public abstract void process(@org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.Postcard postcard, @org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.callback.InterceptorCallback callback);
}