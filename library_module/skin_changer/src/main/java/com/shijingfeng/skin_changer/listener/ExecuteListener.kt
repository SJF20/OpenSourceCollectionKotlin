package com.shijingfeng.skin_changer.listener

import android.app.Activity
import android.view.View
import com.shijingfeng.skin_changer.entity.SkinAttribute

/**
 * Function: 主题资源开始更换监听器
 * Date: 2020/7/22 14:09
 * Description:
 * @author ShiJingFeng
 */
interface ExecuteListener {

    /**
     * 自定义处理主题资源更换逻辑
     *
     * @param view 当前解析的View
     * @param skinAttribute 当前解析的属性实体
     * @return true: 自定义处理  false: 框架处理
     */
    fun onExecute(view: View, skinAttribute: SkinAttribute): Boolean

}