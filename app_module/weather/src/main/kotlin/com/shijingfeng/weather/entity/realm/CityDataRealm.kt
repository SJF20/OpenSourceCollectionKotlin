package com.shijingfeng.weather.entity.realm

import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.common.constant.UNKNOWN_WEATHER
import com.shijingfeng.weather.entity.CityDataItem
import io.realm.RealmModel
import io.realm.annotations.*

/**
 * Function: 城市数据 Realm实体类 (包括 行政数据 和 天气数据)
 * Date: 2020/10/29 13:47
 * Description:
 * @author ShiJingFeng
 */
@RealmClass(name = "city_data")
internal open class CityDataRealm(

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
    var weatherType: Int = 0,

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
    var weatherData: String = "",

    /**
     * 当插入或删除时, 用于维护顺序 思路来源: [http://www.voidcn.com/article/p-wvwueflp-bvm.html], 如果失效查看此地址 [https://m.jb51.cc/mysql/434178.html]
     * 注意: 但是有一个问题,如果你继续在同一区域插入数字,可能会导致 order_number 精度太接近,足够接近以至于不能彼此区分.
     * 为避免这种情况,您的插入程序必须检查两个相邻的 order_number 是否过于接近.在这种情况下,它可以重新分配其他附近行的 order_number, “拉伸”上方和下方的订单号以“创建空间”以获得新值.
     * 您还可以定期运行“清理”过程,并在表的整个或大部分中进行“拉伸”.
     */
    @RealmField(name = "order_number")
    var orderNumber: Double = 0.0,

) : RealmModel {

    /**
     * Realm框架内部需要使用默认构造器
     */
    constructor() : this(
        cityCode = "",
        longitude = 0.0,
        latitude = 0.0,
        cityName = "",
        cityFullName = "",
        weatherType = UNKNOWN_WEATHER,
        weatherDesc = "",
        curTemp = 0.0,
        lowestTemp = 0.0,
        highestTemp = 0.0,
        weatherData = "",
        orderNumber = 0.0
    )

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
        weatherData = this.weatherData,
    )

}