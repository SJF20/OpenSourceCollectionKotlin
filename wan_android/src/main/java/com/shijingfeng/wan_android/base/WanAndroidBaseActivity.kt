package com.shijingfeng.wan_android.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.blankj.utilcode.util.ResourceUtils
import com.shijingfeng.base.base.activity.BaseActivity
import com.shijingfeng.base.util.d
import com.shijingfeng.wan_android.R

/**
 * Function: wan_android 模块 Activity 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
abstract class WanAndroidBaseActivity<V : ViewDataBinding, VM : WanAndroidBaseViewModel<*>> : BaseActivity<V, VM>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("页面", "wan_android 模块: " + this.javaClass.simpleName)
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
     * 获取状态栏背景
     *
     * @return 背景 Drawable
     */
    override fun getStatusBarBackground(): Drawable? = ResourceUtils.getDrawable(R.color.wan_android_status_bar_default_color)

}