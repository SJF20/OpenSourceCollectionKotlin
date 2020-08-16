package com.shijingfeng.base.util;

import java.lang.System;

/**
 * Function: EditText 输入文本过滤器工具类
 * Date: 2020/1/27 14:29
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a8\u0006\t"}, d2 = {"Lcom/shijingfeng/base/util/EditTextInputFilterUtil;", "", "()V", "getProhibitSystemEmojiInputFilter", "Landroid/text/InputFilter;", "isSystemEmoji", "", "codePoint", "", "base_debug"})
public final class EditTextInputFilterUtil {
    
    /**
     * 获取 禁止系统表情输入 过滤器
     * @return 禁止系统表情输入 过滤器
     */
    @org.jetbrains.annotations.NotNull()
    public final android.text.InputFilter getProhibitSystemEmojiInputFilter() {
        return null;
    }
    
    /**
     * 判断是不是系统表情
     * @param codePoint 字符
     * @return true: 是系统表情 false: 不是系统表情
     */
    private final boolean isSystemEmoji(char codePoint) {
        return false;
    }
    
    public EditTextInputFilterUtil() {
        super();
    }
}