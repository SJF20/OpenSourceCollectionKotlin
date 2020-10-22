package com.shijingfeng.weather.model

import com.shijingfeng.base.mvp.model.BaseModel
import com.shijingfeng.weather.contract.CitySearchContract

/**
 * Function: 城市搜索 Model
 * Date: 2020/10/22 17:16
 * Description:
 * @author ShiJingFeng
 */
internal class CitySearchModel(
    presenter: CitySearchContract.Presenter
) : BaseModel<CitySearchContract.Presenter>(
    presenter
), CitySearchContract.Model {



}