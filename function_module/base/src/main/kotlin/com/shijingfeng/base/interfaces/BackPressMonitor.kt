package com.shijingfeng.base.interfaces

/**
 * Function: 模拟 Activity OnBackPressed
 * Date: 2020/3/21 13:52
 * Description:
 * Author: ShiJingFeng
 */
internal interface BackPressMonitor {

    /**
     * 返回键点击 回调方法
     * @return true Fragment消费处理  false 交由Activity处理
     */
    fun onBackPressed(): Boolean

}