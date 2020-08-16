package com.shijingfeng.background_service.api;

import java.lang.System;

/**
 * Function: App 操作相关 Api
 * Date: 2020/5/23 23:28
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0007H\'\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/background_service/api/AppApi;", "", "getNewestAppInfoFromServer", "Lretrofit2/Call;", "Lcom/shijingfeng/background_service/entity/ResultEntity;", "Lcom/shijingfeng/background_service/entity/NewestAppInfoEntity;", "versionName", "", "appKey", "background_service_release"})
public abstract interface AppApi {
    
    /**
     * 从服务器上获取最新应用版本信息
     *
     * @param
     */
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "apiv2/app/check?_api_key=08fe4e02f5d37b158c2d0b25e9614e73")
    @retrofit2.http.FormUrlEncoded()
    @retrofit2.http.Headers(value = {"Domain-Name:payer"})
    public abstract retrofit2.Call<com.shijingfeng.background_service.entity.ResultEntity<com.shijingfeng.background_service.entity.NewestAppInfoEntity>> getNewestAppInfoFromServer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "buildVersion")
    java.lang.String versionName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "appKey")
    java.lang.String appKey);
    
    /**
     * Function: App 操作相关 Api
     * Date: 2020/5/23 23:28
     * Description:
     * @author ShiJingFeng
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
    }
}