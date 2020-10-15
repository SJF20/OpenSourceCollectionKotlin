package com.shijingfeng.weather.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.constant.*
import com.shijingfeng.weather.constant.CLEAR_DAY
import com.shijingfeng.weather.constant.HEAVY_RAIN
import com.shijingfeng.weather.constant.HEAVY_SNOW
import com.shijingfeng.weather.constant.LIGHT_RAIN
import com.shijingfeng.weather.constant.LIGHT_SNOW
import com.shijingfeng.weather.constant.MODERATE_RAIN
import com.shijingfeng.weather.constant.MODERATE_SNOW
import com.shijingfeng.weather.constant.STORM_RAIN
import com.shijingfeng.weather.constant.STORM_SNOW
import com.shijingfeng.weather.util.isRainSnow
import com.shijingfeng.weather.util.isRainy
import com.shijingfeng.weather.util.isSnow
import kotlin.math.sin

/**
 * Function:
 * Date: 2020/10/12 15:50
 * Description:
 * @author ShiJingFeng
 */
class RainSnowView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : SurfaceView(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
), SurfaceHolder.Callback, Runnable {

    @WeatherType private var mWeatherType = CLEAR_DAY

    private var mWeatherImage: Bitmap? = null
    private val mRainSnowParamList = mutableListOf<RainSnowParam>()
    private var count = 0

    private val mPaint = Paint()

    private val mValueAnimator = ValueAnimator.ofFloat(0.0F, 1.0F).apply {
        duration = 60 * 1000
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addUpdateListener {
            invalidate()
        }
    }

    private val mSurfaceHolder = holder.apply {
        addCallback(this@RainSnowView)
    }

    init {
        isFocusable = true
        isFocusableInTouchMode = true
        context.obtainStyledAttributes(attrs, R.styleable.RainSnowView2).run {
            mWeatherType = getInt(R.styleable.RainSnowView2_weatherType, CLEAR_DAY)
            //一定要回收，否则会内存泄漏
            recycle()
        }
        initImage()
    }

    private fun initImage() {
        if (isRainy(mWeatherType)) {
            mWeatherImage = BitmapFactory.decodeResource(resources, R.drawable.rain)
        } else if (isSnow(mWeatherType)) {
            mWeatherImage = BitmapFactory.decodeResource(resources, R.drawable.snow)
        }
        invalidate()
    }

    private fun initParam() {
        val width = width
        val height = height

        mRainSnowParamList.clear()
        if (width != 0 && height != 0) {
            if (isRainSnow(mWeatherType)) {
                when (mWeatherType) {
                    LIGHT_RAIN -> count = 70
                    MODERATE_RAIN -> count = 100
                    HEAVY_RAIN,
                    STORM_RAIN -> count = 200
                    LIGHT_SNOW -> count = 30
                    MODERATE_SNOW -> count = 100
                    HEAVY_SNOW,
                    STORM_SNOW -> count = 200
                    else -> {}
                }

                val widthRatio = width / 392.0
                val heightRatio = height / 817.0

                for (i in 0 until count) {
                    val rainSnowParam = RainSnowParam(
                        width = width.toDouble(),
                        height = height.toDouble(),
                        weatherType = mWeatherType
                    )

                    rainSnowParam.init(widthRatio, heightRatio)
                    mRainSnowParamList.add(rainSnowParam)
                }
            }
        }
        mValueAnimator.start()
    }

    /**
     * 绘制下雨效果 或 下雪效果
     */
    private fun drawRainSnow(canvas: Canvas?) {
        if (canvas == null) return

        mWeatherImage?.let { weatherImage ->
            mRainSnowParamList.forEach { element ->
                move(element)

                canvas.save()
                canvas.scale(element.scale.toFloat(), element.scale.toFloat())
                mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
                    1F, 0F, 0F, 0F, 0F,
                    0F, 1F, 0F, 0F, 0F,
                    0F, 0F, 1F, 0F, 0F,
                    0F, 0F, 0F, element.alpha.toFloat(), 0F,
                ))
                canvas.drawBitmap(weatherImage, element.x.toFloat(), element.y.toFloat(), mPaint)
                canvas.restore()
            }
        }
    }

    private fun move(rainSnowParam: RainSnowParam) {
        rainSnowParam.y += rainSnowParam.speed
        if (isSnow(mWeatherType)) {
            val offsetX = sin(rainSnowParam.y / (300.0 + 50.0 * rainSnowParam.alpha)) * (1.0 + 0.5 * rainSnowParam.alpha) * rainSnowParam.widthRatio

            rainSnowParam.x += offsetX
        }
        if (rainSnowParam.y > rainSnowParam.height / rainSnowParam.scale) {
            rainSnowParam.y = - rainSnowParam.height * rainSnowParam.scale
            if (isRainy(mWeatherType) && mWeatherImage != null) {
                rainSnowParam.y = - mWeatherImage!!.height.toDouble()
            }
            rainSnowParam.reset()
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        initParam()
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        Log.e("测试", "SurfaceView开始创建")
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        Log.e("测试", "SurfaceView开始改变")
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
        Log.e("测试", "SurfaceView开始销毁")
    }

    override fun run() {

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        onDestroy()
    }

    /** 天气类型 */
    var weatherType
        @WeatherType get() = this.mWeatherType
        set(@WeatherType weatherType) {
            this.mWeatherType = weatherType
        }

    /**
     * 销毁，防止内存泄漏
     */
    fun onDestroy() {
        mValueAnimator.removeAllUpdateListeners()
        mValueAnimator.removeAllListeners()
        mValueAnimator.cancel()
    }

}