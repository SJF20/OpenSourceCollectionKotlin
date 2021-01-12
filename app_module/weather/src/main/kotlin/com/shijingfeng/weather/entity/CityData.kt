package com.shijingfeng.weather.entity

import com.google.gson.annotations.SerializedName
import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.common.constant.UNKNOWN_WEATHER
import com.shijingfeng.weather.entity.realm.CityDataRealm
import io.realm.annotations.RealmField

/**
 * Function: 城市数据 实体类 (可读不可写)
 * Date: 2020/11/1 10:09
 * Description:
 * Author: ShiJingFeng
 */
internal data class CityDataItem(

    /** 城市代码, 对应高德中的adCode */
    @SerializedName("cityCode")
    val cityCode: String,

    /** 经度 */
    @SerializedName("longitude")
    val longitude: Double? = null,

    /** 纬度 */
    @SerializedName("latitude")
    val latitude: Double? = null,

    /** 城市名称 */
    @SerializedName("cityName")
    val cityName: String? = null,

    /** 包括上几级行政区的城市名称 */
    @SerializedName("cityFullName")
    val cityFullName: String? = null,

    /** 天气状况 */
    @WeatherType
    @SerializedName("weatherType")
    val weatherType: Int? = null,

    /** 天气类型 文字描述 例如: 晴, 阴, 多云, 小雨 */
    @SerializedName("weatherDesc")
    val weatherDesc: String? = null,

    /** 当前温度 */
    @SerializedName("curTemp")
    val curTemp: Double? = null,

    /** 当日最低温度 */
    @SerializedName("lowestTemp")
    val lowestTemp: Double? = null,

    /** 当日最高温度 */
    @SerializedName("highestTemp")
    val highestTemp: Double? = null,

    /** 天气数据, 用作缓存, Json字符串 */
    @SerializedName("weatherData")
    val weatherData: String? = null,

) : BaseEntity() {
    
    /**
     * 获取ID
     * @return ID
     */
    override fun getId(): String {
        return cityCode
    }

    /**
     * 当前城市数据实体类是否完整 (如果只是用来做更新传参，则不需要调用此函数)
     */
    fun isValid() = cityCode.isNotEmpty()
            && longitude != null
            && latitude != null
            && !cityName.isNullOrEmpty()
            && !cityFullName.isNullOrEmpty()
            && weatherType != null
            && !weatherDesc.isNullOrEmpty()
            && curTemp != null
            && lowestTemp != null
            && highestTemp != null
            && !weatherData.isNullOrEmpty()

    /**
     * 当前 城市数据实体类 转换为 城市数据数据库实体类 [CityDataRealm]
     * 深拷贝(当前对象只有 String, double, int 这三种类型，所以可以看作是深拷贝)
     *
     * @param orderNumber
     *
     */
    fun toCityDataRealm(
        orderNumber: Double
    ) = if (!isValid()) {
        throw IllegalArgumentException("该城市数据实体类部分数据没有, 故不能存到数据库中")
    } else {
        CityDataRealm(
            cityCode = this.cityCode,
            longitude = this.longitude!!,
            latitude = this.latitude!!,
            cityName = this.cityName!!,
            cityFullName = this.cityFullName!!,
            weatherType = this.weatherType!!,
            weatherDesc = this.weatherDesc!!,
            curTemp = this.curTemp!!,
            lowestTemp = this.lowestTemp!!,
            highestTemp = this.highestTemp!!,
            weatherData = this.weatherData!!,
            orderNumber = orderNumber
        )
    }

}