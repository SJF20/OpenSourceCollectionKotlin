package com.shijingfeng.base.widget

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.SizeUtils
import com.shijingfeng.base.R
import com.shijingfeng.base.util.getColorById

/**
 * Function: 水平列表分隔线 ItemDecoration
 * Date: 2020/3/17 23:07
 * Description:
 * Author: ShiJingFeng
 */
class LinearDividerItemDecoration @JvmOverloads constructor(
    /** 分隔线颜色 */
    @ColorInt dividerColor: Int = getColorById(R.color.white_smoke),
    /** 分隔线高 */
    dividerHeight: Int = SizeUtils.dp2px(1F),
    /** 分割线顶部 Margin */
    dividerTopMargin: Int = 0,
    /** 分割线底部 Margin */
    dividerBottomMargin: Int = 0,
    /** 分割线左部 Margin */
    dividerLeftMargin: Int = 0,
    /** 分割线右部 Margin */
    dividerRightMargin: Int = 0
) : RecyclerView.ItemDecoration() {

    /** 分隔线颜色 */
    @ColorInt private val mDividerColor = dividerColor
    /** 分隔线高 */
    private val mDividerHeight = dividerHeight
    /** 分割线顶部 Margin */
    private val mDividerTopMargin = dividerTopMargin
    /** 分割线底部 Margin */
    private val mDividerBottomMargin = dividerBottomMargin
    /** 分割线左部 Margin */
    private val mDividerLeftMargin = dividerLeftMargin
    /** 分割线右部 Margin */
    private val mDividerRightMargin = dividerRightMargin

    private val mPaint = Paint()

    init {
        mPaint.run {
            reset()
            color = mDividerColor
            strokeWidth = mDividerHeight.toFloat()
            isAntiAlias = true
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val currentItemPosition = parent.getChildAdapterPosition(view)
        val itemCount = parent.adapter?.itemCount ?: 0
        val bottomInterval = mDividerTopMargin + mDividerBottomMargin

        outRect.set(0, 0, 0, if (currentItemPosition >= itemCount - 1) 0 else bottomInterval)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        parent.forEachIndexed { index, child ->
            // 矩形左上顶点 = (ItemView的左边界,ItemView的下边界)
            val left = child.left.toFloat()
            val top = (child.bottom + mDividerTopMargin).toFloat()
            // 矩形右下顶点 = (ItemView的右边界,矩形的下边界)
            val right = child.right.toFloat()
            val bottom = top + mDividerHeight

            if (index != parent.childCount - 1) {
                // 通过Canvas绘制分割线
                c.drawLine(left, top, right, bottom, mPaint)
            }
        }
    }
}