package com.shijingfeng.weather.widget

import android.animation.ValueAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.RESTART
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.animation.LinearInterpolator
import com.shijingfeng.base.util.e
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.WeatherType
import com.shijingfeng.weather.constant.*
import com.shijingfeng.weather.util.isRainSnow
import com.shijingfeng.weather.util.isRainy
import com.shijingfeng.weather.util.isSnow
import kotlin.math.max
import kotlin.math.sin
import kotlin.random.Random

/**
 * Function:
 * Date: 2020/10/12 16:27
 * Description:
 * @author ShiJingFeng
 */
internal class RainSnowView2 @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {

    @WeatherType private var mWeatherType = CLEAR_DAY

    private var mWeatherImage: Bitmap? = null
    private val mRainSnowParamList = mutableListOf<RainSnowParam>()
    private var count = 0

    private val mPaint = Paint()

    private var mPrevMillis = System.currentTimeMillis()

    private val mValueAnimator = ValueAnimator.ofFloat(0.0F, 1.0F).apply {
        interpolator = LinearInterpolator()
        duration = 60 * 1000
        repeatCount = INFINITE
        repeatMode = RESTART
        addUpdateListener {
            val curMillis = System.currentTimeMillis()

            if (curMillis - mPrevMillis > 1000) {
                mPrevMillis = curMillis
                e("RainSnowView2", "更新中...")
            }
            invalidate()
        }
    }

    init {
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
//        invalidate()
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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        e("RainSnowView2", "onMeasure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        e("RainSnowView2", "onLayout")
        initParam()
    }

    var drawed = false

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (!drawed) {
            drawed = true
            e("RainSnowView2", "onDraw")
        }
        drawRainSnow(canvas)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        e("RainSnowView2", "onAttachedToWindow")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        e("RainSnowView2", "onDetachedFromWindow")
        onDestroy()
    }

    /**
     * 对应 Activity或Fragment onStart()方法
     * 用于恢复动画播放
     */
    fun onStart() {
        mValueAnimator.resume()
    }

    /**
     * 对应 Activity或Fragment onStop方法
     * 用于暂停动画
     */
    fun onStop() {
        mValueAnimator.pause()
    }

    /**
     * 销毁，防止内存泄漏
     */
    private fun onDestroy() {
        mValueAnimator.removeAllUpdateListeners()
        mValueAnimator.removeAllListeners()
        mValueAnimator.cancel()
    }

    /** 天气类型 */
    var weatherType
      @WeatherType get() = this.mWeatherType
      set(@WeatherType weatherType) {
          this.mWeatherType = weatherType
      }

}

data class RainSnowParam(

    /** x 坐标 */
    var x: Double = 0.0,

    /** y 坐标 */
    var y: Double = 0.0,

    /** 下落速度 */
    var speed: Double = 0.0,

    /** 绘制的缩放 */
    var scale: Double = 0.0,

    /** 宽度 */
    var width: Double = 0.0,

    /** 高度 */
    var height: Double = 0.0,

    /** 透明度 */
    var alpha: Double = 0.0,

    /** 天气类型 */
    @WeatherType var weatherType: Int,

    var widthRatio: Double = 0.0,

    var heightRatio: Double = 0.0

) {

    fun init(
        widthRatio: Double,
        heightRatio: Double
    ) {
        this.widthRatio = widthRatio
        this.heightRatio = max(heightRatio, 0.65)

        /// 雨 0.1 雪 0.5
        reset()
        y = Random.nextInt((800 / scale).toInt()).toDouble()
    }

    /**
     * 当雪花移出屏幕时，需要重置参数
     */
    fun reset() {
        val ratio = when (weatherType) {
            LIGHT_RAIN -> 0.5
            MODERATE_RAIN -> 0.75
            HEAVY_RAIN,
            STORM_RAIN -> 1.0
            LIGHT_SNOW -> 0.5
            MODERATE_SNOW -> 0.75
            HEAVY_SNOW,
            STORM_SNOW -> 1.0
            else -> 1.0
        }

        val random: Double

        if (isRainy(weatherType)) {
            random = 0.4 + 0.12 * Random.nextDouble() * 5.0
            this.scale = random * 1.2
            this.speed = 30.0 * random * ratio * heightRatio
            this.alpha = random * 0.6
            this.x = Random.nextInt((width * 1.2 / scale).toInt()).toDouble() - (width * 0.1 / scale).toInt()
        } else {
            random = 0.4 + 0.12 * Random.nextDouble() * 5.0
            this.scale = random * 0.8 * heightRatio
            this.speed = 8 * random * ratio * heightRatio
            this.alpha = random
            this.x = Random.nextInt((width * 1.2 / scale).toInt()).toDouble() - (width * 0.1 / scale).toInt()
        }
    }

}