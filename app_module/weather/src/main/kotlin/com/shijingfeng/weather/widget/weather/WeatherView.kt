package com.shijingfeng.weather.widget.weather

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.widget.FrameLayout
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.WeatherType
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
import com.shijingfeng.weather.util.getWeatherBgColor
import com.shijingfeng.weather.widget.weather.cloud.CloudView
import com.shijingfeng.weather.widget.weather.night_sunny.NightSunnyView
import com.shijingfeng.weather.widget.weather.rain.RainView
import com.shijingfeng.weather.widget.weather.snow.SnowView

/**
 * Function:
 * Date: 2020/10/21 17:10
 * Description:
 * @author ShiJingFeng
 */
internal class WeatherView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {

    /** 天气类型 */
    @WeatherType private var mWeatherType: Int

    init {
        context.obtainStyledAttributes(attrs, R.styleable.WeatherView).run {
            mWeatherType = getInt(R.styleable.WeatherView_weatherType, CLEAR_DAY)
            //一定要回收，否则会内存泄漏
            recycle()
        }
        updateWeatherType(mWeatherType)
    }

    /**
     * 更新天气类型
     */
    private fun updateWeatherType(@WeatherType weatherType: Int) {
        this.mWeatherType = weatherType
        removeAllViews()
        background = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            colors = getWeatherBgColor(weatherType)
            gradientType = GradientDrawable.LINEAR_GRADIENT
            orientation = GradientDrawable.Orientation.TOP_BOTTOM
        }
        when (weatherType) {
            // 晴（夜间）cloudRate < 0.2
            CLEAR_NIGHT -> addView(NightSunnyView(
                context = context,
            ), 0)

            // 晴（白天） cloudRate < 0.2
            CLEAR_DAY,
            // 多云（白天）0.8 >= cloudRate > 0.2
            PARTLY_CLOUDY_DAY,
            // 多云（夜间）0.8 >= cloudRate > 0.2
            PARTLY_CLOUDY_NIGHT,
            // 阴 cloudRate > 0.8
            CLOUDY ,
            // 雾
            FOG,
            // 轻度雾霾 PM2.5 100~150
            LIGHT_HAZE,
            // 中度雾霾 PM2.5 150~200
            MODERATE_HAZE,
            // 重度雾霾 PM2.5 > 200
            HEAVY_HAZE,
            // 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s
            DUST,
            // 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s
            SAND,
            // 大风
            WIND -> addView(CloudView(
                context = context,
                cloudType = weatherType
            ), 0)

            // 小雨
            LIGHT_RAIN,
            // 中雨
            MODERATE_RAIN,
            // 大雨
            HEAVY_RAIN,
            // 暴雨
            STORM_RAIN -> {
                addView(RainView(
                    context = context,
                    rainType = weatherType
                ), 0)
                addView(CloudView(
                    context = context,
                    cloudType = weatherType
                ), 0)
            }

            // 小雪
            LIGHT_SNOW,
            // 中雪
            MODERATE_SNOW,
            // 大雪
            HEAVY_SNOW,
            // 暴雪
            STORM_SNOW -> {
                addView(SnowView(
                    context = context,
                    snowType = weatherType
                ), 0)
                addView(CloudView(
                    context = context,
                    cloudType = weatherType
                ), 0)
            }

            else -> {}
        }
    }

    /** 天气 类型 */
    var weatherType
        @WeatherType get() = this.mWeatherType
        set(@WeatherType weatherType) {
            if (this.mWeatherType == weatherType) {
                return
            }
            updateWeatherType(weatherType)
        }

}