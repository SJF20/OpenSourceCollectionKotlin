package com.shijingfeng.todo.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.mvvm.activity.BaseMvvmActivity
import com.shijingfeng.base.util.LOG_PAGE
import com.shijingfeng.base.util.d
import com.shijingfeng.todo.BuildConfig.MODULE_NAME
import com.shijingfeng.todo.R

/**
 * Function: todo模块 Activity 基类
 * Date: 2020/3/18 22:55
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class TodoBaseActivity<V : ViewDataBinding, VM : TodoBaseViewModel<*>> : BaseMvvmActivity<V, VM>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        d(LOG_PAGE, "$MODULE_NAME 模块 Activity: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        //Activity默认背景为白色
        mContentView.setBackgroundResource(R.color.white)
    }

}