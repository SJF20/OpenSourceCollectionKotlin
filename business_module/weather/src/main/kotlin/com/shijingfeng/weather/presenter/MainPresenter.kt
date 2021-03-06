package com.shijingfeng.weather.presenter

import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.weather.contract.MainContract

/**
 * Function: 首页 Presenter
 * Date: 2020/9/29 10:43
 * Description:
 * Author: ShiJingFeng
 */
internal class MainPresenter(
    view: MainContract.View
) : BasePresenter<MainContract.View, MainContract.Model>(
    view,
), MainContract.Presenter {

    /**
     * 创建 Model
     *
     * @return Model
     */
    override fun createModel(): MainContract.Model? = null

}