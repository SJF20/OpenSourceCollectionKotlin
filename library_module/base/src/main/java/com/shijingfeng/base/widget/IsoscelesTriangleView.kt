package com.shijingfeng.base.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.shijingfeng.base.annotation.define.IsoscelesTriangleViewStyle
import com.shijingfeng.base.annotation.define.IsoscelesTriangleViewStyle.*

/**
 * Function: 三角形 View (用于下拉选择箭头)
 * Date: 2020/9/16 22:24
 * Description:
 * @author ShiJingFeng
 */
class IsoscelesTriangleView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    /** 路径 */
    private val mPath = Path()
    /** 画笔 */
    private val mPaint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    /** 颜色 */
    @ColorInt
    private var mColor = Color.BLACK

    /** 样式 */
    @IsoscelesTriangleViewStyle
    private var mStyle = STYLE_TOP_TO_BOTTOM

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paddingStart = paddingStart
        val paddingEnd = paddingEnd
        val paddingTop = paddingTop
        val paddingBottom = paddingBottom
        val width = width
        val height = height

        var realWidth = width - paddingStart - paddingEnd
        var realHeight = height - paddingTop - paddingBottom

        if (realWidth < 0) {
            realWidth = 0
        }
        if (realHeight < 0) {
            realHeight = 0
        }

        val left = paddingStart
        val top = paddingTop
        val right = left + realWidth
        val bottom = top + realHeight

        when (mStyle) {
            STYLE_TOP_TO_BOTTOM -> {

            }
            STYLE_BOTTOM_TO_TOP -> {

            }
            STYLE_LEFT_TO_RIGHT -> {

            }
            STYLE_RIGHT_TO_LEFT -> {
                
            }
        }
    }

    /**
     * 设置颜色 (ColoInt)
     */
    var color: Int
        @ColorInt get() = this.mColor
        set(@ColorInt color) {
            this.mColor = color
        }

    /**
     * 设置样式
     */
    var style: Int
        @IsoscelesTriangleViewStyle get() = this.mStyle
        set(@IsoscelesTriangleViewStyle style) {
            this.mStyle = style
        }

}