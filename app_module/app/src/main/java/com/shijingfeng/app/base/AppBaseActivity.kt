package com.shijingfeng.app.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.app.R
import com.shijingfeng.base.mvvm.activity.BaseMvvmActivity
import com.shijingfeng.base.util.d

/**
 * Function: app 模块 Activity 基类
 * Date: 2020/2/2 22:30
 * Description:
 * @author ShiJingFeng
 */
internal abstract class AppBaseActivity<V : ViewDataBinding, VM : AppBaseViewModel<*>> : BaseMvvmActivity<V, VM>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "app 模块: " + this.javaClass.simpleName)
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

}