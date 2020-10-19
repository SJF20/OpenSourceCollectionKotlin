package com.shijingfeng.todo

import android.content.Context
import com.shijingfeng.base.base.application.BaseApplication

/**
 * Function: todo模块 Application (只有设置为 application 单独调试时，才会调用)
 * Date: 2020/3/18 22:20
 * Description:
 * @author ShiJingFeng
 */
internal class TodoApplication : BaseApplication() {

    /**
     * 绑定Context, 先于 onCreate 执行
     */
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // 因为 SophixStubApplication 中调用了 MultiDex.install(this) 为了防止重复调用，故从 BaseApplication 移到此处
        // 初始化MultiDex   Android5.0(API 21)以上不需要了
//        MultiDex.install(this)
    }

}