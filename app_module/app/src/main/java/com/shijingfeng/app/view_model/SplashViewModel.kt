package com.shijingfeng.app.view_model

import android.os.Bundle
import android.os.Handler
import com.shijingfeng.app.base.AppBaseViewModel
import com.shijingfeng.app.source.repository.SplashRepository
import com.shijingfeng.base.arouter.ACTIVITY_APP_MAIN
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.common.global.runOnUiThread

/**
 * Function: 启动页 ViewModel
 * Date: 2020/3/16 13:29
 * Description:
 * @author ShiJingFeng
 */
internal class SplashViewModel(
    repository: SplashRepository? = null
) : AppBaseViewModel<SplashRepository>(
    repository
) {

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
        runOnUiThread(1500) {
            //跳转到首页
            navigation(path = ACTIVITY_APP_MAIN, bundle = Bundle().apply {
                putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
            })
        }
    }

}