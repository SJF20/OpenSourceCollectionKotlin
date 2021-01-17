package com.shijingfeng.weather.widget.weather.snow

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
import com.shijingfeng.weather.annotation.define.SnowType
import com.shijingfeng.weather.common.constant.HEAVY_SNOW
import com.shijingfeng.weather.common.constant.LIGHT_SNOW
import com.shijingfeng.weather.common.constant.MODERATE_SNOW
import com.shijingfeng.weather.common.constant.STORM_SNOW
import kotlin.math.max
import kotlin.math.sin
import kotlin.random.Random

/**
 * Function: 下雪 View
 * Date: 2020/10/16 12:56
 * Description:
 * Author: ShiJingFeng
 */
internal class SnowView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    @SnowType snowType: Int? = null,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(
    context,
    attrs,
    defStyleAttr,
    defStyleRes
) {

    /** 雪 类型 */
    @SnowType private var mSnowType: Int
    /** 雪花 Bitmap */
    private val mSnowImage = BitmapFactory.decodeResource(application.resources, R.drawable.snow)
    /** 雪花实体类 列表 */
    private val mSnowList = mutableListOf<Snow>()

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
        context.obtainStyledAttributes(attrs, R.styleable.SnowView).run {
            mSnowType = getInt(R.styleable.SnowView_snowType,
                LIGHT_SNOW
            )
            //一定要回收，否则会内存泄漏
            recycle()
        }
        if (snowType != null) {
            mSnowType = snowType
        }
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        val width = width
        val height = height

        mSnowList.clear()
        if (width != 0 && height != 0) {
            val count = when (mSnowType) {
                LIGHT_SNOW -> 30
                MODERATE_SNOW -> 100
                HEAVY_SNOW,
                STORM_SNOW -> 200
                else -> 0
            }

            for (i in 0 until count) {
                mSnowList.add(
                    Snow(
                        width = width,
                        height = height,
                        snowType = mSnowType
                    ).init(
                    widthRatio = width / SizeUtils.dp2px(392F).toFloat(),
                    heightRatio = height / SizeUtils.dp2px(817F).toFloat()
                ))
            }
        }
        mValueAnimator.start()
    }

    /**
     * 绘制下雪效果
     */
    private fun drawSnow(canvas: Canvas?) {
        if (canvas == null) return

        mSnowImage?.let { weatherImage ->
            mSnowList.forEach { element ->
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
     * 移动雪花
     */
    private fun move(snow: Snow) {
        snow.run {
            val realHeight = if (scale == 0F) 0F else height / scale

            x += sin(y / (SizeUtils.dp2px(300F).toFloat() + SizeUtils.dp2px(50F).toFloat() * alpha)) * (1F + 0.5F * alpha) * widthRatio
            y += speed
            if (y > realHeight) {
                y = -height * scale
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
        drawSnow(canvas)
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

    /** 雪 类型 */
    var snowType
        @SnowType get() = this.mSnowType
        set(@SnowType snowType) {
            this.mSnowType = snowType
            if (ThreadUtils.isMainThread()) {
                invalidate()
            } else {
                postInvalidate()
            }
        }

}

/**
 * 雪花实体类
 */
internal data class Snow(

    /** 宽度 */
    var width: Int,

    /** 高度 */
    var height: Int,

    /** 雪 类型 */
    @SnowType var snowType: Int,

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
    ): Snow {
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
        val ratio = when (snowType) {
            LIGHT_SNOW -> 0.5F
            MODERATE_SNOW -> 0.75F
            HEAVY_SNOW,
            STORM_SNOW -> 1.0F
            else -> 1.0F
        }
        val random = 0.4F + 0.12F * Random.nextFloat() * 5F

        this.scale = random * 0.8F * heightRatio
        this.speed = SizeUtils.dp2px(8F).toFloat() * random * ratio * heightRatio
        this.alpha = random
        this.x = if (scale == 0F) 0F else Random.nextInt((width * 1.2F / scale).toInt()).toFloat() - (width * 0.1F / scale).toInt()
    }

}