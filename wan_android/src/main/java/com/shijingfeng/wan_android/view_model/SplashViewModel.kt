package com.shijingfeng.wan_android.view_model

import android.os.Bundle
import android.os.Handler
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_LOGIN
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_MAIN
import com.shijingfeng.base.base.repository.BaseRepository
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.wan_android.base.WanAndroidBaseViewModel
import com.shijingfeng.wan_android.constant.LOGIN_ACTIVITY_CAN_BACK
import com.shijingfeng.wan_android.constant.SKIP_TO_HOME
import com.shijingfeng.wan_android.utils.UserUtil

/**
 * Function: 启动页 ViewModel
 * Date: 2020/2/4 21:11
 * Description:
 * @author ShiJingFeng
 */
class SplashViewModel(
    repository: BaseRepository<*, *>? = null
) : WanAndroidBaseViewModel<BaseRepository<*, *>>(repository = repository) {

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        Handler().postDelayed({
            val bundle = Bundle()

            bundle.putBoolean(FINISH_PREVIOUS_ACTIVITY, true)

            //弹框检查是否更新
            if (UserUtil.isLogin()) {
                //跳转到首页
                navigation(path = ACTIVITY_WAN_ANDROID_MAIN, bundle = bundle)
            } else {
                //跳转到登录页面
                bundle.putBoolean(SKIP_TO_HOME, true)
                bundle.putBoolean(LOGIN_ACTIVITY_CAN_BACK, false)
                navigation(path = ACTIVITY_WAN_ANDROID_LOGIN, bundle = bundle)
            }
        }, 1500)
    }
}