package com.shijingfeng.todo.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.base.activity.BaseMvvmActivity
import com.shijingfeng.base.util.d
import com.shijingfeng.base.util.getDrawableById
import com.shijingfeng.todo.R

/**
 * Function: todo模块 Activity 基类
 * Date: 2020/3/18 22:55
 * Description:
 * @author ShiJingFeng
 */
internal abstract class TodoBaseActivity<V : ViewDataBinding, VM : TodoBaseViewModel<*>> : BaseMvvmActivity<V, VM>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "todo 模块: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

    /**
     * 初始化数据
     */
    override fun initData() {
        super.initData()
        //Activity默认背景为白色
        getContentView().setBackgroundResource(R.color.white)
    }

    /**
     * 获取 状态栏 背景资源 (支持换肤)
     */
    override fun getStatusBarBackgroundResource() = R.color.todo_theme_color

}