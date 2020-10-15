package com.shijingfeng.weather.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.weather.constant.WeatherConstant.CLEAR_DAY;
import static com.shijingfeng.weather.constant.WeatherConstant.CLEAR_NIGHT;
import static com.shijingfeng.weather.constant.WeatherConstant.CLOUDY;
import static com.shijingfeng.weather.constant.WeatherConstant.DUST;
import static com.shijingfeng.weather.constant.WeatherConstant.FOG;
import static com.shijingfeng.weather.constant.WeatherConstant.HEAVY_HAZE;
import static com.shijingfeng.weather.constant.WeatherConstant.HEAVY_RAIN;
import static com.shijingfeng.weather.constant.WeatherConstant.HEAVY_SNOW;
import static com.shijingfeng.weather.constant.WeatherConstant.LIGHT_HAZE;
import static com.shijingfeng.weather.constant.WeatherConstant.LIGHT_RAIN;
import static com.shijingfeng.weather.constant.WeatherConstant.LIGHT_SNOW;
import static com.shijingfeng.weather.constant.WeatherConstant.MODERATE_HAZE;
import static com.shijingfeng.weather.constant.WeatherConstant.MODERATE_RAIN;
import static com.shijingfeng.weather.constant.WeatherConstant.MODERATE_SNOW;
import static com.shijingfeng.weather.constant.WeatherConstant.PARTLY_CLOUDY_DAY;
import static com.shijingfeng.weather.constant.WeatherConstant.PARTLY_CLOUDY_NIGHT;
import static com.shijingfeng.weather.constant.WeatherConstant.SAND;
import static com.shijingfeng.weather.constant.WeatherConstant.STORM_RAIN;
import static com.shijingfeng.weather.constant.WeatherConstant.STORM_SNOW;
import static com.shijingfeng.weather.constant.WeatherConstant.WIND;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 天气类型 限制注解
 * Date: 2020/10/14 14:53
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    CLEAR_DAY,
    CLEAR_NIGHT,
    PARTLY_CLOUDY_DAY,
    PARTLY_CLOUDY_NIGHT,
    CLOUDY,
    LIGHT_HAZE,
    MODERATE_HAZE,
    HEAVY_HAZE,
    LIGHT_RAIN,
    MODERATE_RAIN,
    HEAVY_RAIN,
    STORM_RAIN,
    FOG,
    LIGHT_SNOW,
    MODERATE_SNOW,
    HEAVY_SNOW,
    STORM_SNOW,
    DUST,
    SAND,
    WIND
})
@Target({
    // 类属性
    FIELD,
    // 函数参数
    PARAMETER,
    // 局部变量
    LOCAL_VARIABLE,
    // 函数
    METHOD
})
@Retention(SOURCE)
public @interface WeatherType {}
