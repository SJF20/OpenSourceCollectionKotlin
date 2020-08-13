package com.shijingfeng.base.interfaces

import android.view.KeyEvent

/**
 * Function: 模拟 Activity OnKeyDown
 * Date: 2020/3/21 21:19
 * Description:
 * @author ShiJingFeng
 */
internal interface KeyDownMonitor {

    /**
     * 模拟按键 按下监听 回调方法
     * @param keyCode 模拟按键 代码
     * @param event 事件
     * @return  true Fragment消费处理   false 交由Activity处理
     */
    fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean

}