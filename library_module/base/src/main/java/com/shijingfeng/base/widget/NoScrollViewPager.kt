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
 * @author ShiJingFeng
 */
class NoScrollViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

    private var isCanScroll = true

    /**
     * 设置其是否能滑动换页
     * @param isCanScroll false 不能换页， true 可以滑动换页
     */
    fun setCanScroll(isCanScroll: Boolean) {
        this.isCanScroll = isCanScroll
    }

    override fun onInterceptTouchEvent(ev: MotionEvent) = isCanScroll && super.onInterceptTouchEvent(ev)

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent) = isCanScroll && super.onTouchEvent(ev)

}