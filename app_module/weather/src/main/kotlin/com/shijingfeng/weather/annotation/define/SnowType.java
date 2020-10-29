package com.shijingfeng.weather.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.weather.common.constant.WeatherConstant.HEAVY_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.LIGHT_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.MODERATE_SNOW;
import static com.shijingfeng.weather.common.constant.WeatherConstant.STORM_SNOW;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 雪 类型 限制注解
 * Date: 2020/10/14 17:02
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    LIGHT_SNOW,
    MODERATE_SNOW,
    HEAVY_SNOW,
    STORM_SNOW
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
public @interface SnowType {}
