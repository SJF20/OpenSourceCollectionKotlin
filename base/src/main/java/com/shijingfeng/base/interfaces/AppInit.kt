package com.shijingfeng.base.interfaces

import com.shijingfeng.base.annotation.define.AppInitPriority

/** 优先级: 高 */
const val HIGH = 0
/** 优先级: 中 */
const val MEDIUM = 1
/** 优先级: 低 */
const val LOW = 2

/**
 * Function: Application初始化 接口 (用于各个模块监听Application初始化)
 * Date: 2020/5/25 21:58
 * Description:
 * @author ShiJingFeng
 */
interface AppInit {

    /**
     * 初始化 (对应 Application OnCreate())
     */
    fun onCreate() {}

    /**
     * 设置优先级
     */
    @AppInitPriority
    fun getPriority() = MEDIUM

}