package com.shijingfeng.weather.widget.weather.snow

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
import com.blankj.utilcode.util.SizeUtils
import com.shijingfeng.base.base.application.application
import com.shijingfeng.weather.R
import com.shijingfeng.weather.annotation.define.SnowType
import com.shijingfeng.weather.common.constant.HEAVY_SNOW
import com.shijingfeng.weather.common.constant.LIGHT_SNOW
import com.shijingfeng.weather.common.constant.MODERATE_SNOW
import com.shijingfeng.weather.common.constant.STORM_SNOW
import kotlin.math.sin

/**
 * Function: 下雪 View
 * Date: 2020/10/15 16:36
 * Description:
 * @author ShiJingFeng
 */
internal class SnowSurfaceView @JvmOverloads constructor(
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

    /** 雪 类型 */
    @SnowType private var mSnowType =
        LIGHT_SNOW
    /** 雪花实体类 列表 */
    private val mSnowList = mutableListOf<Snow>()

    /** Surface Holder */
    private val mSurfaceHolder = holder.apply {
        setFormat(PixelFormat.TRANSLUCENT)
        addCallback(this@SnowSurfaceView)
    }

    private var mPreMillis = 0L

    /** 动画 */
    private val mValueAnimator = ValueAnimator.ofFloat(0F, 1F).apply {
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
        context.obtainStyledAttributes(attrs, R.styleable.SnowSurfaceView).run {
            mSnowType = getInt(R.styleable.SnowSurfaceView_snowSurfaceType,
                LIGHT_SNOW
            )
            //一定要回收，否则会内存泄漏
            recycle()
        }
    }

    /**
     * Surface创建
     */
    override fun surfaceCreated(holder: SurfaceHolder) = init()

    /**
     * Surface尺寸改变，通常和 surfaceCreated 一起被调用
     */
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

    /**
     * Surface销毁，Activity或Fragment onStop onDestroy时候 和 锁屏时 会调用
     */
    override fun surfaceDestroyed(holder: SurfaceHolder) = destroy()

    /**
     * 初始化
     */
    private fun init() {
        initData()
        mDrawingHandlerThread = object : HandlerThread("drawing_thread") {
            override fun onLooperPrepared() {
                super.onLooperPrepared()
                mDrawingHandler =
                    SnowDrawingHandler(
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
            canvas?.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
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
            x += sin(y / (SizeUtils.dp2px(300F).toFloat() + SizeUtils.dp2px(50F).toFloat() * alpha)) * (1F + 0.5F * alpha) * widthRatio
            if (y > realHeight) {
                y = -height * scale
                reset()
            }
        }
    }

}