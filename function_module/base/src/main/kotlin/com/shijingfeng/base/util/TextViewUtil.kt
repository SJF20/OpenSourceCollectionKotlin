@file:JvmName("TextViewUtil")
package com.shijingfeng.base.util

import android.text.Editable
import android.text.TextWatcher

/**
 * Function: TextView 相关 工具类
 * Date: 2020/10/22 17:31
 * Description:
 * Author: ShiJingFeng
 */

/**
 * TextWatcher接口适配器，解决子类三个方法都得实现的问题
 */
interface TextWatcherAdapter : TextWatcher {

    /**
     * 文本修改前调用
     *
     * @param s 文本修改前的内容
     * @param start 字符串中即将发生修改的位置 (从 0 开始)
     * @param count 字符串中即将被修改的文字的长度。如果是新增的话则为 0 (删除字符时有效)
     * @param after 被修改的文字修改之后的长度。如果是删除的话则为 0 (新增和插入字符时有效)
     */
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    /**
     * 文本修改时调用
     *
     * @param s 文本修改后的内容
     * @param start 字符串中即将发生修改的位置 (从 0 开始)
     * @param before 被改变的字符串长度，如果是新增则为 0 (删除字符时有效)
     * @param count 添加的字符串长度，如果是删除则为 0 (新增和插入字符时有效)
     */
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    /**
     * 文本修改后调用
     *
     * @param s 文本修改后的内容
     */
    override fun afterTextChanged(s: Editable?) {}

}