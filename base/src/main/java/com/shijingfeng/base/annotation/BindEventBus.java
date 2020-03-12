package com.shijingfeng.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Function: 用于标识是否绑定EventBus
 * Author: ShiJingFeng
 * Date: 2019/10/10 13:51
 * Description:
 * @author ShiJingFeng
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BindEventBus {
}
