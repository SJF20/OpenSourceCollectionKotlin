package com.shijingfeng.base.arouter

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.DegradeService
import com.blankj.utilcode.util.ToastUtils

/**
 * Function: 全局降级 Service (项目中只允许有一个 DegradeService 子类, 否则执行最新加载的那一个)
 * Date: 2020/1/28 10:27
 * Description:
 * @author ShiJingFeng
 */
@Route(path = PROVIDER_BASE_COMMON_DEGRADE_SERVICE)
internal class DegradeServiceImpl : DegradeService {

    /**
     * 只初始化一次, 在 DegradeServiceImpl 加载时初始化
     * @param context Context (navigation(Context) 中的 Context )
     */
    override fun init(context: Context) {}

    /**
     * 没有发现要跳转的页面
     * @param context Context (navigation(Context) 中的 Context )
     * @param postcard Postcard
     */
    override fun onLost(context: Context, postcard: Postcard) {
        ToastUtils.showShort("哎呀，页面打开失败！")
    }

}