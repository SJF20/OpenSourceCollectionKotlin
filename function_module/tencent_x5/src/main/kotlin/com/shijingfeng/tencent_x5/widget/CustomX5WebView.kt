package com.shijingfeng.tencent_x5.widget

import android.content.Context
import android.util.AttributeSet
import com.tencent.smtt.sdk.WebView

/**
 * Function: 自定义腾讯X5WebView (用于解决 API23 以下 onScrollListener无法使用问题)
 * Date: 2020/2/2 20:40
 * Description:
 * Author: ShiJingFeng
 */
class CustomX5WebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    private var mOnScrollChangeListener: ((
        //腾讯X5 WebView
        webView: WebView?,
        //当前滑动到的 X坐标
        scrollX: Int,
        //当前滑动到的 Y坐标
        scrollY: Int,
        //上一次的 X坐标
        oldScrollX: Int,
        //上一次的 Y坐标
        oldScrollY: Int
    ) -> Unit)? = null

    /**
     * 设置自定以滑动改变监听器
     * @param onScrollChangeListener 滑动改变监听器
     */
    fun setCustomOnScrollChangeListener(
        onScrollChangeListener: ((
            //腾讯X5 WebView
            webView: WebView?,
            //当前滑动到的 X坐标
            scrollX: Int,
            //当前滑动到的 Y坐标
            scrollY: Int,
            //上一次的 X坐标
            oldScrollX: Int,
            //上一次的 Y坐标
            oldScrollY: Int
        ) -> Unit)?
    ) {
        this.mOnScrollChangeListener = onScrollChangeListener
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        mOnScrollChangeListener?.invoke(this, l, t, oldl, oldt)
    }

}