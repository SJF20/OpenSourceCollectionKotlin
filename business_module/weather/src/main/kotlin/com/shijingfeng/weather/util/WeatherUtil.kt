@file:JvmName("WeatherUtil")
package com.shijingfeng.weather.util

import com.shijingfeng.base.util.getColorById
import com.shijingfeng.base.util.getStringById
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.common.constant.*
import com.shijingfeng.weather.common.constant.CLEAR_DAY
import com.shijingfeng.weather.common.constant.CLEAR_NIGHT
import com.shijingfeng.weather.common.constant.CLOUDY
import com.shijingfeng.weather.common.constant.DUST
import com.shijingfeng.weather.common.constant.FOG
import com.shijingfeng.weather.common.constant.HEAVY_HAZE
import com.shijingfeng.weather.common.constant.HEAVY_RAIN
import com.shijingfeng.weather.common.constant.HEAVY_SNOW
import com.shijingfeng.weather.common.constant.LIGHT_HAZE
import com.shijingfeng.weather.common.constant.LIGHT_RAIN
import com.shijingfeng.weather.common.constant.LIGHT_SNOW
import com.shijingfeng.weather.common.constant.MODERATE_HAZE
import com.shijingfeng.weather.common.constant.MODERATE_RAIN
import com.shijingfeng.weather.common.constant.MODERATE_SNOW
import com.shijingfeng.weather.common.constant.PARTLY_CLOUDY_DAY
import com.shijingfeng.weather.common.constant.PARTLY_CLOUDY_NIGHT
import com.shijingfeng.weather.common.constant.SAND
import com.shijingfeng.weather.common.constant.STORM_RAIN
import com.shijingfeng.weather.common.constant.STORM_SNOW
import com.shijingfeng.weather.common.constant.WIND

/**
 * Function:
 * Date: 2020/10/12 17:12
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 是否下雨或下雪
 */
fun isRainSnow(@WeatherType weatherType: Int) = isRainy(weatherType) || isSnow(weatherType)

/**
 * 判断是否下雨
 */
fun isRainy(@WeatherType weatherType: Int) = when (weatherType) {
    LIGHT_RAIN,
    MODERATE_RAIN,
    HEAVY_RAIN,
    STORM_RAIN -> true
    else -> false
}

/**
 * 判断是否下雪
 */
fun isSnow(@WeatherType weatherType: Int) = when (weatherType) {
    LIGHT_SNOW,
    MODERATE_SNOW,
    HEAVY_SNOW,
    STORM_SNOW -> true
    else -> false
}

/**
 * 根据天气类型获取背景的颜色值
 */
fun getWeatherBgColor(@WeatherType weatherType: Int) = when (weatherType) {
    // 晴（白天） cloudRate < 0.2
    CLEAR_DAY,
    // 大风
    WIND -> intArrayOf(getColorById(R.color.clear_day1), getColorById(R.color.clear_day2))
    // 晴（夜间）cloudRate < 0.2
    CLEAR_NIGHT -> intArrayOf(getColorById(R.color.clear_night1), getColorById(R.color.clear_night2))

    // 多云（白天）0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_DAY -> intArrayOf(getColorById(R.color.partly_cloudy_day1), getColorById(R.color.partly_cloudy_day2))
    // 多云（夜间）0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_NIGHT -> intArrayOf(getColorById(R.color.partly_cloudy_night1), getColorById(R.color.partly_cloudy_night2))

    // 阴 cloudRate > 0.8
    CLOUDY -> intArrayOf(getColorById(R.color.cloudy1), getColorById(R.color.cloudy2))

    // 轻度雾霾 PM2.5 100~150
    LIGHT_HAZE -> intArrayOf(getColorById(R.color.light_haze1), getColorById(R.color.light_haze2))
    // 中度雾霾 PM2.5 150~200
    MODERATE_HAZE -> intArrayOf(getColorById(R.color.moderate_haze1), getColorById(R.color.moderate_haze2))
    // 重度雾霾 PM2.5 > 200
    HEAVY_HAZE -> intArrayOf(getColorById(R.color.heavy_haze1), getColorById(R.color.heavy_haze2))

    // 雾
    FOG -> intArrayOf(getColorById(R.color.fog1), getColorById(R.color.fog2))

    // 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s
    DUST -> intArrayOf(getColorById(R.color.dust1), getColorById(R.color.dust2))
    // 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s
    SAND -> intArrayOf(getColorById(R.color.sand1), getColorById(R.color.sand2))

    // 小雨
    LIGHT_RAIN -> intArrayOf(getColorById(R.color.light_rain1), getColorById(R.color.light_rain2))
    // 中雨
    MODERATE_RAIN -> intArrayOf(getColorById(R.color.moderate_rain1), getColorById(R.color.moderate_rain2))
    // 大雨
    HEAVY_RAIN -> intArrayOf(getColorById(R.color.heavy_rain1), getColorById(R.color.heavy_rain2))
    // 暴雨
    STORM_RAIN -> intArrayOf(getColorById(R.color.storm_rain1), getColorById(R.color.storm_rain2))

    // 小雪
    LIGHT_SNOW -> intArrayOf(getColorById(R.color.light_snow1), getColorById(R.color.light_snow2))
    // 中雪
    MODERATE_SNOW -> intArrayOf(getColorById(R.color.moderate_snow1), getColorById(R.color.moderate_snow2))
    // 大雪
    HEAVY_SNOW -> intArrayOf(getColorById(R.color.heavy_snow1), getColorById(R.color.heavy_snow2))
    // 暴雪
    STORM_SNOW -> intArrayOf(getColorById(R.color.storm_snow1), getColorById(R.color.storm_snow2))

    else -> intArrayOf(getColorById(R.color.white))
}

/**
 * 通过天气类型字符串 获取 天气类型
 *
 * @param weatherTypeStr 天气类型字符串
 * @return 天气类型
 */
@WeatherType fun getWeatherType(
    weatherTypeStr: String
) = when (weatherTypeStr) {
    // 晴（白天） cloudRate < 0.2
    "CLEAR_DAY" -> CLEAR_DAY
    // 晴（夜间）cloudRate < 0.2
    "CLEAR_NIGHT" -> CLEAR_NIGHT

    // 多云（白天）0.8 >= cloudRate > 0.2
    "PARTLY_CLOUDY_DAY" -> PARTLY_CLOUDY_DAY
    // 多云（夜间）0.8 >= cloudRate > 0.2
    "PARTLY_CLOUDY_NIGHT" -> PARTLY_CLOUDY_NIGHT

    // 阴 cloudRate > 0.8
    "CLOUDY" -> CLEAR_DAY

    // 轻度雾霾 PM2.5 100~150
    "LIGHT_HAZE" -> LIGHT_HAZE
    // 中度雾霾 PM2.5 150~200
    "MODERATE_HAZE" -> MODERATE_HAZE
    // 重度雾霾 PM2.5 > 200
    "HEAVY_HAZE" -> HEAVY_HAZE

    // 雾
    "FOG" -> FOG

    // 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s
    "DUST" -> DUST
    // 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s
    "SAND" -> SAND

    // 大风
    "WIND" -> WIND

    // 小雨
    "LIGHT_RAIN" -> LIGHT_RAIN
    // 中雨
    "MODERATE_RAIN" -> MODERATE_RAIN
    // 大雨
    "HEAVY_RAIN" -> HEAVY_RAIN
    // 暴雨
    "STORM_RAIN" -> STORM_RAIN

    // 小雪
    "LIGHT_SNOW" -> LIGHT_SNOW
    // 中雪
    "MODERATE_SNOW" -> MODERATE_SNOW
    // 大雪
    "HEAVY_SNOW" -> HEAVY_SNOW
    // 暴雪
    "STORM_SNOW" -> STORM_SNOW

    else -> UNKNOWN_WEATHER
}

/**
 * 根据天气类型获取天气的描述信息
 */
fun getWeatherDesc(@WeatherType weatherType: Int) = when (weatherType) {
    // 晴（白天） cloudRate < 0.2
    CLEAR_DAY,
    // 晴（夜间）cloudRate < 0.2
    CLEAR_NIGHT -> getStringById(R.string.晴)

    // 多云（白天）0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_DAY,
    // 多云（夜间）0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_NIGHT -> getStringById(R.string.多云)

    // 阴 cloudRate > 0.8
    CLOUDY -> getStringById(R.string.阴)

    // 轻度雾霾 PM2.5 100~150
    LIGHT_HAZE,
    // 中度雾霾 PM2.5 150~200
    MODERATE_HAZE,
    // 重度雾霾 PM2.5 > 200
    HEAVY_HAZE -> getStringById(R.string.霾)

    // 雾
    FOG -> getStringById(R.string.雾)

    // 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s
    DUST -> getStringById(R.string.浮尘)
    // 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s
    SAND -> getStringById(R.string.沙尘)

    // 大风
    WIND -> getStringById(R.string.大风)

    // 小雨
    LIGHT_RAIN -> getStringById(R.string.小雨)
    // 中雨
    MODERATE_RAIN -> getStringById(R.string.中雨)
    // 大雨
    HEAVY_RAIN -> getStringById(R.string.大雨)
    // 暴雨
    STORM_RAIN -> getStringById(R.string.暴雨)

    // 小雪
    LIGHT_SNOW -> getStringById(R.string.小雪)
    // 中雪
    MODERATE_SNOW -> getStringById(R.string.中雪)
    // 大雪
    HEAVY_SNOW -> getStringById(R.string.大雪)
    // 暴雪
    STORM_SNOW -> getStringById(R.string.暴雪)
    // 默认 未知
    else -> getStringById(R.string.未知)
}