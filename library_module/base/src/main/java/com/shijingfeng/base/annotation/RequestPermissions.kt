package com.shijingfeng.base.annotation

/**
 * Function: 请求权限 注解
 * Date: 2020/7/31 12:42
 * Description:
 * @author ShiJingFeng
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequestPermissions (

    /** 你所申请的权限列表，例如 {@link android.Manifest.permission#READ_CONTACTS} */
    val permissions: Array<String> = []

)