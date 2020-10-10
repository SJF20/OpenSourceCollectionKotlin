package com.shijingfeng.weather.presenter

import android.os.Bundle
import com.shijingfeng.base.arouter.ACTIVITY_WEATHER_MAIN
import com.shijingfeng.base.arouter.navigation
import com.shijingfeng.base.common.constant.FINISH_PREVIOUS_ACTIVITY
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.base.mvp.presenter.IPresenter
import com.shijingfeng.weather.contract.SplashContract

/**
 * Function: 启动页 Presenter
 * Date: 2020/9/28 15:08
 * Description:
 * @author ShiJingFeng
 */
internal class SplashPresenter(
    view: SplashContract.View
) : BasePresenter<SplashContract.View, SplashContract.Model>(
    view
), SplashContract.Presenter {

    /**
     * 创建 Model
     *
     * @return Model
     */
    override fun createModel(): SplashContract.Model? = null

    /**
     * 初始化
     */
    override fun init() {
        super.init()
        runOnUiThread(1500) {
            //跳转到首页
            navigation(
                path = ACTIVITY_WEATHER_MAIN,
                bundle = Bundle().apply {
                    putBoolean(FINISH_PREVIOUS_ACTIVITY, true)
                }
            )
        }
    }

}