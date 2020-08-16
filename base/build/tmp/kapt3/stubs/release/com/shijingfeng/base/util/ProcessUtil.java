package com.shijingfeng.base.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\n\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\n\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"getCurrentProcessName", "", "getCurrentProcessNameByAms", "getCurrentProcessNameByFile", "getCurrentProcessNameByReflect", "isMainProcess", "", "base_release"})
public final class ProcessUtil {
    
    /**
     * 是否运行在主进程
     */
    public static final boolean isMainProcess() {
        return false;
    }
    
    /**
     * 获取当前进程名
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentProcessName() {
        return null;
    }
    
    /**
     * 通过文件 获取当前进程名
     */
    private static final java.lang.String getCurrentProcessNameByFile() {
        return null;
    }
    
    /**
     * 通过 AMS 获取当前进程名
     */
    private static final java.lang.String getCurrentProcessNameByAms() {
        return null;
    }
    
    /**
     * 通过反射 获取当前进程名
     */
    private static final java.lang.String getCurrentProcessNameByReflect() {
        return null;
    }
}