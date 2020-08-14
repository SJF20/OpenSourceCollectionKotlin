package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.annotation.define.MarkViewStyle.*;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: MarkView 样式限定注解
 * Date: 2020/8/14 17:10
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    STYLE_LEFT_TOP,
    STYLE_LEFT_BOTTOM,
    STYLE_RIGHT_TOP,
    STYLE_RIGHT_BOTTOM
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
public @interface MarkViewStyle {
    /** 样式: 左上角 */
    int STYLE_LEFT_TOP = 1;
    /** 样式: 左下角 */
    int STYLE_LEFT_BOTTOM = 2;
    /** 样式: 右上角 */
    int STYLE_RIGHT_TOP = 3;
    /** 样式: 右下角 */
    int STYLE_RIGHT_BOTTOM = 4;
}