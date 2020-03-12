package com.shijingfeng.app.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ResourceUtils
import com.shijingfeng.app.R
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.util.d

/**
 * Function: app 模块 Fragment 基类
 * Date: 2020/2/2 22:31
 * Description:
 * @author ShiJingFeng
 */
abstract class AppBaseFragment<V : ViewDataBinding, VM : AppBaseViewModel<*>> : BaseFragment<V, VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("页面", "app 模块: " + this.javaClass.simpleName)
    }

    /**
     * 获取状态栏背景
     *
     * @return 背景 Drawable
     */
    override fun getStatusBarBackground(): Drawable? {
        return ResourceUtils.getDrawable(R.color.app_status_bar_default_color)
    }

}