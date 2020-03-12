package com.shijingfeng.wan_android.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ResourceUtils
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.util.d
import com.shijingfeng.wan_android.R

/**
 * Function: wan_android 模块 Fragment 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
abstract class WanAndroidBaseFragment<V : ViewDataBinding, VM : WanAndroidBaseViewModel<*>> : BaseFragment<V, VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("页面", "wan_android 模块: " + this.javaClass.simpleName)
    }

    /**
     * 获取状态栏背景
     *
     * @return 背景 Drawable
     */
    override fun getStatusBarBackground(): Drawable? {
        return ResourceUtils.getDrawable(R.color.wan_android_status_bar_default_color)
    }

    /**
     * 滑动到顶部
     */
    open fun scrollToTop() {}

}