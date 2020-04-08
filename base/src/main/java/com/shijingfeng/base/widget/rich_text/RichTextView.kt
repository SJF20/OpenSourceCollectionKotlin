package com.shijingfeng.base.widget.rich_text

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Spanned
import android.text.style.ImageSpan
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.HtmlCompat
import androidx.core.text.toSpannable
import com.shijingfeng.base.common.constant.CLICK
import com.shijingfeng.base.common.extension.onItemEvent
import com.shijingfeng.base.util.e

/**
 * Function: 富文本 TextView
 * Date: 20-4-7 上午9:47
 * Description:
 * @author shijingfeng
 */
class RichTextView @JvmOverloads constructor(
    /** Context环境  */
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private var mOnItemEvent: onItemEvent? = null

    /** 富文本 */
    var richText = ""
    set(richText) {
        field = richText
        movementMethod = ClickableLinkMovementMethod.getInstance()

        val spannableString = HtmlCompat.fromHtml(richText, HtmlCompat.FROM_HTML_MODE_LEGACY, RichTextImageGetter(
            mContext = context,
            mTextView = this
        ), null).toSpannable()

        // ImageSpan 数组
        val imageSpanArray = spannableString.getSpans(
            0,
            spannableString.length - 1,
            ImageSpan::class.java
        )
        // 图片 Url 数组
        val imageSourceArray = arrayOfNulls<String>(imageSpanArray.size)

        for (i in imageSpanArray.indices) {
            imageSourceArray[i] = imageSpanArray[i].source
        }

        for (currentPosition in imageSpanArray.indices) {
            val imageSpan = imageSpanArray[currentPosition]
            val start = spannableString.getSpanStart(imageSpan)
            val end = spannableString.getSpanEnd(imageSpan)

            spannableString.setSpan(ClickableImageSpanImpl(imageSpan.drawable).apply {
                setOnItemClickListener { view, data, position, flag ->
                    mOnItemEvent?.invoke(view, imageSourceArray, currentPosition, flag)
                }
            }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        text = spannableString
    }

    /**
     * 设置事件回调
     * @param onItemEvent 事件回调函数
     */
    fun setOnItemEventListener(onItemEvent: onItemEvent) {
        this.mOnItemEvent = onItemEvent
    }

}

/**
 * 可点击的 ImageSpan 实现类
 */
private class ClickableImageSpanImpl internal constructor(d: Drawable) : ClickableImageSpan(d) {

    private var mOnItemEvent: onItemEvent? = null

    override
    fun onClick(view: View) {
        mOnItemEvent?.invoke(view, null, -1, CLICK)
    }

    fun setOnItemClickListener(onItemEvent: onItemEvent) {
        mOnItemEvent = onItemEvent
    }
}