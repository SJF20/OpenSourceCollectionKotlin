package com.shijingfeng.base.util.image_load;

import java.lang.System;

/**
 * Function: 自定义 Glide
 * Date: 2020/1/23 21:03
 * Description:
 * @author ShiJingFeng
 */
@com.bumptech.glide.annotation.GlideModule()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/base/util/image_load/CustomGlide;", "Lcom/bumptech/glide/module/AppGlideModule;", "()V", "applyOptions", "", "context", "Landroid/content/Context;", "builder", "Lcom/bumptech/glide/GlideBuilder;", "base_debug"})
public final class CustomGlide extends com.bumptech.glide.module.AppGlideModule {
    
    /**
     * 应用配置
     * @param context Context
     * @param builder GlideBuilder
     */
    @java.lang.Override()
    public void applyOptions(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.bumptech.glide.GlideBuilder builder) {
    }
    
    public CustomGlide() {
        super();
    }
}