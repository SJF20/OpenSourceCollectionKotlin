package com.shijingfeng.weather.presenter

import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.weather.contract.CityManageContract
import com.shijingfeng.weather.model.CityManageModel

/**
 * Function: 城市管理 Presenter
 * Date: 2020/10/12 11:03
 * Description:
 * Author: ShiJingFeng
 */
internal class CityManagePresenter(
    view: CityManageContract.View
) : BasePresenter<CityManageContract.View, CityManageContract.Model>(
    view
), CityManageContract.Presenter {

    /**
     * 创建 Model
     *
     * @return Model
     */
    override fun createModel() = CityManageModel(this)

}