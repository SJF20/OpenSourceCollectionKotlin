package com.shijingfeng.weather.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.weather.annotation.define.WeatherFuzzyType.RAIN;
import static com.shijingfeng.weather.annotation.define.WeatherFuzzyType.SNOW;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 天气类型模糊分类 限定注解
 * Date: 2020/10/14 11:31
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    RAIN,
    SNOW
})
@Target({
    // 类属性
    FIELD,
    // 函数参数
    PARAMETER,
    // 局部变量
    LOCAL_VARIABLE
})
@Retention(SOURCE)
public @interface WeatherFuzzyType {

    /** 下雨天 */
    int RAIN = 1;
    /** 下雪天 */
    int SNOW = 2;

}
