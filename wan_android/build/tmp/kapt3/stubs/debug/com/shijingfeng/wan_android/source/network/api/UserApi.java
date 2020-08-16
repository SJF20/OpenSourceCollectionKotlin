package com.shijingfeng.wan_android.source.network.api;

import java.lang.System;

/**
 * Function: 用户 Api
 * Date: 2020/2/4 16:17
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00030\nH\'J*\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\n2\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/api/UserApi;", "", "login", "Lcom/shijingfeng/wan_android/entity/ResultEntity;", "Lcom/shijingfeng/wan_android/entity/UserInfoEntity;", "postMap", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "Lio/reactivex/Single;", "register", "wan_android_debug"})
public abstract interface UserApi {
    
    /**
     * 登录 (使用协程)
     * @param postMap 数据
     * @return Single
     */
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "user/login")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.Object> postMap, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.UserInfoEntity>> p1);
    
    /**
     * 退出登录
     * @return Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "user/logout/json")
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<java.lang.Object>> logout();
    
    /**
     * 注册
     * @param postMap 数据
     * @return Single
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "user/register")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:wan_android"})
    public abstract io.reactivex.Single<com.shijingfeng.wan_android.entity.ResultEntity<com.shijingfeng.wan_android.entity.UserInfoEntity>> register(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.FieldMap()
    java.util.Map<java.lang.String, java.lang.Object> postMap);
}