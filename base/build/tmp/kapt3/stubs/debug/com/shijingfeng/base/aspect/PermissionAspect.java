package com.shijingfeng.base.aspect;

import java.lang.System;

/**
 * Function: 权限 AOP
 * Date: 2020/7/30 15:37
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/shijingfeng/base/aspect/PermissionAspect;", "", "()V", "permissionAroundMethod", "", "joinPoint", "Lorg/aspectj/lang/ProceedingJoinPoint;", "requestPermissions", "Lcom/shijingfeng/base/annotation/RequestPermissions;", "permissionPointCutMethod", "base_debug"})
@org.aspectj.lang.annotation.Aspect()
public final class PermissionAspect {
    
    /**
     * 切点
     * "*" 代表一个元素(注意是一个元素不是一个字符), ".." 代表多个元素, "+" 代表该类和所有子类
     * target是被代理对象, this是代理对象
     */
    @org.aspectj.lang.annotation.Pointcut(value = "\n        execution(@com.shijingfeng.base.annotation.RequestPermissions * *(..))\n        && @annotation(requestPermissions) \n        && (target(androidx.fragment.app.FragmentActivity) || target(androidx.fragment.app.Fragment))\n    ")
    public final void permissionPointCutMethod(@org.jetbrains.annotations.Nullable()
    com.shijingfeng.base.annotation.RequestPermissions requestPermissions) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @org.aspectj.lang.annotation.Around(value = "permissionPointCutMethod(requestPermissions)")
    public final void permissionAroundMethod(@org.jetbrains.annotations.NotNull()
    org.aspectj.lang.ProceedingJoinPoint joinPoint, @org.jetbrains.annotations.Nullable()
    com.shijingfeng.base.annotation.RequestPermissions requestPermissions) {
    }
    
    public PermissionAspect() {
        super();
    }
}