package com.shijingfeng.todo.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.todo.constant.FlagConstant.ORDER_BY_COMPLETE_DATE_ASC;
import static com.shijingfeng.todo.constant.FlagConstant.ORDER_BY_COMPLETE_DATE_DESC;
import static com.shijingfeng.todo.constant.FlagConstant.ORDER_BY_CREATE_DATE_ASC;
import static com.shijingfeng.todo.constant.FlagConstant.ORDER_BY_CREATE_DATE_DESC;
import static com.shijingfeng.todo.constant.FlagConstant.ORDER_BY_NONE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 排序 注解限定
 * Date: 2020/9/11 15:52
 * Description:
 *
 * Author: ShiJingFeng
 */
@IntDef({
    // 默认不操作，为原来的 (用于EventBus Event)
    ORDER_BY_NONE,
    // 完成日期顺序 (升序)
    ORDER_BY_COMPLETE_DATE_ASC,
    // 完成日期逆序 (降序)
    ORDER_BY_COMPLETE_DATE_DESC,
    // 创建日期顺序 (升序)
    ORDER_BY_CREATE_DATE_ASC,
    // 创建日期逆序 (降序)
    ORDER_BY_CREATE_DATE_DESC
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
public @interface TodoOrderBy {}
