package com.shijingfeng.base.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.blankj.utilcode.util.SizeUtils
import com.shijingfeng.base.R
import com.shijingfeng.base.annotation.define.MarkViewStyle
import com.shijingfeng.base.annotation.define.MarkViewStyle.*
import com.shijingfeng.base.util.getColorById
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Function:
 * Date: 2020/8/13 17:54
 * Description:
 * @author ShiJingFeng
 */
class MarkView(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val mBgPath = Path()
    private val mBgPaint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
    }
    private val mTextPaint = Paint().apply {
        isAntiAlias = true
    }

    /** 文本 (默认空字符串) */
    private var mText = ""
    /** 文本大小 (默认8sp) */
    private var mTextSize = SizeUtils.sp2px(8F).toFloat()
    /** 文本颜色 (默认纯白色) */
    @ColorInt private var mTextColor = Color.WHITE
    /** 三角背景颜色 (默认纯红色) */
    @ColorInt private var mBgColor = Color.RED
    /** 控件样式 (默认左上角样式) */
    @MarkViewStyle
    private var mStyle = STYLE_LEFT_TOP

    init {
        context.obtainStyledAttributes(attrs, R.styleable.MarkView).run {
            mText = getString(R.styleable.MarkView_text) ?: ""
            mTextSize = getDimension(R.styleable.MarkView_textSize, SizeUtils.sp2px(8F).toFloat())
            mTextColor = getColor(R.styleable.MarkView_textColor, Color.WHITE)
            mBgColor = getColor(R.styleable.MarkView_bgColor, Color.RED)
            //一定要回收，否则会内存泄漏
            recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val w = if (width != 0) width else SizeUtils.dp2px(30F)
        val h = if (height != 0) height else SizeUtils.dp2px(30F)
        val size = if (w > h) h.toFloat() else w.toFloat()

        mStyle = STYLE_LEFT_BOTTOM
        mTextSize = SizeUtils.sp2px(100F).toFloat()
        mTextColor = Color.BLACK

        mBgPaint.run {
            color = mBgColor
        }
        mBgPath.run {
            reset()
            when (mStyle) {
                // 左上角
                STYLE_LEFT_TOP -> {
                    moveTo(0F, 0F)
                    lineTo(size, 0F)
                    lineTo(0F, size)
                    lineTo(0F, 0F)
                }
                // 左下角
                STYLE_LEFT_BOTTOM -> {
                    moveTo(0F, 0F)
                    lineTo(size, size)
                    lineTo(0F, size)
                    lineTo(0F, 0F)
                }
                // 右上角
                STYLE_RIGHT_TOP -> {
                    moveTo(0F, 0F)
                    lineTo(size, 0F)
                    lineTo(size, size)
                    lineTo(0F, 0F)
                }
                // 右下角
                STYLE_RIGHT_BOTTOM -> {
                    moveTo(size, 0F)
                    lineTo(size, size)
                    lineTo(0F, size)
                    lineTo(size, 0F)
                }
                else -> {}
            }
        }
        canvas?.drawPath(mBgPath, mBgPaint)

        mTextPaint.run {
            color = mTextColor
            textSize = mTextSize
        }

        text = "重要"

        val textWidth = mTextPaint.measureText(text)
        val textHeight = measureTextHeight(mTextPaint)

        // 旋转画布后, 坐标系也随之旋转, 旋转角度规则: 以第一象限X轴为0度, 顺时针旋转方向为角度增加方向
        when (mStyle) {
            // 左上角
            STYLE_LEFT_TOP -> {
                val x = size / 4F - textWidth / 2F
                val y = size / 4F + textHeight / 2F
                val textX = 0F - textWidth / 2F
                val textY = sqrt(x.pow(2) + y.pow(2)) + textHeight / 2F

                canvas?.rotate(-45F)
                canvas?.drawText(text, textX, textY, mTextPaint)
            }
            // 左下角
            STYLE_LEFT_BOTTOM -> {
                val x = size / 4F - textWidth / 2F
                val y = size / 4F * 3F + textHeight / 2F
                val textX = 0F - textWidth / 2F
                val textY = sqrt(x.pow(2) + y.pow(2)) + textHeight / 2F

//                canvas?.rotate(45F)
                canvas?.drawText(text, x, y, mTextPaint)
            }
            // 右上角
            STYLE_RIGHT_TOP -> {

            }
            // 右下角
            STYLE_RIGHT_BOTTOM -> {

            }
            else -> {}
        }
    }

    /**
     * 测量文字的高度
     * --经测试后发现，采用另一种带Rect的方式，获得的数据并不准确。
     * 特别是在一些对文字有一些倾斜处理的时候
     * @param paint
     * @return
     */
    private fun measureTextHeight(paint: Paint?) = if (paint == null) 0F else paint.fontMetrics.descent - paint.fontMetrics.ascent

    /**
     * 设置文本
     */
    var text: String
    get() = this.mText
    set(text) {
        this.mText = text
        invalidate()
    }

    /**
     * 设置文本颜色 (ColoInt)
     */
    var textColor: Int
    @ColorInt get() = this.mTextColor
    set(@ColorInt textColor) {
        this.mTextColor = textColor
        invalidate()
    }

    /**
     * 设置文本大小 (px值)
     */
    var textSize: Float
    get() = this.mTextSize
    set(textSize) {
        this.mTextSize = textSize
        invalidate()
    }

    /**
     * 设置三角背景颜色 (ColoInt)
     */
    var bgColor: Int
    @ColorInt get() = this.mBgColor
    set(@ColorInt bgColor) {
        this.mBgColor = bgColor
        invalidate()
    }

    /**
     * 设置样式
     */
    var style: Int
    @MarkViewStyle get() = this.mStyle
    set(@MarkViewStyle style) {
        this.mStyle = style
        invalidate()
    }

}