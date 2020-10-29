package com.shijingfeng.weather.entity.realm

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.RealmField
import io.realm.annotations.Required

/**
 * Function: 城市数据 (包括 行政数据 和 天气数据)
 * Date: 2020/10/29 13:47
 * Description:
 * @author ShiJingFeng
 */
@RealmClass(name = "city_data")
internal open class CityData (

    /** 主键, 城市代码, 对应高德中的adCode */
    @PrimaryKey
    @Required
    @RealmField(name = "city_code")
    var cityCode: String,

    /** 经度 */
    @Required
    @RealmField(name = "longitude")
    var longitude: Double,

    /** 纬度 */
    @Required
    @RealmField(name = "latitude")
    var latitude: Double,

    /** 城市名称 */
    @Required
    @RealmField(name = "city_name")
    var cityName: String,

    /** 包括上几级行政区的城市名称 */
    @RealmField(name = "city_full_name")
    var cityFullName: String = "",

    /** 天气状况 */
    @Required
    @RealmField(name = "weather")
    var weather: String,

    /** 当前温度 */
    @Required
    @RealmField(name = "cur_temp")
    var curTemp: Double,

    /** 当日最低温度 */
    @Required
    @RealmField(name = "lowest_temp")
    var lowestTemp: String,

    /** 当日最高温度 */
    @Required
    @RealmField(name = "highest_temp")
    var highestTemp: String,

    /** 天气数据, 用作缓存, Json字符串 */
    @RealmField(name = "weather_data")
    var weatherData: String

) : RealmModel