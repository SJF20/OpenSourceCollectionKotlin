package com.shijingfeng.weather.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.shijingfeng.base.mvp.view.BaseMvpActivity
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.base.util.d
import com.shijingfeng.weather.R

/**
 * Function: weather 模块 Activity 基类
 * Date: 2020/2/3 14:22
 * Description:
 * @author ShiJingFeng
 */
internal abstract class WeatherBaseActivity<V : ViewBinding, P : BasePresenter> : BaseMvpActivity<V, P>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        d("页面", "weather 模块: " + this.javaClass.simpleName)
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