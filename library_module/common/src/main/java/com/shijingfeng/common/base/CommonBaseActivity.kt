package com.shijingfeng.common.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.shijingfeng.base.mvvm.activity.BaseMvvmActivity
import com.shijingfeng.base.util.d
import com.shijingfeng.common.R

/**
 * Function: common 模块 Activity 基类
 * Date: 2020/3/22 10:13
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class CommonBaseActivity<V : ViewDataBinding, VM : CommonBaseViewModel<*>> : BaseMvvmActivity<V, VM>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        d("页面", "common 模块: " + this.javaClass.simpleName)
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