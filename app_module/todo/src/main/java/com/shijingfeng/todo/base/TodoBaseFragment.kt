package com.shijingfeng.todo.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.base.fragment.BaseMvvmFragment
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.todo.R

/**
 * Function: todo模块 Fragment 基类
 * Date: 2020/3/18 22:59
 * Description:
 * @author ShiJingFeng
 */
internal abstract class TodoBaseFragment<V : ViewDataBinding, VM : TodoBaseViewModel<*>> : BaseMvvmFragment<V, VM>() {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "todo 模块: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

    /**
     * 获取 状态栏 背景资源 (支持换肤)
     */
    override fun getStatusBarBackgroundResource() = R.color.todo_theme_color

}