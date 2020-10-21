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
    // 晴（白天） cloudRate < 0.2
    CLEAR_DAY,
    // 晴（夜间）cloudRate < 0.2
    CLEAR_NIGHT,
    // 多云（白天）0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_DAY,
    // 多云（夜间）0.8 >= cloudRate > 0.2
    PARTLY_CLOUDY_NIGHT,
    // 阴 cloudRate > 0.8
    CLOUDY,
    // 轻度雾霾 PM2.5 100~150
    LIGHT_HAZE,
    // 中度雾霾 PM2.5 150~200
    MODERATE_HAZE,
    // 重度雾霾 PM2.5 > 200
    HEAVY_HAZE,
    // 小雨
    LIGHT_RAIN,
    // 中雨
    MODERATE_RAIN,
    // 大雨
    HEAVY_RAIN,
    // 暴雨
    STORM_RAIN,
    // 雾
    FOG,
    // 小雪
    LIGHT_SNOW,
    // 中雪
    MODERATE_SNOW,
    // 大雪
    HEAVY_SNOW,
    // 暴雪
    STORM_SNOW,
    // 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s
    DUST,
    // 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s
    SAND,
    // 大风
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
