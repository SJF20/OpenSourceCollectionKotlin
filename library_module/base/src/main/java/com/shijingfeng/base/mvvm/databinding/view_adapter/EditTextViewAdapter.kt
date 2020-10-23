/** 生成的 Java 类名 */
@file:JvmName("EditTextViewAdapter")
package com.shijingfeng.base.mvvm.databinding.view_adapter

import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.shijingfeng.base.util.getProhibitSystemEmojiInputFilter

/**
 * Function: EditText View适配器
 * Date: 2020/1/27 14:50
 * Description:
 * @author ShiJingFeng
 */

/**
 * 添加 文本输入监听器
 * @param editText EditText
 * @param textWatcher 文本输入监听器
 */
@BindingAdapter(value = ["textChange"], requireAll = false)
fun addTextChangedListener(
    editText: EditText,
    textWatcher: TextWatcher?
) {
    if (textWatcher == null) {
        return
    }
    editText.addTextChangedListener(textWatcher)
}

/**
 * 设置 文本是明文还是密文
 * @param editText EditText
 * @param isCleartext true 明文  false 密文
 */
@BindingAdapter(value = ["setCleartext"], requireAll = false)
fun setCleartext(
    editText: EditText,
    isCleartext: Boolean
) {
    if (isCleartext) {
        //设置为明文
        editText.transformationMethod = HideReturnsTransformationMethod.getInstance()
    } else {
        //设置为密文
        editText.transformationMethod = PasswordTransformationMethod.getInstance()
    }
}

/**
 * 过滤表情
 * @param editText EditText
 * @param isFilterEmoji 是否过滤表情
 */
@BindingAdapter(value = ["filterEmoji"], requireAll = false)
fun filterEmoji(
    editText: EditText,
    isFilterEmoji: Boolean
) {
    if (isFilterEmoji) {
        editText.filters = arrayOf(getProhibitSystemEmojiInputFilter())
    }
}