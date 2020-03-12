package com.shijingfeng.wan_android.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.shijingfeng.base.arouter.ACTIVITY_WAN_ANDROID_LOGIN
import com.shijingfeng.base.arouter.PROVIDER_WAN_ANDROID_LOGIN_INTERCEPT
import com.shijingfeng.base.arouter.service.LoginInterceptProvider
import com.shijingfeng.base.common.constant.FROM_ACTIVITY_NAME
import com.shijingfeng.base.common.constant.NEED_LOGIN
import com.shijingfeng.wan_android.utils.UserUtil

/**
 * Function: wan_android 模块 登录拦截 Provider
 * Date: 2020/2/3 15:14
 * Description:
 * @author ShiJingFeng
 */
@Route(path = PROVIDER_WAN_ANDROID_LOGIN_INTERCEPT)
class WanAndroidLoginInterceptProvider : LoginInterceptProvider {

    /**
     * 只初始化一次, 在 DegradeServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    override fun init(context: Context) {}

    /**
     * 登录拦截处理
     * @param postcard Postcard
     * @param callback InterceptorCallback
     */
    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        postcard.extras?.let { bundle ->
            val needLogin = bundle.getBoolean(NEED_LOGIN, false)
            val fromName = bundle.getString(FROM_ACTIVITY_NAME, "")

            if (!UserUtil.isLogin() && needLogin) {
                ARouter.getInstance()
                    .build(ACTIVITY_WAN_ANDROID_LOGIN)
                    .withString(FROM_ACTIVITY_NAME, fromName)
                    .navigation()
                callback.onInterrupt(Exception("需要登录"))
            }
        }
        callback.onContinue(postcard)
    }
}