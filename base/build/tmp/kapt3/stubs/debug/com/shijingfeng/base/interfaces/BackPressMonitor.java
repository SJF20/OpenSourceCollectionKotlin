package com.shijingfeng.base.interfaces;

import java.lang.System;

/**
 * Function: 模拟 Activity OnBackPressed
 * Date: 2020/3/21 13:52
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/shijingfeng/base/interfaces/BackPressMonitor;", "", "onBackPressed", "", "base_debug"})
public abstract interface BackPressMonitor {
    
    /**
     * 返回键点击 回调方法
     * @return true Fragment消费处理  false 交由Activity处理
     */
    public abstract boolean onBackPressed();
}