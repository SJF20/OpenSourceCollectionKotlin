package com.shijingfeng.todo.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.todo.constant.FlagConstant.TYPE_ALL;
import static com.shijingfeng.todo.constant.FlagConstant.TYPE_LIFE;
import static com.shijingfeng.todo.constant.FlagConstant.TYPE_NONE;
import static com.shijingfeng.todo.constant.FlagConstant.TYPE_STUDY;
import static com.shijingfeng.todo.constant.FlagConstant.TYPE_WORK;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 待办事项类型 注解限定
 * Date: 2020/9/11 15:43
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 默认不操作，为原来的 (用于EventBus Event)
    TYPE_NONE,
    // 无分类 全部
    TYPE_ALL,
    // 学习
    TYPE_STUDY,
    // 生活
    TYPE_LIFE,
    // 工作
    TYPE_WORK
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
public @interface TodoType {}
