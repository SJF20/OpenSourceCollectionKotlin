package com.shijingfeng.wan_android;

import java.lang.System;

/**
 * Sophix入口类，专门用于初始化Sophix，不应包含任何业务逻辑。
 * 此类必须继承自SophixApplication，onCreate方法不需要实现。
 * 此类不应与项目中的其他类有任何互相调用的逻辑，必须完全做到隔离。
 * AndroidManifest中设置Application为此类，而SophixEntry中设为原先Application类。
 * 注意原先Application里不需要再重复初始化Sophix，并且需要避免混淆原先Application类。
 * 如有其它自定义改造，请咨询官方后妥善处理。
 * <p>
 * 初始化接入改造4个步骤
 * 1. 把此SophixStubApplication入口类添加进项目中，所有Sophix相关初始化放在此类中。并且不应包含开发者的任何业务逻辑代码。 若使用了MultiDex，也应在SophixStubApplication的initSophix之前添加，并且需要记得在原来的Application里面去除MultiDex，避免重复调用导致问题。
 * 2. 把RealApplicationStub的SophixEntry注解的内容改为自己原先真正的MyRealApplication类。
 * 3. 混淆文件中确保某些内容不被混淆。
 * 4. AndroidManifest里面的application改为新增的SophixStubApplication入口类。
 * <p>
 * Date: 2020/7/17 12:18
 * Description:
 *
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/shijingfeng/wan_android/WanAndroidSophixStubApplication;", "Lcom/taobao/sophix/SophixApplication;", "()V", "TAG", "", "attachBaseContext", "", "base", "Landroid/content/Context;", "initSophix", "RealApplicationStub", "wan_android_release"})
public final class WanAndroidSophixStubApplication extends com.taobao.sophix.SophixApplication {
    
    /**
     * 阿里Sophix热修复日志标签
     */
    private final java.lang.String TAG = "Sophix";
    
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
    }
    
    /**
     * 初始化 Sophix
     */
    private final void initSophix() {
    }
    
    public WanAndroidSophixStubApplication() {
        super();
    }
    
    /**
     * 此处SophixEntry应指定真正的Application，并且保证RealApplicationStub类名不被混淆。
     */
    @androidx.annotation.Keep()
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/shijingfeng/wan_android/WanAndroidSophixStubApplication$RealApplicationStub;", "", "()V", "wan_android_release"})
    @com.taobao.sophix.SophixEntry(value = com.shijingfeng.wan_android.WanAndroidApplication.class)
    public static final class RealApplicationStub {
        
        public RealApplicationStub() {
            super();
        }
    }
}