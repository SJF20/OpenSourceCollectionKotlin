package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel

/**
 * Function: 启动页 ViewModel
 * Date: 2020/2/4 21:11
 * Description:
 * Author: ShiJingFeng
 */
internal class SplashViewModel : WanAndroidBaseViewModel<BaseRepository<*, *>>() {

    /**
     * 获取 Repository
     * @return Repository
     */
    override fun getRepository(): Nothing? = null

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        redirectToMain()
    }

    /**
     * 跳转到 首页
     */
    private fun redirectToMain() {
        runOnUiThread {
            //跳转到首页
            navigation(
                path = ACTIVITY_WAN_ANDROID_MAIN,
                bundle = Bundle().apply {
                    putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
                }
            )
        }
    }

}