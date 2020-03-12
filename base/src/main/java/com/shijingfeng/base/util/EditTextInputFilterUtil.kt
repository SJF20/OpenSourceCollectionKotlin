package com.shijingfeng.base.util

import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import com.blankj.utilcode.util.ToastUtils

/**
 * 简单工厂模式创建对象
 * @return 对象
 */
fun createEditTextInputFilterUtil(): EditTextInputFilterUtil {
    return EditTextInputFilterUtil()
}

/**
 * Function: EditText 输入文本过滤器工具类
 * Date: 2020/1/27 14:29
 * Description:
 * @author ShiJingFeng
 */
class EditTextInputFilterUtil {

    /**
     * 获取 禁止系统表情输入 过滤器
     * @return 禁止系统表情输入 过滤器
     */
    fun getProhibitSystemEmojiInputFilter(): InputFilter {
        return InputFilter { source: CharSequence, start: Int, end: Int, _: Spanned, _: Int, _: Int ->
            val buffer = StringBuffer()
            var i = start

            while (i < end) {
                val codePoint = source[i]

                if (!isSystemEmoji(codePoint)) {
                    buffer.append(codePoint)
                } else {
                    ToastUtils.showShort("暂不支持系统表情")
                    ++i
                }
                ++i
            }

            if (source is Spanned) {
                val sp = SpannableString(buffer)

                TextUtils.copySpansFrom(source, start, end, null, sp, 0)
                return@InputFilter sp
            } else {
                return@InputFilter buffer
            }
        }
    }

    /**
     * 判断是不是系统表情
     * @param codePoint 字符
     * @return true: 是系统表情 false: 不是系统表情
     */
    private fun isSystemEmoji(codePoint: Char): Boolean {
        return !(codePoint.toInt() == 0x0
                || codePoint.toInt() == 0x9
                || codePoint.toInt() == 0xA
                || codePoint.toInt() == 0xD
                || codePoint.toInt() in 0x20..0xD7FF
                || codePoint.toInt() in 0xE000..0xFFFD
                || codePoint.toInt() in 0x10000..0x10FFFF)
    }

}