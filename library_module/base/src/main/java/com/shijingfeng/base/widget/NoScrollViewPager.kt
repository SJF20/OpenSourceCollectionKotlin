package com.shijingfeng.base.widget

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Function: 禁止滑动 ViewPager
 * Date: 2020/2/2 20:54
 * Description:
 * Author: ShiJingFeng
 */
class NoScrollViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

    private var isCanScroll = true

    /**
     * 是否能滑动
     */
    var canScroll: Boolean
    get() = isCanScroll
    set(canScroll) {
        this.isCanScroll = canScroll
    }

    override fun onInterceptTouchEvent(ev: MotionEvent) = isCanScroll && super.onInterceptTouchEvent(ev)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent) = isCanScroll && super.onTouchEvent(ev)

}