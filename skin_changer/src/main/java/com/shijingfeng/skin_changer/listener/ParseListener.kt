package com.shijingfeng.skin_changer.listener

import android.view.View

/**
 * Function: 解析监听器
 * Date: 2020/7/22 14:02
 * Description:
 * @author ShiJingFeng
 */
interface ParseListener {

    /**
     * 自定义解析处理
     *
     * @param view 当前解析的View
     * @param name 当前解析的名称
     * @return 自定义解析结果, 如果为 null, 则交给框架处理([name]对应的数据会一律按照资源名(String格式)处理)
     */
    fun onParse(view: View, name: String): Any?

}