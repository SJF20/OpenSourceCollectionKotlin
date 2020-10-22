package com.shijingfeng.weather.presenter

import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.model.CitySearchModel

/**
 * Function: 城市搜索 Presenter
 * Date: 2020/10/22 17:18
 * Description:
 * @author ShiJingFeng
 */
internal class CitySearchPresenter(
    view: CitySearchContract.View
) : BasePresenter<CitySearchContract.View, CitySearchContract.Model>(
    view
), CitySearchContract.Presenter {

    /**
     * 创建 Model
     *
     * @return Model
     */
    override fun createModel() = CitySearchModel(this)

}