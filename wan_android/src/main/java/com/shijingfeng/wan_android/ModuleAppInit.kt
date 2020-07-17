package com.shijingfeng.wan_android

import com.shijingfeng.base.base.application.BaseApplication
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.interfaces.AppInit
import com.shijingfeng.base.util.LOG_LIFECYCLE
import com.shijingfeng.base.util.e
import com.shijingfeng.wan_android.common.global.skinManager
import com.shijingfeng.wan_android.utils.checkTokenExpire
import com.zhy.changeskin.SkinManager

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
        e(LOG_LIFECYCLE, "wan_android ModuleAppInit onCreate")
        // 检查 玩安卓 Token 是否过期
        checkTokenExpire()
        // 初始化换肤框架
        initSkinManager()
    }

    /**
     * 初始化换肤框架
     */
    private fun initSkinManager() {
        skinManager.init(application)
    }

}