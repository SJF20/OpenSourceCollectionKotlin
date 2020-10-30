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
    @Required
    @RealmField(name = "weather")
    var weather: String = "",

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

) : RealmModel