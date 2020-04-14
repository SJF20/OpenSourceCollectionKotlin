package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.os.Handler
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel

/**
 * Function: 启动页 ViewModel
 * Date: 2020/2/4 21:11
 * Description:
 * @author ShiJingFeng
 */
internal class SplashViewModel(
    repository: BaseRepository<*, *>? = null
) : WanAndroidBaseViewModel<BaseRepository<*, *>>(repository = repository) {

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        Handler().postDelayed({
            //跳转到首页
            navigation(
                path = ACTIVITY_WAN_ANDROID_MAIN,
                bundle = Bundle().apply {
                    putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
                }
            )
        }, 1500)
    }
}