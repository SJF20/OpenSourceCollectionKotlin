package com.shijingfeng.apt_annotation

/** 优先级: 高 */
const val PRIORITY_HIGH = 0
/** 优先级: 中 */
const val PRIORITY_MEDIUM = 1
/** 优先级: 低 */
const val PRIORITY_LOW = 2

/**
 * Function: 全局模块事件分发
 * Date: 2020/11/29 15:58
 * Description:
 * @author ShiJingFeng
 */
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
annotation class ModuleDispatcher(

    /** 优先级 越小优先级越大 */
    val priority: Int = PRIORITY_MEDIUM

)