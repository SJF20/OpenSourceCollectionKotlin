package com.shijingfeng.skin_changer.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 换肤类型 限制注解
 * Date: 2020/7/23 14:58
 * Description:
 *
 * @author ShiJingFeng
 */
@IntDef({
    // 插件式换肤
    SkinType.PLUGIN,
    // 宿主内部换肤
    SkinType.HOST
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
public @interface SkinType {

    /** 插件式换肤 */
    int PLUGIN = 0;
    /** 宿主内部换肤 */
    int HOST = 1;

}
