package com.shijingfeng.weather.annotation.define;

import androidx.annotation.IntDef;

import com.shijingfeng.weather.widget.FlowLayout;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: {@link FlowLayout} 排列方向 限制注解
 * Date: 2020/9/24 16:05
 * Description:
 *
 * Author: ShiJingFeng
 */
@IntDef({
    FlowOrientation.FLOW_ORIENTATION_HORIZONTAL,
    FlowOrientation.FLOW_ORIENTATION_VERTICAL
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
public @interface FlowOrientation {

    /** 排列方向: 逐行排列, 可上下滚动 */
    int FLOW_ORIENTATION_VERTICAL = 0;
    /** 排列方向: 逐列排列, 可左右滚动 */
    int FLOW_ORIENTATION_HORIZONTAL = 1;

}
