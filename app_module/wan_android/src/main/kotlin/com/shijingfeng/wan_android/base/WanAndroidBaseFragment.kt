package com.shijingfeng.wan_android.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.base.fragment.BaseMvvmFragment
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.wan_android.R
import com.shijingfeng.wan_android.common.global.skinChangerManager

/**
 * Function: wan_android 模块 Fragment 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
internal abstract class WanAndroidBaseFragment<V : ViewDataBinding, VM : WanAndroidBaseViewModel<*>> : BaseMvvmFragment<V, VM>() {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "wan_android 模块: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

    override fun initData() {
        super.initData()
        if (isEnableLazyLoad()) {
            skinChangerManager.update(this)
        }
    }

    /**
     * 获取 状态栏 背景资源 (支持换肤)
     */
    override fun getStatusBarBackgroundResource() = R.color.wan_android_theme_color

    /**
     * 滑动到顶部
     */
    open fun scrollToTop() {}

}