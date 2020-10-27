package com.shijingfeng.weather.presenter

import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.entity.CitySearchEntity
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

    /**
     * 搜索
     *
     * @param keywords 搜索关键词
     * @param page 页码 (默认值是 1)
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    override fun search(
        keywords: String,
        page: Int,
        onSuccess: onSuccess<CitySearchEntity>,
        onFailure: onFailure
    ) {
        mModel?.search(keywords, page, onSuccess, onFailure)
    }

}