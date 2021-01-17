package com.shijingfeng.weather.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.shijingfeng.base.mvp.view.BaseMvpActivity
import com.shijingfeng.base.mvp.presenter.IPresenter
import com.shijingfeng.base.util.d

/**
 * Function: weather 模块 Activity 基类
 * Date: 2020/2/3 14:22
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class WeatherBaseActivity<V : ViewBinding, P : IPresenter> : BaseMvpActivity<V, P>() {

    /**
     * 初始化
     */
    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        d("页面", "weather 模块: " + this.javaClass.simpleName)
    }

}