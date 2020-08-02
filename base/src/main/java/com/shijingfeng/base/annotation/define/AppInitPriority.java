package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.common.constant.FlagConstant.ADD;
import static com.shijingfeng.base.common.constant.FlagConstant.CLEAR;
import static com.shijingfeng.base.common.constant.FlagConstant.INSERT;
import static com.shijingfeng.base.common.constant.FlagConstant.LOAD;
import static com.shijingfeng.base.common.constant.FlagConstant.NONE;
import static com.shijingfeng.base.common.constant.FlagConstant.REFRESH;
import static com.shijingfeng.base.common.constant.FlagConstant.REMOVE;
import static com.shijingfeng.base.common.constant.FlagConstant.UPDATE;
import static com.shijingfeng.base.interfaces.AppInitKt.HIGH;
import static com.shijingfeng.base.interfaces.AppInitKt.LOW;
import static com.shijingfeng.base.interfaces.AppInitKt.MEDIUM;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 应用初始化 优先级 限制
 * Date: 2020/7/25 14:43
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 优先级: 高
    HIGH,
    // 优先级: 中
    MEDIUM,
    // 优先级: 低
    LOW
})
@Target({
    // 类属性
    FIELD,
    // 函数
    METHOD,
    // 函数参数
    PARAMETER,
    // 局部变量
    LOCAL_VARIABLE
})
@Retention(SOURCE)
public @interface AppInitPriority {}
