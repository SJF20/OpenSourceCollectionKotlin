package com.shijingfeng.todo.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.mvvm.fragment.BaseMvvmFragment
import com.shijingfeng.base.util.LOG_PAGE
import com.shijingfeng.base.util.d
import com.shijingfeng.todo.BuildConfig.MODULE_NAME

/**
 * Function: todo模块 Fragment 基类
 * Date: 2020/3/18 22:59
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class TodoBaseFragment<V : ViewDataBinding, VM : TodoBaseViewModel<*>> : BaseMvvmFragment<V, VM>() {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d(LOG_PAGE, "$MODULE_NAME 模块 Fragment: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

}