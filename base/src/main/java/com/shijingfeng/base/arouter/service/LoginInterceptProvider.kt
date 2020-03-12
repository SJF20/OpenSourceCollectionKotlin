package com.shijingfeng.base.arouter.service

import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Function: 登录拦截 Provider
 * Date: 2020/1/14 19:51
 * Description:
 *
 * @author ShiJingFeng
 */
interface LoginInterceptProvider : IProvider {

    /**
     * 登录拦截处理
     * @param postcard Postcard
     * @param callback InterceptorCallback
     */
    fun process(postcard: Postcard, callback: InterceptorCallback)

}