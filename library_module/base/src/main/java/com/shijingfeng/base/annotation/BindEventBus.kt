package com.shijingfeng.base.annotation

/**
 * Function: 用于标识是否绑定EventBus
 * Author: ShiJingFeng
 * Date: 2019/10/10 13:51
 * Description:
 * @author ShiJingFeng
 */
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindEventBus