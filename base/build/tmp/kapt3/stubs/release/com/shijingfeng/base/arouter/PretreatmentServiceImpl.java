package com.shijingfeng.base.arouter;

import java.lang.System;

/**
 * Function: 全局跳转前预处理 Service (项目中只允许有一个 PretreatmentService 子类, 否则执行最新加载的那一个)
 * Date: 2020/1/14 8:43
 * Description:
 *
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/base/provider/PretreatmentServiceImpl")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/base/arouter/PretreatmentServiceImpl;", "Lcom/alibaba/android/arouter/facade/service/PretreatmentService;", "()V", "init", "", "context", "Landroid/content/Context;", "onPretreatment", "", "postcard", "Lcom/alibaba/android/arouter/facade/Postcard;", "base_release"})
public final class PretreatmentServiceImpl implements com.alibaba.android.arouter.facade.service.PretreatmentService {
    
    /**
     * 只初始化一次, 在 PretreatmentServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * 在跳转前进行预处理
     * @param context Context (navigation(Context) 中的 Context )
     * @param postcard Postcard
     * @return true 不拦截跳转  false 拦截跳转, 自行跳转
     */
    @java.lang.Override()
    public boolean onPretreatment(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.Postcard postcard) {
        return false;
    }
    
    public PretreatmentServiceImpl() {
        super();
    }
}