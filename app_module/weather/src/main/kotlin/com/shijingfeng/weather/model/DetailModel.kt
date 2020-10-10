package com.shijingfeng.weather.model

import com.shijingfeng.base.mvp.model.BaseModel
import com.shijingfeng.weather.contract.DetailContract

/**
 * Function: 天气详情 Model
 * Date: 2020/10/9 13:05
 * Description:
 * @author ShiJingFeng
 */
internal class DetailModel(
    presenter: DetailContract.Presenter
) : BaseModel<DetailContract.Presenter> (
    presenter
), DetailContract.Model {



}