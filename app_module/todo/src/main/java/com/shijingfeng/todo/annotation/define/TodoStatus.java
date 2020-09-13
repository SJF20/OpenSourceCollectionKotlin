package com.shijingfeng.todo.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.todo.constant.FlagConstant.STATUS_DONE;
import static com.shijingfeng.todo.constant.FlagConstant.STATUS_NEED_TO_DO;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 状态 注解限定
 * Date: 2020/9/11 15:53
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 待办
    STATUS_NEED_TO_DO,
    // 已完成
    STATUS_DONE,
})
@Target({
    // 类属性
    FIELD,
    // 函数参数
    PARAMETER,
    // 局部变量
    LOCAL_VARIABLE
})
@Retention(SOURCE)
public @interface TodoStatus {}
