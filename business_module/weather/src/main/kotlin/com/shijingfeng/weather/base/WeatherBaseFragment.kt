package com.shijingfeng.weather.base

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.shijingfeng.base.mvp.view.BaseMvpFragment
import com.shijingfeng.base.mvp.presenter.IPresenter
import com.shijingfeng.base.util.LOG_PAGE
import com.shijingfeng.base.util.d
import com.shijingfeng.weather.BuildConfig.MODULE_NAME

/**
 * Function: weather 模块 Fragment 基类
 * Date: 2020/2/3 14:22
 * Description:
 * Author: ShiJingFeng
 */
internal abstract class WeatherBaseFragment<V : ViewBinding, P : IPresenter> : BaseMvpFragment<V, P>() {

    /**
     * 因为有懒加载的缘故 子类初始化需要时重载init方法，禁止重载onViewCreated方法进行添加额外的初始化方法
     */
    override fun init(savedInstanceState: Bundle?) {
        d(LOG_PAGE, "$MODULE_NAME 模块 Fragment: " + this.javaClass.simpleName)
        super.init(savedInstanceState)
    }

}