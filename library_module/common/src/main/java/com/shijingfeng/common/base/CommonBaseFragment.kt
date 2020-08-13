package com.shijingfeng.common.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.base.fragment.BaseMvvmFragment
import com.shijingfeng.base.util.d

/**
 * Function: app 模块 Fragment 基类
 * Date: 2020/2/2 22:31
 * Description:
 * @author ShiJingFeng
 */
internal abstract class CommonBaseFragment<V : ViewDataBinding, VM : CommonBaseViewModel<*>> : BaseMvvmFragment<V, VM>() {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "common 模块: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

}