package com.shijingfeng.todo.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.base.fragment.BaseFragment
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.todo.R

/**
 * Function: todo模块 Fragment 基类
 * Date: 2020/3/18 22:59
 * Description:
 * @author ShiJingFeng
 */
abstract class TodoBaseFragment<V : ViewDataBinding, VM : TodoBaseViewModel<*>> : BaseFragment<V, VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("页面", "todo 模块: " + this.javaClass.simpleName)
    }

    /**
     * 获取状态栏背景
     *
     * @return 背景 Drawable
     */
    override fun getStatusBarBackground() = getDrawableById(R.color.todo_status_bar_default_color)

}