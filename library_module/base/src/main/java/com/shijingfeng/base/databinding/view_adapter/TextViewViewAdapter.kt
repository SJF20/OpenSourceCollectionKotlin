/** 生成的 Java 类名 */
@file:JvmName("TextViewViewAdapter")
package com.shijingfeng.base.databinding.view_adapter

import android.text.TextUtils
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Function: TextView View适配器
 * Date: 2020/1/27 16:01
 * Description:
 * @author ShiJingFeng
 */

/**
 * 添加 文本输入监听器
 * @param textView EditText
 * @param text 文本
 */
@BindingAdapter(value = ["setText"], requireAll = false)
fun setText(
    textView: TextView,
    text: CharSequence?
) {
    val oldText = textView.text

    //会比较新旧值，一样则不重新赋值。
    if (TextUtils.equals(oldText, text)) {
        return
    }
    textView.text = text
}