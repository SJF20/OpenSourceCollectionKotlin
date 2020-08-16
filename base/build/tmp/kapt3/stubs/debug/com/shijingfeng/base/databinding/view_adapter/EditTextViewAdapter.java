package com.shijingfeng.base.databinding.view_adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0007\u00a8\u0006\u000b"}, d2 = {"addTextChangedListener", "", "editText", "Landroid/widget/EditText;", "textWatcher", "Landroid/text/TextWatcher;", "filterEmoji", "isFilterEmoji", "", "setCleartext", "isCleartext", "base_debug"})
public final class EditTextViewAdapter {
    
    /**
     * 添加 文本输入监听器
     * @param editText EditText
     * @param textWatcher 文本输入监听器
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"textChange"})
    public static final void addTextChangedListener(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, @org.jetbrains.annotations.Nullable()
    android.text.TextWatcher textWatcher) {
    }
    
    /**
     * 设置 文本是明文还是密文
     * @param editText EditText
     * @param isCleartext true 明文  false 密文
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"setCleartext"})
    public static final void setCleartext(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, boolean isCleartext) {
    }
    
    /**
     * 过滤表情
     * @param editText EditText
     * @param isFilterEmoji 是否过滤表情
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {"filterEmoji"})
    public static final void filterEmoji(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, boolean isFilterEmoji) {
    }
}