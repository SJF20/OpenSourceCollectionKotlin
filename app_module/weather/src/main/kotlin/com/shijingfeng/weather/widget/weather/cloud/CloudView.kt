package com.shijingfeng.weather.widget.weather.cloud

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.ThreadUtils
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.RainType
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.common.constant.*
import com.shijingfeng.weather.common.constant.CLEAR_DAY
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
 * Function: 云层 View
 * Date: 2020/10/21 11:09
 * Description:
 * @author ShiJingFeng
 */
internal class CloudView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    @WeatherType cloudType: Int? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {

    /** 宽度比例 */
    private val WIDTH_RATIO by lazy {
        width / SizeUtils.dp2px(392F).toFloat()
    }

    /** 天气 类型 */
    @WeatherType private var mCloudType: Int

    /** 云层 Bitmap */
    private val mCloudBitmap by lazy { BitmapFactory.decodeResource(resources, R.drawable.cloud) }
    /** 太阳 Bitmap */
    private val mSunBitmap by lazy { BitmapFactory.decodeResource(resources, R.drawable.sun) }

    /** 画笔 */
    private val mPaint = Paint()

    init {
        context.obtainStyledAttributes(attrs, R.styleable.CloudView).run {
            mCloudType = getInt(R.styleable.CloudView_cloudType, CLEAR_DAY)
            //一定要回收，否则会内存泄漏
            recycle()
        }
        if (cloudType != null) {
            mCloudType = cloudType
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // Paint设置复位
        mPaint.maskFilter = null
        mPaint.colorFilter = null

        when (mCloudType) {
            // 晴（白天） cloudRate < 0.2
            CLEAR_DAY,
            // 大风
            WIND -> drawClearDay(canvas)

            // 多云（白天）0.8 >= cloudRate > 0.2
            PARTLY_CLOUDY_DAY -> drawPartlyCloudyDay(canvas)

            // 多云（夜间）0.8 >= cloudRate > 0.2
            PARTLY_CLOUDY_NIGHT -> drawPartlyCloudyNight(canvas)

            // 阴 cloudRate > 0.8
            CLOUDY -> drawCloudy(canvas)

            // 小雨
            LIGHT_RAIN -> drawLightRain(canvas)

            // 中雨
            MODERATE_RAIN -> drawModerateRain(canvas)

            // 大雨
            HEAVY_RAIN,
            // 暴雨
            STORM_RAIN -> drawHeavyRain(canvas)

            // 小雪
            LIGHT_SNOW -> drawLightSnow(canvas)

            // 中雪
            MODERATE_SNOW -> drawModerateSnow(canvas)

            // 大雪
            HEAVY_SNOW,
            // 暴雪
            STORM_SNOW -> drawHeavySnow(canvas)

            // 雾
            FOG -> drawFog(canvas)

            // 轻度雾霾 PM2.5 100~150
            LIGHT_HAZE,
            // 中度雾霾 PM2.5 150~200
            MODERATE_HAZE,
            // 重度雾霾 PM2.5 > 200
            HEAVY_HAZE -> drawHaze(canvas)

            // 浮尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 < 6 m/s
            DUST,
            // 沙尘 aqi > 150，pm10 > 150，湿度 < 30%，风速 > 6 m/s
            SAND -> drawDust(canvas)

            else -> {}
        }
    }

    /**
     * 绘制 晴（白天） cloudRate < 0.2
     */
    private fun drawClearDay(canvas: Canvas?) {
        var sunScale: Float
        var x: Float
        var y: Float

        mPaint.maskFilter = BlurMaskFilter(SizeUtils.dp2px(40F).toFloat(), BlurMaskFilter.Blur.NORMAL)
        canvas?.run {
            // 绘制太阳
            sunScale = 1.2F * WIDTH_RATIO
            x = width - mSunBitmap.width * sunScale
            y = -mSunBitmap.width / 2F
            save()
            scale(sunScale, sunScale)
            drawBitmap(mSunBitmap, x, y, mPaint)
            restore()
            // 绘制晴云
            sunScale = 0.6F * WIDTH_RATIO
            x = -SizeUtils.dp2px(100F).toFloat()
            y = -SizeUtils.dp2px(100F).toFloat()
            save()
            scale(sunScale, sunScale)
            drawBitmap(mCloudBitmap, x, y, mPaint)
            restore()
        }
    }

    /**
     * 绘制 多云（白天）0.8 >= cloudRate > 0.2
     */
    private fun drawPartlyCloudyDay(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = 0F
        val y1 = -SizeUtils.dp2px(200F).toFloat()
        val x2 = -mCloudBitmap.width / 2F
        val y2 = -SizeUtils.dp2px(130F).toFloat()
        val x3 = SizeUtils.dp2px(100F).toFloat()
        val y3 = 0F

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            1F, 0F, 0F, 0F, 0F,
            0F, 1F, 0F, 0F, 0F,
            0F, 0F, 1F, 0F, 0F,
            0F, 0F, 0F, 0.9F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            drawBitmap(mCloudBitmap, x3, y3, mPaint)
            restore()
        }
    }

    /**
     * 绘制 多云（夜间）0.8 >= cloudRate > 0.2
     */
    private fun drawPartlyCloudyNight(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = 0F
        val y1 = -SizeUtils.dp2px(200F).toFloat()
        val x2 = -mCloudBitmap.width / 2F
        val y2 = -SizeUtils.dp2px(130F).toFloat()
        val x3 = SizeUtils.dp2px(100F).toFloat()
        val y3 = 0F

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.32F, 0F, 0F, 0F, 0F,
            0F, 0.39F, 0F, 0F, 0F,
            0F, 0F, 0.52F, 0F, 0F,
            0F, 0F, 0F, 0.9F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            drawBitmap(mCloudBitmap, x3, y3, mPaint)
            restore()
        }
    }

    /**
     * 绘制 阴 cloudRate > 0.8
     */
    private fun drawCloudy(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = 0F
        val y1 = -SizeUtils.dp2px(200F).toFloat()
        val x2 = -mCloudBitmap.width / 2F
        val y2 = -SizeUtils.dp2px(130F).toFloat()
        val x3 = SizeUtils.dp2px(100F).toFloat()
        val y3 = 0F

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            1F, 0F, 0F, 0F, 0F,
            0F, 1F, 0F, 0F, 0F,
            0F, 0F, 1F, 0F, 0F,
            0F, 0F, 0F, 0.7F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            drawBitmap(mCloudBitmap, x3, y3, mPaint)
            restore()
        }
    }

    /**
     * 绘制 小雨
     */
    private fun drawLightRain(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = -SizeUtils.dp2px(380F).toFloat()
        val y1 = -SizeUtils.dp2px(150F).toFloat()
        val x2 = 0F
        val y2 = -SizeUtils.dp2px(60F).toFloat()
        val x3 = 0F
        val y3 = SizeUtils.dp2px(60F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.45F, 0F, 0F, 0F, 0F,
            0F, 0.52F, 0F, 0F, 0F,
            0F, 0F, 0.6F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            drawBitmap(mCloudBitmap, x3, y3, mPaint)
            restore()
        }
    }

    /**
     * 绘制 中雨
     */
    private fun drawModerateRain(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = -SizeUtils.dp2px(380F).toFloat()
        val y1 = -SizeUtils.dp2px(150F).toFloat()
        val x2 = 0F
        val y2 = -SizeUtils.dp2px(60F).toFloat()
        val x3 = 0F
        val y3 = SizeUtils.dp2px(60F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.16F, 0F, 0F, 0F, 0F,
            0F, 0.22F, 0F, 0F, 0F,
            0F, 0F, 0.31F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            drawBitmap(mCloudBitmap, x3, y3, mPaint)
            restore()
        }
    }

    /**
     * 绘制 大雨
     */
    private fun drawHeavyRain(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = -SizeUtils.dp2px(380F).toFloat()
        val y1 = -SizeUtils.dp2px(150F).toFloat()
        val x2 = 0F
        val y2 = -SizeUtils.dp2px(60F).toFloat()
        val x3 = 0F
        val y3 = SizeUtils.dp2px(60F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.19F, 0F, 0F, 0F, 0F,
            0F, 0.2F, 0F, 0F, 0F,
            0F, 0F, 0.22F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            drawBitmap(mCloudBitmap, x3, y3, mPaint)
            restore()
        }
    }

    /**
     * 绘制 小雪
     */
    private fun drawLightSnow(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = -SizeUtils.dp2px(380F).toFloat()
        val y1 = -SizeUtils.dp2px(100F).toFloat()
        val x2 = 0F
        val y2 = -SizeUtils.dp2px(170F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.67F, 0F, 0F, 0F, 0F,
            0F, 0.75F, 0F, 0F, 0F,
            0F, 0F, 0.87F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            restore()
        }
    }

    /**
     * 绘制 中雪
     */
    private fun drawModerateSnow(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = -SizeUtils.dp2px(380F).toFloat()
        val y1 = -SizeUtils.dp2px(100F).toFloat()
        val x2 = 0F
        val y2 = -SizeUtils.dp2px(170F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.7F, 0F, 0F, 0F, 0F,
            0F, 0.77F, 0F, 0F, 0F,
            0F, 0F, 0.87F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            restore()
        }
    }

    /**
     * 绘制 大雪
     */
    private fun drawHeavySnow(canvas: Canvas?) {
        val scale = 0.8F * WIDTH_RATIO
        val x1 = -SizeUtils.dp2px(380F).toFloat()
        val y1 = -SizeUtils.dp2px(100F).toFloat()
        val x2 = 0F
        val y2 = -SizeUtils.dp2px(170F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.74F, 0F, 0F, 0F, 0F,
            0F, 0.74F, 0F, 0F, 0F,
            0F, 0F, 0.81F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x1, y1, mPaint)
            drawBitmap(mCloudBitmap, x2, y2, mPaint)
            restore()
        }
    }

    /**
     * 绘制 雾
     */
    private fun drawFog(canvas: Canvas?) {
        val scale = 2F * WIDTH_RATIO
        val x = -mCloudBitmap.width * 0.5F
        val y = -SizeUtils.dp2px(200F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.74F, 0F, 0F, 0F, 0F,
            0F, 0.74F, 0F, 0F, 0F,
            0F, 0F, 0.81F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x, y, mPaint)
            restore()
        }
    }

    /**
     * 绘制 霾
     */
    private fun drawHaze(canvas: Canvas?) {
        val scale = 2F * WIDTH_RATIO
        val x = -mCloudBitmap.width * 0.5F
        val y = -SizeUtils.dp2px(200F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.67F, 0F, 0F, 0F, 0F,
            0F, 0.67F, 0F, 0F, 0F,
            0F, 0F, 0.67F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x, y, mPaint)
            restore()
        }
    }

    /**
     * 绘制 浮尘
     */
    private fun drawDust(canvas: Canvas?) {
        val scale = 2F * WIDTH_RATIO
        val x = -mCloudBitmap.width * 0.5F
        val y = -SizeUtils.dp2px(200F).toFloat()

        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            0.62F, 0F, 0F, 0F, 0F,
            0F, 0.55F, 0F, 0F, 0F,
            0F, 0F, 0.45F, 0F, 0F,
            0F, 0F, 0F, 1F, 0F,
        ))
        canvas?.run {
            save()
            scale(scale, scale)
            drawBitmap(mCloudBitmap, x, y, mPaint)
            restore()
        }
    }

    /** 云 类型 */
    var cloudType
        @RainType get() = this.mCloudType
        set(@WeatherType cloudType) {
            this.mCloudType = cloudType
            if (ThreadUtils.isMainThread()) {
                invalidate()
            } else {
                postInvalidate()
            }
        }

}