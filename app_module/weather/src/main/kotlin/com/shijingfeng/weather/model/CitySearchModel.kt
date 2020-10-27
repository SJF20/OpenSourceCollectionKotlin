package com.shijingfeng.weather.model

import com.shijingfeng.base.common.constant.AMAP_SERVICE_KEY
import com.shijingfeng.base.common.extension.onFailure
import com.shijingfeng.base.common.extension.onSuccess
import com.shijingfeng.base.http.exception.E
import com.shijingfeng.base.http.exception.ServerException
import com.shijingfeng.base.http.exception.handle
import com.shijingfeng.base.mvp.model.BaseModel
import com.shijingfeng.base.util.RetrofitUtil
import com.shijingfeng.base.util.e
import com.shijingfeng.weather.api.CitySearchApi
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.entity.CitySearchEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

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

    private val mCitySearchApi = RetrofitUtil.create(CitySearchApi::class.java)

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
        addDisposable(
            mCitySearchApi
                .search(linkedMapOf<String, Any>().apply {
                    put("key", AMAP_SERVICE_KEY)
                    put("keywords", keywords)
                    put("subdistrict", 0)
                    put("page", page)
                    put("offset", 20)
                })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ citySearch ->
                    if ("1" == citySearch.status) {
                        onSuccess.invoke(citySearch)
                    } else {
                        onFailure.invoke(handle(ServerException(citySearch.infoCode.toInt(), citySearch.info)))
                    }
                }, { throwable ->
                    onFailure.invoke(handle(throwable))
                })
        )
    }

}