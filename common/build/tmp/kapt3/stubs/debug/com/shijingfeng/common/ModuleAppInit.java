package com.shijingfeng.common;

import java.lang.System;

/**
 * Function: 模块 Application初始化 (类名不要变化(反射的缘故), 除非包括其他模块全局更改类名为同一个 并在 base模块中更改反射类名)
 * Date: 2020/5/25 22:12
 * Description:
 * @author ShiJingFeng
 */
@androidx.annotation.Keep()
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/shijingfeng/common/ModuleAppInit;", "Lcom/shijingfeng/base/interfaces/AppInit;", "()V", "onCreate", "", "common_debug"})
public final class ModuleAppInit implements com.shijingfeng.base.interfaces.AppInit {
    
    /**
     * 初始化 (对应 Application OnCreate())
     */
    @java.lang.Override()
    public void onCreate() {
    }
    
    public ModuleAppInit() {
        super();
    }
    
    public int getPriority() {
        return 0;
    }
}