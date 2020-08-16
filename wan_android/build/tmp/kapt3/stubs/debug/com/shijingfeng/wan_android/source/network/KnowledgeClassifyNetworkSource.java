package com.shijingfeng.wan_android.source.network;

import java.lang.System;

/**
 * Function: 知识体系 一级数据 网络源
 * Date: 2020/4/21 20:32
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002Jl\u0010\u0005\u001a\u00020\u00062;\u0010\u0007\u001a7\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\bj\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t`\u000e2\'\u0010\u000f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\bj\u0002`\u0012J\b\u0010\u0013\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/shijingfeng/wan_android/source/network/KnowledgeClassifyNetworkSource;", "Lcom/shijingfeng/base/base/source/BaseNetworkSource;", "()V", "mClassifyApi", "Lcom/shijingfeng/wan_android/source/network/api/ClassifyApi;", "getKnowledgeClassifyList", "", "onSuccess", "Lkotlin/Function1;", "", "Lcom/shijingfeng/wan_android/entity/KnowledgeClassifyEntity;", "Lkotlin/ParameterName;", "name", "data", "Lcom/shijingfeng/base/common/extension/onSuccess;", "onFailure", "Lcom/shijingfeng/base/http/exception/E;", "e", "Lcom/shijingfeng/base/common/extension/onFailure;", "onCleared", "wan_android_debug"})
public final class KnowledgeClassifyNetworkSource extends com.shijingfeng.base.base.source.BaseNetworkSource {
    private final com.shijingfeng.wan_android.source.network.api.ClassifyApi mClassifyApi = null;
    
    /**
     * 获取　知识体系　一级数据　列表
     *
     * @param onSuccess 成功回调函数
     * @param onFailure 失败回调函数
     */
    public final void getKnowledgeClassifyList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<com.shijingfeng.wan_android.entity.KnowledgeClassifyEntity>, kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.shijingfeng.base.http.exception.E, kotlin.Unit> onFailure) {
    }
    
    /**
     * 清除数据
     */
    @java.lang.Override()
    public void onCleared() {
    }
    
    public KnowledgeClassifyNetworkSource() {
        super();
    }
}