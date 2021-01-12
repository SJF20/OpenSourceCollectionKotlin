package com.shijingfeng.weather.presenter

import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.weather.contract.DetailContract
import com.shijingfeng.weather.model.DetailModel

/**
 * Function: 天气详情 Presenter
 * Date: 2020/10/9 12:21
 * Description:
 * Author: ShiJingFeng
 */
internal class DetailPresenter(
    view: DetailContract.View
) : BasePresenter<DetailContract.View, DetailContract.Model>(
    view
), DetailContract.Presenter {

    /**
     * 创建 Model
     *
     * @return Model
     */
    override fun createModel() = DetailModel(this)

}