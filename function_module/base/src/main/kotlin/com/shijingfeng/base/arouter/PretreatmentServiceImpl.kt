package com.shijingfeng.base.arouter

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PretreatmentService
import com.shijingfeng.base.common.constant.FROM_ACTIVITY_NAME

/**
 * Function: 全局跳转前预处理 Service (项目中只允许有一个 PretreatmentService 子类, 否则执行最新加载的那一个)
 * Date: 2020/1/14 8:43
 * Description:
 *
 * Author: ShiJingFeng
 */
@Route(path = PROVIDER_BASE_COMMON_PRETREATMENT_SERVICE)
internal class PretreatmentServiceImpl : PretreatmentService {

    /**
     * 只初始化一次, 在 PretreatmentServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    override fun init(context: Context) {}

    /**
     * 在跳转前进行预处理
     * @param context Context (navigation(Context) 中的 Context )
     * @param postcard Postcard
     * @return true 不拦截跳转  false 拦截跳转, 自行跳转
     */
    override fun onPretreatment(
        context: Context?,
        postcard: Postcard
    ): Boolean {
        val bundle = postcard.extras

        if (bundle == null) {
            if (context != null && context is Activity) {
                postcard.with(Bundle().apply {
                    putString(FROM_ACTIVITY_NAME, context.javaClass.name)
                })
            }
        } else {
            val fromName = bundle.getString(FROM_ACTIVITY_NAME, "")

            if (context != null && context is Activity && TextUtils.isEmpty(fromName)) {
                bundle.putString(FROM_ACTIVITY_NAME, context.javaClass.name)
                postcard.with(bundle)
            }
        }
        return true
    }
}