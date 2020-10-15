/** 生成的 Java 类名 */
@file:JvmName("WeatherConstant")
package com.shijingfeng.weather.constant

/**
 * Function: 天气相关静态字符串
 * Date: 2020/10/14 14:44
 * Description:
 * @author ShiJingFeng
 */

/** 晴（白天） cloudRate < 0.2 */
internal const val CLEAR_DAY = 0
/** 晴（夜间）cloudRate < 0.2 */
internal const val CLEAR_NIGHT = 1
/** 多云（白天）0.8 >= cloudRate > 0.2 */
internal const val PARTLY_CLOUDY_DAY = 2
/** 多云（夜间）0.8 >= cloudRate > 0.2 */
internal const val PARTLY_CLOUDY_NIGHT = 3
/** 阴 cloudRate > 0.8 */
internal const val CLOUDY = 4
/** 轻度雾霾 PM2.5 100~150 */
internal const val LIGHT_HAZE = 5
/** 中度雾霾 PM2.5 150~200 */
internal const val MODERATE_HAZE = 6
/** 重度雾霾 PM2.5 > 200 */
internal const val HEAVY_HAZE = 7
/** 小雨 */
internal const val LIGHT_RAIN = 8
/** 中雨 */
internal const val MODERATE_RAIN = 9
/** 大雨 */
internal const val HEAVY_RAIN = 10
/** 暴雨 */
internal const val STORM_RAIN = 11
/** 雾 */
internal const val FOG = 12
/** 小雪 */
internal const val LIGHT_SNOW = 13
/** 中雪 */
internal const val MODERATE_SNOW = 14
/** 大雪 */
internal const val HEAVY_SNOW =15
/** 暴雪 */
internal const val STORM_SNOW = 16
/** 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s */
internal const val DUST = 17
/** 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s */
internal const val SAND = 18
/** 大风 */
internal const val WIND = 19
