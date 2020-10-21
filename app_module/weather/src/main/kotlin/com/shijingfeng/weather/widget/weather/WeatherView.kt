package com.shijingfeng.weather.widget.weather

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.RainType
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.constant.*
import com.shijingfeng.weather.constant.CLEAR_DAY
import com.shijingfeng.weather.constant.CLOUDY
import com.shijingfeng.weather.constant.DUST
import com.shijingfeng.weather.constant.FOG
import com.shijingfeng.weather.constant.HEAVY_HAZE
import com.shijingfeng.weather.constant.HEAVY_RAIN
import com.shijingfeng.weather.constant.HEAVY_SNOW
import com.shijingfeng.weather.constant.LIGHT_HAZE
import com.shijingfeng.weather.constant.LIGHT_RAIN
import com.shijingfeng.weather.constant.LIGHT_SNOW
import com.shijingfeng.weather.constant.MODERATE_HAZE
import com.shijingfeng.weather.constant.MODERATE_RAIN
import com.shijingfeng.weather.constant.MODERATE_SNOW
import com.shijingfeng.weather.constant.PARTLY_CLOUDY_DAY
import com.shijingfeng.weather.constant.PARTLY_CLOUDY_NIGHT
import com.shijingfeng.weather.constant.STORM_RAIN
import com.shijingfeng.weather.constant.STORM_SNOW

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
    @WeatherType private var mWeatherType = CLEAR_DAY

    init {
        context.obtainStyledAttributes(attrs, R.styleable.WeatherView).run {
            mWeatherType = getInt(R.styleable.WeatherView_weatherType, CLEAR_DAY)
            //一定要回收，否则会内存泄漏
            recycle()
        }
    }

    /**
     * 更新天气类型
     */
    private fun updateWeatherType(@WeatherType weatherType: Int) {
        removeAllViews()
        when (weatherType) {
            CLEAR_DAY -> {}
            CLEAR_NIGHT -> {}
            PARTLY_CLOUDY_DAY -> {}
            PARTLY_CLOUDY_NIGHT -> {}
            CLOUDY -> {}
            LIGHT_RAIN -> {}
            MODERATE_RAIN -> {}
            HEAVY_RAIN,
            STORM_RAIN -> {}
            LIGHT_SNOW -> {}
            MODERATE_SNOW -> {}
            HEAVY_SNOW,
            STORM_SNOW -> {}
            FOG -> {}
            LIGHT_HAZE,
            MODERATE_HAZE,
            HEAVY_HAZE -> {}
            DUST -> {}
            SAND -> {}
            WIND -> {}
            else -> {}
        }
    }

    /** 雨 类型 */
    var weatherType
        @WeatherType get() = this.mWeatherType
        set(@WeatherType weatherType) {
            this.mWeatherType = weatherType

        }

}