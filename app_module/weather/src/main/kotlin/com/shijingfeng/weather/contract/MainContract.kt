package com.shijingfeng.weather.contract

import com.shijingfeng.base.mvp.model.IModel
import com.shijingfeng.base.mvp.presenter.IPresenter
import com.shijingfeng.base.mvp.view.IView

/**
 * Function: 首页 契约类
 * Date: 2020/9/29 10:43
 * Description:
 * @author ShiJingFeng
 */
internal interface MainContract {

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