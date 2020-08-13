package com.shijingfeng.base.annotation

/**
 * Function: Activity或Fragment标记为需要申请权限
 * Author: ShiJingFeng
 * Date: 2019/11/15 13:50
 * Description:
 * @author ShiJingFeng
 */
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class NeedPermissions