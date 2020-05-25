package com.shijingfeng.base.interfaces

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

}