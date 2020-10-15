package com.shijingfeng.weather.model

import com.shijingfeng.base.mvp.model.BaseModel
import com.shijingfeng.weather.contract.CityManageContract

/**
 * Function: 城市管理 Model
 * Date: 2020/10/12 11:00
 * Description:
 * @author ShiJingFeng
 */
internal class CityManageModel(
    presenter: CityManageContract.Presenter
) : BaseModel<CityManageContract.Presenter>(
    presenter
), CityManageContract.Model {



}