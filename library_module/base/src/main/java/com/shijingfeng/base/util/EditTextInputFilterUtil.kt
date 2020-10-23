@file:JvmName("EditTextInputFilterUtil")
package com.shijingfeng.base.util

import android.text.InputFilter
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import com.blankj.utilcode.util.ToastUtils
import com.shijingfeng.base.R

/**
 * 获取 禁止系统表情输入 过滤器
 * @return 禁止系统表情输入 过滤器
 */
fun getProhibitSystemEmojiInputFilter(): InputFilter {

    // 具体调试输出日志请看: 工程根目录/test_log_output/InputFilter单字符操作.txt 和 工程根目录/test_log_output/InputFilter多字符操作.txt
    return InputFilter { source: CharSequence, sourceStart: Int, sourceEnd: Int, dest: Spanned, destStart: Int, destEnd: Int ->
        val buffer = StringBuffer()
        var i = sourceStart
        var haveEmoji = false

        while (i < sourceEnd) {
            val codePoint = source[i]

            if (isSystemEmoji(codePoint)) {
                if (!haveEmoji) {
                    haveEmoji = true
                }
            } else {
                buffer.append(codePoint)
            }
            ++i
        }

        if (haveEmoji) {
            ToastUtils.showShort(getStringById(R.string.暂不支持系统表情))
        }
        if (source is Spanned) {
            val sp = SpannableString(buffer)

            TextUtils.copySpansFrom(source, sourceStart, sourceEnd, null, sp, 0)
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