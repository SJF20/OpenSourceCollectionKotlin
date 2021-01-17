package com.shijingfeng.weather.contract

import com.shijingfeng.base.mvp.model.IModel
import com.shijingfeng.base.mvp.presenter.IPresenter
import com.shijingfeng.base.mvp.view.IView

/**
 * Function: 天气详情 契约类
 * Date: 2020/10/9 12:19
 * Description:
 * Author: ShiJingFeng
 */
internal interface DetailContract {

    /**
     * View 层
     */
    interface View : IView {

    }

    /**
     * Presenter 层
     */
    interface Presenter : IPresenter {

    }

    /**
     * Model 层
     */
    interface Model : IModel {

    }

}