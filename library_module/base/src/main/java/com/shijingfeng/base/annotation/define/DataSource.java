package com.shijingfeng.base.annotation.define;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.shijingfeng.base.common.constant.FlagConstant.DATA_SOURCE_LOCAL;
import static com.shijingfeng.base.common.constant.FlagConstant.DATA_SOURCE_NETWORK;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Function: 数据来源 限定 (注意: 不要改为 Kotlin 注解, 否则乱输入不会提示)
 * Date: 20-4-7 下午1:25
 * Description:
 *
 * Author: shijingfeng
 */
@IntDef({
    // 数据来源: 网络
    DATA_SOURCE_NETWORK,
    // 数据来源: 本地
    DATA_SOURCE_LOCAL
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
public @interface DataSource {}
