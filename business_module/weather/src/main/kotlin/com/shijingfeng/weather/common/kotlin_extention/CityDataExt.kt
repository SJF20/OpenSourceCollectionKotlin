/** 生成的 Java 类名 */
@file:JvmName("CityDataExt")
package com.shijingfeng.weather.common.kotlin_extention

import com.shijingfeng.realm.entity.CityDataRealm
import com.shijingfeng.weather.entity.CityDataItem

/**
 * Function: 城市数据 扩展函数
 * Date: 2021/1/17 22:12
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 当前 城市数据实体类 转换为 城市数据数据库实体类 [CityDataRealm]
 * 深拷贝(当前对象只有 String, double, int 这三种类型，所以可以看作是深拷贝)
 *
 * @param orderNumber
 */
internal fun CityDataItem.toCityDataRealm(
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

/**
 * 当前对象 转化为 [CityDataItem] 对象
 * 深拷贝(当前对象只有 String, double, int 这三种类型，所以可以看作是深拷贝)
 */
internal fun CityDataRealm.toCityDataItem() = CityDataItem(
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