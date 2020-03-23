package com.shijingfeng.base.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.alibaba.android.arouter.launcher.ARouter
import com.shijingfeng.base.arouter.service.LoginInterceptProvider
import com.shijingfeng.base.common.constant.GROUP_APP
import com.shijingfeng.base.common.constant.GROUP_WAN_ANDROID

/**
 * Function: 登录拦截器
 * Date: 2020/1/28 10:29
 * Description:
 * @author ShiJingFeng
 */
@Interceptor(priority = 1, name = "登录拦截")
internal class LoginInterceptor : IInterceptor {

    /**
     * 拦截器的初始化，会在 SDK 初始化的时候调用该方法，仅会调用一次
     * @param context Context
     */
    override fun init(context: Context) {}

    override fun process(postcard: Postcard, callback: InterceptorCallback) {
        val group = postcard.group
        val loginInterceptProvider: LoginInterceptProvider?

        when (group) {
            GROUP_APP ->
                //暂不拦截
                callback.onContinue(postcard)
            GROUP_WAN_ANDROID -> {
                loginInterceptProvider = ARouter.getInstance()
                    .build(PROVIDER_WAN_ANDROID_LOGIN_INTERCEPT)
                    .navigation() as? LoginInterceptProvider
                if (loginInterceptProvider != null) {
                    loginInterceptProvider.process(postcard, callback)
                } else {
                    callback.onContinue(postcard)
                }
            }
            else -> callback.onContinue(postcard)
        }
    }

}