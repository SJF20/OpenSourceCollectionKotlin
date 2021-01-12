/** 生成的 Java 类名 */
@file:JvmName("LayoutUtil")
package com.shijingfeng.base.util

import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import kotlin.coroutines.suspendCoroutine

/**
 * Function: 固定宽 栅格布局 工具类
 * Date: 2020/2/2 21:00
 * Description:
 * Author: ShiJingFeng
 */

/**
 * 布局 (按控件宽度逐行排列, 无固定列数)
 * @param linearLayout 容器LinearLayout
 * @param childViewList 子View列表
 * @param totalWidth 横向总宽度
 * @param interval 间隔大小
 * @param gravity 对齐方式
 */
fun layout(linearLayout: LinearLayout, childViewList: List<View?>, totalWidth: Int, interval: Int = 0, gravity: Int = Gravity.START) {
    if (childViewList.isEmpty()) {
        return
    }

    linearLayout.orientation = LinearLayout.VERTICAL
    linearLayout.removeAllViews()

    val context: Context = linearLayout.context
    val groupChildViewList: MutableList<MutableList<View>> = ArrayList()
    var currentLineWidth = 0

    //垂直分组
    for (i in childViewList.indices) {
        val view = childViewList[i] ?: continue
        val viewWidth: Int

        viewWidth = if (view.measuredState == MATCH_PARENT) {
            totalWidth
        } else {
            val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(
                (1 shl 30) - 1,
                View.MeasureSpec.AT_MOST
            )
            val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(
                (1 shl 30) - 1,
                View.MeasureSpec.AT_MOST
            )

            view.measure(widthMeasureSpec, heightMeasureSpec)
            view.measuredWidth
        }

        val width = viewWidth + interval

        if (currentLineWidth + width > totalWidth) {
            val grandchildViewList: MutableList<View> = ArrayList()

            currentLineWidth = width
            grandchildViewList.add(view)
            groupChildViewList.add(grandchildViewList)
        } else {
            if (groupChildViewList.size == 0) {
                groupChildViewList.add(ArrayList())
            }
            groupChildViewList[groupChildViewList.size - 1].add(view)
            currentLineWidth += width
        }
    }

    //布局
    for (i in 0 until groupChildViewList.size) {
        val grandchildViewList: MutableList<View> = groupChildViewList[i]
        val llChildView = LinearLayout(context)

        llChildView.orientation = LinearLayout.HORIZONTAL
        llChildView.gravity = gravity

        for (j in 0 until grandchildViewList.size) {
            val grandchildView = grandchildViewList[j]

            llChildView.addView(grandchildView)

            val params = grandchildView.layoutParams as LinearLayout.LayoutParams

            if (j != 0) {
                params.leftMargin = interval
            }
            grandchildView.layoutParams = params
        }

        linearLayout.addView(llChildView)

        val params = llChildView.layoutParams as LinearLayout.LayoutParams

        params.height = WRAP_CONTENT
        params.width = MATCH_PARENT

        if (i != 0) {
            params.topMargin = interval
        }
        llChildView.layoutParams = params
    }
}

/**
 * 测量多个View的宽
 * @param viewArray View数组
 * @return 总宽度
 */
fun measureTotalWidth(vararg viewArray: View?): Int {
    var totalWidth = 0

    for (view in viewArray) {
        if (view == null) {
            continue
        }

        val widthMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 shl 30) - 1, View.MeasureSpec.AT_MOST)
        val heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((1 shl 30) - 1, View.MeasureSpec.AT_MOST)

        view.measure(widthMeasureSpec, heightMeasureSpec)

        totalWidth += if (view.layoutParams is ViewGroup.MarginLayoutParams) {
            val marginLayoutParams = view.layoutParams as ViewGroup.MarginLayoutParams

            view.measuredWidth + marginLayoutParams.marginStart + marginLayoutParams.marginEnd
        } else {
            view.measuredWidth
        }
    }
    return totalWidth
}