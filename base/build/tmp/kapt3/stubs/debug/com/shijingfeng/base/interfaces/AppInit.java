package com.shijingfeng.base.interfaces;

import java.lang.System;

/**
 * Function: Application初始化 接口 (用于各个模块监听Application初始化)
 * Date: 2020/5/25 21:58
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/shijingfeng/base/interfaces/AppInit;", "", "getPriority", "", "onCreate", "", "base_debug"})
public abstract interface AppInit {
    
    /**
     * 初始化 (对应 Application OnCreate())
     */
    public abstract void onCreate();
    
    /**
     * 设置优先级
     */
    @com.shijingfeng.base.annotation.define.AppInitPriority()
    public abstract int getPriority();
    
    /**
     * Function: Application初始化 接口 (用于各个模块监听Application初始化)
     * Date: 2020/5/25 21:58
     * Description:
     * @author ShiJingFeng
     */
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        /**
         * 初始化 (对应 Application OnCreate())
         */
        public static void onCreate(com.shijingfeng.base.interfaces.AppInit $this) {
        }
        
        /**
         * 设置优先级
         */
        @com.shijingfeng.base.annotation.define.AppInitPriority()
        public static int getPriority(com.shijingfeng.base.interfaces.AppInit $this) {
            return 0;
        }
    }
}