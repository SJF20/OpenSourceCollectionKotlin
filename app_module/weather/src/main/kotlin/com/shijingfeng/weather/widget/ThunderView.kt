package com.shijingfeng.weather.widget

import android.animation.*
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.shijingfeng.base.common.global.runOnUiThread
import com.shijingfeng.weather.R
import kotlin.random.Random

/**
 * Function: 雷电 View
 * Date: 2020/10/16 13:17
 * Description:
 * @author ShiJingFeng
 */
internal class ThunderView @JvmOverloads constructor(
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

    /** 雷电图片列表 */
    private val mThunderImageList = mutableListOf<Bitmap>()
    /** 雷电实体类 列表 */
    private val mThunderList = mutableListOf<Thunder>()

    private val mTotalAnimator = ValueAnimator.ofFloat(0F, 1F).apply {
        duration = 3 * 1000
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                runOnUiThread(50) {
                    initData()
                    start()
                }
            }
        })
        addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Float
        }
    }

//    private val mAnimatorSet = AnimatorSet().apply {
//        duration = 3 * 1000
//        addListener(object : AnimatorListenerAdapter() {
//            override fun onAnimationEnd(animation: Animator?) {
//                super.onAnimationEnd(animation)
//                runOnUiThread(50) {
//                    initData()
//                    start()
//                }
//            }
//        })
//    }

    /** 画笔 */
    private val mPaint = Paint()

    init {
        initImage()
    }

    /**
     * 初始化雷电图片
     */
    private fun initImage() {
        mThunderImageList.clear()
        mThunderImageList.add(BitmapFactory.decodeResource(resources, R.drawable.lightning0))
        mThunderImageList.add(BitmapFactory.decodeResource(resources, R.drawable.lightning1))
        mThunderImageList.add(BitmapFactory.decodeResource(resources, R.drawable.lightning2))
        mThunderImageList.add(BitmapFactory.decodeResource(resources, R.drawable.lightning3))
        mThunderImageList.add(BitmapFactory.decodeResource(resources, R.drawable.lightning4))
    }

    /**
     * 初始化数据
     */
    private fun initData() {
        val width = width
        val height = height

        mThunderList.clear()
        if (width != 0 && height != 0) {
            // 配置三个闪电信息
            for (i in 0..2) {
                mThunderList.add(Thunder(
                    image = mThunderImageList[Random.nextInt(5)],
                    width = width,
                    height = height,
                    widthRatio = width / 392F
                ))
            }
        }
    }

    /**
     * 绘制雷电
     */
    private fun drawThunder(
        thunder: Thunder,
        canvas: Canvas?
    ) {
        if (canvas == null) return

        canvas.save()
        canvas.scale(thunder.widthRatio * 1.2F, thunder.widthRatio * 1.2F)
        mPaint.colorFilter = ColorMatrixColorFilter(floatArrayOf(
            1F, 0F, 0F, 0F, 0F,
            0F, 1F, 0F, 0F, 0F,
            0F, 0F, 1F, 0F, 0F,
            0F, 0F, 0F, thunder.alpha, 0F,
        ))
        canvas.drawBitmap(thunder.image, thunder.x, thunder.y, mPaint)
        canvas.restore()

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        initData()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mThunderList.forEach { thunder ->
            drawThunder(thunder, canvas)
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }

}

internal data class Thunder(

    /** 配置闪电的图片资源 */
    var image: Bitmap,

    /** 宽度 */
    var width: Int,

    /** 高度 */
    var height: Int,

    var widthRatio: Float,

    /** 图片展示的 x 坐标 */
    var x: Float = Random.nextFloat() * 0.5F * widthRatio - 1F / 3F * image.width,

    /** 图片展示的 y 坐标 */
    var y: Float = Random.nextFloat() * -0.05F * height,

    /** 闪电的 alpha 属性 */
    var alpha: Float = 0F

)