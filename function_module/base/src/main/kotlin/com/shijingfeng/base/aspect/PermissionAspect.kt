package com.shijingfeng.base.aspect

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.shijingfeng.base.annotation.RequestPermissions
import com.shijingfeng.base.util.e
import com.tbruyelle.rxpermissions2.RxPermissions
/**
 * Function: 权限 AOP
 * Date: 2020/7/30 15:37
 * Description:
 * Author: ShiJingFeng
 */
//@Aspect
class PermissionAspect {

    /**
     * 切点
     * "*" 代表一个元素(注意是一个元素不是一个字符), ".." 代表多个元素, "+" 代表该类和所有子类
     * target是被代理对象, this是代理对象
     */
//    @Pointcut("""
//        execution(@com.shijingfeng.base.annotation.RequestPermissions * *(..))
//        && @annotation(requestPermissions)
//        && (target(androidx.fragment.app.FragmentActivity) || target(androidx.fragment.app.Fragment))
//    """)
    fun permissionPointCutMethod(requestPermissions: RequestPermissions?) {}

//    @SuppressLint("CheckResult")
//    @Around("permissionPointCutMethod(requestPermissions)")
//    fun permissionAroundMethod(joinPoint: ProceedingJoinPoint, requestPermissions: RequestPermissions?) {
//        try {
//            if (requestPermissions == null) {
//                joinPoint.proceed()
//                return
//            }
//            val permissions = requestPermissions.permissions
//            val activity = when (joinPoint.target) {
//                is FragmentActivity -> joinPoint.target as FragmentActivity
//                is Fragment -> (joinPoint.target as Fragment).activity!!
//                else -> return
//            }
//
//            if (!permissions.isNullOrEmpty()) {
//                RxPermissions(activity)
//                    .requestEachCombined(* permissions)
//                    .subscribe { permission ->
//                        if (permission.granted) {
//                            joinPoint.proceed()
//                        }
//                    }
//            } else {
//                joinPoint.proceed()
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            joinPoint.proceed()
//        }
//    }

}