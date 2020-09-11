package com.shijingfeng.todo.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.todo.constant.FlagConstant.PRIORITY_ALL;
import static com.shijingfeng.todo.constant.FlagConstant.PRIORITY_IMPORTANT_NOT_URGENCY;
import static com.shijingfeng.todo.constant.FlagConstant.PRIORITY_IMPORTANT_URGENCY;
import static com.shijingfeng.todo.constant.FlagConstant.PRIORITY_NONE;
import static com.shijingfeng.todo.constant.FlagConstant.PRIORITY_NOT_IMPORTANT_NOT_URGENCY;
import static com.shijingfeng.todo.constant.FlagConstant.PRIORITY_NOT_IMPORTANT_URGENCY;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 优先级 注解限定
 * Date: 2020/9/11 15:52
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 默认不操作，为原来的 (用于EventBus Event)
    PRIORITY_NONE,
    // 所有
    PRIORITY_ALL,
    // 重要 不紧急
    PRIORITY_IMPORTANT_URGENCY,
    // 重要 不紧急
    PRIORITY_IMPORTANT_NOT_URGENCY,
    // 不重要 紧急
    PRIORITY_NOT_IMPORTANT_URGENCY,
    // 不重要 不紧急
    PRIORITY_NOT_IMPORTANT_NOT_URGENCY
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
public @interface TodoPriority {}
