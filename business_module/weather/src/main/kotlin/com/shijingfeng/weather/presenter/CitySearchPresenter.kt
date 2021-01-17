package com.shijingfeng.weather.presenter

import com.google.gson.JsonPrimitive
import com.shijingfeng.network.extension.onFailure
import com.shijingfeng.network.extension.onSuccess
import com.shijingfeng.base.mvp.presenter.BasePresenter
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.weather.R
import com.shijingfeng.weather.contract.CitySearchContract
import com.shijingfeng.weather.entity.CityDataItem
import com.shijingfeng.weather.entity.CitySearchEntity
import com.shijingfeng.weather.entity.CitySearchInfoEntity
import com.shijingfeng.weather.entity.Weather
import com.shijingfeng.weather.model.CitySearchModel

/**
 * Function: 城市搜索 Presenter
 * Date: 2020/10/22 17:18
 * Description:
 * Author: ShiJingFeng
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
     * 获取热门城市数据
     *
     * @param cityName 城市名称
     */
    override fun getHotCityData(
        cityName: String
    ) = when (cityName) {
        getStringById(R.string.北京市) -> CitySearchInfoEntity(
            adCode = "110100",
            centerJsonElement = JsonPrimitive("116.405285,39.904989"),
            level = "city",
            cityName = "北京城区",
            cityFullName = "北京市",
        )
        getStringById(R.string.上海市) -> CitySearchInfoEntity(
            adCode = "310100",
            centerJsonElement = JsonPrimitive("121.472644,31.231706"),
            level = "city",
            cityName = "上海城区",
            cityFullName = "上海市",
        )
        getStringById(R.string.广州市) -> CitySearchInfoEntity(
            adCode = "440100",
            centerJsonElement = JsonPrimitive("113.280637,23.125178"),
            level = "city",
            cityName = "广州市",
            cityFullName = "广州市",
        )
        getStringById(R.string.深圳市) -> CitySearchInfoEntity(
            adCode = "440300",
            centerJsonElement = JsonPrimitive("114.085947,22.547"),
            level = "city",
            cityName = "深圳市",
            cityFullName = "深圳市",
        )
        getStringById(R.string.珠海市) -> CitySearchInfoEntity(
            adCode = "440400",
            centerJsonElement = JsonPrimitive("113.553986,22.224979"),
            level = "city",
            cityName = "珠海市",
            cityFullName = "珠海市",
        )
        getStringById(R.string.佛山市) -> CitySearchInfoEntity(
            adCode = "440600",
            centerJsonElement = JsonPrimitive("113.122717,23.028762"),
            level = "city",
            cityName = "佛山市",
            cityFullName = "佛山市",
        )
        getStringById(R.string.南京市) -> CitySearchInfoEntity(
            adCode = "320100",
            centerJsonElement = JsonPrimitive("118.767413,32.041544"),
            level = "city",
            cityName = "南京市",
            cityFullName = "南京市",
        )
        getStringById(R.string.苏州市) -> CitySearchInfoEntity(
            adCode = "320500",
            centerJsonElement = JsonPrimitive("120.619585,31.299379"),
            level = "city",
            cityName = "苏州市",
            cityFullName = "苏州市",
        )
        getStringById(R.string.厦门市) -> CitySearchInfoEntity(
            adCode = "350200",
            centerJsonElement = JsonPrimitive("118.11022,24.490474"),
            level = "city",
            cityName = "厦门市",
            cityFullName = "厦门市",
        )
        getStringById(R.string.南宁市) -> CitySearchInfoEntity(
            adCode = "450100",
            centerJsonElement = JsonPrimitive("108.320004,22.82402"),
            level = "city",
            cityName = "南宁市",
            cityFullName = "南宁市",
        )
        getStringById(R.string.成都市) -> CitySearchInfoEntity(
            adCode = "510100",
            centerJsonElement = JsonPrimitive("104.065735,30.659462"),
            level = "city",
            cityName = "成都市",
            cityFullName = "成都市",
        )
        getStringById(R.string.长沙市) -> CitySearchInfoEntity(
            adCode = "430100",
            centerJsonElement = JsonPrimitive("112.982279,28.19409"),
            level = "city",
            cityName = "长沙市",
            cityFullName = "长沙市",
        )
        getStringById(R.string.福州市) -> CitySearchInfoEntity(
            adCode = "350100",
            centerJsonElement = JsonPrimitive("119.306239,26.075302"),
            level = "city",
            cityName = "福州市",
            cityFullName = "福州市",
        )
        getStringById(R.string.杭州市) -> CitySearchInfoEntity(
            adCode = "330100",
            centerJsonElement = JsonPrimitive("120.153576,30.287459"),
            level = "city",
            cityName = "杭州市",
            cityFullName = "杭州市",
        )
        getStringById(R.string.武汉市) -> CitySearchInfoEntity(
            adCode = "420100",
            centerJsonElement = JsonPrimitive("114.298572,30.584355"),
            level = "city",
            cityName = "武汉市",
            cityFullName = "武汉市",
        )
        getStringById(R.string.青岛市) -> CitySearchInfoEntity(
            adCode = "370200",
            centerJsonElement = JsonPrimitive("120.355173,36.082982"),
            level = "city",
            cityName = "青岛市",
            cityFullName = "青岛市",
        )
        getStringById(R.string.西安市) -> CitySearchInfoEntity(
            adCode = "610100",
            centerJsonElement = JsonPrimitive("108.948024,34.263161"),
            level = "city",
            cityName = "西安市",
            cityFullName = "西安市",
        )
        getStringById(R.string.太原市) -> CitySearchInfoEntity(
            adCode = "140100",
            centerJsonElement = JsonPrimitive("112.549248,37.857014"),
            level = "city",
            cityName = "太原市",
            cityFullName = "太原市",
        )
        getStringById(R.string.石家庄市) -> CitySearchInfoEntity(
            adCode = "130100",
            centerJsonElement = JsonPrimitive("114.502461,38.045474"),
            level = "city",
            cityName = "石家庄市",
            cityFullName = "石家庄市",
        )
        getStringById(R.string.沈阳市) -> CitySearchInfoEntity(
            adCode = "210100",
            centerJsonElement = JsonPrimitive("123.429096,41.796767"),
            level = "city",
            cityName = "沈阳市",
            cityFullName = "沈阳市",
        )
        getStringById(R.string.重庆市) -> CitySearchInfoEntity(
            adCode = "500100",
            centerJsonElement = JsonPrimitive("106.504962,29.533155"),
            level = "city",
            cityName = "重庆城区",
            cityFullName = "重庆市",
        )
        getStringById(R.string.天津市) -> CitySearchInfoEntity(
            adCode = "120100",
            centerJsonElement = JsonPrimitive("117.190182,39.125596"),
            level = "city",
            cityName = "天津城区",
            cityFullName = "天津市",
        )
        else -> CitySearchInfoEntity()
    }

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

    /**
     * 获取城市数据(包括行政数据和天气数据)
     *
     * @param longitude 经度
     * @param latitude 纬度
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    override fun getCityData(
        longitude: Double,
        latitude: Double,
        onSuccess: onSuccess<CityDataItem>,
        onFailure: onFailure
    ) {

    }

    /**
     * 获取天气数据
     *
     * @param longitude 经度
     * @param latitude 纬度
     * @param onSuccess 成功回调
     * @param onFailure 失败回调
     */
    override fun getWeather(
        longitude: Double,
        latitude: Double,
        onSuccess: onSuccess<Weather>,
        onFailure: onFailure
    ) {
        mModel?.getWeather(longitude, latitude, onSuccess, onFailure)
    }

}