package com.shijingfeng.skin_changer.listener

/**
 * Function: 皮肤切换 回调监听器
 * Date: 2020/7/23 12:33
 * Description:
 * @author ShiJingFeng
 */
interface SkinChangingListener {

    /**
     * 皮肤开始切换
     */
    fun onStart() {}

    /**
     * 皮肤切换失败
     */
    fun onError(e: Throwable?) {}

    /**
     * 皮肤切换成功
     */
    fun onCompleted() {}

}