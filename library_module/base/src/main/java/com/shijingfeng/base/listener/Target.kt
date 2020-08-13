package com.shijingfeng.base.listener

import android.graphics.drawable.Drawable

/**
 * Function: ImageLoader 加载回调接口
 * Date: 2020/1/22 20:17
 * Description:
 * @author ShiJingFeng
 */
interface Target<R> {

    /**
     * 加载开始
     * @param placeholder 加载中 占位符
     */
    fun onLoadStarted(placeholder: Drawable?) {}

    /**
     * 加载完成
     * @param resource 资源
     */
    fun onLoadFinished(resource: R?) {}

    /**
     * 加载失败
     * @param errorDrawable 加载错误 占位符
     */
    fun onLoadFailed(errorDrawable: Drawable?) {}

}