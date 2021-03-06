package com.shijingfeng.app.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.app.BuildConfig.MODULE_NAME
import com.shijingfeng.base.mvvm.activity.BaseMvvmActivity
import com.shijingfeng.base.util.LOG_PAGE
import com.shijingfeng.base.util.d

/**
 * Function: app 模块 Activity 基类
 * Date: 2020/2/2 22:30
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class AppBaseActivity<V : ViewDataBinding, VM : AppBaseViewModel<*>> : BaseMvvmActivity<V, VM>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        d(LOG_PAGE, "$MODULE_NAME 模块 Activity: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

}