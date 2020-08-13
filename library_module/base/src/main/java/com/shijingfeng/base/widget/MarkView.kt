package com.shijingfeng.base.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.shijingfeng.base.R

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
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val mBackgroundPath = Path()
    private val mBackgroundPaint = Paint()

    init {
        mBackgroundPaint.style = Paint.Style.FILL
        mBackgroundPaint.color = resources.getColor(R.color.red)
        mBackgroundPaint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        rotation = -45F
        mBackgroundPath.moveTo(0F, 0F)
        
    }

}