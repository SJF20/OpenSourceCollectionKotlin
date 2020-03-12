package com.shijingfeng.base.listener

import android.view.View

/**
 * Function: 适配器事件监听器
 * Date: 2020/1/20 14:46
 * Description:
 * @author ShiJingFeng
 */
@FunctionalInterface
interface OnItemEventListener {

    /**
     * 事件回调方法
     * @param view 点击的View
     * @param data 数据
     * @param position 位置
     * @param flag 标志
     */
    fun onItemEvent(view: View? = null, data: Any? = null, position: Int = -1, flag: String)

}