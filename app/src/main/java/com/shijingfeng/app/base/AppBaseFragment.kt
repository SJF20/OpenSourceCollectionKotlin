package com.shijingfeng.app.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.app.R
import com.shijingfeng.base.base.fragment.BaseMvvmFragment
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getDrawableById

/**
 * Function: app 模块 Fragment 基类
 * Date: 2020/2/2 22:31
 * Description:
 * @author ShiJingFeng
 */
internal abstract class AppBaseFragment<V : ViewDataBinding, VM : AppBaseViewModel<*>> : BaseMvvmFragment<V, VM>() {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "app 模块: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

    /**
     * 获取状态栏背景
     *
     * @return 背景 Drawable
     */
    override fun getStatusBarBackground() = getDrawableById(R.color.app_status_bar_default_color)

}