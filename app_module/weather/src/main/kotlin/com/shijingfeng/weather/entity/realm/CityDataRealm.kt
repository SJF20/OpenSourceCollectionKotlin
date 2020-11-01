package com.shijingfeng.weather.entity.realm

import com.shijingfeng.base.base.entity.BaseEntity
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.common.constant.UNKNOWN_WEATHER
import com.shijingfeng.weather.entity.CityDataItem
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.RealmField
import io.realm.annotations.Required

/**
 * Function: 城市数据 Realm实体类 (包括 行政数据 和 天气数据)
 * Date: 2020/10/29 13:47
 * Description:
 * @author ShiJingFeng
 */
@RealmClass(name = "city_data")
internal open class CityDataRealm (

    /** 主键, 城市代码, 对应高德中的adCode */
    @PrimaryKey
    @Required
    @RealmField(name = "city_code")
    var cityCode: String = "",

    /** 经度 */
    @RealmField(name = "longitude")
    var longitude: Double = 0.0,

    /** 纬度 */
    @RealmField(name = "latitude")
    var latitude: Double = 0.0,

    /** 城市名称 */
    @Required
    @RealmField(name = "city_name")
    var cityName: String = "",

    /** 包括上几级行政区的城市名称 */
    @RealmField(name = "city_full_name")
    var cityFullName: String = "",

    /** 天气状况 */
    @WeatherType
    @RealmField(name = "weather_type")
    var weatherType: Int = UNKNOWN_WEATHER,

    /** 天气类型 文字描述 例如: 晴, 阴, 多云, 小雨 */
    @Required
    @RealmField(name = "weather_desc")
    var weatherDesc: String = "",

    /** 当前温度 */
    @RealmField(name = "cur_temp")
    var curTemp: Double = 0.0,

    /** 当日最低温度 */
    @RealmField(name = "lowest_temp")
    var lowestTemp: Double = 0.0,

    /** 当日最高温度 */
    @RealmField(name = "highest_temp")
    var highestTemp: Double = 0.0,

    /** 天气数据, 用作缓存, Json字符串 */
    @RealmField(name = "weather_data")
    var weatherData: String = ""

) : RealmModel {

    /**
     * 当前对象 转化为 [CityDataItem] 对象
     * 深拷贝(当前对象只有 String, double, int 这三种类型，所以可以看作是深拷贝)
     */
    fun toCityDataItem() = CityDataItem(
        cityCode = this.cityCode,
        longitude = this.longitude,
        latitude = this.latitude,
        cityName = this.cityName,
        cityFullName = this.cityFullName,
        weatherType = this.weatherType,
        weatherDesc = this.weatherDesc,
        curTemp = this.curTemp,
        lowestTemp = this.lowestTemp,
        highestTemp = this.highestTemp,
        weatherData = this.weatherData
    )

}