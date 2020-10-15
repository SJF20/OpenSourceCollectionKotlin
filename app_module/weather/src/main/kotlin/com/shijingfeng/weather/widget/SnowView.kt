package com.shijingfeng.weather.widget

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.animation.LinearInterpolator
import com.shijingfeng.base.base.application.application
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.SnowType
import com.shijingfeng.weather.constant.*
import com.shijingfeng.weather.constant.LIGHT_SNOW
import kotlin.math.max
import kotlin.math.sin
import kotlin.random.Random

/**
 * Function: 下雪 View
 * Date: 2020/10/15 16:36
 * Description:
 * @author ShiJingFeng
 */
internal class SnowView @JvmOverloads constructor(
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

    companion object {
        /** 绘制更新时间间隔(毫秒) */
        private const val UPDATE_TIME_INTERVAL = 60L
    }

    /** 雪 类型 */
    @SnowType private var mSnowType = LIGHT_SNOW
    /** 雪花实体类 列表 */
    private val mSnowList = mutableListOf<Snow>()

    /** Surface Holder */
    private val mSurfaceHolder = holder.apply {
        setFormat(PixelFormat.TRANSLUCENT)
        addCallback(this@SnowView)
    }

    private var mPreMillis = 0L

    /** 动画 */
    private val mValueAnimator = ValueAnimator.ofFloat(0.0F, 1.0F).apply {
        interpolator = LinearInterpolator()
        duration = 60 * 1000
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                mPreMillis = 0L
            }
        })
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
        context.obtainStyledAttributes(attrs, R.styleable.SnowView).run {
            mSnowType = getInt(R.styleable.SnowView_snowType, LIGHT_SNOW)
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
                mDrawingHandler = SnowDrawingHandler(
                    looper = looper,
                    surfaceHolder = mSurfaceHolder,
                    snowList = mSnowList
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
                mSnowList.add(Snow(
                    width = width,
                    height = height,
                    snowType = mSnowType
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

    /** 雪 类型 */
    var snowType
        @SnowType get() = this.mSnowType
        set(@SnowType snowType) {
            this.mSnowType = snowType
        }

}

/**
 * DrawingHandler
 */
private class SnowDrawingHandler(
    looper: Looper,
    surfaceHolder: SurfaceHolder,
    snowList: List<Snow>
) : Handler(looper) {

    /** SurfaceView 帮助类 */
    private val mSurfaceHolder = surfaceHolder
    /** 雪花实体类 列表 */
    private val mSnowList = snowList

    /** 雪花 Bitmap */
    private val mSnowImage = BitmapFactory.decodeResource(application.resources, R.drawable.snow)
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
            drawSnow(canvas)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (canvas != null) {
                mSurfaceHolder.unlockCanvasAndPost(canvas)
            }
        }
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

            y += speed
            x += sin(y / (300F + 50F * alpha)) * (1F + 0.5F * alpha) * widthRatio
            if (y > realHeight) {
                y = -height * scale
                reset()
            }
        }
    }

}

/**
 * 雪花实体类
 */
private data class Snow(

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

    /** 雪 类型 */
    @SnowType var snowType: Int,

    var widthRatio: Float = 0F,

    var heightRatio: Float = 0F

) {

    fun init(
        widthRatio: Float,
        heightRatio: Float
    ): Snow {
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
        val ratio = when (snowType) {
            LIGHT_SNOW -> 0.5F
            MODERATE_SNOW -> 0.75F
            HEAVY_SNOW,
            STORM_SNOW -> 1.0F
            else -> 1.0F
        }
        val random = 0.4F + 0.12F * Random.nextFloat() * 5F

        this.scale = random * 0.8F * heightRatio
        this.speed = 8F * random * ratio * heightRatio
        this.alpha = random
        this.x = if (scale == 0F) 0F else Random.nextInt((width * 1.2F / scale).toInt()).toFloat() - (width * 0.1F / scale).toInt()
    }

}