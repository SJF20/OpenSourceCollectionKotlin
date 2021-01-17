package com.shijingfeng.weather.widget.weather.rain

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.ThreadUtils
import com.shijingfeng.base.base.application.application
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.RainType
import com.shijingfeng.weather.common.constant.HEAVY_RAIN
import com.shijingfeng.weather.common.constant.LIGHT_RAIN
import com.shijingfeng.weather.common.constant.MODERATE_RAIN
import com.shijingfeng.weather.common.constant.STORM_RAIN
import kotlin.math.max
import kotlin.random.Random

/**
 * Function: 下雨 View
 * Date: 2020/10/15 17:54
 * Description:
 * Author: ShiJingFeng
 */
internal class RainView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    @RainType rainType: Int? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {

    /** 雨 类型 */
    @RainType private var mRainType: Int
    /** 水滴 Bitmap */
    private val mRainImage = BitmapFactory.decodeResource(application.resources, R.drawable.rain)
    /** 雨滴实体类 列表 */
    private val mRainList = mutableListOf<Rain>()

    /** 动画 */
    private val mValueAnimator = ValueAnimator.ofFloat(0F, 1F).apply {
        interpolator = LinearInterpolator()
        duration = 60 * 1000
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addUpdateListener {
            invalidate()
        }
    }

    /** 画笔 */
    private val mPaint = Paint()

    init {
        context.obtainStyledAttributes(attrs, R.styleable.RainView).run {
            mRainType = getInt(R.styleable.RainView_rainType,
                LIGHT_RAIN
            )
            //一定要回收，否则会内存泄漏
            recycle()
        }
        if (rainType != null) {
            mRainType = rainType
        }
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        val width = width
        val height = height

        mRainList.clear()
        if (width != 0 && height != 0) {
            val count = when (mRainType) {
                LIGHT_RAIN -> 70
                MODERATE_RAIN -> 100
                HEAVY_RAIN,
                STORM_RAIN -> 200
                else -> 0
            }

            for (i in 0 until count) {
                mRainList.add(
                    Rain(
                        width = width,
                        height = height,
                        rainType = mRainType
                    ).init(
                    widthRatio = width / SizeUtils.dp2px(392F).toFloat(),
                    heightRatio = height / SizeUtils.dp2px(817F).toFloat()
                ))
            }
        }
        mValueAnimator.start()
    }

    /**
     * 绘制下雨效果
     */
    private fun drawRain(canvas: Canvas?) {
        if (canvas == null) return

        mRainImage?.let { weatherImage ->
            mRainList.forEach { element ->
                move(element)

                canvas.save()
                canvas.scale(element.scale, element.scale)
                mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
                    1F, 0F, 0F, 0F, 0F,
                    0F, 1F, 0F, 0F, 0F,
                    0F, 0F, 1F, 0F, 0F,
                    0F, 0F, 0F, element.alpha, 0F,
                ))
                canvas.drawBitmap(weatherImage, element.x, element.y, mPaint)
                canvas.restore()
            }
        }
    }

    /**
     * 移动水滴
     */
    private fun move(rain: Rain) {
        rain.run {
            val realHeight = if (scale == 0F) 0F else height / scale

            y += speed
            if (y > realHeight) {
                y = -mRainImage!!.height.toFloat()
                reset()
            }
        }
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        initData()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawRain(canvas)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
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

    /** 雨 类型 */
    var rainType
        @RainType get() = this.mRainType
        set(@RainType rainType) {
            this.mRainType = rainType
            if (ThreadUtils.isMainThread()) {
                invalidate()
            } else {
                postInvalidate()
            }
        }

}

/**
 * 水滴实体类
 */
internal data class Rain(

    /** 宽度 */
    var width: Int,

    /** 高度 */
    var height: Int,

    /** 雨 类型 */
    @RainType var rainType: Int,

    /** x 坐标 */
    var x: Float = 0F,

    /** y 坐标 */
    var y: Float = 0F,

    /** 下落速度 */
    var speed: Float = 0F,

    /** 绘制的缩放 */
    var scale: Float = 0F,

    /** 透明度 */
    var alpha: Float = 0F,

    var widthRatio: Float = 0F,

    var heightRatio: Float = 0F

) {

    /**
     * 初始化
     */
    fun init(
        widthRatio: Float,
        heightRatio: Float
    ): Rain {
        this.widthRatio = widthRatio
        this.heightRatio = max(heightRatio, 0.65F)

        /// 雨 0.1 雪 0.5
        reset()
        this.y = if (scale == 0F) 0F else Random.nextInt((SizeUtils.dp2px(800F).toFloat() / scale).toInt()).toFloat()
        return this
    }

    /**
     * 当雪花移出屏幕时，需要重置参数
     */
    fun reset() {
        val ratio = when (rainType) {
            LIGHT_RAIN -> 0.5F
            MODERATE_RAIN -> 0.75F
            HEAVY_RAIN,
            STORM_RAIN -> 1.0F
            else -> 1.0F
        }
        val random = 0.4F + 0.12F * Random.nextFloat() * 5F

        this.scale = random * 1.2F
        this.speed = SizeUtils.dp2px(30F).toFloat() * random * ratio * heightRatio
        this.alpha = random * 0.6F
        this.x = if (scale == 0F) 0F else Random.nextInt((width * 1.2F / scale).toInt()).toFloat() - (width * 0.1F / scale).toInt()
    }

}