package com.shijingfeng.base.interfaces;

import java.lang.System;

/**
 * Function: 模拟 Activity OnKeyDown
 * Date: 2020/3/21 21:19
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/shijingfeng/base/interfaces/KeyDownMonitor;", "", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "base_debug"})
public abstract interface KeyDownMonitor {
    
    /**
     * 模拟按键 按下监听 回调方法
     * @param keyCode 模拟按键 代码
     * @param event 事件
     * @return  true Fragment消费处理   false 交由Activity处理
     */
    public abstract boolean onKeyDown(int keyCode, @org.jetbrains.annotations.Nullable()
    android.view.KeyEvent event);
}