package com.shijingfeng.weather.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.weather.common.constant.WeatherConstant.CLEAR_DAY;
import static com.shijingfeng.weather.common.constant.WeatherConstant.CLEAR_NIGHT;
import static com.shijingfeng.weather.common.constant.WeatherConstant.CLOUDY;
import static com.shijingfeng.weather.common.constant.WeatherConstant.DUST;
import static com.shijingfeng.weather.common.constant.WeatherConstant.FOG;
import static com.shijingfeng.weather.common.constant.WeatherConstant.HEAVY_HAZE;
import static com.shijingfeng.weather.common.constant.WeatherConstant.HEAVY_RAIN;
import static com.shijingfeng.weather.common.constant.WeatherConstant.HEAVY_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.LIGHT_HAZE;
import static com.shijingfeng.weather.common.constant.WeatherConstant.LIGHT_RAIN;
import static com.shijingfeng.weather.common.constant.WeatherConstant.LIGHT_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.MODERATE_HAZE;
import static com.shijingfeng.weather.common.constant.WeatherConstant.MODERATE_RAIN;
import static com.shijingfeng.weather.common.constant.WeatherConstant.MODERATE_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.PARTLY_CLOUDY_DAY;
import static com.shijingfeng.weather.common.constant.WeatherConstant.PARTLY_CLOUDY_NIGHT;
import static com.shijingfeng.weather.common.constant.WeatherConstant.SAND;
import static com.shijingfeng.weather.common.constant.WeatherConstant.STORM_RAIN;
import static com.shijingfeng.weather.common.constant.WeatherConstant.STORM_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.UNKNOWN_WEATHER;
import static com.shijingfeng.weather.common.constant.WeatherConstant.WIND;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: ???????????? ????????????
 * Date: 2020/10/14 14:53
 * Description:
 *
 * Author: ShiJingFeng
 */
@IntDef({
    // ??????????????????
    UNKNOWN_WEATHER,
    // ??????????????? cloudRate < 0.2
    CLEAR_DAY,
    // ???????????????cloudRate < 0.2
    CLEAR_NIGHT,
    // ??????????????????0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_DAY,
    // ??????????????????0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_NIGHT,
    // ??? cloudRate > 0.8
    CLOUDY,
    // ???????????? PM2.5 100~150
    LIGHT_HAZE,
    // ???????????? PM2.5 150~200
    MODERATE_HAZE,
    // ???????????? PM2.5 > 200
    HEAVY_HAZE,
    // ??????
    LIGHT_RAIN,
    // ??????
    MODERATE_RAIN,
    // ??????
    HEAVY_RAIN,
    // ??????
    STORM_RAIN,
    // ???
    FOG,
    // ??????
    LIGHT_SNOW,
    // ??????
    MODERATE_SNOW,
    // ??????
    HEAVY_SNOW,
    // ??????
    STORM_SNOW,
    // ?????? aqi > 150???pm10 > 150????????? < 30%????????? < 6 m/s
    DUST,
    // ?????? aqi > 150???pm10 > 150????????? < 30%????????? > 6 m/s
    SAND,
    // ??????
    WIND
})
@Target({
    // ?????????
    FIELD,
    // ????????????
    PARAMETER,
    // ????????????
    LOCAL_VARIABLE,
    // ??????
    METHOD
})
@Retention(SOURCE)
public @interface WeatherType {}
