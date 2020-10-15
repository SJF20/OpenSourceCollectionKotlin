package com.shijingfeng.weather.widget

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.animation.LinearInterpolator
import com.shijingfeng.base.base.application.application
import com.shijingfeng.base.util.e
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.RainType
import com.shijingfeng.weather.constant.HEAVY_RAIN
import com.shijingfeng.weather.constant.LIGHT_RAIN
import com.shijingfeng.weather.constant.MODERATE_RAIN
import com.shijingfeng.weather.constant.STORM_RAIN
import kotlin.Exception
import kotlin.math.max
import kotlin.random.Random

/**
 * Function: 下雨 View
 * Date: 2020/10/12 15:50
 * Description:
 * @author ShiJingFeng
 */
internal class RainView @JvmOverloads constructor(
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
), SurfaceHolder.Callback {

    /** 雨 类型 */
    @RainType private var mRainType = LIGHT_RAIN
    /** 雨滴实体类 列表 */
    private val mRainList = mutableListOf<Rain>()

    /** Surface Holder */
    private val mSurfaceHolder = holder.apply {
        setFormat(PixelFormat.TRANSLUCENT)
        addCallback(this@RainView)
    }

    /** 动画 */
    private val mValueAnimator = ValueAnimator.ofFloat(0.0F, 1.0F).apply {
        interpolator = LinearInterpolator()
        duration = 60 * 1000
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addUpdateListener {
            mDrawingHandler?.sendEmptyMessage(0)
        }
    }
    /** 绘制 线程 */
    private lateinit var mDrawingHandlerThread: HandlerThread
    /** 绘制 Handler */
    private var mDrawingHandler: Handler? = null

    init {
        isFocusable = true
        isFocusableInTouchMode = true
        setZOrderOnTop(true)
        context.obtainStyledAttributes(attrs, R.styleable.RainView).run {
            mRainType = getInt(R.styleable.RainView_rainType, LIGHT_RAIN)
            //一定要回收，否则会内存泄漏
            recycle()
        }
    }

    /**
     * Surface创建
     */
    override fun surfaceCreated(holder: SurfaceHolder?) = init()

    /**
     * Surface尺寸改变，通常和 surfaceCreated 一起被调用
     */
    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {}

    /**
     * Surface销毁，Activity或Fragment onStop onDestroy时候 和 锁屏时 会调用
     */
    override fun surfaceDestroyed(holder: SurfaceHolder?) = destroy()

    /**
     * 初始化
     */
    private fun init() {
        initData()
        mDrawingHandlerThread = object : HandlerThread("drawing_thread") {
            override fun onLooperPrepared() {
                super.onLooperPrepared()
                mDrawingHandler = RainDrawingHandler(
                    looper = looper,
                    surfaceHolder = mSurfaceHolder,
                    rainList = mRainList
                )
            }
        }.apply {
            start()
        }
        mValueAnimator.start()
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
                mRainList.add(Rain(
                    width = width,
                    height = height,
                    rainType = mRainType
                ).init(
                    widthRatio = width / 392F,
                    heightRatio = height / 817F
                ))
            }
        }
    }

    /**
     * 销毁，防止内存泄漏
     */
    private fun destroy() {
        mDrawingHandlerThread.quit()
        mDrawingHandler?.removeCallbacksAndMessages(null)
        mValueAnimator.cancel()
    }

    /** 雨 类型 */
    var rainType
        @RainType get() = this.mRainType
        set(@RainType rainType) {
            this.mRainType = rainType
        }

}

/**
 * DrawingHandler
 */
private class RainDrawingHandler(
    looper: Looper,
    surfaceHolder: SurfaceHolder,
    rainList: List<Rain>
) : Handler(looper) {

    /** SurfaceView 帮助类 */
    private val mSurfaceHolder = surfaceHolder
    /** 水滴实体类 列表 */
    private val mRainList = rainList

    /** 水滴 Bitmap */
    private val mRainImage = BitmapFactory.decodeResource(application.resources, R.drawable.rain)
    /** 画笔 */
    private val mPaint = Paint()

    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        draw()
    }

    /**
     * 此处进行绘制，类似于 View 的 OnDraw(Canvas) 方法
     */
    private fun draw() {
        var canvas: Canvas? = null

        try {
            canvas = mSurfaceHolder.lockCanvas()

            // 还是上一个Canvas, 绘制的内容需要清空一下，防止绘制叠加
            canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
            drawRain(canvas)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (canvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
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

}

/**
 * 水滴实体类
 */
private data class Rain(

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

    /** 宽度 */
    var width: Int = 0,

    /** 高度 */
    var height: Int = 0,

    /** 雨 类型 */
    @RainType var rainType: Int,

    var widthRatio: Float = 0F,

    var heightRatio: Float = 0F

) {

    fun init(
        widthRatio: Float,
        heightRatio: Float
    ): Rain {
        this.widthRatio = widthRatio
        this.heightRatio = max(heightRatio, 0.65F)

        /// 雨 0.1 雪 0.5
        reset()
        this.y = if (scale == 0F) 0F else Random.nextInt((800F / scale).toInt()).toFloat()
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
        this.speed = 30F * random * ratio * heightRatio
        this.alpha = random * 0.6F
        this.x = if (scale == 0F) 0F else Random.nextInt((width * 1.2F / scale).toInt()).toFloat() - (width * 0.1F / scale).toInt()
    }

}