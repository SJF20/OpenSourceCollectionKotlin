package com.shijingfeng.base.widget

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Function: PhotoView ViewPager
 * Date: 2020/1/29 10:40
 * Description: 用于解决 ViewPager 嵌套 PhotoView 发生异常
 * @author ShiJingFeng
 */
class PhotoViewPager(
    mContext: Context,
    mAttrs: AttributeSet? = null
) : ViewPager(mContext, mAttrs) {

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        return try {
            super.onInterceptTouchEvent(ev)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            false
        }
    }

}