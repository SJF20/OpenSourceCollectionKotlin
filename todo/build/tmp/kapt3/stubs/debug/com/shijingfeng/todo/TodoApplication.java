package com.shijingfeng.todo;

import java.lang.System;

/**
 * Function: todo模块 Application (只有设置为 application 单独调试时，才会调用)
 * Date: 2020/3/18 22:20
 * Description:
 * @author ShiJingFeng
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/shijingfeng/todo/TodoApplication;", "Lcom/shijingfeng/base/base/application/BaseApplication;", "()V", "attachBaseContext", "", "base", "Landroid/content/Context;", "todo_debug"})
public final class TodoApplication extends com.shijingfeng.base.base.application.BaseApplication {
    
    /**
     * 绑定Context, 先于 onCreate 执行
     */
    @java.lang.Override()
    protected void attachBaseContext(@org.jetbrains.annotations.NotNull()
    android.content.Context base) {
    }
    
    public TodoApplication() {
        super();
    }
}