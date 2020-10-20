package com.shijingfeng.weather.widget.night_start

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.tan
import kotlin.random.Random

/**
 * Function: 夜晚晴 View
 * Date: 2020/10/16 16:15
 * Description:
 * @author ShiJingFeng
 */
internal class NightSunnyView @JvmOverloads constructor(
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

    /** 流星实体类 列表 */
    private val mMeteorList = mutableListOf<Meteor>()
    /** 星星实体类 列表 */
    private val mStarList = mutableListOf<Star>()

    /** 动画 */
    private val mValueAnimator = ValueAnimator.ofFloat(0F, 1F).apply {
        interpolator = LinearInterpolator()
        duration = 5 * 1000
        repeatCount = ValueAnimator.INFINITE
        repeatMode = ValueAnimator.RESTART
        addUpdateListener {
            invalidate()
        }
    }

    /** 流星宽度 */
    private val mMeteorWidth = 200F
    /** 流星高度 */
    private val mMeteorHeight = 2F
    /**  */
    private val mRadius = 10F

    /** 流星画笔 */
    private val mMeteorPaint = Paint()
    /** 星星画笔 */
    private val mStarPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
        maskFilter = BlurMaskFilter(1F, BlurMaskFilter.Blur.NORMAL)
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        mStarList.clear()
        for (i in 0 until 100) {
            mStarList.add(Star(
                index = Random.nextInt(2)
            ).init(width, height, width / 392F))
        }
        // 如需调整流星量 和 上下位置，可在此处改变 i 的数量 和 height
        for (i in 0 until 10) {
            mMeteorList.add(Meteor(
                width = width,
                height = height / 8,
                widthRatio = width / 392F
            ))
        }
        mValueAnimator.start()
    }

    /**
     * 绘制流星
     */
    private fun drawMeteor(
        meteor: Meteor,
        canvas: Canvas?
    ) {
        if (canvas == null) return

        canvas.save()
        mMeteorPaint.shader = LinearGradient(
            0F, 0F,
            mMeteorWidth, 0F,
            intArrayOf(Color.parseColor("#FFFFFFFF"), Color.parseColor("#00FFFFFF")),
            null,
            Shader.TileMode.CLAMP
        )
        canvas.rotate(meteor.radians * 180F)
        canvas.scale(meteor.widthRatio, meteor.widthRatio)
        canvas.translate(meteor.translateX, tan(PI * 0.1F).toFloat() * mMeteorWidth + meteor.translateY)
        canvas.drawRoundRect(RectF(
            0F, 0F, mMeteorWidth, mMeteorHeight
        ), mRadius, mRadius, mMeteorPaint)
        meteor.move()
        canvas.restore()
        //canvas.save();
        //    var gradient = ui.Gradient.linear(
        //      const Offset(0, 0),
        //      Offset(_meteorWidth, 0),
        //      <Color>[const Color(0xFFFFFFFF), const Color(0x00FFFFFF)],
        //    );
        //    _meteorPaint.shader = gradient;
        //    canvas.rotate(pi * param.radians);
        //    canvas.scale(widthRatio);
        //    canvas.translate(
        //        param.translateX, tan(pi * 0.1) * _meteorWidth + param.translateY);
        //    canvas.drawRRect(
        //        RRect.fromLTRBAndCorners(0, 0, _meteorWidth, _meteorHeight,
        //            topLeft: _radius,
        //            topRight: _radius,
        //            bottomRight: _radius,
        //            bottomLeft: _radius),
        //        _meteorPaint);
        //    param.move();
        //    canvas.restore();
    }

    /**
     * 绘制星星
     */
    private fun drawStar(
        star: Star,
        canvas: Canvas?
    ) {
        if (canvas == null) return

        canvas.save()
        canvas.scale(star.scale, star.scale)
        mStarPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            1F, 0F, 0F, 0F, 0F,
            0F, 1F, 0F, 0F, 0F,
            0F, 0F, 1F, 0F, 0F,
            0F, 0F, 0F, star.alpha, 0F,
        ))
        canvas.drawCircle(star.x, star.y, 3F, mStarPaint)
        canvas.restore()
        star.move()
        //if (param == null) {
        //      return;
        //    }
        //    canvas.save();
        //    var identity = ColorFilter.matrix(<double>[
        //      1,
        //      0,
        //      0,
        //      0,
        //      0,
        //      0,
        //      1,
        //      0,
        //      0,
        //      0,
        //      0,
        //      0,
        //      1,
        //      0,
        //      0,
        //      0,
        //      0,
        //      0,
        //      param.alpha,
        //      0,
        //    ]);
        //    _paint.colorFilter = identity;
        //    canvas.scale(param.scale);
        //    canvas.drawCircle(Offset(param.x, param.y), 3, _paint);
        //    canvas.restore();
        //    param.move();
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        initData()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mMeteorList.forEach { meteor ->
            drawMeteor(meteor, canvas)
        }
        mStarList.forEach { start ->
            drawStar(start, canvas);
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        onDestroy()
    }

    /**
     * 销毁，防止内存泄漏
     */
    private fun onDestroy() {
        mValueAnimator.removeAllUpdateListeners()
        mValueAnimator.removeAllListeners()
        mValueAnimator.cancel()
    }

}

/**
 * 流星 实体类
 */
internal data class Meteor(

    /** X轴平移距离 */
    var translateX: Float = 0F,

    /** Y轴平移距离 */
    var translateY: Float = 0F,

    /** 弧度 */
    var radians: Float = 0F,

    /** 宽 */
    var width: Int,

    /** 高 */
    var height: Int,

    var widthRatio: Float,

) {

    init {
        reset()
    }

    /**
     * 重置数据
     */
    fun reset() {
        translateX = width + Random.nextFloat() * 20F * width
        radians = -Random.nextFloat() * 0.07F - 0.05F
        translateY = Random.nextFloat() * 0.5F * height * widthRatio
    }

    /**
     * 移动
     */
    fun move() {
        translateX -= 20F
        if (translateX <= -width / widthRatio) {
            reset()
        }
    }

}

/**
 * 星星
 */
internal data class Star(

    /** x 坐标 */
    var x: Float = 0F,

    /** y 坐标 */
    var y: Float = 0F,

    /** 透明度值，默认为 0 */
    var alpha: Float = 0F,

    /** 缩放 */
    var scale: Float = 0F,

    /** 是否反向动画 */
    var reverse: Boolean = false,

    /** 当前下标值 */
    var index: Int,

    /** 宽 */
    var width: Int = 0,

    /** 高 */
    var height: Int = 0,

    var widthRatio: Float = 0F

) {

    /**
     * 初始化
     */
    fun init(
        width: Int,
        height: Int,
        widthRatio: Float
    ): Star {
        this.width = width
        this.height = height
        this.widthRatio = widthRatio
        this.alpha = Random.nextFloat()

        val baseScale = if (index == 0) 0.7F else 0.5F

        this.scale = (Random.nextFloat() * 0.1F + baseScale) * widthRatio
        this.x = Random.nextFloat() * width / scale
        this.y = Random.nextFloat() * max(0.3F * height, 150F)
        this.reverse = false
        return this
    }

    /**
     * 重置
     */
    fun reset() {
        val baseScale = if (index == 0) 0.7F else 0.5F

        this.alpha = 0F
        this.scale = (Random.nextFloat() * 0.1F + baseScale) * widthRatio
        this.x = Random.nextFloat() * width / scale
        this.y = Random.nextFloat() * max(0.3F * height, 150F)
        this.reverse = false
    }

    /**
     * 每次绘制完会触发此方法，开始移动
     */
    fun move() {
        if (reverse) {
            this.alpha -= 0.01F
            if (this.alpha < 0F) {
                reset()
            }
        } else {
            this.alpha += 0.01F
            if (this.alpha > 1.2F) {
                this.reverse = true
            }
        }
    }

}