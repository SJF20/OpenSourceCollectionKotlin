package com.shijingfeng.base.arouter;

import java.lang.System;

/**
 * Function: 全局降级 Service (项目中只允许有一个 DegradeService 子类, 否则执行最新加载的那一个)
 * Date: 2020/1/28 10:27
 * Description:
 * @author ShiJingFeng
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/base/provider/DegradeServiceImpl")
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/shijingfeng/base/arouter/DegradeServiceImpl;", "Lcom/alibaba/android/arouter/facade/service/DegradeService;", "()V", "init", "", "context", "Landroid/content/Context;", "onLost", "postcard", "Lcom/alibaba/android/arouter/facade/Postcard;", "base_debug"})
public final class DegradeServiceImpl implements com.alibaba.android.arouter.facade.service.DegradeService {
    
    /**
     * 只初始化一次, 在 DegradeServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    @java.lang.Override()
    public void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    /**
     * 没有发现要跳转的页面
     * @param context Context (navigation(Context) 中的 Context )
     * @param postcard Postcard
     */
    @java.lang.Override()
    public void onLost(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.alibaba.android.arouter.facade.Postcard postcard) {
    }
    
    public DegradeServiceImpl() {
        super();
    }
}