package com.shijingfeng.wan_android

import com.shijingfeng.base.interfaces.AppInit
import com.shijingfeng.base.util.e
import com.shijingfeng.wan_android.utils.checkTokenExpire

/**
 * Function: 模块 Application初始化 (类名不要变化(反射的缘故), 除非包括其他模块全局更改类名为同一个 并在 base模块中更改反射类名)
 * Date: 2020/5/25 22:12
 * Description:
 * @author ShiJingFeng
 */
internal class ModuleAppInit : AppInit {

    /**
     * 初始化 (对应 Application OnCreate())
     */
    override fun onCreate() {
        super.onCreate()
        e("开源集合", "wan_android ModuleAppInit onCreate")
        // 检查 玩安卓 Token 是否过期
        checkTokenExpire()
    }

}